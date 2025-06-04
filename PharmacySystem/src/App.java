import javax.swing.JOptionPane;

class OperacaoCanceladaException extends RuntimeException {
    public OperacaoCanceladaException(String message) {
        super(message);
    }
}

public class App {

    public static void main(String[] args) {
        System.out.println("===== Sistema de Cadastro Entidades para Farmácia =====");

        String[] options = { "Cadastrar Associado", "Cadastrar Colaborador", "Cadastrar Fornecedor", "Sair" };
        int choice;

        do {
            choice = JOptionPane.showOptionDialog(null, "Selecione uma opção de cadastro:",
                    "Menu Principal - Farmácia System",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            try {
                switch (choice) {
                    case 0:
                        cadastrarAssociado();
                        break;
                    case 1:
                        cadastrarColaborador();
                        break;
                    case 2:
                        cadastrarFornecedor();
                        break;
                    case 3:
                        JOptionPane.showMessageDialog(null, "Saindo do sistema...", "Farmácia System",
                                JOptionPane.INFORMATION_MESSAGE);
                        break;
                    case JOptionPane.CLOSED_OPTION:
                        JOptionPane.showMessageDialog(null, "Sistema encerrado.", "Farmácia System",
                                JOptionPane.INFORMATION_MESSAGE);
                        choice = 3;
                        break;
                    default:

                        break;
                }
            } catch (OperacaoCanceladaException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Cadastro Interrompido",
                        JOptionPane.WARNING_MESSAGE);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null,
                        "Erro de formato de número. Verifique os dados inseridos.\nDetalhe: " + e.getMessage(),
                        "Erro de Entrada", JOptionPane.ERROR_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado: " + e.getMessage(), "Erro Crítico",
                        JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        } while (choice != 3);

        System.out.println("===== Operação Finalizada =====");
    }

    private static String lerString(String mensagemPrompt, String tituloJanela) throws OperacaoCanceladaException {
        String input = JOptionPane.showInputDialog(null, mensagemPrompt, tituloJanela, JOptionPane.QUESTION_MESSAGE);
        if (input == null) {
            throw new OperacaoCanceladaException("Operação cancelada pelo usuário.");
        }
        return input;
    }

    private static long lerLong(String mensagemPrompt, String tituloJanela)
            throws OperacaoCanceladaException, NumberFormatException {
        String input = lerString(mensagemPrompt, tituloJanela);
        try {
            return Long.parseLong(input);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Valor '" + input + "' não é um ID válido (número longo).");
        }
    }

    private static Object[] coletarDadosComunsBase() throws OperacaoCanceladaException, NumberFormatException {
        Object[] dadosComuns = new Object[10];
        String titulo = "Dados Comuns - Parte 1/2";

        dadosComuns[0] = lerLong("ID:", titulo);
        dadosComuns[1] = lerString("Nome Completo/Razão Social:", titulo);
        dadosComuns[2] = lerString("Logradouro (Rua, Av, etc.):", titulo);
        dadosComuns[3] = lerString("Número do Endereço:", titulo);
        dadosComuns[4] = lerString("CEP (somente números):", titulo);
        dadosComuns[5] = lerString("Bairro:", titulo);
        dadosComuns[6] = lerString("Cidade:", titulo);
        dadosComuns[7] = lerString("UF (Ex: GO, SP):", titulo);
        dadosComuns[8] = lerString("Telefone (com DDD):", titulo);
        dadosComuns[9] = lerString("CPF ou CNPJ:", titulo);

        return dadosComuns;
    }

    private static void cadastrarAssociado() throws OperacaoCanceladaException, NumberFormatException {
        JOptionPane.showMessageDialog(null, "Iniciando Cadastro de Associado...", "Novo Associado",
                JOptionPane.INFORMATION_MESSAGE);
        Object[] dadosComuns = coletarDadosComunsBase();

        String tituloEspecifico = "Dados do Associado - Parte 2/2";
        String situacao = lerString("Situação (Ex: Ativo, Inativo):", tituloEspecifico);
        String numeroAssociado = lerString("Número de Associado (fornecido):", tituloEspecifico);

        Associado novoAssociado = new Associado(
                (long) dadosComuns[0], (String) dadosComuns[1], (String) dadosComuns[2], (String) dadosComuns[3],
                (String) dadosComuns[4], (String) dadosComuns[5], (String) dadosComuns[6], (String) dadosComuns[7],
                (String) dadosComuns[8], (String) dadosComuns[9],
                situacao, numeroAssociado);

        JOptionPane.showMessageDialog(null, "Associado Cadastrado com Sucesso!\n\n" + novoAssociado.toString(),
                "Sucesso no Cadastro", JOptionPane.INFORMATION_MESSAGE);
    }

    private static void cadastrarColaborador() throws OperacaoCanceladaException, NumberFormatException {
        JOptionPane.showMessageDialog(null, "Iniciando Cadastro de Colaborador...", "Novo Colaborador",
                JOptionPane.INFORMATION_MESSAGE);
        Object[] dadosComuns = coletarDadosComunsBase();

        String tituloEspecifico = "Dados do Colaborador - Parte 2/2";
        String cargo = lerString("Cargo/Função:", tituloEspecifico);

        Colaborador novoColaborador = new Colaborador(
                (long) dadosComuns[0], (String) dadosComuns[1], (String) dadosComuns[2], (String) dadosComuns[3],
                (String) dadosComuns[4], (String) dadosComuns[5], (String) dadosComuns[6], (String) dadosComuns[7],
                (String) dadosComuns[8], (String) dadosComuns[9],
                cargo);
        JOptionPane.showMessageDialog(null, "Colaborador Cadastrado com Sucesso!\n\n" + novoColaborador.toString(),
                "Sucesso no Cadastro", JOptionPane.INFORMATION_MESSAGE);
    }

    private static void cadastrarFornecedor() throws OperacaoCanceladaException, NumberFormatException {
        JOptionPane.showMessageDialog(null, "Iniciando Cadastro de Fornecedor...", "Novo Fornecedor",
                JOptionPane.INFORMATION_MESSAGE);
        Object[] dadosComuns = coletarDadosComunsBase();

        String tituloEspecifico = "Dados do Fornecedor - Parte 2/2";
        String nomeFantasia = lerString("Nome Fantasia:", tituloEspecifico);
        String website = lerString("Website (Ex: www.site.com):", tituloEspecifico);

        Fornecedor novoFornecedor = new Fornecedor(
                (long) dadosComuns[0], (String) dadosComuns[1], (String) dadosComuns[2], (String) dadosComuns[3],
                (String) dadosComuns[4], (String) dadosComuns[5], (String) dadosComuns[6], (String) dadosComuns[7],
                (String) dadosComuns[8], (String) dadosComuns[9],
                nomeFantasia, website);
        JOptionPane.showMessageDialog(null, "Fornecedor Cadastrado com Sucesso!\n\n" + novoFornecedor.toString(),
                "Sucesso no Cadastro", JOptionPane.INFORMATION_MESSAGE);
    }
}