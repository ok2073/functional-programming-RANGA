package com.keelient.programming;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsJshell {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
        List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF",
                                        "Azure", "Docker", "Kubernetes");
        System.out.println("----------------------------------------------------------");
        System.out.println(numbers.stream().reduce(0, (x, y) -> x > y ? x : y));
        numbers.stream()
                .distinct()
                .forEach(System.out::println);
        System.out.println("----------------------------------------------------------");
        numbers.stream()
                .sorted()
                .forEach(System.out::println);
        System.out.println("----------------------------------------------------------");
        courses.stream()
                .sorted()
                .forEach(System.out::println);
        System.out.println("----------------------------------------------------------");
        courses.stream()
                .sorted(Comparator.naturalOrder())
                .forEach(System.out::println);
        System.out.println("----------------------------------------------------------");
        courses.stream()
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);
        System.out.println("----------------------------------------------------------");
        courses.stream()
                .sorted(Comparator.comparing(String::length))
                .forEach(System.out::println);
        System.out.println("----------------------------------------------------------");
        courses.stream()
                .sorted(Comparator.comparing(String::length).reversed())
                .forEach(System.out::println);
        System.out.println("----------------------------------------------------------");
        List<Integer> doubledNumbers = doubleList(numbers);
        doubledNumbers.forEach(System.out::println);
        System.out.println("----------------------------------------------------------");
        List<Integer> evenNumbersOnly = evenNumbers(numbers);
        evenNumbersOnly.stream()
                .forEach(System.out::println);
        System.out.println("----------------------------------------------------------");
        List<Integer> coursesLength = coursesLength(courses);
        coursesLength.stream()
                .forEach(System.out::println);
    }

    private static List<Integer> doubleList(List<Integer> numbers) {
        return numbers.stream()
                .map(number -> (int)Math.pow(number, 2))
                .collect(Collectors.toList());
    }

    private static List<Integer> evenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(number -> number % 2 == 0)
                .collect(Collectors.toList());
    }

    private static List<Integer> coursesLength(List<String> courses) {
        return courses.stream()
                .map(String::length)
                .collect(Collectors.toList());
    }
}
