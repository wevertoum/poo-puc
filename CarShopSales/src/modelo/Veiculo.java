package modelo;

public class Veiculo {
    private final String placa;
    private final String modelo;
    private final int ano;
    private final String fabricante;
    private final String cor;

    public Veiculo(String placa, String modelo, int ano, String fabricante, String cor) {
        this.placa = placa;
        this.modelo = modelo;
        this.ano = ano;
        this.fabricante = fabricante;
        this.cor = cor;
    }

    @Override
    public String toString() {
        return "Veículo:\n" +
               "Placa: " + placa + "\n" +
               "Modelo: " + modelo + "\n" +
               "Ano: " + ano + "\n" +
               "Fabricante: " + fabricante + "\n" +
               "Cor: " + cor;
    }
}
