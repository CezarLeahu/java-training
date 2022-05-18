package org.example.multithreading.sharedmemory;

public class Counter {
    private volatile int sum = 0;

    public int getSum() {
        return sum;
    }

    public void increment() {
        ++sum;
    }

    public synchronized void synchronizedIncrement() {
        ++sum;
    }
}
