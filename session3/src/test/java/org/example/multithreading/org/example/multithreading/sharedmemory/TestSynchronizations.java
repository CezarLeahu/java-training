package org.example.multithreading.org.example.multithreading.sharedmemory;

import org.example.multithreading.sharedmemory.Synchronizations;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TestSynchronizations {

    @Test
    public void executeTasksWithoutSynchronizations() throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        Synchronizations s = new Synchronizations();

        Instant start = Instant.now();

        for (int i = 0; i < 10; ++i) {
            executor.submit(s::waitOneSecond);
        }

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.HOURS);

        System.out.println("Task executed in: " + Duration.between(start, Instant.now()).toSeconds() + " seconds");
    }

    @Test
    public void executeTasksWithInternalSynchronizationsOnThis() throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        Synchronizations s = new Synchronizations();

        Instant start = Instant.now();

        for (int i = 0; i < 10; ++i) {
            executor.submit(s::waitOneSecondWithInternalSynchronizeOnThis);
        }

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.HOURS);

        System.out.println("Task executed in: " + Duration.between(start, Instant.now()).toSeconds() + " seconds");
    }

    @Test
    public void executeTasksWithSynchronizedMethod() throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        Synchronizations s = new Synchronizations();

        Instant start = Instant.now();

        for (int i = 0; i < 10; ++i) {
            executor.submit(s::waitOneSecondSynchronized);
        }

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.HOURS);

        System.out.println("Task executed in: " + Duration.between(start, Instant.now()).toSeconds() + " seconds");
    }
}
