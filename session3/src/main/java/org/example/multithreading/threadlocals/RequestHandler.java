package org.example.multithreading.threadlocals;

public class RequestHandler {

    public void handle(String request) {
        System.out.println("Handled request '" + request + "' with id " + Context.getRequestId());
    }
}
