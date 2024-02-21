package com.keelient.programming;

import java.util.List;
import java.util.function.Supplier;

public class FP03MethodRefences {
    public static void main(String[] args) {
        List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF",
                "Azure", "Docker", "Kubernetes");
        System.out.println("------------------------------------------------------------------------");
        courses.stream()
                .map(String::toUpperCase)
                .forEach(FP03MethodRefences::print);
        System.out.println("------------------------------------------------------------------------");
        Supplier<String> supplier = () -> new String();
    }

    private static void print(String str) {
        System.out.println(str);
    }
}
