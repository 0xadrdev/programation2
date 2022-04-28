package practica2.ejercicio10;
import java.util.Arrays;


public class Persona {

    private String nombre;
    private static int cantidad;
    
    public Persona(String elNombre) {
        nombre = elNombre;
        System.out.println("Creada persona " + (++cantidad));
    }
    
    public String toString() {
        return nombre;
    }
    public static void main(String[] args) {
        Persona[] personas = new Persona[3];
        personas[0] = new Persona("Elena");
        personas[1] = new Persona("Cristina");
        personas[2] = new Persona("Felipe");
        System.out.println(Arrays.toString(personas));
    }
}

