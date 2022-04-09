package practica2.ejercicio03;

import java.util.Scanner;

import practica2.ejercicio02.Restaurante; 
import practica2.ejercicio01.Punto;

import java.io.FileNotFoundException;



public class RestauranteProximo {

    public static void main(String[] args) throws FileNotFoundException{
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce el nombre de un fichero: ");

        System.out.println("Indique su posición actual: ");

        System.out.print("Coordenada X: ");
        double x = sc.nextDouble();

        System.out.print("Coordenada y: ");
        double y = sc.nextDouble();
        
        sc.close();
        
        Punto p = new Punto(x, y);
        Restaurante[] restaurantes = Restaurante.leeRestaurantes("datos/restaurantes.txt");

        System.out.print("El restaurante más cercano a su posición es " + restauranteMasProximo(restaurantes, p).getNombre() + " situado en el punto " + restauranteMasProximo(restaurantes,p).getPosicion());
        

    }

    public static Restaurante restauranteMasProximo(Restaurante[] restaurantes, Punto p){
        int indiceRestauranteMasProximo = 0;
        double menorDistancia = restaurantes[0].distancia(p);


        for (int i = 0; i < restaurantes.length; i++) {
            
            if (restaurantes[i].distancia(p) < menorDistancia) {
                indiceRestauranteMasProximo = i;
                menorDistancia = restaurantes[i].distancia(p);
            }

        }

        return restaurantes[indiceRestauranteMasProximo];
    }

    
}
