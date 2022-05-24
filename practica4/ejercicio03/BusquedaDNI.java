package practica4.ejercicio03;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BusquedaDNI {
    public static void main(String[] args) throws FileNotFoundException {
		String[] dnisCenso = crearVectorDni("datos/dniCensoOrdenado.txt");
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

    public static int contarCoincidencias(String[] vector1, String[] vector2) {
        int numeroCoincidencias = 0;
        for (int i = 0, j = 0; i < vector1.length && j < vector2.length;) {
            if (vector1[i].equals(vector2[j])) {
                numeroCoincidencias++;
                j++;
                i++;
            } else if (vector1[i].compareTo(vector2[j]) > 0) {
                j++; 
            } else {
                i++;
            }
        }
        return numeroCoincidencias;
    }
}
