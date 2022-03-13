package practica1;
import java.util.Scanner; 


public class ejercicio02 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce un número entero: ");
        
        int num = sc.nextInt();
        long fact = 1;

        if (num == 0 || num == 1) {
            fact = 1;

        } else if (num % 2 == 0) {
            for(int i = 1; i <= num; i++) {
                if (i % 2 == 0){
                    fact *= i; 
                }
            }

        }

        else {
            for(int i = 1; i <= num; i++) {
                if (i % 2 != 0){
                    fact *= i; 
                }
            }
        }
        
        System.out.println(num + " !!= " + fact);
        
        sc.close();

    }
}