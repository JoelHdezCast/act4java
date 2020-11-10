public class Triangle implements Figura{
    @Override
    public Double Area(Double b, Double a) {
        Double area = (b * a) / 2;
        return area;
    }

    @Override
    public Double Perimetro(Double b) {
        return b * 3;
    }
}
