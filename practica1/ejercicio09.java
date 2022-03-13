package practica1;

import java.util.Scanner; 


public class ejercicio09 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce un número entero: ");
        int num = sc.nextInt();
        long primorial = 1;

       for (int i = 1; i <= num; i++) {
            if (ejercicio07.esPrimo(i)) {
                primorial *= i;
            }
        }

        System.out.println(num + "# " + "= " + primorial);
        sc.close();
    }
}