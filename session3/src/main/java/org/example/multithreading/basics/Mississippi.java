package org.example.multithreading.basics;


import static java.text.MessageFormat.format;

public class Mississippi implements Runnable {

    private final int seconds;

    public Mississippi(int seconds) {
        this.seconds = seconds;
    }

    @Override
    public void run() {
        for (int i = 0; i < seconds; ++i) {

            System.out.println(format("{0} Mississippi", i + 1));

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Thread was interrupted from the outside - " + e.getMessage());
            }
        }
    }
}
