package org.example.multithreading.org.example.multithreading.concurrency;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import static java.util.stream.IntStream.range;

public class TestAtomicVariables {

    @Test
    public void testSimpleCounter() throws InterruptedException {
        SimpleCounter counter = new SimpleCounter();

        ExecutorService executor = Executors.newFixedThreadPool(10);

        range(0, 10000).forEach(i -> executor.submit(counter::increment));

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.HOURS);

        counter.print();
    }

    class SimpleCounter {
        int val = 0;

        void increment() {
            ++val;
        }

        void print() {
            System.out.println(val);
        }
    }


    @Test
    public void testVolatileCounter() throws InterruptedException {
        VolatileCounter counter = new VolatileCounter();

        ExecutorService executor = Executors.newFixedThreadPool(10);

        range(0, 10000).forEach(i -> executor.submit(counter::increment));

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.HOURS);

        counter.print();
    }

    class VolatileCounter {
        volatile int val = 0;

        void increment() {
            ++val;
        }

        void print() {
            System.out.println(val);
        }
    }

    @Test
    public void testSynchronizedCounter() throws InterruptedException {
        SynchronizedCounter counter = new SynchronizedCounter();

        ExecutorService executor = Executors.newFixedThreadPool(10);

        range(0, 100000).forEach(i -> executor.submit(counter::increment));

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.HOURS);

        counter.print();
    }

    class SynchronizedCounter {
        volatile int val = 0;

        synchronized void increment() {
            ++val;
        }

        void print() {
            System.out.println(val);
        }
    }

    @Test
    public void testAtomicInteger() throws InterruptedException {
        AtomicInteger counter = new AtomicInteger();

        ExecutorService executor = Executors.newFixedThreadPool(10);

        range(0, 100000).forEach(i -> executor.submit(counter::incrementAndGet));

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.HOURS);

        System.out.println(counter.get());
    }
}
