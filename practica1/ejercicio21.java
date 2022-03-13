
package practica1;


public class ejercicio21{
    public static void main(String[] args) {
        int[] vector = {-1,-1,2,2,4,5};
        System.out.println("OLAS DE FRIO == " + posiciónInserción(vector, 200));

    }

    private static int posiciónInserción(int[] vector, int num) {
        int idx = 0;
        int mayor = 0;
        for(int i = 0; i < vector.length - 1; i++) {
            if(vector[i] == num){
                return i;
            } else {
                if(vector[i] < num && vector[i + 1] > num){
                    idx = i; 
                }
            }

            if(vector[i] > mayor){
                mayor = vector[i];
            }
        }

        if(num > mayor){
            return vector.length - 1;
        }
        return idx;
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