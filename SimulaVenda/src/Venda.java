import java.util.concurrent.atomic.AtomicInteger;

public class Venda {
    private static final AtomicInteger contadorIdGlobal = new AtomicInteger(0); // Para gerar IDs únicos de venda
    private final int idVenda;
    private Comprador comprador;
    private Vendedor vendedor;
    private Produto produto;
    private boolean finalizada;
    private boolean cancelada;

    public Venda(Comprador comprador, Vendedor vendedor, Produto produto) {
        this.idVenda = contadorIdGlobal.incrementAndGet();
        this.comprador = comprador;
        this.vendedor = vendedor;
        this.produto = produto;
        this.finalizada = false;
        this.cancelada = false;
    }

    // Getters
    public int getIdVenda() {
        return idVenda;
    }

    public Comprador getComprador() {
        return comprador;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public Produto getProduto() {
        return produto;
    }

    public boolean isFinalizada() {
        return finalizada;
    }

    public boolean isCancelada() {
        return cancelada;
    }

    /**
     * Tenta finalizar a venda.
     * @return true se a venda foi finalizada com sucesso, false caso contrário.
     */
    public boolean finalizarVenda() {
        if (finalizada) {
            // System.out.println("Venda ID " + idVenda + " já está finalizada."); // Log interno
            return true; // Já estava finalizada, considera sucesso na tentativa
        }
        if (cancelada) {
            // System.out.println("Venda ID " + idVenda + " está cancelada e não pode ser finalizada."); // Log interno
            return false;
        }
        if (produto.isVendido()) {
            // System.out.println("Erro ao finalizar Venda ID " + idVenda + ": Produto '" + produto.getNome() + "' já foi vendido."); // Log interno
            return false;
        }

        // System.out.println("\nTentando finalizar Venda ID " + idVenda + " para o produto: " + produto.getNome()); // Log interno
        // System.out.println("Comprador: " + comprador.getNome() + " | Vendedor: " + vendedor.getNome()); // Log interno

        if (comprador.realizarPagamento(produto.getPreco())) {
            produto.marcarComoVendido();
            vendedor.registrarGanhosDeVenda(produto.getPreco());
            this.finalizada = true;
            // System.out.println("Venda ID " + idVenda + " finalizada com sucesso!"); // Log interno
            return true;
        } else {
            // System.out.println("Falha ao finalizar Venda ID " + idVenda + ": Pagamento não pôde ser concluído."); // Log interno
            return false;
        }
    }

    /**
     * Cancela a venda, se ainda não estiver finalizada.
     */
    public void cancelarVenda() {
        if (finalizada) {
            // System.out.println("Venda ID " + idVenda + " já foi finalizada e não pode ser cancelada diretamente (necessitaria de um processo de devolução)."); // Log interno
            return;
        }
        if (cancelada) {
            // System.out.println("Venda ID " + idVenda + " já está cancelada."); // Log interno
            return;
        }
        this.cancelada = true;
        // System.out.println("Venda ID " + idVenda + " foi cancelada."); // Log interno
    }

    @Override
    public String toString() {
        String status = finalizada ? "Finalizada" : (cancelada ? "Cancelada" : "Pendente");
        return "ID Venda: " + idVenda +
               " | Comprador: " + (comprador != null ? comprador.getNome() : "N/A") +
               " | Vendedor: " + (vendedor != null ? vendedor.getNome() : "N/A") +
               " | Produto: " + (produto != null ? produto.getNome() : "N/A") +
               " (R$" + (produto != null ? String.format("%.2f", produto.getPreco()) : "N/A") + ")" +
               " | Status: " + status;
    }
}