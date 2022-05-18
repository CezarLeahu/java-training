package org.example.multithreading.org.example.multithreading.sharedmemory;

import org.example.multithreading.sharedmemory.Counter;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TestCounter {

    @Test
    public void testCounterOnMultipleThreads() throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        Counter c = new Counter();

        for (int i = 0; i < 500; ++i) {
            executor.submit(c::increment);
        }

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.HOURS);

        System.out.println(c.getSum());
    }

    @Test
    public void testCounterOnMultipleThreadsSynchronized() throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        Counter c = new Counter();

        for (int i = 0; i < 500; ++i) {
            executor.submit(c::synchronizedIncrement);
        }

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.HOURS);

        System.out.println(c.getSum());
    }
}
