package com.keelient.programming;

import java.util.List;
import java.util.function.BinaryOperator;

public class FP03FunctionalInterfaces {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
        System.out.println("----------------------------------------------------");
        BinaryOperator<Integer> sumBinaryOperator = Integer::sum;
        int sum = numbers.stream()
                    .reduce(0, sumBinaryOperator);
        System.out.println(sum);

    }
}
