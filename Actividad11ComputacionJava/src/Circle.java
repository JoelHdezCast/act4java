public class Circle implements Figura{

    @Override
    public Double Area(Double r, Double l2) {
        Double area = 3.14 * (r*r);
        return area;
    }

    @Override
    public Double Perimetro(Double r) {
        Double per = (r * 2) * 3.14;
        return per;
    }
}
