package practica1;

import java.util.Scanner; 


public class ejercicio04 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce un número entero: ");

        int num = sc.nextInt();
        int contador = 2;
        String s = ""; 

        while (contador < num){
            boolean esPrimo = true;

            for(int i = 2; i < contador; i++){
                if (contador % i == 0){
                    esPrimo = false;
                    break;
                }
            }
            
            if (esPrimo){
                s += Integer.toString(contador) + " ";

            }
            contador++;            
            

        }
        System.out.println("Los números primos menores que " + num + " son: " + s);
        sc.close();
    }
}
