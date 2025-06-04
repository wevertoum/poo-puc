
import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;

class OperacaoCanceladaCadastroException extends RuntimeException {

    public OperacaoCanceladaCadastroException(String message) {
        super(message);
    }
}

public class App {

    public static void main(String[] args) {
        System.out.println("===== Sistema de Cadastro de Colaboradores da Escola =====");

        String[] opcoesMenu = {"Cadastrar Colaborador Pessoa Física", "Cadastrar Colaborador Pessoa Jurídica", "Sair"};
        int escolha;

        do {
            escolha = JOptionPane.showOptionDialog(
                    null,
                    "Selecione o tipo de colaborador para cadastrar:",
                    "Cadastro de Colaboradores",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    opcoesMenu,
                    opcoesMenu[0]
            );

            Colaborador novoColaborador = null;

            try {
                switch (escolha) {
                    case 0 ->
                        novoColaborador = cadastrarPessoaFisica();
                    case 1 ->
                        novoColaborador = cadastrarPessoaJuridica();
                    case 2 ->
                        JOptionPane.showMessageDialog(null, "Saindo do sistema...", "Informação", JOptionPane.INFORMATION_MESSAGE);
                    case JOptionPane.CLOSED_OPTION -> {
                        JOptionPane.showMessageDialog(null, "Operação cancelada. Saindo...", "Informação", JOptionPane.INFORMATION_MESSAGE);
                        escolha = 2;
                    }
                    default -> {
                    }
                }

                if (novoColaborador != null) {
                    JOptionPane.showMessageDialog(
                            null,
                            "Colaborador Cadastrado com Sucesso!\n\n" + novoColaborador.obterDetalhes(),
                            "Detalhes do Colaborador",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                    System.out.println("\n--- Colaborador Cadastrado ---");
                    System.out.println(novoColaborador.obterDetalhes());
                    System.out.println("Nome Principal: " + novoColaborador.getNomePrincipal());
                    System.out.println("Identificador Fiscal: " + novoColaborador.getIdentificadorFiscalPrincipal());
                }

            } catch (OperacaoCanceladaCadastroException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Cadastro Interrompido", JOptionPane.WARNING_MESSAGE);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Erro de formato numérico: " + e.getMessage() + "\nPor favor, insira um número válido.", "Erro de Entrada", JOptionPane.ERROR_MESSAGE);
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, "Erro nos dados fornecidos: " + e.getMessage(), "Erro de Validação", JOptionPane.ERROR_MESSAGE);
            } catch (HeadlessException e) {
                JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado: " + e.getMessage(), "Erro Crítico", JOptionPane.ERROR_MESSAGE);
            }

        } while (escolha != 2);

        System.out.println("===== Aplicação Encerrada =====");
    }

    private static String lerString(String mensagem) throws OperacaoCanceladaCadastroException {
        String input = JOptionPane.showInputDialog(null, mensagem, "Entrada de Dados", JOptionPane.QUESTION_MESSAGE);
        if (input == null) {
            throw new OperacaoCanceladaCadastroException("Cadastro cancelado pelo usuário.");
        }
        if (input.trim().isEmpty()) {

        }
        return input.trim();
    }

    private static String lerStringOpcional(String mensagem) throws OperacaoCanceladaCadastroException {
        String input = JOptionPane.showInputDialog(null, mensagem + " (Opcional, deixe em branco se não aplicável)", "Entrada de Dados", JOptionPane.QUESTION_MESSAGE);
        if (input == null) {
            throw new OperacaoCanceladaCadastroException("Cadastro cancelado pelo usuário.");
        }
        return input.trim();
    }

    private static int lerInt(String mensagem) throws OperacaoCanceladaCadastroException, NumberFormatException {
        String input = lerString(mensagem);
        try {
            int valor = Integer.parseInt(input);
            if (valor < 0) {
                throw new NumberFormatException("O valor para '" + mensagem.replace(":", "") + "' não pode ser negativo.");
            }
            return valor;
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Entrada inválida para '" + mensagem.replace(":", "") + "'. Esperado um número inteiro. Erro: " + e.getMessage());
        }
    }

    private static List<String> lerListaDisciplinas() throws OperacaoCanceladaCadastroException {
        String inputDisciplinas = lerString("Disciplinas que ministra (separadas por vírgula, ex: Matemática,Física):");
        if (inputDisciplinas.isEmpty()) {
            return new ArrayList<>();
        }

        return new ArrayList<>(Arrays.asList(inputDisciplinas.split("\\s*,\\s*")));
    }

    private static ColaboradorPessoaFisica cadastrarPessoaFisica() throws OperacaoCanceladaCadastroException, NumberFormatException {
        JOptionPane.showMessageDialog(null, "Cadastro de Colaborador Pessoa Física", "Novo Cadastro", JOptionPane.INFORMATION_MESSAGE);

        String nome = lerString("Nome Completo:");
        String cpf = lerString("CPF (somente números):");
        String rg = lerString("RG:");
        int idade = lerInt("Idade:");
        String logradouro = lerString("Logradouro (Rua, Av., etc.):");
        String numeroEnd = lerString("Número do Endereço:");
        String bairro = lerString("Bairro:");
        String cidade = lerString("Cidade:");
        String uf = lerString("UF (Ex: SP, RJ):");
        String telefone = lerString("Telefone (com DDD):");
        String email = lerString("E-mail:");
        String titulacao = lerString("Titulação (Ex: Graduado, Mestre):");
        List<String> disciplinas = lerListaDisciplinas();

        return new ColaboradorPessoaFisica(nome, cpf, rg, idade, logradouro, numeroEnd, bairro, cidade, uf,
                telefone, email, titulacao, disciplinas);
    }

    private static ColaboradorPessoaJuridica cadastrarPessoaJuridica() throws OperacaoCanceladaCadastroException, NumberFormatException {
        JOptionPane.showMessageDialog(null, "Cadastro de Colaborador Pessoa Jurídica", "Novo Cadastro", JOptionPane.INFORMATION_MESSAGE);

        String razaoSocial = lerString("Razão Social:");
        String nomeFantasia = lerStringOpcional("Nome Fantasia:");
        String cnpj = lerString("CNPJ (somente números):");
        String inscricaoMunicipal = lerStringOpcional("Inscrição Municipal:");
        String inscricaoEstadual = lerStringOpcional("Inscrição Estadual:");
        String logradouro = lerString("Logradouro da Sede:");
        String numeroEnd = lerString("Número do Endereço da Sede:");
        String bairro = lerString("Bairro da Sede:");
        String cidade = lerString("Cidade da Sede:");
        String uf = lerString("UF da Sede (Ex: SP, RJ):");
        String telefone = lerString("Telefone de Contato (com DDD):");
        String email = lerString("E-mail de Contato:");
        String website = lerStringOpcional("Website (Ex: www.empresa.com):");
        List<String> disciplinas = lerListaDisciplinas();

        return new ColaboradorPessoaJuridica(razaoSocial, nomeFantasia, cnpj, inscricaoMunicipal, inscricaoEstadual,
                logradouro, numeroEnd, bairro, cidade, uf, telefone, email, website, disciplinas);
    }
}
