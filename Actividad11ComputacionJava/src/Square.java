public class Square implements Figura {
    @Override
    public Double Area(Double l1, Double l2) {
        return l1 * l1;
    }

    @Override
    public Double Perimetro(Double l) {
        return l * 4;
    }
}
