
import java.util.List;

public class ColaboradorPessoaJuridica extends Colaborador {

    private String razaoSocial;
    private String nomeFantasia;
    private String inscricaoMunicipal;
    private String inscricaoEstadual;
    private String cnpj;
    private String website;

    public ColaboradorPessoaJuridica(String razaoSocial, String nomeFantasia, String cnpj,
            String inscricaoMunicipal, String inscricaoEstadual,
            String logradouro, String numeroEndereco, String bairro, String cidade, String uf,
            String telefone, String emailContato, String website, List<String> disciplinasMinistradas) {
        super(logradouro, numeroEndereco, bairro, cidade, uf, telefone, emailContato, disciplinasMinistradas);
        this.razaoSocial = razaoSocial;
        this.nomeFantasia = nomeFantasia;
        this.inscricaoMunicipal = inscricaoMunicipal;
        this.inscricaoEstadual = inscricaoEstadual;
        this.cnpj = cnpj;
        this.website = website;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getInscricaoMunicipal() {
        return inscricaoMunicipal;
    }

    public void setInscricaoMunicipal(String inscricaoMunicipal) {
        this.inscricaoMunicipal = inscricaoMunicipal;
    }

    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public void setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    @Override
    public String getNomePrincipal() {
        return this.razaoSocial;
    }

    @Override
    public String getIdentificadorFiscalPrincipal() {
        return this.cnpj;
    }

    @Override
    public String obterDetalhes() {
        return """
               Website: Colaborador (Pessoa Jur\u00eddica):
               Raz\u00e3o Social: """ + razaoSocial
                + "\nNome Fantasia: " + (nomeFantasia != null && !nomeFantasia.isEmpty() ? nomeFantasia : "N/A")
                + "\nCNPJ: " + cnpj
                + "\nInscrição Municipal: " + (inscricaoMunicipal != null && !inscricaoMunicipal.isEmpty() ? inscricaoMunicipal : "N/A")
                + "\nInscrição Estadual: " + (inscricaoEstadual != null && !inscricaoEstadual.isEmpty() ? inscricaoEstadual : "N/A") + (website != null && !website.isEmpty() ? website : "N/A")
                + super.toString();
    }
}
