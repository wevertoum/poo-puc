package model;

public class Livro {

    private final int id;
    private final String titulo;
    private final String autor;
    private boolean disponivel;

    public Livro(int id, String titulo, String autor) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.disponivel = true;
    }

    public void emprestar() {
        if (disponivel) {
            disponivel = false;
        } else {
            throw new IllegalStateException("Livro já emprestado.");
        }
    }

    public void devolver() {
        disponivel = true;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    @Override
    public String toString() {
        return "Livro [ID=" + id + ", Título=" + titulo + ", Autor=" + autor + ", Disponível=" + disponivel + "]";
    }
}
