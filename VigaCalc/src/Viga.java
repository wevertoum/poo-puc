public class Viga {
    
    private double base;
    private double altura;
    private double comprimento;

    
    public Viga(double base, double altura, double comprimento) {
        this.base = base;
        this.altura = altura;
        this.comprimento = comprimento;
    }

    
    public double getBase() {
        return base;
    }

    public double getAltura() {
        return altura;
    }

    public double getComprimento() {
        return comprimento;
    }

    
    public double calcularVolume() {
        return this.base * this.altura * this.comprimento;
    }

    
    public void setBase(double base) {
        if (base > 0) { 
            this.base = base;
        }
    }

    public void setAltura(double altura) {
        if (altura > 0) {
            this.altura = altura;
        }
    }

    public void setComprimento(double comprimento) {
        if (comprimento > 0) {
            this.comprimento = comprimento;
        }
    }
}