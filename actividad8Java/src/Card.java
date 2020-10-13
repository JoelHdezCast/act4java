public class Card {

    private Palo mpalo;
    private Color mcolor;
    private Valor mvalor;

    enum  Palo {
        TREBOL,
        CORAZON,
        PICA,
        DIAMANTE
    }
    enum Color{
        ROJO,
        NEGRO
    }
    enum Valor{
        AS,
        DOS,
        TRES,
        CUATRO,
        CINCO,
        SEIS,
        SIETE,
        OCHO,
        NUEVE,
        DIEZ,
        JACK,
        QUEEN,
        KING
    }

    public Card(Color color, Palo palo, Valor valor){
        this.mpalo = palo;
        this.mcolor = color;
        this.mvalor = valor;
    }
    public Palo getPalo() {
        return mpalo;
    }
    public Color getColor() {
        return mcolor;
    }
    public Valor getValor() {
        return mvalor;
    }
}
