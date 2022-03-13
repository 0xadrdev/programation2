package practica1;
import java.util.Scanner; 


public class ejercicio06 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce un número entero: ");
        
        int num = sc.nextInt();
        int mayor = 0;
        int contador = 0;
        int numero_con_mas_divisores = 0;
        
        while (contador <= num){

            int numero_divisores = 0;

            for (int i = 1; i <= contador; i++)
                if (contador % i == 0)
                    numero_divisores += 1;

            if (numero_divisores > mayor) 
                mayor = numero_divisores; 
                numero_con_mas_divisores = contador;
            
            contador++;
        }

        
        System.out.println("El número con más divisores es " + numero_con_mas_divisores + " (" + mayor + " divisores)");

        sc.close();

    }

}