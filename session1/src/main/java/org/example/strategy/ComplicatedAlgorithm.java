package org.example.strategy;

public class ComplicatedAlgorithm {
    private final SortingRoutine sortingRoutine;

    public ComplicatedAlgorithm(SortingRoutine sortingRoutine) {
        this.sortingRoutine = sortingRoutine;
    }

    public void execute() {
        commonSteps();
        sortingRoutine.sort();
        alsoCommonSteps();
    }

    private void commonSteps() {
        System.out.println("executing common steps");
    }

    private void alsoCommonSteps() {
        System.out.println("executing the other common steps");
    }
}
