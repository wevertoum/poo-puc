public class TrianguloRetangulo extends FiguraGeometrica {

    public TrianguloRetangulo(double base, double altura) {
        super(base, altura);
    }

    @Override
    public double calcularArea() {
        return (getBase() * getAltura()) / 2.0;
    }

    @Override
    public String toString() {
        return "Triângulo Retângulo [" + super.toString() + ", Área: " + String.format("%.2f", calcularArea()) + "]";
    }
}