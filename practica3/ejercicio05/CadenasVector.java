package practica3.ejercicio05;

import java.util.Arrays;

public class CadenasVector {

    public static void main(String[] args) {
        String[] mainArray = {"cero", "dos", "uno"};
        int posInsercion = 0;
        int ultimaPos = mainArray.length - 1;
        String unaCadena = "tres";

        
        for (int i = 0; i < mainArray.length; i++) {
            if (unaCadena.compareTo(mainArray[i]) > 0 ) {
                posInsercion = i + 1;
            } 
        }
        if (unaCadena.compareTo(mainArray[mainArray.length - 1]) > 0) {
            posInsercion = mainArray.length;
        }
        System.out.println("POS INSERCION --> " + posInsercion);
        System.out.println("VECTOR --> " + Arrays.toString(mainArray));
        System.out.println("Cadena --> " + unaCadena);
    }
    
}
