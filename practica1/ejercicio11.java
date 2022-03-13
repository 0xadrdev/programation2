package practica1;
public class ejercicio11 {
    public static void main(String[] args) {

        // prueba("hola", "osa", false);
        // prueba("hola", "ola", true);
        // prueba("hola", "hola", true);
        // prueba("hola", "", true);
        // prueba("hola", "ola", true);
        // prueba("hola", "ola", true);
        prueba("desoxirribonucleico","ico"," es sufijo de A");
        prueba("persiana","pana"," no es sufijo de A");
        prueba("persiana","ana"," es sufijo de A");
        prueba("ana","persiana"," no es sufijo de A");
        prueba("ana","ana"," es sufijo de A");
        prueba("ana",""," es sufijo de A");
        prueba("",""," es sufijo de A");
        prueba("","ana"," no es sufijo de A");
        prueba("marmota","mar"," no es sufijo de A");
        prueba("marmota","mota"," es sufijo de A");
        prueba("empanada","nada"," es sufijo de A");
        prueba("empanada","pan"," no es sufijo de A");
        prueba("ejemplo","ejemplo"," es sufijo de A");
        prueba("ejemplo",""," es sufijo de A");
        prueba("ejemplo","e"," no es sufijo de A");
        prueba("ejemplo","o"," es sufijo de A");
        prueba("o","o"," es sufijo de A");
        prueba("e","o"," no es sufijo de A");
        prueba("xx","xxx"," no es sufijo de A");
        prueba("persona","a"," es sufijo de A");
        prueba("persona","o"," no es sufijo de A");
        prueba("persona","x"," no es sufijo de A");
        prueba("persona","na"," es sufijo de A");
        prueba("persona","ea"," no es sufijo de A");
        prueba("persona","ya"," no es sufijo de A");
        prueba("persona","uy"," no es sufijo de A");
        prueba("persona",""," es sufijo de A");
        prueba("persona","osa"," no es sufijo de A");
        prueba("persona","ona"," es sufijo de A");
        prueba("persona","ano"," no es sufijo de A");
        prueba("persona","ina"," no es sufijo de A");
        prueba("persona","ana"," no es sufijo de A");
        prueba("persona","sona"," es sufijo de A");
        prueba("persona","mona"," no es sufijo de A");
        prueba("persona","sana"," no es sufijo de A");
        prueba("persona","sara"," no es sufijo de A");
        prueba("persona","rsona"," es sufijo de A");
        prueba("persona","ersona"," es sufijo de A");
        prueba("persona","xrxoxa"," no es sufijo de A");
        prueba("persona","persona"," es sufijo de A");
        prueba("persona","eersona"," no es sufijo de A");



    }

    private static boolean esSufijo(String s1, String s2) {
        int resto = s1.length() - s2.length();
  
        if(s2.length() > s1.length()){
            return false;
        }



        for(int i = s1.length() - s2.length(); i < s1.length(); i++) {

            
            if (s1.charAt(i) != s2.charAt(i - resto)){

                return false;
            }
        }


        return true;
    }

    private static void prueba(String s1, String s2, String esperado) {
        boolean resultado = esSufijo(s1,s2);
        System.out.format("Prueba con %s y %s: ", s1, s2);
        if (resultado && " es sufijo de A" == esperado) {
            System.out.println("OK");
        } else if ( !resultado && " no es sufijo de A" == esperado) {
            System.out.println("OK");

        } else {
            System.out.println("ERROR");
        }
    }
}