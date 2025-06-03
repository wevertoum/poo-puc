import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Aluno;

public class Principal {

    private static final List<Aluno> alunos = new ArrayList<>();

    public static void main(String[] args) {
        OUTER:
        while (true) {
            String[] opcoes = {"Cadastrar Aluno", "Sair"};
            int escolha = JOptionPane.showOptionDialog(null, "Sistema de Gerenciamento Escolar",
                    "SchoolSystem", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);
            switch (escolha) {
                case 0 ->
                    cadastrarAluno();
                case 1 -> {
                    JOptionPane.showMessageDialog(null, "Sistema encerrado.");
                    break OUTER;
                }
                default -> {
                }
            }
        }
    }

    private static void cadastrarAluno() {
        try {
            String nome = JOptionPane.showInputDialog("Digite o nome do aluno:");
            String endereco = JOptionPane.showInputDialog("Digite o endereço residencial:");
            String telefone = JOptionPane.showInputDialog("Digite o telefone de contato:");
            String email = JOptionPane.showInputDialog("Digite o e-mail:");
            String matricula = JOptionPane.showInputDialog("Digite a matrícula:");

            Aluno aluno = new Aluno(nome, endereco, telefone, email, matricula);
            alunos.add(aluno);
            JOptionPane.showMessageDialog(null, "Aluno cadastrado com sucesso!\n" + aluno.toString());

            StringBuilder listaAlunos = new StringBuilder("Alunos cadastrados:\n");
            for (Aluno a : alunos) {
                listaAlunos.append(a.toString()).append("\n");
            }
            JOptionPane.showMessageDialog(null, listaAlunos.toString());
        } catch (NullPointerException | java.awt.HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
        } catch (RuntimeException e) {
            JOptionPane.showMessageDialog(null, "Erro inesperado: " + e.getMessage());
        }
    }
}