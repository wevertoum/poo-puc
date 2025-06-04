public class Produto {
    private String nome;
    private float preco;
    private int tamanho; // O diagrama menciona 'tamanho', pode ser numeração de roupa, etc.
    private boolean isVendido;
    private static int proximoId = 1; // Para um ID simples do produto
    private final int idProduto;


    public Produto(String nome, float preco, int tamanho) {
        this.idProduto = proximoId++;
        this.nome = nome;
        this.preco = preco;
        this.tamanho = tamanho;
        this.isVendido = false; // Um produto começa não vendido
    }

    // Getters
    public int getIdProduto() {
        return idProduto;
    }

    public String getNome() {
        return nome;
    }

    public float getPreco() {
        return preco;
    }

    public int getTamanho() {
        return tamanho;
    }

    public boolean isVendido() {
        return isVendido;
    }

    // Setters (exemplo, podem não ser todos necessários dependendo da lógica)
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreco(float preco) {
        if (preco > 0) {
            this.preco = preco;
        }
    }

    /**
     * Método para marcar o produto como vendido.
     */
    public void marcarComoVendido() {
        this.isVendido = true;
        // System.out.println("Produto '" + this.nome + "' marcado como vendido."); // Log interno
    }

    public void marcarComoDisponivel() {
        this.isVendido = false;
        // System.out.println("Produto '" + this.nome + "' marcado como disponível."); // Log interno
    }


    @Override
    public String toString() {
        return "ID: " + idProduto + " | Produto: " + nome +
               " | Preço: R$" + String.format("%.2f", preco) +
               " | Tamanho: " + tamanho +
               " | Vendido: " + (isVendido ? "Sim" : "Não");
    }
}