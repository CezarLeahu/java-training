# Java Training - Part I - Basics

* _circa 2022_
* Target audience: engineers working in the industry on Enterprise Applications
* Requirements: at least one other OOP language known pretty well
* This will be a very opinionated tutorial, based largely on previously-encountered horrors stories 
* Heavy focus on:
  - Functional Java (Java 8+)
  - Code design
  - Good and bad practices
  - Enterprise applications
* IntelliJ as IDE of choice 
* We'll use Lombok once we pass the Java basics
* Code examples over literature
* Each topic will have its own session and code directory


## 1. Basic Syntax
  - What is Java?
    - Object-Oriented Programming inspired by the C/C++ family
    - Static-typed
    - JVM, Java bytecode - both compiled and 
    - Packages (namespaces)
    - Classpath - class (absolute name), classpath errors
  - core syntax
    - data types
      - signed
    - imports, static imports
  - the idea/purpose of an object
    - POJOs / DTOs
    - fields/methods
    - visibility & access
    - getters and setters
  - inheritance and polymorphism
    - interfaces vs abstract classes
    - default methods
    - overloading vs Overwriting
  - collections
    - lists, sets, maps
    - hashCode and equals
  - exceptions
    - try-catch-finally
    - try-with-resources
    - passing exceptions

## 2. Generics. AOP. JUnit
  - AOP, Annotations and Lombok
  - Generics
  - Testing in Java and JUnit

## 3.Multithreading in Java
  - immutable types and collections
  - Shared-memory vs Message-passing
    - synchonized 
    - mutex/lock
    - BlockingQueues
  - ThreadLocal variables

## 4. Functional Java (8+ features)
  - lambdas
  - streams
    - formatting
  - collectors
    - custom collectors
  - immutable 
  - (Optional) Zone Date Time?
  - Reactive programming?

# Java Training - Part II - Advanced Topics

## 1. Functional Java (8+ features)
> Same as the last chapter from the Basic course

## 2. Maven
  - project folder structure (src/main, src/test, java, resources)
  - project modules
  - lifecycle
  - core plugins
  - Docker plugin
  - setting up a CI pipeline with
  - excludes vs provided
  - Gradle

## 3. JEE and Spring (2 sessions)
  - JEE, Enterprise Beans, CDI
  - Spring, Spring Beans
  - History
  - Applications Servers. Servlet Containers
  - JPA
  - JTA, Spring
  - Spring Data and repositories

## 4. Microservices with Java
  * single-page applications, MS architectures
  - Spring Boot (spring Boot Initializr)
  - Spring Native
  - JHipster

## 5. Design Patterns - good and bad practices
  - OOP language which supports all the GoF patterns
  - rule of thumb: minimum amount of code
  - composition vs inheritance
  - strategy vs anchor
  - methods should receive interface types and return concrete types
  - DRY, KISS, Premature Optimization
  - SOLID - or the more simple approach:
    - separate Data classes from behaviour types
    - avoid inheritance (i.e. abstract classes, interfaces are ok)
  - IntelliJ Code Inspections, SONAR


