
import java.util.List;

public abstract class Colaborador {

    protected String logradouro;
    protected String numeroEndereco;
    protected String bairro;
    protected String cidade;
    protected String uf;
    protected String telefone;
    protected String email;
    protected List<String> disciplinasMinistradas;

    public Colaborador(String logradouro, String numeroEndereco, String bairro, String cidade, String uf,
            String telefone, String email, List<String> disciplinasMinistradas) {
        this.logradouro = logradouro;
        this.numeroEndereco = numeroEndereco;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
        this.telefone = telefone;
        this.email = email;
        this.disciplinasMinistradas = disciplinasMinistradas;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getDisciplinasMinistradas() {
        return disciplinasMinistradas;
    }

    public void setDisciplinasMinistradas(List<String> disciplinasMinistradas) {
        this.disciplinasMinistradas = disciplinasMinistradas;
    }

    public abstract String getNomePrincipal();
    public abstract String getIdentificadorFiscalPrincipal();
    public abstract String obterDetalhes();

    @Override
    public String toString() {
        return "\nEndereço: " + logradouro + ", Nº " + numeroEndereco
                + "\nBairro: " + bairro + ", Cidade: " + cidade + "/" + uf
                + "\nTelefone: " + telefone + ", Email: " + email
                + "\nDisciplinas: " + (disciplinasMinistradas != null ? String.join(", ", disciplinasMinistradas) : "Nenhuma");
    }
}
