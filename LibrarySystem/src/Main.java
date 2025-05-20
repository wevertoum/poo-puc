
import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Emprestimo;
import model.Livro;
import model.Usuario;

public class Main {

    private static final List<Livro> livros = new ArrayList<>();
    private static final List<Usuario> usuarios = new ArrayList<>();
    private static final List<Emprestimo> emprestimos = new ArrayList<>();

    public static void main(String[] args) {
        livros.add(new Livro(1, "Dom Quixote", "Miguel de Cervantes"));
        livros.add(new Livro(2, "1984", "George Orwell"));
        livros.add(new Livro(3, "O Senhor dos Anéis", "J.R.R. Tolkien"));
        livros.add(new Livro(4, "A Revolução dos Bichos", "George Orwell"));
        livros.add(new Livro(5, "O Pequeno Príncipe", "Antoine de Saint-Exupéry"));
        livros.add(new Livro(6, "O peregrino", "John Bunyan"));
        livros.add(new Livro(7, "Viagem ao Centro da Terra", "Jules Verne"));
        livros.add(new Livro(8, "A Arte da Guerra", "Sun Tzu"));
        livros.add(new Livro(9, "O Príncipe", "Nicolau Maquiavel"));

        OUTER:
        while (true) {
            String[] opcoes = {"Consultar livros disponíveis", "Realizar empréstimo", "Devolver livro", "Sair"};
            int escolha = JOptionPane.showOptionDialog(null, "Sistema de Gerenciamento de Biblioteca",
                    "Biblioteca", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);
            switch (escolha) {
                case 0 ->
                    consultarLivrosDisponiveis();
                case 1 ->
                    realizarEmprestimo();
                case 2 ->
                    realizarDevolucao();
                case 3 -> {
                    JOptionPane.showMessageDialog(null, "Sistema encerrado.");
                    break OUTER;
                }
                default -> {
                }
            }
        }
    }

    private static void consultarLivrosDisponiveis() {
        StringBuilder sb = new StringBuilder("Livros disponíveis:\n");
        for (Livro livro : livros) {
            if (livro.isDisponivel()) {
                sb.append(livro.toString()).append("\n");
            }
        }
        JOptionPane.showMessageDialog(null, sb.length() > 20 ? sb.toString() : "Nenhum livro disponível.");
    }

    private static void realizarEmprestimo() {
        String cpf = JOptionPane.showInputDialog("Digite o CPF:");
        String nome = JOptionPane.showInputDialog("Digite o nome:");
        String idLivroStr = JOptionPane.showInputDialog("Digite o ID do livro:");

        try {
            int idLivro = Integer.parseInt(idLivroStr);
            Livro livro = livros.stream().filter(l -> l.getId() == idLivro && l.isDisponivel()).findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("Livro não encontrado ou indisponível."));

            Usuario usuario = usuarios.stream().filter(u -> u.getCpf().equals(cpf)).findFirst()
                    .orElseGet(() -> {
                        Usuario novoUsuario = new Usuario(cpf, nome);
                        usuarios.add(novoUsuario);
                        return novoUsuario;
                    });

            Emprestimo emprestimo = new Emprestimo(livro, usuario);
            emprestimos.add(emprestimo);
            JOptionPane.showMessageDialog(null, "Empréstimo realizado com sucesso!\n" + emprestimo.getDetalhes());
        } catch (HeadlessException | IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
        }
    }

    private static void realizarDevolucao() {
        String cpf = JOptionPane.showInputDialog("Digite o CPF:");
        String idLivroStr = JOptionPane.showInputDialog("Digite o ID do livro:");

        try {
            int idLivro = Integer.parseInt(idLivroStr);
            Usuario usuario = usuarios.stream().filter(u -> u.getCpf().equals(cpf)).findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado."));
            Livro livro = livros.stream().filter(l -> l.getId() == idLivro).findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("Livro não encontrado."));

            if (!usuario.getLivrosEmprestados().contains(livro)) {
                throw new IllegalArgumentException("Este livro não está emprestado para este usuário.");
            }

            usuario.devolverLivro(livro);
            emprestimos.removeIf(e -> e.getDetalhes().contains(livro.getTitulo()) && e.getDetalhes().contains(usuario.getNome()));
            JOptionPane.showMessageDialog(null, "Livro devolvido com sucesso: " + livro.getTitulo());
        } catch (HeadlessException | IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
        }
    }

    public static List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }
}
