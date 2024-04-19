package Streams.test;

import Streams.classes.Esporte;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest01 {
    private static List<Esporte> esportes = new ArrayList<>(List.of(
            new Esporte("Futebol", 10),
            new Esporte("Basquete", 7),
            new Esporte("Golfe", 3),
            new Esporte("Futebol Americano", 8),
            new Esporte("Vôlei", 9),
            new Esporte("Skate", 6),
            new Esporte("Surf", 5)
    ));

    public static void main(String[] args) {
        List<String> stream = esportes.stream()
                .sorted(Comparator.comparing(Esporte::getNota).reversed())
                .filter(e -> e.getNota() > 6)
                .map(Esporte::getNome)
                .collect(Collectors.toList());
        System.out.println(stream);
    }
}
