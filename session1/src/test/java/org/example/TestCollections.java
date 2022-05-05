package org.example;

import org.example.collections.Car;
import org.example.collections.CarWithMissingHashCodeAndEquals;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.Collections.unmodifiableSet;

public class TestCollections {

    @Test
    public void testCarSet() {
        Set<Car> set = new HashSet<>();

        set.add(new Car(1, "red", "qwerty"));
        set.add(new Car(2, "blue", "asdf"));
        set.add(new Car(3, "green", "jkls"));
        set.add(new Car(1, "red", "qwerty"));

        System.out.println(set);
    }

    @Test
    public void testCarSetWithMissingHashCodeAndEqual() {
        Set<CarWithMissingHashCodeAndEquals> set = new HashSet<>();

        set.add(new CarWithMissingHashCodeAndEquals(1, "red", "qwerty"));
        set.add(new CarWithMissingHashCodeAndEquals(2, "blue", "asdf"));
        set.add(new CarWithMissingHashCodeAndEquals(3, "green", "jkls"));
        set.add(new CarWithMissingHashCodeAndEquals(1, "red", "qwerty"));

        System.out.println(set);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private static Set<String> toUppercase(Collection<String> strings) {
        //return strings.stream().map(String::toUpperCase).collect(toUnmodifiableSet());

        Set<String> res = new HashSet<>();
        for (String s : strings) {
            res.add(s.toUpperCase());
        }
        return unmodifiableSet(res);
    }

    @Test
    public void testToUppercase() {
        List<String> strings = List.of("a", "b", "c", "a", "b"); // creates an immutable list

        Set<String> upppercaseStrings = toUppercase(strings); // return an immutable set

        System.out.println(upppercaseStrings);

        //uppercaseStrings.add("d"); // runtime error, uppercaseStrings is immutable
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////

    // Bad implementation - mutating the input parameters
    private static void toUppercaseTheWrongWay(List<String> strings) {
        for (int i = 0; i < strings.size(); ++i) {
            strings.set(i, strings.get(i).toUpperCase());
        }
    }

    @Test
    public void testToUppercaseTheWrongWay() {
        List<String> strings = new ArrayList<>(List.of("a", "b", "c", "a", "b"));

        toUppercaseTheWrongWay(strings); // mutates its given parameters

        System.out.println(strings);
    }
}
