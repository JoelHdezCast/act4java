import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MetodoReferencia {
    public static void metodoSortLenght(List list){
        Collections.sort(list, Comparator.comparingInt(String::length));
        System.out.println("Metodo de referencia, sort por longitud: " + list);
    }
    public static void metodoSortAlphabet(List list){
        Collections.sort(list);
        System.out.println("Metodo de referencia, sort alfabeticamente: " + list);
    }
}
