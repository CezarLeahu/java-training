package org.example.anchor;

import org.junit.jupiter.api.Test;

public class TestComplicatedAlgorithm {

    @Test
    public void runAlgorithms() {

        new ComplicatedAlgorithmWithQuickSort().execute();
        System.out.println();

        new ComplicatedAlgorithmWithMergeSort().execute();
        System.out.println();
    }
}
