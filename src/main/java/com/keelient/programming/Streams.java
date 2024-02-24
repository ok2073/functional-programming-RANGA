package com.keelient.programming;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Streams {
    public static void main(String[] args) {
        System.out.println("-----------------------------------------------------------------");
        Stream<Integer> integerStream = Stream.of(1, 12, 4, 6, 66, 123, 4, 5);
        int streamSum = integerStream.reduce(0, Integer::sum);
        System.out.println("streamSum: " + streamSum);
        System.out.println("-----------------------------------------------------------------");
        int[] numberArray = {1, 12, 4, 6, 66, 123, 4, 5};
        System.out.println("sum: " + Arrays.stream(numberArray).sum());
        System.out.println("average: " + Arrays.stream(numberArray).average());
        System.out.println("min: " + Arrays.stream(numberArray).min().getAsInt());
        System.out.println("max: " + Arrays.stream(numberArray).max().getAsInt());
        System.out.println("-----------------------------------------------------------------");
        IntStream range = IntStream.range(1, 3);
        System.out.println("range no right boundary: ");
        range.forEach(System.out::println);
        System.out.println("-----------------------------------------------------------------");
        IntStream rangeClosed = IntStream.rangeClosed(1, 3);
        System.out.println("range right boundary: ");
        rangeClosed.forEach(System.out::println);
        System.out.println("-----------------------------------------------------------------");
        IntStream limit = IntStream.iterate(1, e -> e + 2).limit(10);
        System.out.println("limit: ");
        limit.forEach(System.out::println);
        System.out.println("-----------------------------------------------------------------");
        IntStream.iterate(1, e -> e + 2)
                .limit(10)
                .peek(System.out::println).sum();

        System.out.println("-----------------------------------------------------------------");
        long reduce = LongStream.rangeClosed(1, 4).reduce(1, (x, y) -> x * y);
        System.out.println("reduce: " + reduce);
        System.out.println("-----------------------------------------------------------------");
        Optional<BigInteger> bigIntegerReduce = LongStream.rangeClosed(1, 4).mapToObj(BigInteger::valueOf).reduce(BigInteger::multiply);
        System.out.println("bigIntegerReduce: " + bigIntegerReduce.get());
    }
}
