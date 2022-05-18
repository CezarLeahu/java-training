package org.example.multithreading.org.example.multithreading.sharedmemory;

import org.example.multithreading.sharedmemory.SynchronizedCollection;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static java.util.stream.IntStream.range;

public class TestSynchronizedCollections {

    @Test
    public void testRegularOperations() throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        SynchronizedCollection collections = new SynchronizedCollection();

        Instant start = Instant.now();

        range(0, 200000).forEach(i -> {
            if (i % 2 == 0) {
                executor.submit(() -> collections.put("" + (i % 100)));
            } else {
                executor.submit(() -> collections.remove("" + (i - 1 % 100)));
            }
        });
        // the previous numbers balance out - after all these operations complete, the collections should be empty

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.HOURS);

        collections.print(); // high chance we get some residual values

        System.out.println("Task executed in: " + Duration.between(start, Instant.now()).toSeconds() + " seconds");
    }

    @Test
    public void testSynchronizedOperations() throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        SynchronizedCollection collections = new SynchronizedCollection();

        Instant start = Instant.now();

        range(0, 200000).forEach(i -> {
            if (i % 2 == 0) {
                executor.submit(() -> collections.putSynchronized("" + (i % 100)));
            } else {
                executor.submit(() -> collections.removeSynchronized("" + (i - 1 % 100)));
            }
        });
        // the previous numbers balance out - but we can't know the execution order of the tasks

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.HOURS);

        collections.print(); // no residual values, in theory

        System.out.println("Task executed in: " + Duration.between(start, Instant.now()).toSeconds() + " seconds");
    }
}
