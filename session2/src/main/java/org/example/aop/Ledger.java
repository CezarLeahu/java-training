package org.example.aop;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Ledger {
    private List<Entry> entries = new ArrayList<>();

    public void put(String data) {
        entries.add(new Entry(Instant.now(), data));
    }

    public void printLedger() {
        entries.forEach(e -> System.out.println(e.instant + " : " + e.data));
    }

    public void trimLedger(int number) {
        entries = entries.subList(entries.size() - number, entries.size());
    }

    private record Entry(Instant instant, String data) {
    }
}
