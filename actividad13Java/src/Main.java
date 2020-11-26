import java.util.*;

public class Main {

    public static void main(String[] args){
        List lista = new ArrayList<String>();
        lista.add("hola");
        lista.add("gagagaa");
        lista.add("aahhhhh");
        lista.add("gg");
        lista.add("adios");

        System.out.println("Actividad 13\n");

        sortInterface anonimaLenght = new sortInterface() {
            @Override
            public void Sort(List list) {
                Collections.sort(list, Comparator.comparingInt(String::length));
                System.out.println("Clase anonima, sort por longitud: " + list);
            }
        };
        anonimaLenght.Sort(lista);
        sortInterface anonimaAlpha = new sortInterface() {
            @Override
            public void Sort(List list) {
                Collections.sort(list);
                System.out.println("Clase anonima, sort alfabeticamente: " + list);
            }
        };
        anonimaAlpha.Sort(lista);

        sortInterface lenghtS = MetodoReferencia::metodoSortLenght;
        lenghtS.Sort(lista);
        sortInterface alphabet = MetodoReferencia::metodoSortAlphabet;
        alphabet.Sort(lista);

        sortInterface sortLen = (list) -> {
            Collections.sort(list, Comparator.comparingInt(String::length));
            System.out.println("Lambda, sort por longitud: " + list);
        };
        sortLen.Sort(lista);
        sortInterface sortAlpha = (list) -> {
            Collections.sort(list);
            System.out.println("Lambda, sort alfabeticamente: " + list);
        };
        sortAlpha.Sort(lista);
    }
}
