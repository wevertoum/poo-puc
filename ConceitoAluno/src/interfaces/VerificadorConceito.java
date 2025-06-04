package interfaces;

import javax.swing.JOptionPane;

public class VerificadorConceito implements FeedbackAluno {

    private int opcaoSelecionada;

    public VerificadorConceito() {

    }

    public void analisarEExibirFeedback(int opcao) {
        this.opcaoSelecionada = opcao;
        String mensagemFeedback;

        mensagemFeedback = switch (this.opcaoSelecionada) {
            case 1 ->
                CONCEITO_EXCELENCIA;
            case 2 ->
                CONCEITO_SATISFATORIO;
            case 3 ->
                CONCEITO_INSUFICIENTE;
            default ->
                "Opção inválida. Por favor, insira 1, 2 ou 3.";
        };

        JOptionPane.showMessageDialog(
                null,
                mensagemFeedback,
                "Conceito do Aluno",
                JOptionPane.INFORMATION_MESSAGE
        );
    }
}
