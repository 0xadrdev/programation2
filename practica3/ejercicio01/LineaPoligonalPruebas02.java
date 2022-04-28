package practica3.ejercicio01; // Indica aquí el nombre del paquete que utilizas.
import practica2.ejercicio01.*;

public class LineaPoligonalPruebas02 {

    private static final int LÍMITE = 100000;

    public static void main(String[] args) {

        LineaPoligonal línea = new LineaPoligonal();

        System.out.println("Creada línea poligonal vacía");
        System.out.println("\nAñadiendo puntos a la línea...");

        for (int i = 1; i <= LÍMITE; i++) {
            if (i % 10000 == 0)
                System.out.println("  " + i + " puntos");
            línea.añadir(new Punto(i, i));
        }

        double longitud = línea.longitud();
        double esperado = (LÍMITE - 1) * Math.sqrt(2);

        System.out.println("\nLongitud de la línea: " + longitud);

        if (Math.abs(longitud - esperado) < 1E-3) {
            System.out.println(" --> BIEN");
        } else {
            System.out.println(" --> MAL: Debería ser " + esperado);
        }
    }

}
