package org.example.multithreading.org.example.multithreading.messagepassing;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.util.UUID.randomUUID;

public class TestBlockingQueue {
    private final BlockingQueue<String> messageQueue = new ArrayBlockingQueue<>(5);

    public void producer() {
        try {
            while (true) {
                messageQueue.put("Message " + randomUUID());
            }
        } catch (InterruptedException ignore) {
        }
    }

    public void consumer() {
        try {
            while (true) {
                System.out.println(messageQueue.take());
            }
        } catch (InterruptedException ignore) {
        }
    }

    @Test
    public void generateAndPrintMessages() throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(5);

        executor.submit(this::consumer);
        executor.submit(this::consumer);

        executor.submit(this::producer);
        executor.submit(this::producer);
        executor.submit(this::producer);

        Thread.sleep(10 * 1000);
    }
}
