package practica2.ejercicio02;

import java.io.FileNotFoundException;


public class RestaurantePruebas {
    public static void main(String[] args) throws FileNotFoundException {
        Restaurante[] restaurantes = Restaurante.leeRestaurantes("datos/restaurantes.txt");

        for (int i = 0; i < restaurantes.length; i++) {
            System.out.println(restaurantes[i].getNombre());
        }
    }
    
}
