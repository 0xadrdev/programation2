package practica4.ejercicio02;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BusquedaDNI {
    public static void main(String[] args) throws FileNotFoundException {
		String[] dnisCenso = crearVectorDni("datos/dniCenso.txt");
		String[] dnisClientes = crearVectorDni("datos/dniClientesOrdenado.txt");
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
        int inicio = 0;
        int fin = vector.length - 1;
        while (inicio <= fin) {
            int medio = (inicio + fin) / 2;
            if (vector[medio].compareTo(dni) < 0) {
                inicio = medio + 1;
            } else if (vector[medio].compareTo(dni) > 0) {
                fin = medio - 1;
            } else {
                return vector[medio].equals(dni);
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
