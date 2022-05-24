package practica4.ejercicio01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BusquedaDNI {
    public static void main(String[] args) throws FileNotFoundException {
		String[] dnisCenso = crearVectorDni("datos/dniCenso.txt");
		String[] dnisClientes = crearVectorDni("datos/dniClientes.txt");
		long tiempoInicio = System.currentTimeMillis();
		int coincidencias = contarCoincidencias(dnisCenso, dnisClientes);
		long tiempoTranscurrido = System.currentTimeMillis() - tiempoInicio;
		System.out.println("He encontrado " + coincidencias + " coincidencias (empleando " + tiempoTranscurrido+ " milisegundos)");
	}

    public static String[] crearVectorDni(String nombreFichero) throws FileNotFoundException {
        Scanner fichero = new Scanner(new File(nombreFichero), "UTF-8");
        String[] vector = new String[fichero.nextInt()];
        int indice = 0;
        while(fichero.hasNext()) {
            vector[indice++] = fichero.next();
        }
        return vector;
    }

    public static boolean buscarDni(String dni, String[] vector) {
        for (int i = 0; i < vector.length; i++) {
            if (vector[i].compareTo(dni) == 0) {
                return true;
            }
        }
        return false;
    }

    public static int contarCoincidencias(String[] vector1, String[] vector2) {
        int numeroCoincidencias = 0;
        for (int i = 0; i < vector1.length; i++) {
            if (buscarDni(vector1[i], vector2)) {
                numeroCoincidencias++;
            }
        }
        return numeroCoincidencias;
    }
}
