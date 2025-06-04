
import java.awt.HeadlessException;
import javax.swing.JOptionPane;

class EntradaCanceladaException extends RuntimeException {

    public EntradaCanceladaException(String message) {
        super(message);
    }
}

public class App {

    public static void main(String[] args) {
        System.out.println("===== Calculadora Polimórfica =====");

        String[] opcoesMenu = {"Soma", "Subtração", "Multiplicação", "Divisão", "Sair"};
        int escolha;

        do {
            escolha = JOptionPane.showOptionDialog(
                    null,
                    "Selecione a operação matemática desejada:",
                    "Calculadora Básica",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    opcoesMenu,
                    opcoesMenu[0]
            );

            if (escolha == 4 || escolha == JOptionPane.CLOSED_OPTION) {
                if (escolha == 4) {
                    JOptionPane.showMessageDialog(null, "Saindo da calculadora...", "Informação", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Operação cancelada. Saindo...", "Informação", JOptionPane.INFORMATION_MESSAGE);
                }
                break;
            }

            Operacao operacaoSelecionada;
            String nomeOperacao;

            switch (escolha) {
                case 0 -> {
                    operacaoSelecionada = new Soma();
                    nomeOperacao = "Soma";
                }
                case 1 -> {
                    operacaoSelecionada = new Subtracao();
                    nomeOperacao = "Subtração";
                }
                case 2 -> {
                    operacaoSelecionada = new Multiplicacao();
                    nomeOperacao = "Multiplicação";
                }
                case 3 -> {
                    operacaoSelecionada = new Divisao();
                    nomeOperacao = "Divisão";
                }
                default -> {
                    JOptionPane.showMessageDialog(null, "Opção inválida.", "Erro", JOptionPane.ERROR_MESSAGE);
                    continue;
                }
            }

            try {

                double num1 = lerNumero("Informe o primeiro número:");
                double num2 = lerNumero("Informe o segundo número para a " + nomeOperacao.toLowerCase() + ":");

                double resultado = operacaoSelecionada.calcular(num1, num2);

                JOptionPane.showMessageDialog(
                        null,
                        String.format("O resultado da %s entre %.2f e %.2f é: %.2f",
                                nomeOperacao, num1, num2, resultado),
                        "Resultado da Operação",
                        JOptionPane.INFORMATION_MESSAGE
                );

            } catch (EntradaCanceladaException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Operação Interrompida", JOptionPane.WARNING_MESSAGE);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Entrada inválida. Por favor, insira um número válido.", "Erro de Entrada", JOptionPane.ERROR_MESSAGE);
            } catch (ArithmeticException e) {
                JOptionPane.showMessageDialog(null, "Erro aritmético: " + e.getMessage(), "Erro de Cálculo", JOptionPane.ERROR_MESSAGE);
            } catch (HeadlessException e) {
                JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado: " + e.getMessage(), "Erro Crítico", JOptionPane.ERROR_MESSAGE);

            }

        } while (true);

        System.out.println("===== Aplicação Calculadora Encerrada =====");
    }

    private static double lerNumero(String mensagemPrompt) throws EntradaCanceladaException, NumberFormatException {
        String input = JOptionPane.showInputDialog(null, mensagemPrompt, "Entrada de Número", JOptionPane.QUESTION_MESSAGE);
        if (input == null) {
            throw new EntradaCanceladaException("Entrada de número cancelada pelo usuário.");
        }

        input = input.trim().replace(',', '.');
        if (input.isEmpty()) {
            throw new NumberFormatException("Nenhum número foi inserido.");
        }
        return Double.parseDouble(input);
    }
}
