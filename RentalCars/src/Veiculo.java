public class Veiculo {
    protected String placa;
    protected String marca;
    protected String modelo;
    protected int anoModelo;
    protected int anoFabricacao;
    protected String chassi;
    protected String renavam;
    protected String procedencia;
    protected String corExterna;
    protected String corInterna;
    protected String tipoCombustivel;
    protected String motor;
    protected double quilometragem;
    protected double consumoMedio;

    public Veiculo(String placa, String marca, String modelo, int anoModelo, int anoFabricacao,
            String chassi, String renavam, String procedencia, String corExterna,
            String corInterna, String tipoCombustivel, String motor,
            double quilometragem, double consumoMedio) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.anoModelo = anoModelo;
        this.anoFabricacao = anoFabricacao;
        this.chassi = chassi;
        this.renavam = renavam;
        this.procedencia = procedencia;
        this.corExterna = corExterna;
        this.corInterna = corInterna;
        this.tipoCombustivel = tipoCombustivel;
        this.motor = motor;
        this.quilometragem = quilometragem;
        this.consumoMedio = consumoMedio;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnoModelo() {
        return anoModelo;
    }

    public void setAnoModelo(int anoModelo) {
        this.anoModelo = anoModelo;
    }

    public int getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(int anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public String getRenavam() {
        return renavam;
    }

    public void setRenavam(String renavam) {
        this.renavam = renavam;
    }

    public String getProcedencia() {
        return procedencia;
    }

    public void setProcedencia(String procedencia) {
        this.procedencia = procedencia;
    }

    public String getCorExterna() {
        return corExterna;
    }

    public void setCorExterna(String corExterna) {
        this.corExterna = corExterna;
    }

    public String getCorInterna() {
        return corInterna;
    }

    public void setCorInterna(String corInterna) {
        this.corInterna = corInterna;
    }

    public String getTipoCombustivel() {
        return tipoCombustivel;
    }

    public void setTipoCombustivel(String tipoCombustivel) {
        this.tipoCombustivel = tipoCombustivel;
    }

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public double getQuilometragem() {
        return quilometragem;
    }

    public void setQuilometragem(double quilometragem) {
        this.quilometragem = quilometragem;
    }

    public double getConsumoMedio() {
        return consumoMedio;
    }

    public void setConsumoMedio(double consumoMedio) {
        this.consumoMedio = consumoMedio;
    }

    public String exibirInformacoes() {
        return "Placa: " + placa +
                "\nMarca: " + marca +
                "\nModelo: " + modelo +
                "\nAno Modelo: " + anoModelo +
                "\nAno Fabricação: " + anoFabricacao +
                "\nChassi: " + chassi +
                "\nRenavam: " + renavam +
                "\nProcedência: " + procedencia +
                "\nCor Externa: " + corExterna +
                "\nCor Interna: " + corInterna +
                "\nTipo de Combustível: " + tipoCombustivel +
                "\nMotor: " + motor +
                "\nQuilometragem: " + quilometragem + " km" +
                "\nConsumo Médio: " + consumoMedio + " km/l";
    }
}