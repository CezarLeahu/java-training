package org.example.exceptions;

import org.junit.jupiter.api.Test;

public class TestExceptions {

    @Test
    public void throwACheckedExceptions() throws Exception {
        throw new Exception("Something is wrong and you have to check me");
    }

    @Test
    public void throwARuntimeException() {
        throw new RuntimeException("Something is wrong and but you don't have to check me");
    }

    @Test
    public void tryFinallyBlock() {
        try {
            System.out.println("Do something");

            if (true) {
                throw new RuntimeException("Something is wrong");
            }

            System.out.println("Do something else");
        } finally {
            System.out.println("finally block always executes");
        }
    }

    @Test
    public void tryCatchFinallyBlock() {
        try {
            System.out.println("Do something");

            if (true) {
                throw new RuntimeException("Something is wrong");
            }

            System.out.println("Do something else");
        } catch (Exception e) {
            System.out.println("Caught an exception: " + e.getMessage());
        } finally {
            System.out.println("finally block always executes");
        }
    }

    @Test
    public void catchThrowable() {
        try {
            throw new Error("The world is collapsing!");
        } catch (Throwable t) {
            System.out.println("Caught an exception or an error: " + t.getMessage());
        }
    }

    @Test
    public void catchAndThrow() throws Exception {
        try {
            throw new Exception("Some issue");
        } catch (Exception e) {
            System.out.println("Propagate exception: " + e.getMessage());
            throw e;
        }
    }
}
