
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class operaciones extends JFrame implements ActionListener{

    private int X;
    private int Y;
    private JButton boton;
    private JTextField valor1;
    private JTextField valor2;
    private JLabel resultadoSuma;
    private JLabel resultadoResta;
    private JLabel resultadoDivision;
    private JLabel resultadoMultiplicacion;
    private JLabel resultadoModulo;
    private JLabel textoinicial;

    public static void main(String[] args){
        operaciones frame = new operaciones();
        frame.setSize(300,300);
        frame.createGUI();
        frame.setVisible(true);
    }

    private void createGUI(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(null);
        textoinicial = new JLabel("Ingresa 2 numeros");
        window.add(textoinicial).setBounds(35,10,300,30);
        valor1 = new JTextField("valor 1");
        window.add(valor1).setBounds(50,45,50,30);
        valor2 = new JTextField("valor 2");
        window.add(valor2).setBounds(150,45,50,30);
        boton = new JButton("Calcular");
        boton.addActionListener(this);
        window.add(boton).setBounds(50,80,150,40);
        resultadoSuma = new JLabel(" ");
        window.add(resultadoSuma).setBounds(50,110,100,30);
        resultadoResta = new JLabel(" ");
        window.add(resultadoResta).setBounds(50,120,100,30);
        resultadoMultiplicacion = new JLabel(" ");
        window.add(resultadoMultiplicacion).setBounds(50,130,200,30);
        resultadoDivision = new JLabel(" ");
        window.add(resultadoDivision).setBounds(50,140,100,30);
        resultadoModulo = new JLabel(" ");
        window.add(resultadoModulo).setBounds(50,150,100,30);
    }

    public void actionPerformed(ActionEvent event){

        X = Integer.parseInt(valor1.getText());
        Y = Integer.parseInt(valor2.getText());

        resultadoSuma.setText("Suma = " + suma(X, Y));
        resultadoResta.setText("Resta = " + resta(X, Y));
        resultadoMultiplicacion.setText("Multiplicación = " + multiplicacion(X, Y));
        resultadoDivision.setText("División = " + division(X, Y));
        resultadoModulo.setText("Modulo = " + modulo(X, Y));
    }

    public int suma(int x, int y){
        return x + y;
    }
    public int resta(int x, int y){
        return x - y;
    }
    public float multiplicacion(int x, int y){
        return x * y;
    }
    public float division(int x, int y){
        return x / y;
    }
    public int modulo(int x, int y){
        return x % y;
    }
}
