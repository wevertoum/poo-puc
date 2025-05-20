
import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Emprestimo;
import model.ItemBiblioteca;
import model.Livro;
import model.Usuario;

public class Main {

    private static final List<ItemBiblioteca> itens = new ArrayList<>();
    private static final List<Usuario> usuarios = new ArrayList<>();
    private static final List<Emprestimo> emprestimos = new ArrayList<>();

    public static void main(String[] args) {
        itens.add(new Livro(1, "Dom Quixote", "Miguel de Cervantes"));
        itens.add(new Livro(2, "1984", "George Orwell"));
        itens.add(new Livro(3, "O Senhor dos Anéis", "J.R.R. Tolkien"));
        itens.add(new Livro(4, "A Revolução dos Bichos", "George Orwell"));
        itens.add(new Livro(5, "O Pequeno Príncipe", "Antoine de Saint-Exupéry"));
        itens.add(new Livro(6, "O peregrino", "John Bunyan"));
        itens.add(new Livro(7, "Viagem ao Centro da Terra", "Jules Verne"));
        itens.add(new Livro(8, "A Arte da Guerra", "Sun Tzu"));
        itens.add(new Livro(9, "O Príncipe", "Nicolau Maquiavel"));

        OUTER:
        while (true) {
            String[] opcoes = {"Consultar itens disponíveis", "Realizar empréstimo", "Devolver item", "Sair"};
            int escolha = JOptionPane.showOptionDialog(null, "Sistema de Gerenciamento de Biblioteca",
                    "Biblioteca", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);
            switch (escolha) {
                case 0 ->
                    consultarItensDisponiveis();
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

    private static void consultarItensDisponiveis() {
        StringBuilder sb = new StringBuilder("Itens disponíveis:\n");
        for (ItemBiblioteca item : itens) {
            if (item.isDisponivel()) {
                sb.append(item.toString()).append("\n");
            }
        }
        JOptionPane.showMessageDialog(null, sb.length() > 20 ? sb.toString() : "Nenhum item disponível.");
    }

    private static void realizarEmprestimo() {
        String cpf = JOptionPane.showInputDialog("Digite o CPF:");
        String nome = JOptionPane.showInputDialog("Digite o nome:");
        String idItemStr = JOptionPane.showInputDialog("Digite o ID do item:");

        try {
            int idItem = Integer.parseInt(idItemStr);
            ItemBiblioteca item = itens.stream().filter(i -> i.getId() == idItem && i.isDisponivel()).findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("Item não encontrado ou indisponível."));

            Usuario usuario = usuarios.stream().filter(u -> u.getCpf().equals(cpf)).findFirst()
                    .orElseGet(() -> {
                        Usuario novoUsuario = new Usuario(cpf, nome);
                        usuarios.add(novoUsuario);
                        return novoUsuario;
                    });

            Emprestimo emprestimo = new Emprestimo(item, usuario);
            emprestimos.add(emprestimo);
            JOptionPane.showMessageDialog(null, "Empréstimo realizado com sucesso!\n" + emprestimo.getDetalhes());
        } catch (HeadlessException | IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
        }
    }

    private static void realizarDevolucao() {
        String cpf = JOptionPane.showInputDialog("Digite o CPF:");
        String idItemStr = JOptionPane.showInputDialog("Digite o ID do item:");

        try {
            int idItem = Integer.parseInt(idItemStr);
            Usuario usuario = usuarios.stream().filter(u -> u.getCpf().equals(cpf)).findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado."));
            ItemBiblioteca item = itens.stream().filter(i -> i.getId() == idItem).findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("Item não encontrado."));

            if (!usuario.getItensEmprestados().contains(item)) {
                throw new IllegalArgumentException("Este item não está emprestado para este usuário.");
            }

            usuario.devolverItem(item);
            emprestimos.removeIf(e -> e.getDetalhes().contains(item.toString()) && e.getDetalhes().contains(usuario.getNome()));
            JOptionPane.showMessageDialog(null, "Item devolvido com sucesso: " + item.toString());
        } catch (HeadlessException | IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
        }
    }

    public static List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }
}
