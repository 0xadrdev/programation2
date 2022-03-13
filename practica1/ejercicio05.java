package practica1;

import java.util.Scanner; 


public class ejercicio05 {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        
        System.out.print("Introduce un número entero: ");

        int num = sc.nextInt();
        int contador = 2;
        int primorial = 1; 

        while (contador <= num){
            boolean esPrimo = true;

            for(int i = 2; i < contador; i++){
                if (contador % i == 0){
                    esPrimo = false;
                    break;
                }
            }

            if (esPrimo){
                primorial *= contador;
            }

            contador++;          
        }

        System.out.println(num + "# = " + primorial);

        sc.close();
    }
}