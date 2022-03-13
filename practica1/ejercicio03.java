package practica1;

import java.util.Scanner; 


public class ejercicio03 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce un número entero: ");
        int num = sc.nextInt();

        if (ejercicio07.esPrimo(num) == true) {
            System.out.println("Es primo");
        } else {
            System.out.println("No es primo");
        }
        sc.close();

    }
}