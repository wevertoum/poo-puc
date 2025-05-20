package model;

import java.util.ArrayList;
import java.util.List;

public class Usuario {

    private final String cpf;
    private final String nome;
    private final List<ItemBiblioteca> itensEmprestados;

    public Usuario(String cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
        this.itensEmprestados = new ArrayList<>();
    }

    public void pegarEmprestado(ItemBiblioteca item) {
        item.emprestar();
        itensEmprestados.add(item);
    }

    public void devolverItem(ItemBiblioteca item) {
        item.devolver();
        itensEmprestados.remove(item);
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public List<ItemBiblioteca> getItensEmprestados() {
        return itensEmprestados;
    }

    @Override
    public String toString() {
        return "Usuário [CPF=" + cpf + ", Nome=" + nome + "]";
    }
}
