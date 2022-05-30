package IteratorExample;

import java.util.stream.Stream;

public final class NumbersGenerator {

    public static void generateEven(int max) {
        Stream.iterate(-30, n -> n+1)
                .limit(max)
                .filter(n -> n % 2 == 0)
                .forEach(System.out::println);
    }
}