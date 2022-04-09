package practica2.ejercicio04;

import java.util.Scanner;

import practica2.ejercicio02.Restaurante; 
import practica2.ejercicio01.Punto;

import java.io.FileNotFoundException;


public class RestauranteValorado {  

    public static void main(String[] args) throws FileNotFoundException{
        
        Scanner sc = new Scanner(System.in);
    
        System.out.println("Indique su posición actual: ");
    
        System.out.print("Coordenada X: ");
        double x = sc.nextDouble();
    
        System.out.print("Coordenada y: ");
        double y = sc.nextDouble();

        System.out.print("Indique la distancia máxima que quiere andar: ");
        double distancia = sc.nextDouble();
                
        Punto p = new Punto(x, y);
        Restaurante[] restaurantes = Restaurante.leeRestaurantes("datos/restaurantes.txt");

        System.out.println("El restaurante mejor valorado a una distancia de " + distancia + " m es " + restauranteMejorValorado(restaurantes, p, distancia).getNombre() + " y se encuentra situado en " + restauranteMejorValorado(restaurantes, p, distancia).getPosicion());

        sc.close();
    }

    public static Restaurante restauranteMejorValorado(Restaurante[] restaurantes, Punto p, Double d) {
        int indiceRestauranteMejorValorado = -1;
        int mayorValoracion = 0;
        for (int i = 0; i < restaurantes.length; i++) {
            if(restaurantes[i].distancia(p) <= d && restaurantes[i].getValoración() > mayorValoracion){
                indiceRestauranteMejorValorado = i;
                mayorValoracion = restaurantes[i].getValoración();
            }
            
        }
        
        if (indiceRestauranteMejorValorado == -1) {
            return null;
        } else {
            return restaurantes[indiceRestauranteMejorValorado];
        }
    }
}
