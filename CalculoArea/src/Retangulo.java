public class Retangulo extends FiguraGeometrica {

    public Retangulo(double base, double altura) {
        super(base, altura);
    }

    @Override
    public double calcularArea() {
        return getBase() * getAltura();
    }

    @Override
    public String toString() {
        return "Retângulo [" + super.toString() + ", Área: " + String.format("%.2f", calcularArea()) + "]";
    }
}