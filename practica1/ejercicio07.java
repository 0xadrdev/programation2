package practica1;
public class ejercicio07 {

    public static void main(String[] args){
        System.out.println(esPrimo(1));
        System.out.println(esPrimo(2));
        System.out.println(esPrimo(0));

        System.out.println(esPrimo(1003));
    }
    public static boolean esPrimo(int num){
        int numeroDeDivisores = 0;

        for(int i = 1; i <= num; i++){
            if (num % i == 0){
                numeroDeDivisores += 1;
            }
        }

        if (numeroDeDivisores == 2){
            return true;
        }

        return false;
    }

}