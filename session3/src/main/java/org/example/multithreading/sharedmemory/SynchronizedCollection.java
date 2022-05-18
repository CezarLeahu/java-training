package org.example.multithreading.sharedmemory;

import java.util.ArrayList;
import java.util.List;

public class SynchronizedCollection {

    private final List<String> list = new ArrayList<>();

    public void put(String s) {
        list.add(s);
    }

    public void remove(String s) {
        list.remove(s);
    }

    public boolean contains(String s) {
        return list.contains(s);
    }

    public synchronized void putSynchronized(String s) {
        list.add(s);
    }

    public synchronized void removeSynchronized(String s) {
        list.remove(s);
    }

    public synchronized boolean containsSynchronized(String s) {
        return list.contains(s);
    }

    public void print() {
        System.out.println("List: " + list);
    }
}
