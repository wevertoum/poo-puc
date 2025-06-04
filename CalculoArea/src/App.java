import java.awt.HeadlessException;
import javax.swing.JOptionPane;

class EntradaInvalidaException extends Exception {
    public EntradaInvalidaException(String message) {
        super(message);
    }
}

public class App {

    public static void main(String[] args) {
        System.out.println("===== Calculadora de Área de Figuras Geométricas =====");

        String[] opcoesMenu = { "Calcular Área do Retângulo", "Calcular Área do Triângulo Retângulo", "Sair" };
        int escolha;

        do {
            escolha = JOptionPane.showOptionDialog(
                    null,
                    "Selecione a figura geométrica para calcular a área:",
                    "Calculadora de Áreas",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    opcoesMenu,
                    opcoesMenu[0]);

            FiguraGeometrica figura = null;
            String tipoFigura = "";

            try {
                switch (escolha) {
                    case 0 -> {
                        tipoFigura = "Retângulo";
                        double baseRet = lerDimensao("Informe a base do " + tipoFigura + ":");
                        double alturaRet = lerDimensao("Informe a altura do " + tipoFigura + ":");
                        figura = new Retangulo(baseRet, alturaRet);
                    }
                    case 1 -> {
                        tipoFigura = "Triângulo Retângulo";
                        double baseTri = lerDimensao("Informe a base do " + tipoFigura + ":");
                        double alturaTri = lerDimensao("Informe a altura do " + tipoFigura + ":");
                        figura = new TrianguloRetangulo(baseTri, alturaTri);
                    }
                    case 2 -> JOptionPane.showMessageDialog(null, "Saindo da calculadora...", "Informação",
                                JOptionPane.INFORMATION_MESSAGE);
                    case JOptionPane.CLOSED_OPTION -> {
                        JOptionPane.showMessageDialog(null, "Operação cancelada. Saindo...", "Informação",
                                JOptionPane.INFORMATION_MESSAGE);
                        escolha = 2;
                    }
                    default -> {
                    }
                }

                if (figura != null) {
                    double area = figura.calcularArea();
                    JOptionPane.showMessageDialog(
                            null,
                            "Dados da Figura:\n" + figura.toString() +
                                    "\n\nA Área do " + tipoFigura + " é: " + String.format("%.2f", area)
                                    + " unidades de área.",
                            "Resultado do Cálculo",
                            JOptionPane.INFORMATION_MESSAGE);
                }

            } catch (EntradaInvalidaException e) {
                JOptionPane.showMessageDialog(null, "Erro de entrada: " + e.getMessage(), "Erro",
                        JOptionPane.ERROR_MESSAGE);
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, "Erro ao criar figura: " + e.getMessage(), "Erro de Dados",
                        JOptionPane.ERROR_MESSAGE);
            } catch (HeadlessException e) {
                JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado: " + e.getMessage(), "Erro Crítico",
                        JOptionPane.ERROR_MESSAGE);
            }

        } while (escolha != 2);

        System.out.println("===== Aplicação Encerrada =====");
    }

    private static double lerDimensao(String mensagemPrompt) throws EntradaInvalidaException {
        String input = JOptionPane.showInputDialog(null, mensagemPrompt, "Entrada de Dados",
                JOptionPane.QUESTION_MESSAGE);
        if (input == null) {
            throw new EntradaInvalidaException("Entrada de dados cancelada pelo usuário.");
        }
        try {
            double valor = Double.parseDouble(input);
            if (valor <= 0) {
                throw new EntradaInvalidaException("O valor da dimensão deve ser positivo.");
            }
            return valor;
        } catch (NumberFormatException e) {
            throw new EntradaInvalidaException("Valor inserido ('" + input + "') não é um número válido.");
        }
    }
}