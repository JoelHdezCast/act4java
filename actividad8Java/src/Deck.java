import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

public class Deck extends JFrame implements ActionListener{
    private List <Card> cards = new ArrayList<Card>(52);

    private JButton shuffleB, headB, pickB, handB, crearB;
    private JTextArea area;

    public static void main(String[] args){

        Deck demo = new Deck();
        demo.setSize(400,200);
        demo.createGUI();
        demo.setVisible(true);

    }

    private void createGUI()
    {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());
        crearB = new JButton("Crear Deck");
        window.add(crearB);
        crearB.addActionListener(this);
        shuffleB = new JButton("Shuffle");
        window.add(shuffleB);
        shuffleB.addActionListener(this);
        headB = new JButton("Head");
        window.add(headB);
        headB.addActionListener(this);
        pickB = new JButton("Pick");
        window.add(pickB);
        pickB.addActionListener(this);
        handB = new JButton("Hand");
        window.add(handB);
        handB.addActionListener(this);
        area = new JTextArea(100,100);
        window.add(area);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == shuffleB){
            shuffle();
        }
        if (e.getSource() == headB){
            area.append(head());
        }
        if (e.getSource() == pickB){
            area.append(pick());
        }
        if (e.getSource() == handB){
            for (int i = 0; i < 5; i++) {
                area.append(hand());
            }
            area.append(Size());
        }
        if (e.getSource() == crearB){
            crearDeck();
        }
    }

    public List<Card> crearDeck(){
        cards.clear();
        for (Card.Palo p : Card.Palo.values()){
                for (Card.Valor v : Card.Valor.values()){
                    if (p.equals(Card.Palo.CORAZON) || p.equals(Card.Palo.DIAMANTE)) {
                        Card.Color c = Card.Color.ROJO;
                        Card card = new Card(c, p, v);
                        cards.add(card);
                    }else {
                        Card.Color c = Card.Color.NEGRO;
                        Card card = new Card(c, p, v);
                        cards.add(card);
                    }
                }
        }
        return cards;
    }

    /*public void mostrarDeck(){
        for (int i = 0; i < cards.size(); i++){
            String carta = cards.get(i).getColor().toString()+ " " + cards.get(i).getPalo().toString() + " " + cards.get(i).getValor().toString();
            System.out.println(carta);
        }
    }*/

    public void shuffle(){
        Collections.shuffle(cards);
    }

    public String head(){
        String carta = "\n" + cards.get(0).getColor().toString()+ " " + cards.get(0).getPalo().toString() + " " + cards.get(0).getValor().toString() +
                "\nQuedan: " + cards.size();
        cards.remove(0);
        return carta;
    }

    public String pick(){
        int random = (new Random().nextInt(cards.size()));
        String carta = "\n" + cards.get(random).getColor().toString()+ " " + cards.get(random).getPalo().toString() + " " + cards.get(random).getValor().toString() +
                "\nQuedan: " + cards.size();
        cards.remove(random);
        return carta;
    }

    public String hand(){
        int random = (new Random().nextInt(cards.size()));
        String carta = "\n" + cards.get(random).getColor().toString()+ " " + cards.get(random).getPalo().toString() + " " + cards.get(random).getValor().toString();
        cards.remove(random);
        return carta;
    }

    public String Size(){
        String tam = "\nQuedan: " + cards.size();
        return tam;
    }

}
