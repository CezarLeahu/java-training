package org.example.multithreading.org.example.multithreading.sharedmemory;

import org.example.multithreading.sharedmemory.MessageContainer;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestMessageContainer {

    private static final ExecutorService executor = Executors.newFixedThreadPool(5);

    public MessageContainer sharedResource = new MessageContainer();

    @Test
    public void useMessageContainer() throws InterruptedException {
        sharedResource.setMessage("Message ");

        executor.submit(this::messagePrinter);
        executor.submit(this::messagePrinter);
        executor.submit(this::messagePrinter);

        executor.submit(this::messageIncrementor);

        Thread.sleep(30 * 1000); // 30 sec
    }

    public void messageIncrementor() {
        try {
            for (int i = 0; true; ++i) {

                synchronized (sharedResource) {
                    sharedResource.setMessage("Message " + i);
                    sharedResource.notify();
                }

                Thread.sleep(3000);
            }
        } catch (InterruptedException ignore) {
        }
    }

    public void messagePrinter() {
        try {
            while (true) {

                synchronized (sharedResource) {
                    sharedResource.wait();
                    System.out.println(sharedResource.getMessage() + " from thread " + Thread.currentThread().getName());
                }
            }
        } catch (InterruptedException ignore) {
        }
    }
}
