public class PessoaEntidade {
    private long id;
    private String nome;
    private String logradouro;
    private String numeroEndereco;
    private String cep;
    private String bairro;
    private String cidade;
    private String uf;
    private String telefone;
    private String cpfCnpj;

    public PessoaEntidade(long id, String nome, String logradouro, String numeroEndereco,
                          String cep, String bairro, String cidade, String uf,
                          String telefone, String cpfCnpj) {
        this.id = id;
        this.nome = nome;
        this.logradouro = logradouro;
        this.numeroEndereco = numeroEndereco;
        this.cep = cep;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
        this.telefone = telefone;
        this.cpfCnpj = cpfCnpj;
    }

    public long getId() { return id; }
    public String getNome() { return nome; }
    public String getLogradouro() { return logradouro; }
    public String getNumeroEndereco() { return numeroEndereco; }
    public String getCep() { return cep; }
    public String getBairro() { return bairro; }
    public String getCidade() { return cidade; }
    public String getUf() { return uf; }
    public String getTelefone() { return telefone; }
    public String getCpfCnpj() { return cpfCnpj; }

    public void setId(long id) { this.id = id; }
    public void setNome(String nome) { this.nome = nome; }
    public void setLogradouro(String logradouro) { this.logradouro = logradouro; }
    public void setNumeroEndereco(String numeroEndereco) { this.numeroEndereco = numeroEndereco; }
    public void setCep(String cep) { this.cep = cep; }
    public void setBairro(String bairro) { this.bairro = bairro; }
    public void setCidade(String cidade) { this.cidade = cidade; }
    public void setUf(String uf) { this.uf = uf; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
    public void setCpfCnpj(String cpfCnpj) { this.cpfCnpj = cpfCnpj; }

    @Override
    public String toString() {
        return  "ID: " + id +
                "\nNome: " + nome +
                "\nLogradouro: " + logradouro + ", Nº: " + numeroEndereco +
                "\nCEP: " + cep + ", Bairro: " + bairro +
                "\nCidade: " + cidade + ", UF: " + uf +
                "\nTelefone: " + telefone +
                "\nCPF/CNPJ: " + cpfCnpj;
    }
}