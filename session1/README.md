Java Introduction. Basic Syntax
===

Java language
---
### Language:
  - Object Oriented
  - Static-typed
  - Garbage-collected
  - C/C++ family of languages
  - Cross-platform (_kind of/not exactly_)

### Managed code:
  - Java code is compiled into **Java bytecode** (with the "`javac`" executable)
  - Java bytecode is run/interpreted by the JVM
  - JIT (just-in-time) compilation
    * performed by the JVM
    * compilation at runtime
    * Java bytecode to machine code
    * flexibility at runtime (code can be updated without stopping the app)
    * it uses standard Java artifacts (**JARs**, WARs, EARs)
  - alternative: AOT (ahead-of-time) compilation
    * it produces actual target-specific executables (usually called "_native images_")
      + architecture-specific: x86, AMD64, ARM64, etc.
      + OS-specific: Linux, Windows, Mac, BSD, etc.
    * **no interpreter**, **no JVM**, but _it does include a runtime_ (e.g. for garbage collection, thread scheduling, and other needed component)
    * Graal VM, Substrate VM - with various frameworks Spring Native, Quarkus, Micronaut
    * more and more popular now in the Cloud world (well suited for containers)
  - **Java bytecode** can be (and it is) generated from other programming languages: **Kotlin**, _Scala_, Groovy, Clojure

### JVM:
  - Runs Java bytecode
  - the "`java`" executable
  - Various vendors (Oracle, Amazon, IBM, Eclipse)
  - Von-Newman architecture
  - Java Physical Machines (CPUs) actually do exist ([stackoverflow](https://stackoverflow.com/questions/4007579/what-about-java-physical-machine))

Classes and Objects
---
Primitive types:
  - _boolean, byte, short, int, long, float, double, char_
  - signed (careful when printing)
  - can not be _null_
  - Associated object types (`Boolean`, `Integer`, etc.), which can be _null_
  - Autoboxing and Unboxing

Everything else is an _Object_ sub-type.

A **class**:
  - defines a type
  - it always extends the "`Object`" class (thus inheriting some common methods)
  - it contains *fields* and *methods*

An **object**:
  - is an instance of a class
  - it contains both **data** and **behaviour**

> **A word about programming and software:** \
> Fundamentally, all that code/software does is to manipulate data. It retrieves, modifies and sends data away.\
> Every method in the code has an "IN" and an "OUT".


### Encapsulation:
  - _public, package-private, protected, private_ visibility for fields, methods and classes
  - **accessors** (getters & setters) are used to provide access to actual fields:
    * part of the normal Java boilerplate code
    * they have a standard syntax which should be strictly respected
    * musn't contain any logic (they should always be simple one-liners)
    * the `get` and `set` method prefixes should be reserved for accessors only (use other synonyms when needed, like
      "_retrieve_" or "_compute_")

### Inheritance and Polymorphism

Class hierarchies:
  - Overriding vs Overloading (*)

Interfaces (*)
  - represent pure behaviour
  - no data (no fields, only public methods)
  - can contain _Default methods_ (since Java 8)
  - a class can implement multiple interfaces
  - improve loose-coupling

Abstract Classes
  - a class can only extend one other class (either abstract or at least non-final)
  - usually used when classes have common fields and methods
  - they reduce code duplication, but they can significantly increase its complexity
  - create tight-coupling

> *Interface usage* generally is a great addition o a codebase, it improves loose coupling, it emphasises the behaviour,
> and it can also simplify testing.\
> *Abstract classes* and Class hierarchies on the other hand, usually obfuscate the code and the logic, and even with a
> powerful IDE it's often difficult to follow multi-layered class hierarchies.

Anchor vs Strategy pattern (*)
- **Anchors** (**hooks**) pattern should be avoided
- the **Strategy** pattern should be used
- **Composition** over **Inheritance**


Collections
---
* Arrays should be avoided
* Lists, Sets and Maps
* `equals()` and `hashCode()`
* Immutable collections should be used (but carefully):
  * Sets.of(...), Lists.of(...), Maps.of(...)
  * Collections.unmodifiableSet()
  * Collections.singleton()

> Methods should accept interface types and should return concrete types.
> e.g. `public LinkedHashSet<String> sort(Collection<String> elements) {...}`

> The mark of a good programmer is his proclivity to use Sets and Maps.

> It's a given that code should work, and be secure, and without any performance issues.
> But apart from that, the code should be readable. Particularly Java code, which is a high-level language by design.
> It's inherently not particularly efficient. It's more important for it to be readable and maintainable.

Exceptions
---
* Checked vs Unchecked
* Exception hierarchy (Throwable, Error, Exception, RuntimeException)
* _try-catch-finally_ (Autoclosable interface)
* _try-with-resources_ (Autoclosable interface)


References
---
* [Java Novice to Javanista course on Percipio](https://ness.percipio.com/journey/717919cf-1692-4bcd-b1ab-db5304aedcad)
