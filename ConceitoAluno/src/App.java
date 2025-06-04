
import interfaces.VerificadorConceito;
import javax.swing.JOptionPane;

public class App {

    public static void main(String[] args) {
        System.out.println("===== Sistema de Conceito do Aluno =====");

        // Cria uma instância da classe que implementa a interface
        VerificadorConceito verificador = new VerificadorConceito();

        boolean continuar = true;
        while (continuar) {
            String inputOpcao = JOptionPane.showInputDialog(null, """
                                                                  Informe a op\u00e7\u00e3o referente ao desempenho do aluno:
                                                                  1 - Excel\u00eancia
                                                                  2 - Satisfat\u00f3rio
                                                                  3 - Insuficiente
                                                                  
                                                                  Digite 1, 2 ou 3:""",
                    "Entrada de Conceito",
                    JOptionPane.QUESTION_MESSAGE
            );

            if (inputOpcao == null) { // Usuário clicou em Cancelar ou fechou a janela
                JOptionPane.showMessageDialog(null, "Operação cancelada.", "Aviso", JOptionPane.WARNING_MESSAGE);
                break; // Sai do loop
            }

            try {
                int opcao = Integer.parseInt(inputOpcao);
                verificador.analisarEExibirFeedback(opcao); // Chama o método para exibir o feedback

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(
                        null,
                        "Entrada inválida. Por favor, digite um número (1, 2 ou 3).",
                        "Erro de Entrada",
                        JOptionPane.ERROR_MESSAGE
                );
            }

            int resposta = JOptionPane.showConfirmDialog(
                    null,
                    "Deseja verificar outro conceito?",
                    "Continuar?",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE
            );

            if (resposta == JOptionPane.NO_OPTION || resposta == JOptionPane.CLOSED_OPTION) {
                continuar = false;
            }
        }

        JOptionPane.showMessageDialog(null, "Sistema encerrado.", "Informação", JOptionPane.INFORMATION_MESSAGE);
        System.out.println("===== Sistema Encerrado =====");
    }
}
