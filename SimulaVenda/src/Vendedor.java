public class Vendedor {
    private String nome;
    private float comissaoAcumulada;
    public static final float TAXA_COMISSAO = 0.10f; // 10% de comissão
    private static int proximoId = 1;
    private final int idVendedor;

    public Vendedor(String nome) {
        this.idVendedor = proximoId++;
        this.nome = nome;
        this.comissaoAcumulada = 0.0f;
    }

    // Getters
    public int getIdVendedor() {
        return idVendedor;
    }

    public String getNome() {
        return nome;
    }

    public float getComissaoAcumulada() {
        return comissaoAcumulada;
    }

    // Setters
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Método para registrar os ganhos de uma venda e calcular a comissão.
     * @param valorVenda O valor total da venda realizada.
     */
    public void registrarGanhosDeVenda(float valorVenda) {
        if (valorVenda > 0) {
            float ganhoComissao = valorVenda * TAXA_COMISSAO;
            this.comissaoAcumulada += ganhoComissao;
            // System.out.println("Vendedor " + nome + " ganhou R$" + String.format("%.2f", ganhoComissao) + " de comissão. Total acumulado: R$" + String.format("%.2f", this.comissaoAcumulada)); // Log interno
        }
    }

    @Override
    public String toString() {
        return "ID: " + idVendedor + " | Vendedor: " + nome +
               " | Comissão Acumulada: R$" + String.format("%.2f", comissaoAcumulada);
    }
}