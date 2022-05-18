package org.example.multithreading.sharedmemory;

public class Synchronizations {

    public void waitOneSecond() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ignore) {
        }
    }

    public void waitOneSecondWithInternalSynchronizeOnThis() {
        synchronized (this) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ignore) {
            }
        }
    }

    public synchronized void waitOneSecondSynchronized() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ignore) {
        }
    }
}
