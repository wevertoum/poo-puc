package model;

import java.time.LocalDate;

public class Emprestimo {

    private final ItemBiblioteca item;
    private final Usuario usuario;
    private final LocalDate dataEmprestimo;

    public Emprestimo(ItemBiblioteca item, Usuario usuario) {
        this.item = item;
        this.usuario = usuario;
        this.dataEmprestimo = LocalDate.now();
        usuario.pegarEmprestado(item);
    }

    public String getDetalhes() {
        return "Empréstimo: " + item.toString() + " para " + usuario.getNome() + " em " + dataEmprestimo;
    }
}
