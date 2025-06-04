public abstract class FiguraGeometrica {
    protected double base;
    protected double altura;

    public FiguraGeometrica(double base, double altura) {
        if (base <= 0 || altura <= 0) {
            throw new IllegalArgumentException("Base e altura devem ser valores positivos.");
        }
        this.base = base;
        this.altura = altura;
    }

    public double getBase() {
        return base;
    }

    public double getAltura() {
        return altura;
    }

    public abstract double calcularArea();

    @Override
    public String toString() {
        return "Base: " + base + ", Altura: " + altura;
    }
}