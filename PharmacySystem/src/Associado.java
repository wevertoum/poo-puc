public class Associado extends PessoaEntidade {
    private String situacao;
    private String numeroAssociado;
    private String matriculaAssociado; 

    public Associado(long id, String nome, String logradouro, String numeroEndereco,
                     String cep, String bairro, String cidade, String uf,
                     String telefone, String cpfCnpj,
                     String situacao, String numeroAssociado) {
        super(id, nome, logradouro, numeroEndereco, cep, bairro, cidade, uf, telefone, cpfCnpj);
        this.situacao = situacao;
        this.numeroAssociado = numeroAssociado;
        
        this.matriculaAssociado = "MAT-" + cidade.substring(0, Math.min(cidade.length(), 3)).toUpperCase() + "-" + id;
    }

    
    public String getSituacao() { return situacao; }
    public String getNumeroAssociado() { return numeroAssociado; }
    public String getMatriculaAssociado() { return matriculaAssociado; }

    
    public void setSituacao(String situacao) { this.situacao = situacao; }
    public void setNumeroAssociado(String numeroAssociado) {
        this.numeroAssociado = numeroAssociado;
        
        
    }
    

    @Override
    public String toString() {
        return super.toString() +
               "\nTipo: Associado" +
               "\nSituação: " + situacao +
               "\nNúmero de Associado: " + numeroAssociado +
               "\nMatrícula Gerada: " + matriculaAssociado;
    }
}