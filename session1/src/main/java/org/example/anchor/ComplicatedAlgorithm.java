package org.example.anchor;

public abstract class ComplicatedAlgorithm {

    public void execute() {
        commonSteps();
        sortingRoutine();
        alsoCommonSteps();
    }

    private void commonSteps() {
        System.out.println("executing common steps");
    }

    protected abstract void sortingRoutine();

    private void alsoCommonSteps() {
        System.out.println("executing the other common steps");
    }
}
