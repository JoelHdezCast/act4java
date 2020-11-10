import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame implements ActionListener {
    private JButton cuadroB, circuloB, trianguloB, areaB, periB;
    private JTextField valor1, valor2;
    private JTextArea areaT;
    int opcion;

    Circle circle = new Circle();
    Triangle triangle = new Triangle();
    Square square = new Square();

    public static void main(String[] args){
        Main demo = new Main();
        demo.setSize(400,200);
        demo.createGUI();
        demo.setVisible(true);
    }

    private void createGUI()
    {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());
        cuadroB = new JButton("Cuadrado");
        window.add(cuadroB);
        cuadroB.addActionListener(this);
        circuloB = new JButton("Circulo");
        window.add(circuloB);
        circuloB.addActionListener(this);
        trianguloB = new JButton("Triangulo");
        window.add(trianguloB);
        trianguloB.addActionListener(this);
        areaB = new JButton("Area");
        window.add(areaB);
        areaB.addActionListener(this);
        periB = new JButton("Perimetro");
        window.add(periB);
        periB.addActionListener(this);
        valor1 = new JTextField("lado: ");
        window.add(valor1);
        valor2 = new JTextField("altura: ");
        window.add(valor2);
        areaT = new JTextArea(50,50);
        window.add(areaT);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == cuadroB) {
                opcion = 1;
                String area = "\nCuadrado seleccionado";
                areaT.append(area);
            }
            if (e.getSource() == circuloB) {
                opcion = 2;
                String area = "\nCirculo seleccionado";
                areaT.append(area);
            }
            if (e.getSource() == trianguloB) {
                opcion = 3;
                String area = "\nTriangulo seleccionado";
                areaT.append(area);
            }
            if (e.getSource() == areaB){
                double v1 = Double.parseDouble(valor1.getText());
                double v2 = Double.parseDouble(valor2.getText());
                switch (opcion){
                    case 1:
                        String area = "\nArea del cuadrado: " + square.Area(v1,v2);
                        areaT.append(area);
                        break;
                    case 2:
                        area = "\nArea del circulo: " + circle.Area(v1,v2);
                        areaT.append(area);
                        break;
                    case 3:
                        area = "\nArea del triangulo: " + triangle.Area(v1,v2);
                        areaT.append(area);
                        break;
                }
            }
            if (e.getSource() == periB){
                double v1 = Double.parseDouble(valor1.getText());
                switch (opcion){
                    case 1:
                        String peri = "\nPerimetro del cuadrado: " + square.Perimetro(v1);
                        areaT.append(peri);
                        break;
                    case 2:
                        peri = "\nPerimetro del circulo: " + circle.Perimetro(v1);
                        areaT.append(peri);
                        break;
                    case 3:
                        peri = "\nPerimetro del triangulo: " + triangle.Perimetro(v1);
                        areaT.append(peri);
                        break;
                }
            }
        }catch (NumberFormatException errorObject){
            JOptionPane.showMessageDialog(null, "Error");
        }
    }
}
