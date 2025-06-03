package model;

public class Aluno {
    private final String nome;
    private final String endereco;
    private final String telefone;
    private final String email;
    private final String matricula;

    public Aluno(String nome, String endereco, String telefone, String email, String matricula) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
        this.matricula = matricula;
    }

    @Override
    public String toString() {
        return "Aluno{nome=" + nome + ", endereco=" + endereco + ", telefone=" + telefone +
               ", email=" + email + ", matricula=" + matricula + "}";
    }
}