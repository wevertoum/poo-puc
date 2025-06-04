public class VeiculoCarga extends Veiculo {
    private double capacidadeMaximaCargaKg;
    private double alturaCarga;
    private double larguraCarga;
    private double profundidadeCarga;

    public VeiculoCarga(String placa, String marca, String modelo, int anoModelo, int anoFabricacao,
            String chassi, String renavam, String procedencia, String corExterna,
            String corInterna, String tipoCombustivel, String motor,
            double quilometragem, double consumoMedio,
            double capacidadeMaximaCargaKg, double alturaCarga, double larguraCarga, double profundidadeCarga) {
        super(placa, marca, modelo, anoModelo, anoFabricacao, chassi, renavam, procedencia,
                corExterna, corInterna, tipoCombustivel, motor, quilometragem, consumoMedio);
        this.capacidadeMaximaCargaKg = capacidadeMaximaCargaKg;
        this.alturaCarga = alturaCarga;
        this.larguraCarga = larguraCarga;
        this.profundidadeCarga = profundidadeCarga;
    }

    public double getCapacidadeMaximaCargaKg() {
        return capacidadeMaximaCargaKg;
    }

    public void setCapacidadeMaximaCargaKg(double capacidadeMaximaCargaKg) {
        this.capacidadeMaximaCargaKg = capacidadeMaximaCargaKg;
    }

    public double getAlturaCarga() {
        return alturaCarga;
    }

    public void setAlturaCarga(double alturaCarga) {
        this.alturaCarga = alturaCarga;
    }

    public double getLarguraCarga() {
        return larguraCarga;
    }

    public void setLarguraCarga(double larguraCarga) {
        this.larguraCarga = larguraCarga;
    }

    public double getProfundidadeCarga() {
        return profundidadeCarga;
    }

    public void setProfundidadeCarga(double profundidadeCarga) {
        this.profundidadeCarga = profundidadeCarga;
    }

    @Override
    public String exibirInformacoes() {
        return super.exibirInformacoes() +
                "\nTipo: Carga" +
                "\nCapacidade Máx. Carga: " + capacidadeMaximaCargaKg + " kg" +
                "\nAltura Carga: " + alturaCarga + " m" +
                "\nLargura Carga: " + larguraCarga + " m" +
                "\nProfundidade Carga: " + profundidadeCarga + " m";
    }
}