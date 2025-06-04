import javax.swing.JOptionPane;

public class App {

    public static void main(String[] args) {
        System.out.println("===== Calculadora de Preço de Venda =====");

        CalculadorPreco calculador = new CalculadorPreco();

        boolean continuar = true;

        while (continuar) {
            String inputPrecoCompra = JOptionPane.showInputDialog(
                    null,
                    "Informe o preço de COMPRA do produto (R$):",
                    "Cálculo de Preço de Venda",
                    JOptionPane.QUESTION_MESSAGE);

            if (inputPrecoCompra == null) {
                JOptionPane.showMessageDialog(null, "Operação cancelada pelo usuário.", "Aviso",
                        JOptionPane.WARNING_MESSAGE);
                break;
            }

            try {
                double precoCompra = Double.parseDouble(inputPrecoCompra);
                double precoVenda = calculador.calcularPrecoVenda(precoCompra);
                String mensagemResultado = String.format("""
                        Detalhes do C\u00e1lculo:

                        Pre\u00e7o de Compra Informado: R$ %.2f
                        \u00cdndice Markup Aplicado: %.2f

                        Pre\u00e7o de Venda Calculado: R$ %.2f""",
                        precoCompra,
                        CalculadorPreco.MARKUP_FIXO,
                        precoVenda);

                JOptionPane.showMessageDialog(
                        null,
                        mensagemResultado,
                        "Resultado - Preço de Venda",
                        JOptionPane.INFORMATION_MESSAGE);

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(
                        null,
                        "Entrada inválida. Por favor, insira um valor numérico para o preço de compra.\nExemplo: 123.45",
                        "Erro de Entrada",
                        JOptionPane.ERROR_MESSAGE);
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(
                        null,
                        e.getMessage(),
                        "Erro de Validação",
                        JOptionPane.ERROR_MESSAGE);
            }

            int resposta = JOptionPane.showConfirmDialog(
                    null,
                    "Deseja calcular o preço de venda para outro produto?",
                    "Continuar?",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE);

            if (resposta == JOptionPane.NO_OPTION || resposta == JOptionPane.CLOSED_OPTION) {
                continuar = false;
            }
        }

        JOptionPane.showMessageDialog(null, "Aplicação encerrada.", "Informação", JOptionPane.INFORMATION_MESSAGE);
        System.out.println("===== Aplicação Encerrada =====");
    }
}