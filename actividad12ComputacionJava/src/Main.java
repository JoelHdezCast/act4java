import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class Main extends JFrame implements ActionListener {

    private JTextField numero, nombre;
    private JLabel nota;
    private JButton agregarB;
    private JButton borrarB;
    private JButton mostrarB;
    private JTextArea areaT;
    AddressBook book = new AddressBook();

    public static void main(String[] args){
        AddressBook book = new AddressBook();
        book.cargar();
        Main frame = new Main();
        frame.setSize(300,300);
        frame.createGUI();
        frame.setVisible(true);
    }
    //Se crea la interfaz gráfica
    private void createGUI(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());
        nota = new JLabel("Contacto");
        window.add(nota);
        numero = new JTextField(10);
        window.add(numero);
        nombre = new JTextField(10);
        window.add(nombre);
        agregarB = new JButton("Agregar");
        window.add(agregarB);
        agregarB.addActionListener(this);
        borrarB = new JButton("Borrar");
        window.add(borrarB);
        borrarB.addActionListener(this);
        mostrarB = new JButton("Lista de contactos");
        window.add(mostrarB);
        mostrarB.addActionListener(this);
        areaT = new JTextArea(50,50);
        window.add(areaT);

    }

    //Se define lo que hace cada boton
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == agregarB){
            String num = numero.getText();
            String nom = nombre.getText();
            book.cargarArchivo();
            book.guardar(nom, num);
            areaT.append("se agregó el contacto\n");
        }
        if (e.getSource() == borrarB){
            String num = numero.getText();
            String nom = nombre.getText();
            book.cargarArchivo();
            book.contactos.remove(num, nom);
            book.guardarArchivo();
            areaT.append("se borró el contacto\n");
        }
        if (e.getSource() == mostrarB){
            book.cargarArchivo();
            String lista = "";
            //Se pasan los datos de la hashmap a una variable string
            for (Map.Entry<String, String> aux : book.contactos.entrySet()) {
                lista = lista.concat(aux.getKey() + ":" + aux.getValue() + "\n");
            }
            areaT.append(lista);
        }
    }


}
