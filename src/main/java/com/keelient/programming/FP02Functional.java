package com.keelient.programming;

import java.util.List;

public class FP02Functional {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
        System.out.println("----------------------------------------------------");
        int sum = addListfunctional(numbers);
        System.out.println(sum);
        System.out.println("----------------------------------------------------");
        int sum2 = addListfunctional2(numbers);
        System.out.println(sum2);
        System.out.println("----------------------------------------------------");
        int sum3 = addListfunctional3(numbers);
        System.out.println(sum3);
    }

    private static int sum(int a, int b) {
        System.out.println(a + " " + b);
        return a + b;
    }

    private static int addListfunctional(List<Integer> numbers) {
        return numbers.stream()
                .reduce(0, FP02Functional::sum);
    }

    private static int addListfunctional2(List<Integer> numbers) {
        return numbers.stream()
                .reduce(0, (x, y) -> x + y);
    }

    private static int addListfunctional3(List<Integer> numbers) {
        return numbers.stream()
                .reduce(0, Integer::sum);
    }
}
