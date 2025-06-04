package controle;

import javax.swing.JOptionPane;
import modelo.Cliente;
import modelo.Veiculo;

public class Principal {
    public static void main(String[] args) {
        String cpf = JOptionPane.showInputDialog("Digite o CPF do cliente:");
        String nome = JOptionPane.showInputDialog("Digite o nome do cliente:");
        String endereco = JOptionPane.showInputDialog("Digite o endereço do cliente:");
        String telefone = JOptionPane.showInputDialog("Digite o telefone do cliente:");
        String email = JOptionPane.showInputDialog("Digite o e-mail do cliente:");

        Cliente cliente = new Cliente(cpf, nome, endereco, telefone, email);

        String placa = JOptionPane.showInputDialog("Digite a placa do veículo:");
        String modelo = JOptionPane.showInputDialog("Digite o modelo do veículo:");
        int ano = Integer.parseInt(JOptionPane.showInputDialog("Digite o ano do veículo:"));
        String fabricante = JOptionPane.showInputDialog("Digite o fabricante do veículo:");
        String cor = JOptionPane.showInputDialog("Digite a cor do veículo:");

        Veiculo veiculo = new Veiculo(placa, modelo, ano, fabricante, cor);

        String mensagemFinal = cliente.toString() + "\n\n" + veiculo.toString();
        JOptionPane.showMessageDialog(null, mensagemFinal);
    }
}
