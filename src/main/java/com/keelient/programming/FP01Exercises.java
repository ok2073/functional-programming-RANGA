package com.keelient.programming;

import java.util.List;

public class FP01Exercises {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
        List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF",
                                        "Azure", "Docker", "Kubernetes");
        System.out.println("--------------------------------------------------");
        printOddNumbersInListLambda(numbers);
        System.out.println("--------------------------------------------------");
        printAllCourses(courses);
        System.out.println("--------------------------------------------------");
        printAllCoursesContaingWord(courses, "Spring");
        System.out.println("--------------------------------------------------");
        printAllCoursesContaingWordGreaterThan(courses, 4);
        System.out.println("--------------------------------------------------");
        printSquaresOfEvenNumbersInListFunctional(numbers);
        System.out.println("--------------------------------------------------");
        printCubesOfOddNumbersInListFunctional(numbers);
        System.out.println("--------------------------------------------------");
        printAllCoursesNameLength(courses);
    }

    private static void printOddNumbersInListLambda(List<Integer> numbers) {
        numbers.stream()
                .filter(number -> number % 2 != 0)
                .forEach(System.out::println);
    }

    private static void printAllCourses(List<String> courses) {
        courses.stream()
                .forEach(System.out::println);
    }

    private static void printAllCoursesContaingWord(List<String> courses, String word) {
        courses.stream()
                .filter(course -> course.contains(word))
                .forEach(System.out::println);
    }

    private static void printAllCoursesContaingWordGreaterThan(List<String> courses, int charsNumber) {
        courses.stream()
                .filter(course -> course.length() >= 4)
                .forEach(System.out::println);
    }

    private static void printSquaresOfEvenNumbersInListFunctional(List<Integer> numbers) {
        numbers.stream()
                .filter(number -> number % 2 == 0)
                .map(number -> (int) Math.pow(number, 2))
                .forEach(System.out::println);
    }

    private static void printCubesOfOddNumbersInListFunctional(List<Integer> numbers) {
        numbers.stream()
                .filter(number -> number % 2 != 0)
                .map(number -> (int) Math.pow(number, 3))
                .forEach(System.out::println);
    }

    private static void printAllCoursesNameLength(List<String> courses) {
        courses.stream()
                .map(course -> course.length())
                .forEach(System.out::println);
    }
}
