package org.example.multithreading.org.example.multithreading.threadlocals;

import org.example.multithreading.threadlocals.Context;
import org.example.multithreading.threadlocals.ServerContainer;
import org.junit.jupiter.api.Test;

import static java.util.stream.IntStream.range;

public class TestServer {

    @Test
    public void checkRequestIds() throws InterruptedException {
        ServerContainer sv = new ServerContainer();

        range(1, 100).mapToObj(i -> "Message " + i).forEach(sv::receiveNewRequest);

        Thread.sleep(3 * 1000);
        System.out.println("Context.getRequestId() from the main thread: " + Context.getRequestId());
    }
}
