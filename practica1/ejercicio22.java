package practica1;



public class ejercicio22{
    public static void main(String[] args) {
        double[][] temperaturas = {{-1, -1, 3, 0, -1},{-1, 6, -1, -1, 0},{-1, 0, 10, 0, -1}};
        System.out.println("OLAS DE FRIO == " + másOlasDeFrío(temperaturas, 1));

    }

    private static int másOlasDeFrío( double[][] temperaturas, int dias) {
        int mayor = 0;
        int año = 0; 
        for(int i = 0; i < temperaturas.length; i++){
            if(ejercicio16.contarOlasDeFrío(temperaturas[i], dias) >= mayor){
                mayor = ejercicio16.contarOlasDeFrío(temperaturas[i], dias);
                año = i;
            }
        }

        return 1990 + año;
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