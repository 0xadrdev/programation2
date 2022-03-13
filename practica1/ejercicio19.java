package practica1;
import java.util.Arrays;



public class ejercicio19{
    public static void main(String[] args) {
        int[] vector1 = {1,1,1,2,3,4,5};
        int[] vectorEsperado1 = {2,3,4,5};
        prueba(vector1, 1, vectorEsperado1);

        int[] vector2 = {1,1,1};
        int[] vectorEsperado2 = {};
        prueba(vector2, 1, vectorEsperado2);
        
        int[] vector3 = {1,2,3,3,4,4,5};
        int[] vectorEsperado3 = {1,2,4,4,5};
        prueba(vector3, 3, vectorEsperado3);
    }

    private static int[] eliminarValor(int[] vector, int num) {
        int numeroDeElementosRepetidos = 0;
        for(int i = 0; i < vector.length; i++){
            if(vector[i] == num){
                numeroDeElementosRepetidos++;
            }
        }


        int[] copia = new int[vector.length - numeroDeElementosRepetidos];

        for(int i = 0, j = 0; i < vector.length; i++){
                if(vector[i] != num){
                    copia[j++] = vector[i];
                }
        }

        return copia;

    }


    private static void prueba(int[] vector, int num, int[] esperado) {
        int[] resultado = eliminarValor(vector, num);
        System.out.format("Prueba con %s y numero %s --> ", Arrays.toString(vector), num);
        
        if (Arrays.equals(resultado, esperado)) {
            System.out.println("OK");
        } else {
            System.out.println("ERROR");
        }
    }
}