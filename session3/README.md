Multithreading in Java
===

The programming dimensions/aspects we need to keep in mind in Java (and not just Java):
* *the objects*: the **data**, the classes, the methods attached to them
* *the threads*: the **time**, when those methods are actually executed

> **Concurrency vs Parallelism:** parallel code is concurrent, but the reverse isn't necessarily the case (check 
> [Concurrency vs Parallelism on geeksforgeeks.org](https://www.geeksforgeeks.org/difference-between-concurrency-and-parallelism/)).

Software threads get scheduled to actual CPU threads in a round-robin fashion. Therefore, the software threads 
compete for the same actual CPU resources. They are concurrent. Depending on how many CPU threads (hardware) are 
available, they **might** also be parallel.

Basics
---

### Creating a simple thread
With `Runnable`:
```java
    new Thread(new Runnable() {
        @Override
        public void run() {
            System.out.println("Hello from a secondary thread");
            }
        }).start();
```

With `Callable` and `FutureTask`:
```java
    FutureTask<SomeReturnType> task = new FutureTask<>(() -> {
        // do some work
        
        return resultValue;
    });

    new Thread(task).start();

    SomeReturnType result = task.get();
```

### Thread Pools

Types of thread pools:
* `Executor`:
  - allows submission of `Runnable` tasks
  - methods: `void execute(Runnable)`
* `ExecutorService`:
  - allows submission of both `Runnable` and `Callable` tasks
  - produces _Futures_ on task submissions
  - provides shutdown procedures
  - methods:
    * `Future<?> submit(Runnable)`
    * `Future<T> submit(Callable<T>)`
    * `void shutdown()`
    * `boolean awaitTermination()`
    * `List<Runnable> shutdownNow()`
* `ThreadPoolExecutor`:
  - _(not an interface, but an actual class type)_
  - it's an extensible thread pool implementation
  - configurable options: `corePoolSize`, `maximumPoolSize`, `keepAliveTime`
* `ScheduledExecutorService`:
  - provides options for scheduling tasks:
    * after a given delay
    * periodically
  - methods:
    * `ScheduledFuture<?> schedule(Runnable, delay, TimeUnit)`
    * `ScheduledFuture<?> scheduleAtFixedRate(...)`
    * `ScheduledFuture<?> scheduleWithFixedDelay(...)`


Shared-memory vs Message-passing
---

> _Don't communicate by sharing memory; share memory by communicating._

### Locking methods

Locks are generally used in OOP to secure concurrent access to a resource (typically an object).

Java offers an out-of-the-box synchronization mechanism directly in the language.

**Synchronizations:**
- are a type of locks
- they **always** ensure synchronization on _one particular resource_
- don't support multiple resources
- syntactic sugar for adding an actual **lock**
- just like locks, not particularly fast - every synchronization takes a bit of time
- quick & simple way to secure access to a specific resource when performance isn't a concern
- generally not an option for high-performance applications or web applications in general


Types of synchronization in Java:
* **synchronized code block** on a specific object (any object in Java can act as a resource for a synchronization):
  - example:
  ```java
        synchronized (someObject) {
            someObject.someCriticalMethod();
        }
  ```
* **synchronized methods**:
  - it synchronizes the `this` object
  - cleaner code, but usually even less efficient than synchronized blocks, since the synchronized methods might 
    include operations with don't need synchronization (e.g. logging operations)
  - Gotchas:
    * multiple synchronized methods in the same **object** can't run in parallel
  - example:
  ```java
    public synchronized void someMethodA() {
      // all the operations in this method are synchonized on *this*
      // the locking is not targeted on the specific "critical" operation
      // because `someMethodB` is also synchronized on *this*, the two methods cannot execute in parralel
    }
  
    public synchronized void someMethodB() {
    }
  ```
  
* synchronized static methods
  - Gotchas:
    * multiple synchronized methods in the same **class** can't run in parallel (same as on the )
  ```java
    public static synchronized void someMethodA() {
      // all the operations in this method are synchonized on *this*
      // the locking is not targeted on the specific "critical" operation
      // because `someMethodB` is also synchronized on *this*, the two methods cannot execute in parralel
    }
  
    public static synchronized void someMethodB() {
    }
  ```

Thread synchronization is safe, but extremely slow.

### Wait & notify
- while they don't replace **sychronizations**, they do provide a way for threads to wait for one-another when
  sharing a resource
- the `wait()`, `notify()` and `notifyAll()` methods are available on all objects in Java:
  - with `wait()` the current thread starts waiting (locks/pauses) on a given object (the shared resource typically);
  - with `notify()` the current thread notifies (unlocks/resumes) another tread that is waiting on a given object;
  - with `notifyAll()` the current thread notifies (unlocks/resumes) all the treads that are waiting on a given object.


### Message Passing with Blocking Queues
- it eliminates the need for manual locks/semaphores or explicit synchronization
- it works best with immutable data (immutable messages)
- the programming model si similar to process communication across external infrastructure (computer network, 
  external messaging service, etc.)
- scales better, more tolerant to communication latencies


Immutable types
---
- immutable types, immutable collections, immutable objects are preferable in multithreaded applications since they're
  thread-safe and don't need any synchronization
  * they're also not mutable, but that can usually be circumvented by creating new objects/collections
  * while creation of new objects is more expensive than mutating an existing object, in a multithreaded context it 
    eliminates entire classes of problems and issues with shared-memory
  * another reason to think of code and methods as operations with a separated **input** and **output**
- examples of immutable types in Java: String, unmodifiable collections, Guava immutable types 

Synchronized vs Concurrent collections
---
Both ensure thread-safety, but they ensure it in different ways:
* **Synchronized collections**:
  - use locks (shared memory) on the whole collection
  - much slower - locks are blocking operations
  - consistent up-to-date results
* **Concurrent collections**
  - no locking on the whole collection, but targeted locking on individual segments/buckets of the collection
  - non-blocking operations
  - the available view for each thread at the same moment in time might differ (a recent view, maybe not the exact 
    latest)
  - great and sufficient for most use-cases (e.g. local caches of data)

### Atomic variables
* Wrapper over basic types with atomic operations, e.g. `incrementAndGet`, `getAndSet`, `compareAndSet`, etc.

ThreadLocal variables
---
ThreadLocal variables allow attaching data directly to a thread, as opposed to a data object.

It's useful when you need to keep some context information for each thread, but you can't just pass that information 
around between the method calls in your main logic.

Useful for servlet containers, logger, etc.

References
---
* [Java Novice to Javanista course on Percipio](https://ness.percipio.com/journey/717919cf-1692-4bcd-b1ab-db5304aedcad)
* [Concurrency vs Parallelism - geeksforgeeks.org](https://www.geeksforgeeks.org/difference-between-concurrency-and-parallelism/)
* [Thread Pools in Java - Baeldung.com](https://www.baeldung.com/thread-pool-java-and-guava)
