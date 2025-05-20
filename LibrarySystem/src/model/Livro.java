package model;

public class Livro extends ItemBiblioteca {

    private final String titulo;
    private final String autor;

    public Livro(int id, String titulo, String autor) {
        super(id);
        this.titulo = titulo;
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    @Override
    public String toString() {
        return "Livro [ID=" + getId() + ", Título=" + titulo + ", Autor=" + autor + ", Disponível=" + isDisponivel() + "]";
    }
}
