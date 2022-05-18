package org.example.multithreading.org.example.multithreading.concurrency;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static java.util.stream.IntStream.range;

public class TestCollectionPerformance {

    @Test
    public void timeSynchronizedCollections() throws InterruptedException {
        final Collection<String> messages = Collections.synchronizedCollection(new HashSet<>());

        final ExecutorService executor = Executors.newFixedThreadPool(10);

        final Instant start = Instant.now();

        for (int i = 0; i < 10; ++i) {
            executor.submit(() -> range(0, 5000000).mapToObj(e -> "Message " + e).forEach(messages::add));
            executor.submit(() -> range(0, 5000000).mapToObj(e -> "Message " + e).forEach(messages::remove));
        }

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.HOURS);

        System.out.println("Task executed in: " + Duration.between(start, Instant.now()).toSeconds() + " seconds");
    }

    @Test
    public void timeConcurrentCollections() throws InterruptedException {
        final Collection<String> messages = ConcurrentHashMap.newKeySet();

        final ExecutorService executor = Executors.newFixedThreadPool(5);

        final Instant start = Instant.now();

        for (int i = 0; i < 10; ++i) {
            executor.submit(() -> range(0, 5000000).mapToObj(e -> "Message " + e).forEach(messages::add));
            executor.submit(() -> range(0, 5000000).mapToObj(e -> "Message " + e).forEach(messages::remove));
        }

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.HOURS);

        System.out.println("Task executed in: " + Duration.between(start, Instant.now()).toSeconds() + " seconds");
    }
}
