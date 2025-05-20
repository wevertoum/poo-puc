package model;

import java.time.LocalDate;

public class Emprestimo {

    private final Livro livro;
    private final Usuario usuario;
    private final LocalDate dataEmprestimo;

    public Emprestimo(Livro livro, Usuario usuario) {
        this.livro = livro;
        this.usuario = usuario;
        this.dataEmprestimo = LocalDate.now();
        usuario.pegarEmprestado(livro);
    }

    public String getDetalhes() {
        return "Empréstimo: " + livro.getTitulo() + " para " + usuario.getNome() + " em " + dataEmprestimo;
    }
}
