
package practica1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;



public class ejercicio23 {
    public static void main(String[] args) throws FileNotFoundException {

        String[] equipos = {"Athletic_Club_de_Bilbao", "CA_Osasuna", 
        "CD_Alavés", "Club_Atlético_de_Madrid", 
        "Cádiz_CF", "Elche_CF", "FC_Barcelona", 
        "Getafe_CF", "Granada_CF", "Levante_UD", 
        "RCD_Espanyol", "RCD_Mallorca", "RC_Celta", 
        "Rayo_Vallecano", "Real_Betis_Balompié", 
        "Real_Madrid_CF", "Real_Sociedad_de_Fútbol", 
        "Sevilla_FC", "Valencia_CF", "Villarreal_CF"};

        char[][] matrizResultados = crearMatrizResultados(equipos, "datos/liga21-22-jornada25-sin-aplazados.txt");
        int esperadoSinDerrotasEnCasa = 2;
        String esperadoObtenerLíder = "Real_Madrid_CF";

        pruebaSinDerrotasEnCasa(matrizResultados, esperadoSinDerrotasEnCasa);
        preubaobtenerLíder(matrizResultados, equipos, esperadoObtenerLíder);
    }
    
    public static char[][] crearMatrizResultados(String[] equipos, String nombreFichero) throws FileNotFoundException { // De momento, no capturamos la excepción.
        char[][] matriz = new char[equipos.length][equipos.length];

        Scanner fichero = new Scanner(new File(nombreFichero), "UTF-8");
        
        while(fichero.hasNext()){

            String equipoLocal = fichero.next();
            int golesEquipoLocal = fichero.nextInt();
            String equipoVisitante = fichero.next();
            int golesEquipoVisitante = fichero.nextInt();

            int posEquipoLocal = -1;
            int posEquipoVisitante = -1;

            for(int i = 0; i < equipos.length; i++){

                if(equipos[i].equals(equipoLocal)){
                    posEquipoLocal = i; 
                }

                if(equipos[i].equals(equipoVisitante)){
                    posEquipoVisitante = i;
                }
            }    

            if (golesEquipoLocal > golesEquipoVisitante) {
            
                matriz[posEquipoLocal][posEquipoVisitante] = '1';
           
            } else {

                if (golesEquipoVisitante > golesEquipoLocal) {

                    matriz[posEquipoLocal][posEquipoVisitante] = '2';

                } else {
                    if (golesEquipoVisitante == golesEquipoLocal){
                        matriz[posEquipoLocal][posEquipoVisitante] = 'X';
                    }
                }
            }
        }

        for(int i=0; i < matriz.length; i++){
            for(int j=0; j < matriz[i].length; j++){
                if(matriz[i][j] == '\u0000'){
                    matriz[i][j] = '-';
                }
            }
        }

        fichero.close();
        return matriz;
    }
    public static int sinDerrotasEnCasa(char matriz[][]){
        int equipos = 0;
        for(int i = 0; i < matriz.length; i++){
            boolean haPerdido = false;
            for(int j=0; j < matriz[i].length; j++){
                if(matriz[i][j] == '2'){
                    haPerdido = true;
                    break;
                }
            }
            if(haPerdido == false){
                equipos++;
            }
        }
        return equipos;
    }

    public static String obtenerLíder(char[][] matriz, String[] equipos){
        String lider = "";
        int mayor = 0;
        
        for(int i = 0; i < matriz.length; i++){
            int puntos = 0;
            for(int j=0; j < matriz[i].length; j++){
                if(matriz[i][j] == '1'){
                    puntos += 3;
                } else {
                    if(matriz[i][j] == 'X'){
                        puntos += 1;
                    }
                }
            }
            if(puntos > mayor) {
                lider = equipos[i];
                mayor = puntos;
            }
        }
        return lider;
    }

    public static void pruebaSinDerrotasEnCasa(char[][] matriz, int esperado){
        int resultado = sinDerrotasEnCasa(matriz);
        System.out.print("Prueba con matriz de Resultados y valor " + esperado + " --> ");

        if (resultado == esperado) {
            System.out.println("OK");
        } else {
            System.out.println("ERROR");
        }
    }

    public static void preubaobtenerLíder(char matriz[][], String[] equipos, String esperado){
        String resultado = obtenerLíder(matriz, equipos);
        System.out.printf("Preuba con matriz de Resultados y valor %s --> ", esperado);

        if (esperado.equals(resultado)) {
            System.out.println("OK");
        } else {
            System.out.println("ERROR");
        }
    }

}