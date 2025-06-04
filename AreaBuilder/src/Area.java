public class Area {
    public double calcularArea(double lado) {
        if (lado <= 0) {
            throw new IllegalArgumentException("O lado do quadrado deve ser um valor positivo.");
        }
        return lado * lado;
    }

    public double calcularArea(double base, double altura) {
        if (base <= 0 || altura <= 0) {
            throw new IllegalArgumentException("A base e a altura do retângulo devem ser valores positivos.");
        }
        return base * altura;
    }

    public double calcularArea(double baseMaior, double baseMenor, double altura) {
        if (baseMaior <= 0 || baseMenor <= 0 || altura <= 0) {
            throw new IllegalArgumentException("As bases e a altura do trapézio devem ser valores positivos.");
        }
        if (baseMenor >= baseMaior) {
            throw new IllegalArgumentException("A base menor não pode ser maior ou igual à base maior do trapézio.");
        }
        return ((baseMaior + baseMenor) * altura) / 2.0;
    }
}