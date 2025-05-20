package model;

public abstract class ItemBiblioteca {
    private final int id;
    private boolean disponivel;

    public ItemBiblioteca(int id) {
        this.id = id;
        this.disponivel = true;
    }

    public void emprestar() {
        if (disponivel) {
            disponivel = false;
        } else {
            throw new IllegalStateException("Item já emprestado.");
        }
    }

    public void devolver() {
        disponivel = true;
    }

    public int getId() {
        return id;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    @Override
    public abstract String toString();
}