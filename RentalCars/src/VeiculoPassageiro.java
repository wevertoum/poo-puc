public class VeiculoPassageiro extends Veiculo {
    private int numeroPortas;
    private int numeroPassageiros;
    private String opcionais;

    public VeiculoPassageiro(String placa, String marca, String modelo, int anoModelo, int anoFabricacao,
            String chassi, String renavam, String procedencia, String corExterna,
            String corInterna, String tipoCombustivel, String motor,
            double quilometragem, double consumoMedio,
            int numeroPortas, int numeroPassageiros, String opcionais) {
        super(placa, marca, modelo, anoModelo, anoFabricacao, chassi, renavam, procedencia,
                corExterna, corInterna, tipoCombustivel, motor, quilometragem, consumoMedio);
        this.numeroPortas = numeroPortas;
        this.numeroPassageiros = numeroPassageiros;
        this.opcionais = opcionais;
    }

    public int getNumeroPortas() {
        return numeroPortas;
    }

    public void setNumeroPortas(int numeroPortas) {
        this.numeroPortas = numeroPortas;
    }

    public int getNumeroPassageiros() {
        return numeroPassageiros;
    }

    public void setNumeroPassageiros(int numeroPassageiros) {
        this.numeroPassageiros = numeroPassageiros;
    }

    public String getOpcionais() {
        return opcionais;
    }

    public void setOpcionais(String opcionais) {
        this.opcionais = opcionais;
    }

    @Override
    public String exibirInformacoes() {
        return super.exibirInformacoes() +
                "\nTipo: Passageiro" +
                "\nNúmero de Portas: " + numeroPortas +
                "\nNúmero de Passageiros: " + numeroPassageiros +
                "\nOpcionais: " + opcionais;
    }
}