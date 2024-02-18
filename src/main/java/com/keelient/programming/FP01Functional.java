package com.keelient.programming;

import java.util.List;

public class FP01Functional {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
        printAllNumbersInLisFunctional(numbers);
        System.out.println("--------------------------------------------------");
        printAllNumbersInLisFunctional2(numbers);
        System.out.println("--------------------------------------------------");
        printEvenNumbersInListFunctional(numbers);
        System.out.println("--------------------------------------------------");
        printEvenNumbersInListLambda(numbers);
    }

    private static void print(int number) {
        System.out.println(number);
    }

    private static void printAllNumbersInLisFunctional(List<Integer> numbers) {
        numbers.stream()
                .forEach(FP01Functional::print);
    }

    private static void printAllNumbersInLisFunctional2(List<Integer> numbers) {
        numbers.stream()
                .forEach(System.out::println);
    }

    private static boolean isEven(int number) {
       return  number % 2 == 0;
    }

    private static void printEvenNumbersInListFunctional(List<Integer> numbers) {
       numbers.stream()
               .filter(FP01Functional::isEven)
               .forEach(System.out::println);
    }

    private static void printEvenNumbersInListLambda(List<Integer> numbers) {
        numbers.stream()
                .filter(number -> number % 2 == 0)
                .forEach(System.out::println);
    }
}
