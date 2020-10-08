import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class actividad7java {

    private int valor = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
        actividad7java actividad = new actividad7java();

        System.out.println("Ingresa un numero: ");
        actividad.valor = Integer.parseInt(reader.readLine());
        System.out.println("Numeros primos: ");
        actividad.imprimir(actividad.numerosPrimos(actividad.valor));
        System.out.println("Serie de fibonacci: ");
        actividad.imprimir(actividad.fibonacci(actividad.valor));
    }

    public int[] numerosPrimos(int n){
        int[] primos;
        primos = new int[n];
        primos[0] = 2;

        for (int i = 1; i < n; i++){
            if (i % 2 != 0){
                primos[i] = i;
            }
        }

        return primos;
    }

    public int[] fibonacci(int n){
        int [] serie;
        serie = new int[n];
        serie[0] = 0;
        serie[1] = 1;

        if (n < 1){
            System.out.println("se necesita un numero mayor a 1");
        }
        for (int i = 2; i < n; i++){
            serie[i] = serie[i-1] + serie[i-2];
        }
        return serie;
    }

    public void imprimir(int[] x){
        for (int i = 0; i < x.length; i++){
            System.out.println(x[i]);
        }
    }
}
