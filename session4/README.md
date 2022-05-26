Functional Programming in Java
===

> *IDE Usage:* when it comes to lambdas and streams, 

Lambdas and Method References
---

### Functional Interfaces

**Functional interfaces** are just interfaces with one single method (without an implementation). They may contain additional _default_ methods, but they can't have more than one method without an implementation. The annotation `@FunctionalInterface` only enforces that behaviour at compile time.

Example:
```java
@FunctionalInterface
public interface Runnable {

    public abstract void run();
}

```

If an interface has multiple methods (without default implementations), then we wouldn't be able to do type inference to actual _lambdas_ (we wouldn't know which method to chose, to infer to).


### Lambda Expressions
Examples:
```java

    () -> operation()
    a -> operation(a)
    (a, b) -> operation(a, b)

    () -> {
        instruction1();
        instruction2();
    }

    (a, b) -> {
        instruction3();
        return instruction4();
    }

```


### Method References
Examples:
```java
class Example {

    
    void spawnThreads() {

        Runnable runnable = () -> System.out.println("Hello 1");
        new Thread(runnable).start();


        new Thread(() -> System.out.println("Hello 2")).start();


        new Thread(this::simpleMethod).start();
        new Thread(() -> methodWithArgument("hello 3")).start();

        new Thread(Example::simpleStaticMethod).start();
        new Thread(() -> staticMethodWithArguments("a", "b")).start();

        OtherClass oc = new OtherClass();
        new Thread(oc::simpleMethod).start();
        new Thread(OtherClass::simpleStaticMethod).start();
    }


    void simpleMethod() { }

    void methodWithArgument(String arg) { }

    static void simpleStaticMethod() { }

    static void staticMethodWithArguments(String arg1, int arg2) { }

}

class OtherClass {

    void simpleMethod() { }

    static void simpleStaticMethod() { }
}
```


### Predefined Functional Interfaces
Examples:
* `Runnable`
* `Callable<V>`
* Everything under `java.util.function`:
  - `Supplier<T>`
  - `Consumer<T>`
  - `Predicate<T>`
  - `Function<T, R>`
  - `BiConsumer<T, U>`
  - `BiConsumer<T, U>`
  - `BiFunction<T, U, R>`
  - etc.


Streams
---

> A **monad** allows us to wrap a value, apply a set of transformations, and get the value back with all transformations applied.

> _IDEs (IntelliJ in particular):_ the fastest and the saner way of learning to use Streams.


Types of operations in a stream:
- **intermediate**: "lazy" operation in a stream
- **terminal**: trigger the processing of the stream

### Collectors

- simple reducers to a singular value (count, max, sum)
- collectors for collections: toList, toSet, toMap
- groupingBy collectors


### Immutability
In the context of Streams, each of the individual operations have a clear distinct input and output. Therefore that input and output might as well be immutable.

> *Immutability* of input and output helps with keeping the algorithm/method/lambda clean, safe and easy to reason about.

### Streams and IO
- Common mistakes
- Example of how to query for information


References
---
* [Java Novice to Javanista course on Percipio](https://ness.percipio.com/journey/717919cf-1692-4bcd-b1ab-db5304aedcad)
* [Functional Programming in Java](https://www.baeldung.com/java-functional-programming)
* [The Java 8 Stream API Tutorial](https://www.baeldung.com/java-8-streams)
