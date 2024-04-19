package Streams.test;

import Streams.classes.Categoria;
import Streams.classes.Esporte;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamTest08 {
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

    public static void main(String[] args) {
        Map<Categoria, List<Esporte>> map = new HashMap<>();
        List<Esporte> individual = new ArrayList<>();
        List<Esporte> coletivo = new ArrayList<>();
        List<Esporte> misto = new ArrayList<>();
        
        for (Esporte esporte : esportes) {
            if (esporte.getCategoria() == Categoria.COLETIVO) {
                coletivo.add(esporte);
            } else if (esporte.getCategoria() == Categoria.INDIVIDUAL) {
                individual.add(esporte);
            }else if (esporte.getCategoria() == Categoria.MISTO) {
                misto.add(esporte);
            }
        }
        map.put(Categoria.COLETIVO, coletivo);
        map.put(Categoria.INDIVIDUAL, individual);
        map.put(Categoria.MISTO, misto);
        System.out.println(map);

        Map<Categoria, List<Esporte>> collect = esportes.stream()
                .collect(Collectors.groupingBy(Esporte::getCategoria));
        System.out.println(collect);
        System.out.println(Runtime.getRuntime().availableProcessors());

    }
}
