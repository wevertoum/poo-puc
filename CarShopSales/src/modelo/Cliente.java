package modelo;

public class Cliente {
    private final String cpf;
    private final String nome;
    private final String endereco;
    private final String telefone;
    private final String email;

    public Cliente(String cpf, String nome, String endereco, String telefone, String email) {
        this.cpf = cpf;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Cliente:\n" +
               "CPF: " + cpf + "\n" +
               "Nome: " + nome + "\n" +
               "Endereço: " + endereco + "\n" +
               "Telefone: " + telefone + "\n" +
               "Email: " + email;
    }
}
