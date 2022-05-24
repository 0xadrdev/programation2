package practica3.ejercicio05;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PalabraMasFrecuente {
    public static void main(String[] args) throws FileNotFoundException{
        String nombreFichero = "datos/AlicesAdventuresInWonderland.txt";
        Scanner fichero = new Scanner(new File(nombreFichero), "UTF-8");
        Diccionario diccionario = new Diccionario();
        while(fichero.hasNext()) {
            String palabra = fichero.next();
            diccionario.añadir(palabra, 1);
        }
        String cadena =  diccionario.cadenaConMayorCantidad();
        System.out.println("La palabra mas frecuente en " + nombreFichero + " es <<"  + cadena + ">> con " + diccionario.cantidad(cadena) + " apariciones. ");
    }
}
