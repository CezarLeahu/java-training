package org.example.strategy;

import org.junit.jupiter.api.Test;

public class TestComplicatedAlgorithm {

    @Test
    public void runAlgorithms() {

        new ComplicatedAlgorithm(new QuickSortRoutine()).execute();
        System.out.println();

        new ComplicatedAlgorithm(new MergeSortRoutine()).execute();
        System.out.println();
    }

    @Test
    void runAlgorithmsWithReversedOrder() {

        new ComplicatedAlgorithm(new ReverseOrderSortingDecorator(new QuickSortRoutine())).execute();
        System.out.println();

        new ComplicatedAlgorithm(new ReverseOrderSortingDecorator(new MergeSortRoutine())).execute();
        System.out.println();
    }
}
