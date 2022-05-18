package org.example.multithreading.basics;

import java.util.concurrent.Callable;

public class PrimeCalculator implements Callable<Integer> {

    private final int nth;

    public PrimeCalculator(int nth) {
        if (nth > 15) {
            throw new RuntimeException("I don't have all day");
        }
        this.nth = nth;
    }

    @Override
    public Integer call() throws Exception {
        int x = 1;
        for (int n = nth; n > 0; ++x) {
            if (prime(x)) {
                --n;
            }
        }

        return x - 1;
    }

    private static boolean prime(int x) {
        if (x == 1) {
            return true;
        }
        for (int i = 2; i <= x / 2; ++i) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }
}
