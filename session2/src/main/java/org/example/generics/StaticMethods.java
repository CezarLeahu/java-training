package org.example.generics;

import java.util.Random;

public class StaticMethods {

    public static <T> void doSomeWork(T t) {
        System.out.println("Doing some work with T: " + t);
    }

    public static <T, R> R doSomethingElse(T t, Class<R> cls) {
        System.out.println("Doing something else with T: " + t);
        return null;
    }

    @SafeVarargs
    public static <T> T randomElement(T... elems) {
        return elems[Math.abs(new Random().nextInt() % elems.length)];
    }
}
