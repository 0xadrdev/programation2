package practica1;

import java.util.Scanner; 


public class ejercicio10 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce un número entero: ");
        int num = sc.nextInt();
        int numero_mayor_divisores = 1;

        for(int i = 1; i <= num; i++){
            if(contarDivisores(i) >= contarDivisores(numero_mayor_divisores)){
                numero_mayor_divisores = i; 
            }
        }

        System.out.println("El número con más divisores es " + numero_mayor_divisores + " (" + contarDivisores(numero_mayor_divisores) + " divisores)" );


        sc.close();
    }

    public static int contarDivisores(int num) {
        int numero_divisores = 0;

            for (int i = 1; i <= num; i++){
                if (num % i == 0){
                    numero_divisores += 1;
                }
            }
        return numero_divisores;
    }
}
