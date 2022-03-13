package practica1;



public class ejercicio17{
    public static void main(String[] args) {
        int[] vector = {1,2,3,4,5,6,7,7,7,7};
        System.out.println("OLAS DE FRIO == " + hayRepetidos(vector));

    }

    private static boolean hayRepetidos(int[] vector) {

        for(int i = 0; i < vector.length; i++) {
            for(int j = 0; j < vector.length; j++){
                if(vector[i] == vector[j] && j != i){
                    return true;
                }
            }
        }
        return false;

    }


    // private static void prueba(String[] vector, boolean esperado) {
    //     boolean resultado = estaOrdenado(vector);
    //     System.out.format("Prueba con %s --> ", Arrays.toString(vector));
        
    //     if (resultado == esperado) {
    //         System.out.println("OK");
    //     } else {
    //         System.out.println("ERROR");
    //     }
    //     System.out.println(resultado);

    // }
}