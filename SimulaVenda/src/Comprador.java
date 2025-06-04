public class Comprador {
    private String nome;
    private float recurso; // Dinheiro disponível para o comprador
    private static int proximoId = 1;
    private final int idComprador;

    public Comprador(String nome, float recursoInicial) {
        this.idComprador = proximoId++;
        this.nome = nome;
        this.recurso = recursoInicial;
    }

    // Getters
    public int getIdComprador() {
        return idComprador;
    }

    public String getNome() {
        return nome;
    }

    public float getRecurso() {
        return recurso;
    }

    // Setters
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void adicionarRecurso(float valor) {
        if (valor > 0) {
            this.recurso += valor;
        }
    }

    /**
     * Método para simular a ação de pagar.
     * Deduz o valor do produto dos recursos do comprador.
     * @param valorProduto O valor do produto a ser comprado.
     * @return true se o pagamento for bem-sucedido (recursos suficientes), false caso contrário.
     */
    public boolean realizarPagamento(float valorProduto) {
        if (valorProduto <= 0) {
            // System.out.println("Valor do produto inválido para pagamento."); // Log interno
            return false;
        }
        if (this.recurso >= valorProduto) {
            this.recurso -= valorProduto;
            // System.out.println(nome + " pagou R$" + String.format("%.2f", valorProduto) + ". Recursos restantes: R$" + String.format("%.2f", this.recurso)); // Log interno
            return true;
        } else {
            // System.out.println(nome + " não tem recursos suficientes para pagar R$" + String.format("%.2f", valorProduto) + ". Recursos atuais: R$" + String.format("%.2f", this.recurso)); // Log interno
            return false;
        }
    }

    @Override
    public String toString() {
        return "ID: " + idComprador + " | Comprador: " + nome +
               " | Recursos: R$" + String.format("%.2f", recurso);
    }
}