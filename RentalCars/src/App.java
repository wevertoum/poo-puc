import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class App {

    public static void main(String[] args) {

        String[] tiposVeiculo = { "Veículo de Passageiro", "Veículo de Carga" };
        int escolhaTipo = JOptionPane.showOptionDialog(null, "Selecione a espécie do veículo:",
                "Cadastro de Veículo - Passo 1/3",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, tiposVeiculo, tiposVeiculo[0]);

        if (escolhaTipo == JOptionPane.CLOSED_OPTION) {
            JOptionPane.showMessageDialog(null, "Cadastro cancelado.");
            return;
        }

        String tipoSelecionado = tiposVeiculo[escolhaTipo];
        Veiculo veiculo;

        String placa, marca, modelo, chassi, renavam, procedencia;
        int anoModelo, anoFabricacao;
        String corExterna, corInterna, tipoCombustivel, motor;
        double quilometragem, consumoMedio;

        double capacidadeCarga = 0, alturaC = 0, larguraC = 0, profundidadeC = 0;

        int numPortas = 0, numPassageiros = 0;
        String opcionais = "";

        JPanel painelInfoVeiculo = new JPanel(new GridLayout(0, 2, 5, 5));
        JTextField placaField = new JTextField(15);
        JTextField marcaField = new JTextField(15);
        JTextField modeloField = new JTextField(15);
        JTextField anoModeloField = new JTextField(5);
        JTextField anoFabricacaoField = new JTextField(5);
        JTextField chassiField = new JTextField(20);
        JTextField renavamField = new JTextField(15);
        JTextField procedenciaField = new JTextField(10);

        painelInfoVeiculo.add(new JLabel("Placa:"));
        painelInfoVeiculo.add(placaField);
        painelInfoVeiculo.add(new JLabel("Marca:"));
        painelInfoVeiculo.add(marcaField);
        painelInfoVeiculo.add(new JLabel("Modelo:"));
        painelInfoVeiculo.add(modeloField);
        painelInfoVeiculo.add(new JLabel("Ano Modelo:"));
        painelInfoVeiculo.add(anoModeloField);
        painelInfoVeiculo.add(new JLabel("Ano Fabricação:"));
        painelInfoVeiculo.add(anoFabricacaoField);
        painelInfoVeiculo.add(new JLabel("Chassi:"));
        painelInfoVeiculo.add(chassiField);
        painelInfoVeiculo.add(new JLabel("Renavam:"));
        painelInfoVeiculo.add(renavamField);
        painelInfoVeiculo.add(new JLabel("Procedência (Nacional/Importado):"));
        painelInfoVeiculo.add(procedenciaField);

        JTextField capacidadeField = null, alturaField = null, larguraField = null, profundidadeField = null;

        if (tipoSelecionado.equals("Veículo de Carga")) {
            capacidadeField = new JTextField(5);
            alturaField = new JTextField(5);
            larguraField = new JTextField(5);
            profundidadeField = new JTextField(5);
            painelInfoVeiculo.add(new JLabel("Capacidade Carga (kg):"));
            painelInfoVeiculo.add(capacidadeField);
            painelInfoVeiculo.add(new JLabel("Altura Carga (m):"));
            painelInfoVeiculo.add(alturaField);
            painelInfoVeiculo.add(new JLabel("Largura Carga (m):"));
            painelInfoVeiculo.add(larguraField);
            painelInfoVeiculo.add(new JLabel("Profundidade Carga (m):"));
            painelInfoVeiculo.add(profundidadeField);
        }

        int resultadoInfo = JOptionPane.showConfirmDialog(null, painelInfoVeiculo,
                "Cadastro de Veículo - Passo 2/3: Informações do Veículo", JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE);

        if (resultadoInfo == JOptionPane.OK_OPTION) {
            try {
                placa = placaField.getText();
                marca = marcaField.getText();
                modelo = modeloField.getText();
                anoModelo = Integer.parseInt(anoModeloField.getText());
                anoFabricacao = Integer.parseInt(anoFabricacaoField.getText());
                chassi = chassiField.getText();
                renavam = renavamField.getText();
                procedencia = procedenciaField.getText();

                if (tipoSelecionado.equals("Veículo de Carga")) {
                    capacidadeCarga = Double.parseDouble(capacidadeField.getText());
                    alturaC = Double.parseDouble(alturaField.getText());
                    larguraC = Double.parseDouble(larguraField.getText());
                    profundidadeC = Double.parseDouble(profundidadeField.getText());
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Erro de formato nos números. Verifique os dados.", "Erro",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Cadastro cancelado.");
            return;
        }

        JPanel painelCaracteristicas = new JPanel(new GridLayout(0, 2, 5, 5));
        JTextField corExternaField = new JTextField(10);
        JTextField corInternaField = new JTextField(10);
        JTextField tipoCombustivelField = new JTextField(10);
        JTextField motorField = new JTextField(10);
        JTextField quilometragemField = new JTextField(10);
        JTextField consumoMedioField = new JTextField(5);

        painelCaracteristicas.add(new JLabel("Cor Externa:"));
        painelCaracteristicas.add(corExternaField);
        painelCaracteristicas.add(new JLabel("Cor Interna:"));
        painelCaracteristicas.add(corInternaField);
        painelCaracteristicas.add(new JLabel("Tipo Combustível:"));
        painelCaracteristicas.add(tipoCombustivelField);
        painelCaracteristicas.add(new JLabel("Motor:"));
        painelCaracteristicas.add(motorField);
        painelCaracteristicas.add(new JLabel("Quilometragem (km):"));
        painelCaracteristicas.add(quilometragemField);
        painelCaracteristicas.add(new JLabel("Consumo Médio (km/l):"));
        painelCaracteristicas.add(consumoMedioField);

        JTextField numPortasField = null, numPassageirosField = null, opcionaisField = null;

        if (tipoSelecionado.equals("Veículo de Passageiro")) {
            numPortasField = new JTextField(3);
            numPassageirosField = new JTextField(3);
            opcionaisField = new JTextField(20);
            painelCaracteristicas.add(new JLabel("Número de Portas:"));
            painelCaracteristicas.add(numPortasField);
            painelCaracteristicas.add(new JLabel("Número de Passageiros:"));
            painelCaracteristicas.add(numPassageirosField);
            painelCaracteristicas.add(new JLabel("Opcionais:"));
            painelCaracteristicas.add(opcionaisField);
        }

        int resultadoCaracteristicas = JOptionPane.showConfirmDialog(null, painelCaracteristicas,
                "Cadastro de Veículo - Passo 3/3: Características", JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE);

        if (resultadoCaracteristicas == JOptionPane.OK_OPTION) {
            try {
                corExterna = corExternaField.getText();
                corInterna = corInternaField.getText();
                tipoCombustivel = tipoCombustivelField.getText();
                motor = motorField.getText();
                quilometragem = Double.parseDouble(quilometragemField.getText());
                consumoMedio = Double.parseDouble(consumoMedioField.getText());

                if (tipoSelecionado.equals("Veículo de Passageiro")) {
                    numPortas = Integer.parseInt(numPortasField.getText());
                    numPassageiros = Integer.parseInt(numPassageirosField.getText());
                    opcionais = opcionaisField.getText();
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Erro de formato nos números. Verifique os dados.", "Erro",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Cadastro cancelado.");
            return;
        }

        if (tipoSelecionado.equals("Veículo de Passageiro")) {
            veiculo = new VeiculoPassageiro(placa, marca, modelo, anoModelo, anoFabricacao, chassi, renavam,
                    procedencia, corExterna, corInterna, tipoCombustivel, motor, quilometragem, consumoMedio,
                    numPortas, numPassageiros, opcionais);
        } else {
            veiculo = new VeiculoCarga(placa, marca, modelo, anoModelo, anoFabricacao, chassi, renavam,
                    procedencia, corExterna, corInterna, tipoCombustivel, motor, quilometragem, consumoMedio,
                    capacidadeCarga, alturaC, larguraC, profundidadeC);
        }

        if (veiculo != null) {
            JOptionPane.showMessageDialog(null, veiculo.exibirInformacoes(),
                    "Veículo Cadastrado com Sucesso!", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}