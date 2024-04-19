package Streams.test;

import java.util.List;

public class StreamTest04 {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        list.stream().reduce((x,y) -> x+y).ifPresent(System.out::println);
        System.out.println(list.stream().reduce(0,(x,y) -> x+y));
        list.stream().reduce(Integer::sum).ifPresent(System.out::println);

        list.stream().reduce(Integer::max).ifPresent(System.out::println);
        list.stream().reduce((x,y) -> x > y ? x : y).ifPresent(System.out::println);

    }
}
