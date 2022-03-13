package practica1;
import java.util.Arrays;



public class ejercicio18{
    public static void main(String[] args) {
        int[] vector = {1,2,3,4,5};
        System.out.println("OLAS DE FRIO == " + Arrays.toString(elimnarPosición(vector, 0)));

    }

    private static int[] elimnarPosición(int[] vector, int pos) {
        int[] copia = new int[vector.length - 1];
        if(pos >= 0 && pos < vector.length){
            for(int i = 0, j = 0; i < vector.length; i++){
                if(i != pos){
                    copia[j++] = vector[i];
                    System.out.println(Arrays.toString(copia));
                }
            }
        }

        return copia;

    }


    // private static void prueba(String[] vector, boolean esperado) {
    //     boolean resultado = estaOrdenado(vector);
    //     System.out.format("Prueba con %s --> ", Arrays.toString(vector));
        
    //     if (resultado == esperado) {
    //         System.out.println("OK");
    //     } else {
    //         System.out.println("ERROR");
    //     }
    //     System.out.println(resultado);

    // }
}