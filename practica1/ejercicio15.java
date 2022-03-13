package practica1;
import java.util.Arrays;



public class ejercicio15 {
    public static void main(String[] args) {

        String[] mainArray = {"a", "b", "c", "d", "e"};
        
        prueba(mainArray, false);

    }

    private static boolean estaOrdenado( String[] cadena) {
        for(int i = 0; i < cadena.length - 1; i++){
            if (cadena[i].compareTo(cadena[i + 1]) < 0){
                return false;
            }
        }
        return true;
    }


    private static void prueba(String[] vector, boolean esperado) {
        boolean resultado = estaOrdenado(vector);
        System.out.format("Prueba con %s --> ", Arrays.toString(vector));
        
        if (resultado == esperado) {
            System.out.println("OK");
        } else {
            System.out.println("ERROR");
        }
        System.out.println(resultado);

    }
    
}