package com.keelient.programming;

import java.io.IOException;
import java.nio.file.*;
import java.util.Arrays;

public class FP05Files {
    public static void main(String[] args) throws IOException {
        System.out.println("----------------------------------");
        Files.lines(Path.of("file.txt"))
                .map(str -> str.split(" "))
                .flatMap(Arrays::stream)
                .distinct()
                .sorted()
                .forEach(System.out::println);
        System.out.println("----------------------------------");
        Files.list(Paths.get("."))
                .filter(Files::isDirectory)
                .forEach(System.out::println);
    }
}
