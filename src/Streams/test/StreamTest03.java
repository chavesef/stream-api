package Streams.test;

import Streams.classes.Esporte;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StreamTest03 {
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
        System.out.println(esportes.stream().noneMatch(esporte -> esporte.getNota() == 1));
        esportes.stream()
                        .filter(e -> e.getNota() < 6)
                .sorted(Comparator.comparing(Esporte::getNota))
                        .findFirst()
                .ifPresent(System.out::println);
    }

}
