package org.example.multithreading.org.example.multithreading.basics;

import org.example.multithreading.basics.Mississippi;
import org.example.multithreading.basics.PrimeCalculator;
import org.junit.jupiter.api.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class TestThreads {

    @Test
    public void newThreadWithRunnable() throws InterruptedException {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello from a secondary thread");
            }
        });

        System.out.println("[main thread (1)]");

        t.start();

        System.out.println("[main thread (2)]");

        // around this time we should see the message from the secondary thread

        Thread.sleep(2000);

        System.out.println("[main thread (3)]");
    }

    @Test
    public void newThreadWithLambdaRunnable() throws InterruptedException {
        Thread t = new Thread(() -> System.out.println("Hello from secondary thread"));

        System.out.println("[main thread (1)]");

        t.start();

        System.out.println("[main thread (2)]");

        // around this time we should see the message from the secondary thread

        Thread.sleep(2000);

        System.out.println("[main thread (3)]");
    }

    @Test
    public void newThreadWithExternalRunnable() throws InterruptedException {
        System.out.println("[main thread (1)]");

        new Thread(new Mississippi(5)).start(); // attempt to print for 5 seconds on the secondary thread

        Thread.sleep(2000);

        System.out.println("[main thread (2)]");

        // When the main thread stops, the program stops (all secondary threads are canceled)
    }

    @Test
    public void newThreadWithCallable() throws InterruptedException, ExecutionException {
        System.out.println("[main thread (1)]");

        FutureTask<Integer> task = new FutureTask<>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                // intensive computation
                Thread.sleep(1000);
                return 1 + 1;
            }
        });

        new Thread(task).start();

        System.out.println("[main thread (2)] - task.isDone(): " + task.isDone());


        Thread.sleep(2000);

        System.out.println("[main thread (3)] - task.isDone(): " + task.isDone());

        System.out.println("[main thread (4)] - task.get(): " + task.get());
    }

    @Test
    public void newThreadWithCallableLambda() throws InterruptedException, ExecutionException {
        System.out.println("[main thread (1)]");

        FutureTask<Integer> task = new FutureTask<>(() -> {
            // intensive computation
            Thread.sleep(3000);
            return 1 + 1;
        });

        new Thread(task).start();

        System.out.println("[main thread (2)] - task.isDone(): " + task.isDone());

        System.out.println("[main thread (3)] - task.get(): " + task.get());

        System.out.println("[main thread (4)] - task.isDone(): " + task.isDone());
    }

    @Test
    public void newThreadWithExternalCallable() throws InterruptedException, ExecutionException {
        System.out.println("[main thread (1)]");

        FutureTask<Integer> task = new FutureTask<>(new PrimeCalculator(10));

        new Thread(task).start();

        System.out.println("[main thread (2)] - 10th prime number: " + task.get());
    }
}
