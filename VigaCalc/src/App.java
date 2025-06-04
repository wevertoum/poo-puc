import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) {
        String inputBase, inputAltura, inputComprimento;
        double base = 0, altura = 0, comprimento = 0;
        boolean dadosValidos = false;

        while (!dadosValidos) {
            inputBase = JOptionPane.showInputDialog(null, "Informe a base da viga (em metros):",
                    "Cálculo de Volume de Viga", JOptionPane.QUESTION_MESSAGE);
            if (inputBase == null) {
                JOptionPane.showMessageDialog(null, "Operação cancelada.", "Aviso", JOptionPane.WARNING_MESSAGE);
                return;
            }
            try {
                base = Double.parseDouble(inputBase);
                if (base <= 0) {
                    JOptionPane.showMessageDialog(null, "A base deve ser um valor positivo.", "Erro de Entrada",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    dadosValidos = true;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Entrada inválida para a base. Por favor, insira um número.",
                        "Erro de Entrada", JOptionPane.ERROR_MESSAGE);
            }
        }

        dadosValidos = false;
        while (!dadosValidos) {
            inputAltura = JOptionPane.showInputDialog(null, "Informe a altura da viga (em metros):",
                    "Cálculo de Volume de Viga", JOptionPane.QUESTION_MESSAGE);
            if (inputAltura == null) {
                JOptionPane.showMessageDialog(null, "Operação cancelada.", "Aviso", JOptionPane.WARNING_MESSAGE);
                return;
            }
            try {
                altura = Double.parseDouble(inputAltura);
                if (altura <= 0) {
                    JOptionPane.showMessageDialog(null, "A altura deve ser um valor positivo.", "Erro de Entrada",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    dadosValidos = true;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Entrada inválida para a altura. Por favor, insira um número.",
                        "Erro de Entrada", JOptionPane.ERROR_MESSAGE);
            }
        }

        dadosValidos = false;
        while (!dadosValidos) {
            inputComprimento = JOptionPane.showInputDialog(null, "Informe o comprimento da viga (em metros):",
                    "Cálculo de Volume de Viga", JOptionPane.QUESTION_MESSAGE);
            if (inputComprimento == null) {
                JOptionPane.showMessageDialog(null, "Operação cancelada.", "Aviso", JOptionPane.WARNING_MESSAGE);
                return;
            }
            try {
                comprimento = Double.parseDouble(inputComprimento);
                if (comprimento <= 0) {
                    JOptionPane.showMessageDialog(null, "O comprimento deve ser um valor positivo.", "Erro de Entrada",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    dadosValidos = true;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Entrada inválida para o comprimento. Por favor, insira um número.",
                        "Erro de Entrada", JOptionPane.ERROR_MESSAGE);
            }
        }

        Viga viga = new Viga(base, altura, comprimento);

        double volume = viga.calcularVolume();

        String mensagemResultado = String.format("""
                                                 Dados da Viga:
                                                 Base: %.2f m
                                                 Altura: %.2f m
                                                 Comprimento: %.2f m
                                                 
                                                 Volume de Concreto Necess\u00e1rio: %.3f m\u00b3""",
                viga.getBase(), viga.getAltura(), viga.getComprimento(), volume);

        JOptionPane.showMessageDialog(null, mensagemResultado, "Resultado do Cálculo", JOptionPane.INFORMATION_MESSAGE);
    }
}