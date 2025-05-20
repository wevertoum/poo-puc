package model;

import java.util.ArrayList;
import java.util.List;

public class Usuario {

    private final String cpf;
    private final String nome;
    private final List<Livro> livrosEmprestados;

    public Usuario(String cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
        this.livrosEmprestados = new ArrayList<>();
    }

    public void pegarEmprestado(Livro livro) {
        livro.emprestar();
        livrosEmprestados.add(livro);
    }

    public void devolverLivro(Livro livro) {
        livro.devolver();
        livrosEmprestados.remove(livro);
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public List<Livro> getLivrosEmprestados() {
        return livrosEmprestados;
    }

    @Override
    public String toString() {
        return "Usuário [CPF=" + cpf + ", Nome=" + nome + "]";
    }
}
