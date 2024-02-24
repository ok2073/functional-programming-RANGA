package com.keelient.programming;

import java.util.stream.LongStream;

public class FP05Parallel {
    public static void main(String[] args) {
        System.out.println("----------------------------");
        long time = System.currentTimeMillis();
        long sum = LongStream.range(0, 1000000).parallel().sum();
        System.out.println("sum: " + sum);
        System.out.println(System.currentTimeMillis() - time);
    }
}
