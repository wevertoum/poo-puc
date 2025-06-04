public class Colaborador extends PessoaEntidade {
    private String cargo;

    public Colaborador(long id, String nome, String logradouro, String numeroEndereco,
                       String cep, String bairro, String cidade, String uf,
                       String telefone, String cpfCnpj,
                       String cargo) {
        super(id, nome, logradouro, numeroEndereco, cep, bairro, cidade, uf, telefone, cpfCnpj);
        this.cargo = cargo;
    }

    public String getCargo() { return cargo; }
    public void setCargo(String cargo) { this.cargo = cargo; }

    @Override
    public String toString() {
        return super.toString() +
               "\nTipo: Colaborador" +
               "\nCargo/Função: " + cargo;
    }
}