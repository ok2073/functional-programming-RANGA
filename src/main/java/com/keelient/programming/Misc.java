package com.keelient.programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Misc {
    public static void main(String[] args) {
        List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS",
                                        "PCF", "Azure", "Docker", "Kubernetes");
        List<String> modifyableCourses = new ArrayList<>(courses);
        System.out.println("---------------------------------------------------------");
        modifyableCourses.replaceAll(course -> course.toUpperCase());
        modifyableCourses.forEach(System.out::println);
        System.out.println("---------------------------------------------------------");
        modifyableCourses.removeIf(course -> course.length() < 6);
        modifyableCourses.forEach(System.out::println);
    }
}
