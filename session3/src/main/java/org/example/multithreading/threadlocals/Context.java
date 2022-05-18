package org.example.multithreading.threadlocals;

import java.util.Random;

import static java.lang.Math.abs;

public class Context {
    private static final Random random = new Random();

    public static final ThreadLocal<Integer> requestId = new ThreadLocal<>();

    public static Integer getRequestId() {
        return requestId.get();
    }

    public static void generateRequestId() {
        requestId.set(abs(random.nextInt()));
    }
}
