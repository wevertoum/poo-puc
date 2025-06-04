import java.awt.HeadlessException;
import javax.swing.JOptionPane;

class EntradaInvalidaCalculoException extends Exception {
    public EntradaInvalidaCalculoException(String message) {
        super(message);
    }
}

public class App {

    public static void main(String[] args) {
        System.out.println("===== Calculadora de Área de Cômodos (Sobrecarga) =====");

        Area calculadora = new Area();

        String[] opcoesMenu = { "Calcular Área do Quadrado", "Calcular Área do Retângulo", "Calcular Área do Trapézio",
                "Sair" };
        int escolha;

        do {
            escolha = JOptionPane.showOptionDialog(
                    null,
                    "Selecione a forma do cômodo para calcular a área:",
                    "Calculadora de Áreas - Construção Civil",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    opcoesMenu,
                    opcoesMenu[0]);

            String tipoFigura = "";
            double areaCalculada = 0;
            boolean calculoRealizado = false;

            try {
                switch (escolha) {
                    case 0 -> {
                        tipoFigura = "Quadrado";
                        double ladoQuad = lerDimensao("Informe o lado do " + tipoFigura + " (em metros):");
                        areaCalculada = calculadora.calcularArea(ladoQuad);
                        calculoRealizado = true;
                    }

                    case 1 -> {
                        tipoFigura = "Retângulo";
                        double baseRet = lerDimensao("Informe a base do " + tipoFigura + " (em metros):");
                        double alturaRet = lerDimensao("Informe a altura do " + tipoFigura + " (em metros):");
                        areaCalculada = calculadora.calcularArea(baseRet, alturaRet);

                        calculoRealizado = true;
                    }

                    case 2 -> {
                        tipoFigura = "Trapézio";
                        double baseMaiorTrap = lerDimensao("Informe a base MAIOR do " + tipoFigura + " (em metros):");
                        double baseMenorTrap = lerDimensao("Informe a base MENOR do " + tipoFigura + " (em metros):");
                        double alturaTrap = lerDimensao("Informe a altura do " + tipoFigura + " (em metros):");
                        areaCalculada = calculadora.calcularArea(baseMaiorTrap, baseMenorTrap, alturaTrap);

                        calculoRealizado = true;
                    }

                    case 3 -> JOptionPane.showMessageDialog(null, "Saindo da calculadora...", "Informação",
                            JOptionPane.INFORMATION_MESSAGE);

                    case JOptionPane.CLOSED_OPTION -> {
                        JOptionPane.showMessageDialog(null, "Operação cancelada. Saindo...", "Informação",
                                JOptionPane.INFORMATION_MESSAGE);
                        escolha = 3;
                    }

                    default -> {
                    }
                }

                if (calculoRealizado) {
                    JOptionPane.showMessageDialog(
                            null,
                            "A Área do " + tipoFigura + " é: " + String.format("%.2f", areaCalculada) + " m².",
                            "Resultado do Cálculo de Área",
                            JOptionPane.INFORMATION_MESSAGE);
                }

            } catch (EntradaInvalidaCalculoException e) {
                JOptionPane.showMessageDialog(null, "Erro de entrada: " + e.getMessage(), "Erro",
                        JOptionPane.ERROR_MESSAGE);
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, "Erro nos dados da figura: " + e.getMessage(), "Erro de Dados",
                        JOptionPane.ERROR_MESSAGE);
            } catch (HeadlessException e) {
                JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado: " + e.getMessage(), "Erro Crítico",
                        JOptionPane.ERROR_MESSAGE);
            }

        } while (escolha != 3);

        System.out.println("===== Aplicação Encerrada =====");
    }

    private static double lerDimensao(String mensagemPrompt) throws EntradaInvalidaCalculoException {
        String input = JOptionPane.showInputDialog(null, mensagemPrompt, "Entrada de Dados - Área",
                JOptionPane.QUESTION_MESSAGE);
        if (input == null) {
            throw new EntradaInvalidaCalculoException("Entrada de dados cancelada pelo usuário.");
        }
        try {
            double valor = Double.parseDouble(input);

            return valor;
        } catch (NumberFormatException e) {
            throw new EntradaInvalidaCalculoException("Valor inserido ('" + input + "') não é um número válido.");
        }
    }
}