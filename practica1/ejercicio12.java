package practica1;
public class ejercicio12 {
    public static void main(String[] args) {
        prueba(" pepe Tepep emr", 3);
        prueba("   rjrenvpirnv `4j 4pgh 45gp `425j 4`gj42`5gj425g5j 4 `j45g `45gj4`gj4g`      j42hpojh              ", 10);
        prueba("hola me llamor ror fk  `woergprgihrpgh gògpih3qf`we´pqñw`++4erg erg erg rgq 3 134gewrrcñ rer grpeg erp  gwngobvohew  gerh ioerhg iwherg oghio hwgoi eegio egiouhgh toigh woigh weoeigh woeigh gi weioegh ghiwi  g  w     f  sed f f ger g r g g t h t h tr  ef d g w rg er g er g wtg t rg rt g t g  tg tg  tg t g e g v fd g fv  rtf  cf  g      t g t g tg  tg    t g t g tg t reg f t r g 56 4t rge fd  rg f tr fedtgr fvgt rfgt rftgrf gt rftg rfgt rf gtrfgtr feo5iwt 0954t5 tgrfijg              f f  f f ff     ff ff        fff         f f    f f f      r e e  ws  d df f f   gg g  g g g", 138);
    }

    public static int contarPalabras(String cadena) {
        int numeroPalabras = 0;
        int contadorCaracteres = 0;

        // Si no hay espacios al principio al principio de la cadena, sumamos la primera palabra. 
        
        if (cadena.charAt(0) != ' '){
            numeroPalabras = 1; 
        }

        while (contadorCaracteres < cadena.length() - 1)  {

            if (cadena.charAt(contadorCaracteres) == ' ' && cadena.charAt(contadorCaracteres + 1) != ' ') {
                numeroPalabras++;
            } 
            
            contadorCaracteres++;
        }

        return numeroPalabras; 
    }

    private static void prueba(String s1, int esperado) {
        int resultado = contarPalabras(s1);
        System.out.format("Prueba con %s: ", s1);
        
        if (resultado == esperado ) {
            System.out.println("OK");
        } else {
            System.out.println("ERROR");
        }
        System.out.println(resultado);

        

    }
}