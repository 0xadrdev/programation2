package practica1;

import java.util.Arrays;


public class ejercicio14 {
    public static void main(String[] args) {
        int mainArray[] = {1,2,3,4,5,6,7,8,3,10};
        prueba(mainArray, 3, 8);
        prueba(mainArray, 3, 8);
        prueba(mainArray, 3, 8);
        prueba(mainArray, 3, 8);


    }

    private static int ultimaPosicion( int[] vector, int num) {
        int pos = -1;

        for(int i = 0; i < vector.length; i++){
            if (num == vector[i]){
                pos = i;
            }
        }
        return pos;
    }



    private static void prueba(int[] vector, int num, int esperado) {
        int resultado = ultimaPosicion(vector, num);
        System.out.format("Prueba con %s y %s --> ", Arrays.toString(vector), num);
        
        if (resultado == esperado) {
            System.out.println("OK");
        } else {
            System.out.println("ERROR");
        }


    }
}