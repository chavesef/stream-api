package Streams.test;

import Streams.classes.Categoria;
import Streams.classes.Esporte;
import org.junit.Test;

import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class TestStream {
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
    @Test
    public void testStream(){
        StreamTest07 streamTest07 = new StreamTest07();
        assertEquals(56, esportes.stream()
                .collect(Collectors.summingInt(Esporte::getNota)), 0);
        assertEquals(8, esportes.stream()
                .collect(Collectors.counting()), 0);
        assertEquals(7.0,
                streamTest07.calculaMedia(), 0);
        assertEquals("Futebol, Basquete, Golfe, Futebol Americano, Vôlei, Skate, Surf, Futebol Americano",
                esportes.stream().map(Esporte::getNome)
                .collect(Collectors.joining(", ")));
        assertEquals("Basquete, Futebol, Futebol Americano, Golfe, Skate, Surf, Vôlei",
                StreamTest07.imprimeOrdemAlfabetica());
        assertEquals("Futebol, Vôlei, Futebol Americano, Basquete, Skate, Surf, Golfe",
                StreamTest07.imprimeOrdemNota());
        assertEquals(26./3,
                StreamTest07.mediaEsporteColetivo(), 0.001);
        assertEquals("Futebol, Vôlei, Futebol Americano",
                StreamTest07.imprimeMaiorQueMediaOrdem());
    }
}
