package practica1;

import java.util.Scanner; 


    public class ejercicio08 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce un número entero: ");
        int num = sc.nextInt();
        System.out.print("Los números primos menores que " + num + " son: ");
        for (int i = 0; i < num; i++) {
            if (ejercicio07.esPrimo(i)) {
                System.out.print(i + " ");
            }
        }


        sc.close();
    }
    }