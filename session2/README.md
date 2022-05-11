Generics. AOP. JUnit
===

Generics 
---
> The purpose of _generics_ in Java is to improve the quality of the code. That said, using _generics_ when they're not 
> needed is about as bad as not using them when they are.

> **Generics** give type information during compile-time only.
>
> **Type erasure**: the actual type information is stripped during compilation and at runtime the generic types are 
> bound simply to the base '_Object_' class.

Common examples of Generis in the Java standard APIs:
* Collections:
  ```java
  Collection<SomeType> c = new LinkedList<>();
  List<SomeType> l = new ArrayList<>();
  Set<SomeType> s = new HashSet<>();
  ```
* Comparators
  ```java
  Comparator<CustomType> c = (CustomType a, CustomType b) -> {...}
  ```
* Streams, Optional & Co.

### When generics are useful:
- When you need type information at compile time (e.g. when you want to avoid ambiguous casts)
- When you wish to ensure **the same type** across multiple steps/operations/methods/objects
- When you wish to remove duplicated code, but you need to keep the type information (e.g. when writing generic 
  algorithms)

### When to not use generics:
- When a basic interface is enough.

### Usage
* on methods:
  ```java
  public <T> void doSomeWork(T t) {...}

  public <T, R> R doSomethingElse(T t, Class<R> cls) {...}
  ```

* on static methods:
  ```java
  public static <T> void doSomeWork(T t) {...}

  public static <T, R> R doSomethingElse(T t, Class<R> cls) {...}
  ```

* on classes:
  ```java
  public class Container<T> {

    private T value;

    public Container(T t) {
      value = t;
    }

    public T getValue() {
      return value;
    }

    public void setValue(T t) {
      return value = t;
    }
  }

  // Somewhere else in the code:
  Container<String> container = new Container<>("asdf");

  String s = container.getValue(); // no cast needed, have the type information (at compile-time at least)
  ```

* _diamond operator_:
  ```java
  List<String> messages1 = new ArrayList<String>();
  
  // no need to specify the type on the both sides of "=", the following is enough
  List<String> messages2 = new ArrayList<>();
  ```
  
* multiple generic types:
  ```java
  public <R, A, B> R searchMatch(A a, Set<B> b, List<R> list) {...}
  ```
  
* type restriction for Generics:
  ```java
  public <T extends Event> void handleEvent(T e) {...}
  ```

  ```java
  public <T extends Number & Comparable<T>> T searchMaxValue(Collection<T> elems) {...}
  ```
  
### Gotchas with casting
* `List<String>` can casted to `Collection<String>`, but...
* `List<String>` cannot be cast to `List<Object>` or `Collection<Object>` - it results in a compilation error
* same for other generics

AOP
---

**PointCut**: a pattern in the code (e.g. a specific method call).

**JoinPoint**: an actual **PointCut** instance.

**Advice**: an alteration of the default code behavior of a _PointCut/JoinPoint_.

Types of Advices:
* _Before_
* _After_
* _AfterThrowing_
* _AfterReturning_
* **_Around_**

While most advices can add some additional side effects, the **_Around_** advice can completely 
change/remove/replace the execution of a join point.

AOP can be implemented with multiple tools, and it can happen both at compile-time or at run-time.

IoC containers (Spring, CDI, etc.) are build with AOP (and annotations).

### AspectJ demo
The reference AOP tool in Java. It defines the language for describing PointCuts.
Not used very often though, as AOP capabilities are offered out-of-the box by IoC Containers (e.g. Spring).

### AOP with Annotations
How IoC frameworks are built.

### Lombok
The "**Structure**" IDE windows comes in handy when using Lombook.

Testing in Java
---
### JUnit
JUnit is just a library for running tests.\
Those test don't actually have to be _unit tests_ (as the JUnit name might suggest). Almost any type of test can be run 
through JUnit (integration, e2e, API tests, contract test, etc.).

### Code design
> We don't alter production code for (unit) tests. But it sure is easier to test cleaner code (well-structured code).

Think of every _*public* method/service call_ as an operation with an **IN** and an **OUT**:
_For the given Input **x**, my operation should return the following **y** Output._

Often times that is enough - comparison of the output data.

A method call in Java can have the following outputs:
* return value
* thrown exception
* mutable input parameter (**Inadvisable!!!**, though not uncommon)
* calls to public methods from other known objects

### Mockito
Mocking framework. It provides:
* Mocks
* Spy
* verifications on method calls.

Sometimes it's too difficult to spawn the actual target objects (e.g. DB Repositories, other IO services) for 
testing. An integration test environment might not available, or it would be difficult to set up, or too expensive.\
It is in these cases that a mocking framework enters the picture, as it allows us to write unit test for a business 
case, where we would otherwise need an integration test.

> Bear in mind, though, excessive mocking quickly becomes unproductive. Better to have a bunch of clear, simple and 
> obvious integration test, rather than a complex, difficult to maintain mock.