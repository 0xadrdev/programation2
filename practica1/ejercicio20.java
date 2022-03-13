
package practica1;


public class ejercicio20{
    public static void main(String[] args) {
        int[] vector = {6,4,7,8,2,9,3,10,5};
        int[] vector2 = {1,1,2,2,3,4,5};
        
        
        System.out.println("OLAS DE FRIO == " + contiene(vector, 1));
        System.out.println("OLAS DE FRIO == " + contieneVectores(vector, vector2, 1));


    }

    private static boolean contiene(int[] vector, int num) {

        for(int i = 0; i < vector.length; i++) {
            for(int j = 0; j < vector.length; j++) {
                if(vector[i] == num && vector[j] == num && j != i){
                    return true;
                }
            }    
        }
        return false;
    }

    private static boolean contieneVectores(int[] vector1, int[] vector2, int num) {

        for(int i = 0; i < vector2.length; i++) {
            boolean estado = false; 
            for(int j = 0; j < vector1.length; j++) {
                if(vector2[i] == vector1[j]){
                    estado = true; 
                }
            } 
            if(estado == false){
                return false;
            }
        }
        return true;
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