package org.example.generics;

import java.util.Collection;
import java.util.Comparator;

public class WithTypeRestrictions {

    public static <E extends RuntimeException> void analyseRuntimeException(E exception) {
        System.out.println(exception.getMessage());
    }

    public static <T extends Number & Comparable<T>> T searchMaxValue(Collection<T> elems) {
        return elems.stream().max(Comparable::compareTo).orElse(null);
    }

    public static <T> T searchMax(Collection<T> elems, Comparator<T> comparator) {
        return elems.stream().max(comparator).orElse(null);
    }
}
