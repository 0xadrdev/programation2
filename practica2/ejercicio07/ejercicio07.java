package practica2.ejercicio07;

import java.util.Scanner; 
import practica2.ejercicio05.*;

public class ejercicio07 {

    public static void main(String[] args) throws ExcepcionFechaInvalida{

        Fecha fechaNacimiento  = new Fecha(6,9,2003);


        try {

        Fecha posibleFecha = preguntarFecha();
        
        int intentos = 1;
    

        while (fechaNacimiento.compareTo(posibleFecha) != 0) {

            System.out.println("No has acertado, intentalo otra vez. ");

            if (posibleFecha.compareTo(fechaNacimiento) < 0) {

                System.out.println("La fecha que buscas es mayor a la que has introducido. ");
    
            } else if (posibleFecha.compareTo(fechaNacimiento) > 0) {
    
                System.out.println("La fecha que buscas es menor a la que has introducido. ");
                
            }

            System.out.println();
            posibleFecha = preguntarFecha();
            intentos++;
        }   

        System.out.println("\u001B[1;31m"+"AWESOME!!! has adivinado mi fecha de nacimento con solo: " + intentos + " intentos. \u001B[0m");
    
        } catch (ExcepcionFechaInvalida e) {
            System.out.println("Has introducido una fecha incorrecta.");
        }
    
    }
    
    
    
public static Fecha preguntarFecha() {
        Scanner sc = new Scanner(System.in);

        Fecha fechaMax = new Fecha(1,1,2022);
        Fecha fechaMin = new Fecha(1,1,1900);
        Fecha minimaFechaPosterior;
        Fecha maximaFechaAnterior;
        
        System.out.print("Introduce el que creas que es mi día de nacimiento: ");
        int día = sc.nextInt();

        System.out.print("Introduce el que creas que es mi mes de nacimiento: ");
        int mes = sc.nextInt();

        System.out.print("Introduce el que creas que es mi año de nacimiento: ");
        int año = sc.nextInt();

        
        Fecha fecha = new Fecha(día, mes, año);


        if (fecha.compareTo(fechaMin) < 0) {

            System.out.println("Has introducido una fecha más pequeña de lo que se permite. Recuerda que la fecha no puede ser más pequeña que: " + fechaMin.toString());
            fecha = preguntarFecha();

        } else if (fecha.compareTo(fechaMax) > 0) {

            

            System.out.println("Has introducido una fecha más grande de lo que se permite. Recuerda que la fecha no puede ser más grande que: " + fechaMax.toString());
            fecha = preguntarFecha();

        }
        return fecha; 
    }
}