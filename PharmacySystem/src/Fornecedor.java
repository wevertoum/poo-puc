public class Fornecedor extends PessoaEntidade {
    private String nomeFantasia;
    private String website;

    public Fornecedor(long id, String nome, String logradouro, String numeroEndereco,
                      String cep, String bairro, String cidade, String uf,
                      String telefone, String cpfCnpj,
                      String nomeFantasia, String website) {
        super(id, nome, logradouro, numeroEndereco, cep, bairro, cidade, uf, telefone, cpfCnpj);
        this.nomeFantasia = nomeFantasia;
        this.website = website;
    }

    public String getNomeFantasia() { return nomeFantasia; }
    public void setNomeFantasia(String nomeFantasia) { this.nomeFantasia = nomeFantasia; }
    public String getWebsite() { return website; }
    public void setWebsite(String website) { this.website = website; }

    @Override
    public String toString() {
        return super.toString() +
               "\nTipo: Fornecedor" +
               "\nNome Fantasia: " + nomeFantasia +
               "\nWebsite: " + website;
    }
}