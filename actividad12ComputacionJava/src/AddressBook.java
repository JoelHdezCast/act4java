import java.util.HashMap;
import java.io.*;
import java.util.Map;

public class AddressBook {
    public HashMap<String, String> contactos = new HashMap<>();
    private String archivoTxt = "Address Book.txt";
    private File archivo = new File(archivoTxt);

    public void cargar(){
        if (!archivo.exists()){
            crearArchivo();
        }else {
            cargarArchivo();
        }
    }
    public void guardar(String nombre, String numero){
        contactos.put(numero, nombre);
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
    public void crearArchivo(){
        try {
            archivo.createNewFile();
        }catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public void cargarArchivo(){
        String aux, str = "";
        int a = 1;
        try (BufferedReader buff = new BufferedReader(new FileReader(archivoTxt))){
            while ((aux = buff.readLine()) != null){
                str = str.concat(aux);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        String[] tokens = str.split(",");
        for (int i = 0; i < tokens.length; i = i + 2) {
            contactos.put(tokens[i], tokens[a]);
            a = a + 2;
        }
    }
}
