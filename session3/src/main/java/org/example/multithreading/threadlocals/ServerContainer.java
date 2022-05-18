package org.example.multithreading.threadlocals;

public class ServerContainer {
    public void receiveNewRequest(final String request) {
        new Thread(() -> {
            Context.generateRequestId();

            new RequestHandler().handle(request);
        }).start();
    }
}
