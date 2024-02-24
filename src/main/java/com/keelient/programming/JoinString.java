package com.keelient.programming;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class JoinString {
    public static void main(String[] args) {
        List<Course> courses = List.of(
                new Course("Spring", "Framework", 100, 20000),
                new Course("Spring Boot", "Framework", 201, 20000),
                new Course("API", "Microservices", 88, 20000),
                new Course("Microservices", "Microservices", 96, 20000),
                new Course("Fullstack", "Framework", 91, 20000),
                new Course("AWS", "Cloud", 92, 58000),
                new Course("Azure", "Cloud", 99, 3000),
                new Course("Docker", "Cloud", 92, 20000),
                new Course("Kubernetes", "Cloud", 102, 1000)
        );
        List<Course> courses2 = List.of(
                new Course("Spring", "Framework", 100, 20000),
                new Course("Spring Boot", "Framework", 201, 20000),
                new Course("API", "Microservices", 88, 20000),
                new Course("Microservices", "Microservices", 96, 20000),
                new Course("Fullstack", "Framework", 91, 20000),
                new Course("AWS", "Cloud", 92, 58000),
                new Course("Azure", "Cloud", 99, 3000),
                new Course("Docker", "Cloud", 92, 20000),
                new Course("Kubernetes", "Cloud", 102, 1000)
        );

        System.out.println("-------------------------------------------------------------------");
        String collect = courses.stream()
                .map(Course::getName)
                .collect(Collectors.joining(" - "));
        System.out.println("collect: " + collect);
        System.out.println("-------------------------------------------------------------------");
        List<String> collectSplitted = courses.stream()
                .map(Course::getName)
                .map(name -> name.split(""))
                .flatMap(Arrays::stream)
                .collect(Collectors.toList());
        System.out.println("collectSplitted: " + collectSplitted);
        System.out.println("-------------------------------------------------------------------");
        List<List<Course>> collectFlatMap =
                courses.stream()
                .flatMap(course -> courses2.stream()
                        .map(course2 -> List.of(course, course2)))
                .collect(Collectors.toList());
        System.out.println(collectFlatMap);
        System.out.println("-------------------------------------------------------------------");
        Predicate<Course> reviewScoreGreaterThan95Predicate = createPredicateWithCutoffReviewScore(95);
        Predicate<Course> reviewScoreLowerThan90Predicate = createPredicateWithCutoffReviewScore(90);
        System.out.println("-------------------------------------------------------------------");
        Optional<String> first = courses.stream()
                .map(Course::getName)
                .peek(System.out::println)
                .filter(name -> name.length() > 11)
                .map(String::toUpperCase)
                .peek(System.out::println)
                .findFirst();
        System.out.println("first: " + first);
    }

    private static Predicate<Course> createPredicateWithCutoffReviewScore(int cutoffReviewScore){
        return course -> course.getReviewScore() > cutoffReviewScore;
    }

}
