package practica2.ejercicio02;

import practica2.ejercicio01.Punto;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Restaurante {
    private String nombre;
    private Punto posicion;
    private int valoracion; 

    public Restaurante(String nombre, Punto posicion, int valoracion){
        this.nombre = nombre;
        this.posicion = posicion;
        this.valoracion = valoracion;
    }
    
    public String getNombre(){
        return this.nombre;
    }

    public Punto getPosicion(){
        return this.posicion;
    }

    public int getValoración(){
        return this.valoracion;
    }

    public double distancia(Punto p){
        return p.distancia(this.posicion);
    }

    public static Restaurante[] leeRestaurantes(String nombreFichero) throws FileNotFoundException{

        Scanner fichero = new Scanner(new File(nombreFichero), "UTF-8");

        Restaurante[] restaurantes = new Restaurante[fichero.nextInt()];

        for (int i = 0; i < restaurantes.length; i++) {
            int x = fichero.nextInt();
            int y = fichero.nextInt();
            int valoracion = fichero.nextInt();
            String nombre = fichero.next();

            restaurantes[i] =  new Restaurante(nombre, new Punto(x,y), valoracion);
        }

        // while(fichero.hasNext()){
        //     int x = fichero.nextInt();
        //     System.out.println(x);
        //     int y = fichero.nextInt();
        //     System.out.println(y);

        //     int valoracion = fichero.nextInt();
        //     System.out.println(valoracion);

        //     String nombre = fichero.next();
        //     System.out.println(nombre);
        //     System.out.println("-------------------------------------");

        // }
        
        fichero.close();
        return restaurantes;
    }
}