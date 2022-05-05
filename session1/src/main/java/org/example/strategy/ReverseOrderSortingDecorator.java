package org.example.strategy;

public class ReverseOrderSortingDecorator implements SortingRoutine{
    private final SortingRoutine embeddedSortingRoutine;

    public ReverseOrderSortingDecorator(SortingRoutine embeddedSortingRoutine) {
        this.embeddedSortingRoutine = embeddedSortingRoutine;
    }

    @Override
    public void sort() {
        switchCompatorFunction();
        embeddedSortingRoutine.sort();
    }

    private void switchCompatorFunction() {
        System.out.println("reverse comparator order");
    }
}
