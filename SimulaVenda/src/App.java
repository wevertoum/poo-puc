
import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;

public class App {

    private static final List<Produto> produtos = new ArrayList<>();
    private static final List<Comprador> compradores = new ArrayList<>();
    private static final List<Vendedor> vendedores = new ArrayList<>();
    private static final List<Venda> vendas = new ArrayList<>();

    public static void main(String[] args) {

        produtos.add(new Produto("Camiseta Estampada", 59.90f, 3));
        produtos.add(new Produto("Calça Jeans", 149.50f, 42));
        produtos.add(new Produto("Tênis Esportivo", 299.00f, 40));

        compradores.add(new Comprador("Maria Silva", 300.00f));
        compradores.add(new Comprador("João Santos", 500.00f));

        vendedores.add(new Vendedor("Carlos Andrade"));
        vendedores.add(new Vendedor("Ana Beatriz"));

        String[] opcoesMenuPrincipal = {
            "Gerenciar Produtos",
            "Gerenciar Compradores",
            "Gerenciar Vendedores",
            "Realizar Nova Venda",
            "Cancelar Venda",
            "Visualizar Dados",
            "Sair"
        };

        int escolhaMenu;
        do {
            escolhaMenu = JOptionPane.showOptionDialog(null,
                    "Selecione uma opção:", "Sistema de Vendas da Loja",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
                    opcoesMenuPrincipal, opcoesMenuPrincipal[0]);

            switch (escolhaMenu) {
                case 0 ->
                    gerenciarProdutos();
                case 1 ->
                    gerenciarCompradores();
                case 2 ->
                    gerenciarVendedores();
                case 3 ->
                    realizarNovaVenda();
                case 4 ->
                    cancelarVendaExistente();
                case 5 ->
                    visualizarDados();
                case 6, JOptionPane.CLOSED_OPTION ->
                    JOptionPane.showMessageDialog(null, "Encerrando o sistema...");
                default -> {
                }
            }
        } while (escolhaMenu != 6 && escolhaMenu != JOptionPane.CLOSED_OPTION);
    }

    private static void gerenciarProdutos() {
        String[] opcoes = {"Adicionar Produto", "Listar Produtos", "Voltar"};
        int escolha = JOptionPane.showOptionDialog(null, "Gerenciamento de Produtos", "Produtos",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);
        if (escolha == 0) {
            adicionarNovoProduto();
        } else if (escolha == 1) {
            visualizarLista("Produtos Cadastrados", produtos);
        }
    }

    private static void gerenciarCompradores() {
        String[] opcoes = {"Adicionar Comprador", "Listar Compradores", "Voltar"};
        int escolha = JOptionPane.showOptionDialog(null, "Gerenciamento de Compradores", "Compradores",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);
        if (escolha == 0) {
            adicionarNovoComprador();
        } else if (escolha == 1) {
            visualizarLista("Compradores Cadastrados", compradores);
        }
    }

    private static void gerenciarVendedores() {
        String[] opcoes = {"Adicionar Vendedor", "Listar Vendedores", "Voltar"};
        int escolha = JOptionPane.showOptionDialog(null, "Gerenciamento de Vendedores", "Vendedores",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);
        if (escolha == 0) {
            adicionarNovoVendedor();
        } else if (escolha == 1) {
            visualizarLista("Vendedores Cadastrados", vendedores);
        }
    }

    private static void adicionarNovoProduto() {
        try {
            String nome = JOptionPane.showInputDialog(null, "Nome do produto:", "Novo Produto", JOptionPane.QUESTION_MESSAGE);
            if (nome == null || nome.trim().isEmpty()) {
                return;
            }
            String precoStr = JOptionPane.showInputDialog(null, "Preço do produto (ex: 49.90):", "Novo Produto", JOptionPane.QUESTION_MESSAGE);
            if (precoStr == null) {
                return;

            }
            float preco = Float.parseFloat(precoStr);

            String tamanhoStr = JOptionPane.showInputDialog(null, "Tamanho do produto (numérico):", "Novo Produto", JOptionPane.QUESTION_MESSAGE);
            if (tamanhoStr == null) {
                return;

            }
            int tamanho = Integer.parseInt(tamanhoStr);

            Produto novoProduto = new Produto(nome, preco, tamanho);
            produtos.add(novoProduto);
            JOptionPane.showMessageDialog(null, "Produto '" + nome + "' adicionado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Erro: Preço ou tamanho inválido. Use números.", "Erro de Formato", JOptionPane.ERROR_MESSAGE);
        } catch (NullPointerException e) {

            JOptionPane.showMessageDialog(null, "Entrada cancelada.", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }

    private static void adicionarNovoComprador() {
        try {
            String nome = JOptionPane.showInputDialog(null, "Nome do comprador:", "Novo Comprador", JOptionPane.QUESTION_MESSAGE);
            if (nome == null || nome.trim().isEmpty()) {
                return;
            }

            String recursoStr = JOptionPane.showInputDialog(null, "Recurso inicial do comprador (ex: 200.00):", "Novo Comprador", JOptionPane.QUESTION_MESSAGE);
            if (recursoStr == null) {
                return;
            }
            float recurso = Float.parseFloat(recursoStr);

            Comprador novoComprador = new Comprador(nome, recurso);
            compradores.add(novoComprador);
            JOptionPane.showMessageDialog(null, "Comprador '" + nome + "' adicionado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Erro: Recurso inválido. Use um número.", "Erro de Formato", JOptionPane.ERROR_MESSAGE);
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Entrada cancelada.", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }

    private static void adicionarNovoVendedor() {
        try {
            String nome = JOptionPane.showInputDialog(null, "Nome do vendedor:", "Novo Vendedor", JOptionPane.QUESTION_MESSAGE);
            if (nome == null || nome.trim().isEmpty()) {
                return;
            }

            Vendedor novoVendedor = new Vendedor(nome);
            vendedores.add(novoVendedor);
            JOptionPane.showMessageDialog(null, "Vendedor '" + nome + "' adicionado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Entrada cancelada.", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }

    private static void realizarNovaVenda() {
        if (produtos.stream().noneMatch(p -> !p.isVendido())) {
            JOptionPane.showMessageDialog(null, "Nenhum produto disponível para venda.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (compradores.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum comprador cadastrado.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (vendedores.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum vendedor cadastrado.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            List<Produto> produtosDisponiveis = produtos.stream().filter(p -> !p.isVendido()).collect(Collectors.toList());
            Produto produtoSelecionado = selecionarItem(produtosDisponiveis, "Selecione o Produto para Venda:");
            if (produtoSelecionado == null) {
                return;
            }

            Comprador compradorSelecionado = selecionarItem(compradores, "Selecione o Comprador:");
            if (compradorSelecionado == null) {
                return;
            }

            Vendedor vendedorSelecionado = selecionarItem(vendedores, "Selecione o Vendedor:");
            if (vendedorSelecionado == null) {
                return;
            }

            Venda novaVenda = new Venda(compradorSelecionado, vendedorSelecionado, produtoSelecionado);
            boolean sucesso = novaVenda.finalizarVenda();

            if (sucesso) {
                vendas.add(novaVenda);
                JOptionPane.showMessageDialog(null, "Venda (ID: " + novaVenda.getIdVenda() + ") finalizada com sucesso!\n"
                        + "Comprador: " + compradorSelecionado.getNome() + " (Recursos restantes: R$" + String.format("%.2f", compradorSelecionado.getRecurso()) + ")\n"
                        + "Vendedor: " + vendedorSelecionado.getNome() + " (Comissão acumulada: R$" + String.format("%.2f", vendedorSelecionado.getComissaoAcumulada()) + ")",
                        "Venda Realizada", JOptionPane.INFORMATION_MESSAGE);
            } else {

                String motivoFalha = "Pagamento não pôde ser concluído (recursos insuficientes ou produto indisponível).";
                if (produtoSelecionado.isVendido()) {
                    motivoFalha = "Produto '" + produtoSelecionado.getNome() + "' foi vendido momentos antes ou está indisponível.";
                } else if (compradorSelecionado.getRecurso() < produtoSelecionado.getPreco()) {
                    motivoFalha = "Comprador não possui recursos suficientes.";
                }
                JOptionPane.showMessageDialog(null, "Falha ao finalizar a venda.\nMotivo: " + motivoFalha, "Falha na Venda", JOptionPane.ERROR_MESSAGE);
            }
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao tentar realizar a venda: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);

        }
    }

    private static void cancelarVendaExistente() {
        if (vendas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhuma venda registrada para cancelar.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        List<Venda> vendasParaCancelar = vendas.stream()
                .filter(v -> !v.isFinalizada() && !v.isCancelada())
                .collect(Collectors.toList());

        if (vendasParaCancelar.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhuma venda pendente (não finalizada e não cancelada) para cancelar.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        try {
            Venda vendaSelecionada = selecionarItem(vendasParaCancelar, "Selecione a Venda Pendente para Cancelar:");
            if (vendaSelecionada == null) {
                return;
            }
            vendaSelecionada.cancelarVenda();

            JOptionPane.showMessageDialog(null, "Venda ID " + vendaSelecionada.getIdVenda() + " cancelada com sucesso.", "Venda Cancelada", JOptionPane.INFORMATION_MESSAGE);
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao tentar cancelar a venda: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);

        }
    }

    private static void visualizarDados() {
        String[] opcoesVisualizar = {"Listar Produtos", "Listar Compradores", "Listar Vendedores", "Listar Vendas", "Voltar"};
        int escolha = JOptionPane.showOptionDialog(null, "Selecione o que deseja visualizar:", "Visualizar Dados",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
                opcoesVisualizar, opcoesVisualizar[0]);

        switch (escolha) {
            case 0 ->
                visualizarLista("Produtos Cadastrados", produtos);
            case 1 ->
                visualizarLista("Compradores Cadastrados", compradores);
            case 2 ->
                visualizarLista("Vendedores Cadastrados", vendedores);
            case 3 ->
                visualizarLista("Histórico de Vendas", vendas);
            case 4, JOptionPane.CLOSED_OPTION -> {

            }
        }
    }

    private static <T> void visualizarLista(String titulo, List<T> lista) {
        if (lista.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum item para listar em '" + titulo + "'.", "Lista Vazia", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (T item : lista) {
            sb.append(item.toString()).append("\n");
            count++;
            if (count % 15 == 0 && lista.size() > 15) {
                sb.append("--- (mais itens abaixo) ---\n");
            }
        }

        if (lista.size() > 15) {
            javax.swing.JTextArea textArea = new javax.swing.JTextArea(sb.toString());
            javax.swing.JScrollPane scrollPane = new javax.swing.JScrollPane(textArea);
            textArea.setLineWrap(true);
            textArea.setWrapStyleWord(true);
            scrollPane.setPreferredSize(new java.awt.Dimension(500, 400));
            JOptionPane.showMessageDialog(null, scrollPane, titulo, JOptionPane.PLAIN_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, sb.toString(), titulo, JOptionPane.PLAIN_MESSAGE);
        }
    }

    private static <T> T selecionarItem(List<T> lista, String mensagemPrompt) {
        if (lista.isEmpty()) {

            return null;
        }

        String[] displayOpcoes = new String[lista.size()];
        for (int i = 0; i < lista.size(); i++) {
            T item = lista.get(i);
            if (item instanceof Produto produto) {
                displayOpcoes[i] = produto.getIdProduto() + ": " + produto.getNome() + (produto.isVendido() ? " (Vendido)" : " (Disponível R$" + String.format("%.2f", produto.getPreco()) + ")");
            } else if (item instanceof Comprador comprador) {
                displayOpcoes[i] = comprador.getIdComprador() + ": " + comprador.getNome() + " (R$" + String.format("%.2f", comprador.getRecurso()) + ")";
            } else if (item instanceof Vendedor vendedor) {
                displayOpcoes[i] = vendedor.getIdVendedor() + ": " + vendedor.getNome();
            } else if (item instanceof Venda venda) {
                displayOpcoes[i] = "ID Venda: " + venda.getIdVenda() + " (Produto: " + venda.getProduto().getNome() + " - Status: " + (venda.isFinalizada() ? "Finalizada" : (venda.isCancelada() ? "Cancelada" : "Pendente")) + ")";
            } else {
                displayOpcoes[i] = (item != null ? item.toString() : "null");
            }
        }

        Object selecionadoObj = JOptionPane.showInputDialog(null, mensagemPrompt,
                "Seleção de Item", JOptionPane.QUESTION_MESSAGE, null,
                displayOpcoes, (displayOpcoes.length > 0 ? displayOpcoes[0] : null));

        if (selecionadoObj == null) {
            return null;
        }

        String selecionadoStr = (String) selecionadoObj;

        for (int i = 0; i < displayOpcoes.length; i++) {
            if (displayOpcoes[i].equals(selecionadoStr)) {
                return lista.get(i);
            }
        }
        return null;
    }
}
