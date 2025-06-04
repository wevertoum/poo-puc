
import java.util.List;

public class ColaboradorPessoaFisica extends Colaborador {

    private String nomeCompleto;
    private String cpf;
    private String rg;
    private int idade;
    private String titulacao;

    public ColaboradorPessoaFisica(String nomeCompleto, String cpf, String rg, int idade,
            String logradouro, String numeroEndereco, String bairro, String cidade, String uf,
            String telefone, String email, String titulacao, List<String> disciplinasMinistradas) {
        super(logradouro, numeroEndereco, bairro, cidade, uf, telefone, email, disciplinasMinistradas);
        this.nomeCompleto = nomeCompleto;
        this.cpf = cpf;
        this.rg = rg;
        this.idade = idade;
        this.titulacao = titulacao;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getTitulacao() {
        return titulacao;
    }

    public void setTitulacao(String titulacao) {
        this.titulacao = titulacao;
    }

    @Override
    public String getNomePrincipal() {
        return this.nomeCompleto;
    }

    @Override
    public String getIdentificadorFiscalPrincipal() {
        return this.cpf;
    }

    @Override
    public String obterDetalhes() {
        return """
               Colaborador (Pessoa F\u00edsica):
               Nome: """ + nomeCompleto
                + "\nCPF: " + cpf + ", RG: " + rg
                + "\nIdade: " + idade + " anos"
                + "\nTitulação: " + titulacao
                + super.toString();
    }
}
