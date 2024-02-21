package com.keelient.programming;

import java.util.List;
import java.util.Random;
import java.util.function.*;
import java.util.stream.Collectors;

public class FP03BehaviourParametrization {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
        System.out.println("----------------------------------------------------");
        Predicate<Integer> evenPredicate = x -> x % 2 == 0;
        filterAndPrint(numbers, evenPredicate);
        System.out.println("----------------------------------------------------");
        Predicate<Integer> oddPredicate = x -> x % 2 != 0;
        filterAndPrint(numbers, oddPredicate);
        System.out.println("----------------------------------------------------");
        filterAndPrint(numbers, number -> number % 3 == 0);
        System.out.println("----------------------------------------------------");
        Function<Integer, Integer> mappingFunction = x -> x * x;
        List<Integer> squaredNumbers = mapAndCreateNewList(numbers, mappingFunction);
        squaredNumbers.stream()
                .forEach(System.out::println);
        System.out.println("----------------------------------------------------");
        Supplier<Integer> randomIntegerSupplier = () -> 2;
        System.out.println(randomIntegerSupplier.get());
        System.out.println("----------------------------------------------------");
        Supplier<Integer> randomIntegerSupplier2 = () -> {
            Random random = new Random();
            return random.nextInt(1000);
        };
        System.out.println(randomIntegerSupplier2.get());
        System.out.println("----------------------------------------------------");
        UnaryOperator<Integer> unaryOperator = x -> 3 * x;
        System.out.println(unaryOperator.apply(10));
        System.out.println("----------------------------------------------------");
        BiPredicate<Integer, String> biPredicate = (number, str) -> {
            return number < 10 && str.length() >= 5;
        };
        System.out.println(biPredicate.test(9, "hello"));
        System.out.println("----------------------------------------------------");
        BiFunction<Integer, String, Boolean> biFunction = (number, str) -> {
            return number < 10 && str.length() >= 5;
        };
        System.out.println(biFunction.apply(9, "hello"));
        System.out.println("----------------------------------------------------");
        BiConsumer<Integer, String> biConsumer = (s1, s2) -> {
            System.out.println(s1);
            System.out.println(s2);
        };
        biConsumer.accept(5, "Chicken");
        System.out.println("----------------------------------------------------");
        IntBinaryOperator intBinaryOperator = (x, y) -> x + y;
        System.out.println(intBinaryOperator.applyAsInt(1, 4));

    }

    private static void filterAndPrint(List<Integer> numbers, Predicate<Integer> predicate){
        numbers.stream()
                .filter(predicate)
                .forEach(System.out::println);
    }

    private static List<Integer> mapAndCreateNewList(List<Integer> numbers, Function<Integer, Integer> mappingFunction) {
        return numbers.stream()
                .map(mappingFunction)
                .collect(Collectors.toList());
    }


}
