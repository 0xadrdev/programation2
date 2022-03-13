package practica1;
public class ejercicio13 {
    public static void main(String[] args) {
        prueba("jazmin ramon", 1, "jazmin");
        prueba("    pepe    ppe    robert          k          trjnrt       ", 5, "trjnrt");
        prueba("                         jazmin                      ", 1, "jazmin");
        prueba("hola me llamo pepep", 1, "hola");
        prueba("hola me llamo pepep", 2, "me");
        prueba("hola me llamo pepep", 3, "llamo");
        prueba("        hola    me            llamo        pepep          ", 4, "pepep");
        prueba("               jazmin                      ", 1, "jazmin");



        // prueba("   rjrenvpirnv `4j 4pgh 45gp `425j 4`gj42`5gj425g5j 4 `j45g `45gj4`gj4g`      j42hpojh              ", 11);
        // prueba("hola me llamor ror fk  `woergprgihrpgh gògpih3qf`we´pqñw`++4erg erg erg rgq 3 134gewrrcñ rer grpeg erp  gwngobvohew  gerh ioerhg iwherg oghio hwgoi eegio egiouhgh toigh woigh weoeigh woeigh gi weioegh ghiwi  g  w     f  sed f f ger g r g g t h t h tr  ef d g w rg er g er g wtg t rg rt g t g  tg tg  tg t g e g v fd g fv  rtf  cf  g      t g t g tg  tg    t g t g tg t reg f t r g 56 4t rge fd  rg f tr fedtgr fvgt rfgt rftgrf gt rftg rfgt rf gtrfgtr feo5iwt 0954t5 tgrfijg              f f  f f ff     ff ff        fff         f f    f f f      r e e  ws  d df f f   gg g  g g g", 138);
    }

    private static String obtenerPalabra(String cadena, int num) {
        int contadorCaracteres = 0;
        int numeroPalabras = 1;
        String palabra = ""; 

        // if (num > ejercicio12.contarPalabras(cadena) || num < ejercicio12.contarPalabras(cadena)){
        //     return null;
        // }

        if (ejercicio12.contarPalabras(cadena) == 1 ){
            while (cadena.charAt(contadorCaracteres) != ' '){
                palabra += cadena.charAt(contadorCaracteres);
                contadorCaracteres++;
                if (contadorCaracteres == cadena.length()) {
                    return palabra;
                }

            }
        }

        if(cadena.charAt(0) == ' '){
            numeroPalabras = 0;
        }

        if (cadena.charAt(0) != ' ' && num == 1){
            while(cadena.charAt(contadorCaracteres) != ' ') {
                palabra += cadena.charAt(contadorCaracteres);
                contadorCaracteres++;
            }
            return palabra;
        }

        while (contadorCaracteres < cadena.length() - 1)  {

            if (cadena.charAt(contadorCaracteres) == ' ' && cadena.charAt(contadorCaracteres + 1) != ' ') {
            
                numeroPalabras++;
                // System.out.println(cadena.charAt(contadorCaracteres));
                if (numeroPalabras == num) {
                    // print(contadorCaracteres);
                    // System.out.println(cadena.charAt(contadorCaracteres));

                    contadorCaracteres++;

                    while(cadena.charAt(contadorCaracteres) != ' ') {
                        palabra += cadena.charAt(contadorCaracteres);
                        contadorCaracteres++;
                        if (contadorCaracteres == cadena.length()) {
                            return palabra;
                        }
                    }
                }
            } 
            contadorCaracteres++;
        }
        return palabra; 
    }



    private static void prueba(String s1, int num, String esperado) {
        String resultado = obtenerPalabra(s1, num);
        System.out.format("Prueba con %s y %s --> ", s1, num);
        
        if (resultado.equals(esperado) ) {
            System.out.println("OK");
        } else {
            System.out.println("ERROR");
        }

        // for (int i = 0; i < resultado.length(); i++) {
        //     System.out.println(resultado.charAt(i));
        // }
    }
}