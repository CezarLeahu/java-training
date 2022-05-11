package org.example.aopwithannotations;

public class Algorithm {

    @Loggable
    public void execute() {
        routineBlack();
        routineBlue();
        for (int i = 5; i > 0; --i) {
            routineRed();
        }
        routineBlack();
    }

    private void routineBlue() {
        // some computation
    }

    @Loggable
    private void routineRed() {
        // some computation
    }

    @Loggable
    private void routineBlack() {
        // some computation
    }
}
