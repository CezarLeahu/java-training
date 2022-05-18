package org.example.multithreading.org.example.multithreading.basics;

import org.junit.jupiter.api.Test;

import java.time.OffsetDateTime;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TestThreadPools {

    @Test
    public void passTaskToASingleThreadExecutor() {
        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(() -> System.out.println("Printing from the executor's thread"));
        System.out.println("Done!");
    }

    @Test
    public void passMultipleTasksToASingleThreadExecutor() {
        Executor executor = Executors.newSingleThreadExecutor();

        for (int n = 10; n > 0; --n) {
            executor.execute(() -> System.out.println("Hello from thread " + Thread.currentThread().getName()));
        }

        System.out.println("Done!");
    }

    @Test
    public void passTasksToAFixedThreadPoolExecutorService() {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        for (int n = 10; n > 0; --n) {
            executor.submit(() -> System.out.println("Hello from thread " + Thread.currentThread().getName()));
        }

        System.out.println("Done!");
    }

    @Test
    public void passTasksToAVariableThreadPoolExecutor() throws InterruptedException {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        System.out.println("Pool size (initial): " + executor.getPoolSize());
        System.out.println("Pool queue size (initial): " + executor.getQueue().size());

        for (int n = 10; n > 0; --n) {
            executor.submit(() -> System.out.println("Hello from thread " + Thread.currentThread().getName()));
        }
        System.out.println("Pool size (after submissions): " + executor.getPoolSize());
        System.out.println("Pool queue size (after submissions): " + executor.getQueue().size());

        Thread.sleep(60 * 1000);
        System.out.println("Pool size (one minute later): " + executor.getPoolSize());
        System.out.println("Pool queue size (one minute later): " + executor.getQueue().size());
    }

    @Test
    public void passTasksToAScheduledThreadPoolExecutor() throws InterruptedException {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(3);

        executor.schedule(
            () -> System.out.println("Hello from pool thread, it's " + OffsetDateTime.now()),
            5,
            TimeUnit.SECONDS
        );
        System.out.println("Main thread here, it's       " + OffsetDateTime.now());

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.HOURS);
    }
}
