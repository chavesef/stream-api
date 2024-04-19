package Streams.test;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest06 {
    public static void main(String[] args) {
        IntStream.range(0, 10).forEach(System.out::println);
        Stream.of("Elias", "Chicken", "Kabrito")
                .map(String::toUpperCase)
                .forEach(s -> System.out.print(s + " "));

        int [] num = {4,6,9,13,31};
        Arrays.stream(num)
                .average()
                .ifPresent(System.out::println);

        Stream.iterate(0, n -> n + 2)
                .limit(10)
                .forEach(System.out::println);

        Stream.iterate(new int[] {0,1}, n -> new int []{n[1], n[0]+n[1]})
        .limit(20)
        .forEach(a -> System.out.println(Arrays.toString(a)));

        Stream.iterate(new int[] {0,1}, n -> new int []{n[1], n[0]+n[1]})
                .limit(20)
                .map(a -> a[0])
                .forEach(System.out::println);
    }
}
