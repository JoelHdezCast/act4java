
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PromedioAlumno extends JFrame implements ActionListener{

    //declaracion de variables y componentes de la interfaz
    private String nombre;
    private int calificaciones[] = {0,5,3,0,0};
    private JLabel texto, res, prom;
    private JTextField cal1, cal2, cal3, cal4, cal5;
    private JTextField nom;
    private JButton calcular;

    public static void main(String[] args){

        PromedioAlumno alumno = new PromedioAlumno();//instanciamos un objeto alumno
        //declaramos la interfaz
        alumno.setSize(300,300);
        alumno.createGUI();
        alumno.setVisible(true);

    }

    //se crea la interfaz y se añaden los componentes
    private void createGUI(){

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());
        texto = new JLabel("Ingresa nombre y calificaciones");
        window.add(texto);
        nom = new JTextField("nombre: ");
        window.add(nom);
        cal1 = new JTextField("calificacion 1:");
        window.add(cal1);
        cal2 = new JTextField("calificacion 2:");
        window.add(cal2);
        cal3 = new JTextField("calificacion 3:");
        window.add(cal3);
        cal4 = new JTextField("calificacion 4:");
        window.add(cal4);
        cal5 = new JTextField("calificacion 5:");
        window.add(cal5);
        calcular = new JButton("Calcular");
        window.add(calcular);
        calcular.addActionListener(this);
        res = new JLabel(" ");
        res.setPreferredSize(new Dimension(150, 20));
        window.add(res);
        prom = new JLabel(" ");
        prom.setPreferredSize(new Dimension(150, 20));
        window.add(prom);

    }

    public double calcularPromedio(int x[]){

        double resultado = x[0];//inicializamos la variable resultado con el primer valor del array

        //realizamos un ciclo para sumar los valores
        for (int i = 1; i < calificaciones.length; i++){
            resultado = resultado + x[i];
        }
        resultado = resultado / calificaciones.length;//los dividimos para obtener el promedio

        return resultado;
    }

    public String obtenerCalificacion(double x){//asignamos la calificacion dependiendo del promedio obtenido

        String calificacion = "";

        if (x <= 50){
            calificacion = "F";
        }
        if (x <= 60 && x >= 51){
            calificacion = "E";
        }
        if (x <= 70 && x >= 61){
            calificacion = "D";
        }
        if (x <= 80 && x >= 71){
            calificacion = "C";
        }
        if (x <= 90 && x >= 81){
            calificacion = "B";
        }
        if (x <= 100 && x >= 91){
            calificacion = "A";
        }

        return calificacion;
    }

    public void imprimirResultados(){

        prom.setText("Promedio: " + calcularPromedio(calificaciones));//colocamos el valor obtenido con el metodo calcularPromedio
        res.setText("Calificacion: " + obtenerCalificacion(calcularPromedio(calificaciones)));//calculamos el valor de la calificacion

    }

    @Override
    public void actionPerformed(ActionEvent e) {//al ser presionado el boton calcular

        try {//usamos un try catch para buscar errores en lo ingresado por el usuario

            if (e.getSource() == calcular) {

                //convertimos lo ingresado a entero y lo metemos dentro del array
                calificaciones[0] = Integer.parseInt(cal1.getText());
                calificaciones[1] = Integer.parseInt(cal2.getText());
                calificaciones[2] = Integer.parseInt(cal3.getText());
                calificaciones[3] = Integer.parseInt(cal4.getText());
                calificaciones[4] = Integer.parseInt(cal5.getText());;

                imprimirResultados();//llamamos al metodo imprimirResultado
            }
        }catch (NumberFormatException errorObject){
            JOptionPane.showMessageDialog(null, "Error");
        }
    }
}
