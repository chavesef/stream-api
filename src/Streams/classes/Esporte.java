package Streams.classes;

import java.util.Objects;

public class Esporte {
    private String nome;
    private int nota;
    private Categoria categoria;

    public Esporte(String nome, int nota) {
        this.nome = nome;
        this.nota = nota;
    }

    public Esporte(String nome, int nota, Categoria categoria) {
        this.nome = nome;
        this.nota = nota;
        this.categoria = categoria;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Esporte esporte = (Esporte) o;
        return nota == esporte.nota && Objects.equals(nome, esporte.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, nota);
    }

    @Override
    public String toString() {
        return "Esporte - " +
                "nome='" + nome + '\'' +
                ", nota=" + nota +
                ", categoria=" + categoria;
    }

    public String getNome() {
        return nome;
    }

    public int getNota() {
        return nota;
    }

    public Categoria getCategoria() {
        return categoria;
    }
}
