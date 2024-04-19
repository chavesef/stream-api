package Streams.test;

import Streams.classes.Categoria;
import Streams.classes.Esporte;

import java.util.*;
import java.util.stream.Collectors;

public class StreamTest07 {
    private static List<Esporte> esportes = new ArrayList<>(List.of(
            new Esporte("Futebol", 10, Categoria.COLETIVO),
            new Esporte("Basquete", 7, Categoria.COLETIVO),
            new Esporte("Golfe", 3, Categoria.INDIVIDUAL),
            new Esporte("Futebol Americano", 8, Categoria.MISTO),
            new Esporte("Vôlei", 9, Categoria.COLETIVO),
            new Esporte("Skate", 6, Categoria.INDIVIDUAL),
            new Esporte("Surf", 5, Categoria.MISTO),
            new Esporte("Futebol Americano", 8, Categoria.MISTO)
    ));

    public static String imprimeOrdemAlfabetica() {
        return esportes.stream()
                .map(Esporte::getNome)
                .sorted()
                .distinct()
                .collect(Collectors.joining(", "));

    }

    public static String imprimeOrdemNota() {
        return esportes.stream()
                .sorted(Comparator.comparing(Esporte::getNota).reversed())
                .map(Esporte::getNome)
                .distinct()
                .collect(Collectors.joining(", "));
    }

    public static double mediaEsporteColetivo() {
        return esportes.stream()
                .filter(e -> e.getCategoria() == Categoria.COLETIVO)
                .collect(Collectors.averagingDouble(Esporte::getNota));
    }

    public static String imprimeMaiorQueMediaOrdem() {
        return esportes.stream()
                .filter(e -> e.getNota() > calculaMedia())
                .sorted(Comparator.comparing(Esporte::getNota).reversed())
                .map(Esporte::getNome)
                .distinct()
                .collect(Collectors.joining(", "));
    }

    public static double calculaMedia(){
       return esportes.stream()
                .collect(Collectors.averagingInt(Esporte::getNota));
    }
    public static void main(String[] args) {
        System.out.println(esportes.stream().collect(Collectors.counting()));

        esportes.stream().max(Comparator.comparing(Esporte::getNota)).ifPresent(System.out::println);
        esportes.stream()
                .collect(Collectors.maxBy(Comparator.comparing(Esporte::getNota)))
                .ifPresent(System.out::println);
        System.out.println(esportes.stream()
                .collect(Collectors.summingInt(Esporte::getNota)));
        System.out.println(esportes.stream()
                .collect(Collectors.averagingInt(Esporte::getNota)));
        IntSummaryStatistics collect = esportes.stream()
                .collect(Collectors.summarizingInt(Esporte::getNota));
        System.out.println(collect);

        String collect1 = esportes.stream().map(Esporte::getNome)
                .collect(Collectors.joining(", "));
        System.out.println(collect1);

    }
}
