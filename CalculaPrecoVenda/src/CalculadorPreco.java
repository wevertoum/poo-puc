public class CalculadorPreco {
    public static final double MARKUP_FIXO = 1.54;

    public CalculadorPreco() {
    }

    public final double calcularPrecoVenda(double precoCompra) {
        if (precoCompra < 0) {
            throw new IllegalArgumentException("O preço de compra não pode ser negativo.");
        }

        return MARKUP_FIXO * precoCompra;
    }
}