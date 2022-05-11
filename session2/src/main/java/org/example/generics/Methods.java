package org.example.generics;

public class Methods {

    public <T> void doSomeWork(T t) {
        System.out.println("Doing some work with T: " + t);
    }

    public <T, R> R doSomethingElse(T t, Class<R> cls) {
        System.out.println("Doing something else with T: " + t);
        return null;
    }
}
