
package practica1;

import java.util.Scanner; 


public class ejercicio01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce un número entero: ");
        int num = sc.nextInt();
        
        int fact = 1;

        for(int i = 1; i <= num; i++) 
            fact *= i; 

            System.out.println(num + "! = " + fact);

        sc.close();

    }
}

/*

import java.util.Scanner; 


public class ejercicio02 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce un número entero: ");
        int num = sc.nextInt();




        sc.close();
    }
}
}*/ 