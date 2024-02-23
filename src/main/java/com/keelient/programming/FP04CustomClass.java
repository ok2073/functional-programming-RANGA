package com.keelient.programming;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
class Course {
    private String name;
    private String category;
    private int reviewScore;
    private int noOfStudents;
}

public class FP04CustomClass {
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

        System.out.println("----------------------------------------------------------------------------");
        Predicate<Course> reviewScoreGreaterThan95Predicate = course -> course.getReviewScore() > 95;
        boolean allMatch = courses.stream()
                .allMatch(reviewScoreGreaterThan95Predicate);
        System.out.println("allMatch: " + allMatch);
        System.out.println("----------------------------------------------------------------------------");
        boolean noneMatch = courses.stream()
                .noneMatch(reviewScoreGreaterThan95Predicate);
        System.out.println("noneMatch: " + noneMatch);
        System.out.println("----------------------------------------------------------------------------");
        Predicate<Course> reviewScoreLowerThan90Predicate = course -> course.getReviewScore() < 90;
        boolean anyMatch = courses.stream()
                .anyMatch(reviewScoreLowerThan90Predicate);
        System.out.println("anyMatch: " + anyMatch);
        System.out.println("----------------------------------------------------------------------------");
        Comparator<Course> comparingByNoOfStudentsIncreasing =  Comparator.comparing(Course::getNoOfStudents);
        List<Course> courseListSortedByNoOfStudentsIncreasing = courses.stream()
                .sorted(comparingByNoOfStudentsIncreasing)
                .collect(Collectors.toList());
        System.out.println("comparingByNoOfStudentsIncreasing: " + courseListSortedByNoOfStudentsIncreasing);
        System.out.println("----------------------------------------------------------------------------");
        Comparator<Course> comparingByNoOfStudentsDecreasing =  Comparator.comparing(Course::getNoOfStudents).reversed();
        List<Course> courseListSortedByNoOfStudentsDecreasing = courses.stream()
                .sorted(comparingByNoOfStudentsDecreasing)
                .collect(Collectors.toList());
        System.out.println("comparingByNoOfStudentsDecreasing: " + courseListSortedByNoOfStudentsDecreasing);
        System.out.println("----------------------------------------------------------------------------");
        Comparator<Course> comparingByNoOfStudentsAndNoReviews = Comparator.comparing(Course::getNoOfStudents)
                                                                .thenComparing(Course::getReviewScore).reversed();
        List<Course> courseListSortedByNoOfStudentsAndNoReviews = courses.stream()
                .sorted(comparingByNoOfStudentsAndNoReviews)
                .collect(Collectors.toList());
        System.out.println("comparingByNoOfStudentsAndNoReviews : " + courseListSortedByNoOfStudentsAndNoReviews);
        System.out.println("----------------------------------------------------------------------------");
        courseListSortedByNoOfStudentsAndNoReviews = courses.stream()
                .sorted(comparingByNoOfStudentsAndNoReviews)
                .limit(2)
                .collect(Collectors.toList());
        System.out.println("limit 2: " + courseListSortedByNoOfStudentsAndNoReviews );
        System.out.println("----------------------------------------------------------------------------");
        courseListSortedByNoOfStudentsAndNoReviews = courses.stream()
                .sorted(comparingByNoOfStudentsAndNoReviews)
                .skip(1)
                .collect(Collectors.toList());
        System.out.println("skip 1: " + courseListSortedByNoOfStudentsAndNoReviews );
        System.out.println("----------------------------------------------------------------------------");
        List<Course> courseListTakeWhile100 = courses.stream()
                .takeWhile(course -> course.getReviewScore() >= 100)
                .collect(Collectors.toList());
        System.out.println("courseListTakeWhile100: " + courseListTakeWhile100);
        System.out.println("----------------------------------------------------------------------------");
        List<Course> courseListDropWhile100 = courses.stream()
                .dropWhile(course -> course.getReviewScore() >= 100)
                .collect(Collectors.toList());
        System.out.println("courseListDropWhile100: " + courseListDropWhile100);
        System.out.println("----------------------------------------------------------------------------");
        Optional<Course> max = courses.stream()
                                .max(comparingByNoOfStudentsAndNoReviews);
        System.out.println("max: " + max);
        System.out.println("----------------------------------------------------------------------------");
        Course min = courses.stream()
                .min(comparingByNoOfStudentsAndNoReviews)
                .orElse(new Course("Kubernetes", "Cloud", 102, 1000));
        System.out.println("min: " + min);
        System.out.println("----------------------------------------------------------------------------");
        Optional first = courses.stream()
                    .filter(course -> course.getReviewScore() > 100)
                    .findFirst();
        System.out.println("first: " + first);
        System.out.println("----------------------------------------------------------------------------");
        Optional any = courses.stream()
                .filter(course -> course.getReviewScore() > 100)
                .findAny();
        System.out.println("any: " + any);
    }
}
