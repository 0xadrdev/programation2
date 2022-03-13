package practica1;



public class ejercicio16{
    public static void main(String[] args) {
        double[] temperaturas = {-1,-1,0,-1,-1,1,1,1};
        System.out.println("OLAS DE FRIO == " + contarOlasDeFrío(temperaturas, 1));
        System.out.println("OLAS DE FRIO == " + contarOlasDeFríoTest(temperaturas, 1));

    }

    public static int contarOlasDeFrío( double[] temperaturas, int dias) {
        int contador = 0;
        int contadorDias = 0;
        int olasDeFrio = 0;
        while(contador < temperaturas.length){
            System.out.println(contador);
            if(temperaturas[contador] < 0 ){

                while(temperaturas[contador] < 0){
                    contadorDias++;
                    contador++;
                    if (contador == temperaturas.length && temperaturas[contador - 1] < 0){
                        break;
                    }
                }
                System.out.println("DIAS " + contadorDias);
                if(contadorDias > dias){
                    olasDeFrio += 1;
                }

                contadorDias = 0;
            }

            contador++;
        }

        return olasDeFrio;

    }

    private static int contarOlasDeFríoTest(double[] vector, int num){
        int consecutivo = 0;
        int olas = 0;

        for(int i=0; i < vector.length; i++){
            if (vector[i] < 0){
                consecutivo += 1;
            }

            if(vector[i] >= 0 || i == (vector.length - 1)){
                if(consecutivo > num){
                    olas += 1;
                    consecutivo = 0;
                }
            }
        }
        return olas;
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