package practica3.ejercicio05;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GanadorLiga {
    public static void main(String[] args) throws FileNotFoundException{
        Diccionario diccionario = new Diccionario();
        Scanner fichero = new Scanner(new File("datos/liga2017-2018.txt"), "UTF-8");
        while(fichero.hasNext()){
            String equipoLocal = fichero.next();
            int golesEquipoLocal = fichero.nextInt();
            String equipoVisitante = fichero.next();
            int golesEquipoVisitante = fichero.nextInt();
            if(golesEquipoVisitante == golesEquipoLocal) {
                diccionario.añadir(equipoLocal, 1);
                diccionario.añadir(equipoVisitante, 1);
            } else if (golesEquipoLocal > golesEquipoVisitante) {
                diccionario.añadir(equipoLocal, 3);
            } else {
                diccionario.añadir(equipoVisitante, 3);
            }
        }
        System.out.println("Ganador liga 2017-1018: " + "<" + diccionario.cadenaConMayorCantidad() + "> " + "con " + diccionario.cantidad(diccionario.cadenaConMayorCantidad()) + " puntos. ");
    }
}
