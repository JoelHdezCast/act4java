import java.util.HashMap;
import java.io.*;
import java.util.Map;

public class AddressBook {
    public HashMap<String, String> contactos = new HashMap<>();
    private String archivoTxt = "Address Book.txt";
    private File archivo = new File(archivoTxt);

    //se crea el archivo
    public void cargar(){
        if (!archivo.exists()){
            crearArchivo();
        }else {
            cargarArchivo();
        }
    }
    public void guardar(String nombre, String numero){
        //se ingresan los 2 nuevos valores a la hashmap
        contactos.put(numero, nombre);
        String lista = "";
        //se guardan los valores de la hashmap dentro de un string
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivoTxt))){
            for (Map.Entry<String, String> aux : contactos.entrySet()){
                lista = lista.concat(aux.getKey() + "," + aux.getValue() + ",\n");
            }
            //el string se guarda en el archivo de texto
            writer.write(lista);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    //guarda la hashmap en el archivo
    public void guardarArchivo(){
        String lista = "";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivoTxt))){
            for (Map.Entry<String, String> aux : contactos.entrySet()){
                lista = lista.concat(aux.getKey() + "," + aux.getValue() + ",\n");
            }
            writer.write(lista);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    //crea el archivo
    public void crearArchivo(){
        try {
            archivo.createNewFile();
        }catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    //lee el archivo de texto
    public void cargarArchivo(){
        String aux, str = "";
        int a = 1;
        //se lee el contenido del archivo y se mete dentro de un string
        try (BufferedReader buff = new BufferedReader(new FileReader(archivoTxt))){
            while ((aux = buff.readLine()) != null){
                str = str.concat(aux);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        //con el .split se separan los valores para poder usarlos dentro de una lista
        String[] tokens = str.split(",");
        //usando la lista se pasan los valores a la hashmap
        for (int i = 0; i < tokens.length; i = i + 2) {
            contactos.put(tokens[i], tokens[a]);
            a = a + 2;
        }
    }
}
