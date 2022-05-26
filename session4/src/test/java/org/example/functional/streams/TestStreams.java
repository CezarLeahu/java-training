package org.example.functional.streams;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toMap;
import static java.util.stream.Collectors.toSet;

public class TestStreams {

    @Test
    public void exampleWithCollections() {
        Collection<Integer> input = List.of(-5, -2, 0, 1, 3, 4, 5, 6, 7, 8, 9, 13, 15, 16, 17, 20);

        Set<String> filteredAndModified = input
            .stream()
            .filter(Objects::nonNull)
            .filter(i -> i % 2 == 0)
            .filter(i -> i > 0)
            .map(Object::toString)
            .filter(s -> s.length() < 3)
            .map(s -> s.repeat(3))
            .collect(toSet());
        System.out.println("Filtered and modified: " + filteredAndModified);


        int sumOfPositiveOddNumbers = input
            .stream()
            .filter(Objects::nonNull)
            .filter(i -> i > 0)
            .filter(i -> i % 2 != 0)
            .reduce(Integer::sum)
            .orElse(0);
        System.out.println("Sum of positive odd numbers: " + sumOfPositiveOddNumbers);


        Optional<Integer> max = input
            .stream()
            .filter(Objects::nonNull)
            .max(Integer::compareTo);
        System.out.println("Max value:" + max.orElseThrow(() -> new RuntimeException("No elements")));
    }

    @Test
    public void checkOrderOfOperations() {

        int sumOfPositiveOddNumbers = IntStream.range(-20, 10)
            .peek(i -> System.out.println("[before positive filter at element: " + i))
            .filter(i -> i > 0)
            .peek(i -> System.out.println("[before odd filter at element: " + i))
            .filter(i -> i % 2 != 0)
            .peek(i -> System.out.println("[before reduce: " + i))
            .reduce(Integer::sum)
            .orElse(0);
        System.out.println("Sum of positive odd numbers: " + sumOfPositiveOddNumbers);

    }

    @Data
    @AllArgsConstructor
    static class Person {
        String name;
        int age;
    }

    private static final Collection<Person> PEOPLE = List.of(
        new Person("Gary", 27),
        new Person("John", 47),
        new Person("Linda", 37),
        new Person("Erica", 35),
        new Person("Mark", 47),
        new Person("Helen", 47),
        new Person("Tom", 37)
    );


    @Test
    public void findPersonsInTheir30s() {

        Collection<Person> inTheir30s = PEOPLE
            .stream()
            .filter(p -> p.age >= 30 && p.age < 40)
            .collect(toSet());

        System.out.println("People their 30s (full):      " + inTheir30s);
        System.out.println();

        System.out.println("People their 30s (formatted): " + inTheir30s
            .stream()
            .map(Person::getName)
            .collect(joining(", ")));
    }

    @Test
    public void mapAgesToNames() {

        Map<String, Integer> namesAndAge = PEOPLE
            .stream()
            .filter(Objects::nonNull)
            .collect(toMap(Person::getName, Person::getAge));

        System.out.println("Names and ages (full):      " + namesAndAge);
        System.out.println();

        System.out.println("Names and ages (formatted): ");
        namesAndAge.forEach((k, v) -> System.out.println("\t" + k + " - " + v));
    }

    @Test
    public void groupPeopleByGeneration() {

        Map<Integer, List<Person>> sameGeneration = PEOPLE
            .stream()
            .collect(groupingBy(Person::getAge));

        System.out.println("People in the same generation (full): " + sameGeneration);
        System.out.println();

        System.out.println("People in the same generation (formatted): ");
        sameGeneration
            .forEach((age, list) -> System.out.println("\t" + age + ": " + list
                .stream()
                .map(Person::getName)
                .collect(joining(", "))
            ));
        System.out.println();


        Map<Integer, Collection<String>> generationsWithMultiplePeople = sameGeneration
            .entrySet()
            .stream()
            .filter(e -> e.getValue().size() > 1)
            .collect(toMap(
                Map.Entry::getKey,
                e -> e.getValue().stream().map(Person::getName).collect(toSet())));

        System.out.println("Generations with multiple people: " + generationsWithMultiplePeople);
        System.out.println();

        Collection<String> peopleAloneInTheirGeneration = sameGeneration
            .values()
            .stream()
            .filter(list -> list.size() == 1)
            .flatMap(Collection::stream)
            .map(Person::getName)
            .collect(toSet());

        System.out.println("People alone in their generation: " + peopleAloneInTheirGeneration);
    }

    @Test
    public void numberOfPeopleByGeneration() {
        Map<Integer, Long> countByGeneration = PEOPLE
            .stream()
            .collect(groupingBy(Person::getAge, counting()));

        System.out.println("Number of people by generation: " + countByGeneration);
    }
}
