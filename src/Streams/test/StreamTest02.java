package Streams.test;

import Streams.classes.Esporte;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamTest02 {
    private static List<Esporte> esportes = new ArrayList<>(List.of(
            new Esporte("Futebol", 10),
            new Esporte("Basquete", 7),
            new Esporte("Golfe", 3),
            new Esporte("Futebol Americano", 8),
            new Esporte("Vôlei", 9),
            new Esporte("Skate", 6),
            new Esporte("Surf", 5),
            new Esporte("Futebol Americano", 8)
    ));
    public static void main(String[] args) {
        Stream<Esporte> stream = esportes.stream();
                esportes.forEach(System.out::println);
        long count = stream.distinct()
                .filter(e -> e.getNota() > 6)
                .count();
        System.out.println(count);
    }
}
