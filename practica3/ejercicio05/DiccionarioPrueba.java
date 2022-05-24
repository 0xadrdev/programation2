package practica3.ejercicio05;  // Indica aquí el nombre del paquete que utilizas.

// Para que este programa de prueba funcione correctamente es importante que
// los métodos toString() de las clases Nodo y Diccionario
// usen el formato indicado en el enunciado, es decir:
// {} para una lista vacía y
// {cadena-->cantidad, cadena-->cantidad, ..., cadena-->cantidad} para una lista no vacía
import java.util.Arrays;


public class DiccionarioPrueba {

    public static void main(String[] args) {
        Diccionario diccionario = new Diccionario();

        System.out.println("\nContenido del diccionario: " + diccionario);
        System.out.println("--> Probamos añadir(String) de cadenas que NO están presentes:");
        diccionario.añadir("Elena", 5);
        diccionario.añadir("Pablo", 3);
        diccionario.añadir("Noa", 3);
        comprueba(diccionario, "{Elena-->5, Noa-->3, Pablo-->3}");

        System.out.println("\nContenido del diccionario: " + diccionario);
        System.out.println("--> Probamos añadir(String) de cadenas que SI están presentes:");
        diccionario.añadir("Pablo", 7);
        diccionario.añadir("Elena", 1);
        comprueba(diccionario, "{Elena-->6, Noa-->3, Pablo-->10}");

        System.out.println("\nContenido del diccionario: " + diccionario);
        System.out.println("--> Probamos get(String):");
        System.out.println("La cantidad asociada a Pablo es " + diccionario.cantidad("Pablo"));
        System.out.println("La cantidad asociada a Elena es " + diccionario.cantidad("Elena"));
        System.out.println("La cantidad asociada a María es " + diccionario.cantidad("María"));

        System.out.println("\nContenido del diccionario: " + diccionario);
        System.out.println("--> Probamos cadenaConMayorCantidad():");
        System.out.println("La cadena con mayor cantidad es " + diccionario.cadenaConMayorCantidad());

        String[] números = new String[] {"cero", "uno", "dos", "tres" };
		diccionario = new Diccionario();

        for (int i = 0 ; i < números.length ; i++) {
			diccionario.añadir(números[i], i);
			System.out.println("numeros[i]" + números[i]);
			System.out.println(diccionario.cadenaConMayorCantidad());    
		}

        // System.out.println("EMPIEZA EL CAMINO BB");
		Diccionario diccionarioNúmeros = new Diccionario();
		for (int i = 0 ; i < números.length ; i++)
			diccionarioNúmeros.añadir(números[i], i);

        String[] partes = new String[números.length];
		for (int i = 0 ; i < números.length ; i++)
			partes[i] = números[i] + "-->" + i; 

		Arrays.sort(partes);
		String resultado = Arrays.toString(partes);
		resultado = "{" + resultado.substring(1, resultado.length() - 1) + "}";
		System.out.println("Debes revisar el método toString" + resultado + diccionarioNúmeros.toString());

    }


    public static void comprueba(Diccionario dic, String valorCorrecto) {
        if (!dic.toString().equals(valorCorrecto)) {
            System.out.println("*** Detectado error: Se esperaba " + valorCorrecto
                    + " pero se ha obtenido " + dic);
        } else {
            System.out.println("    (ok)");
        }
    }

}

// public void añadir(String unaCadena, int unaCantidad) {
//     if (talla == 0) {
//         primerNodo = new Nodo(unaCadena, unaCantidad, null, null);
//         talla++;
//     } else {
//         // Buscamos la posción de inserción.
//         boolean palabraPresente = false;
//         int posInsercion = 0;
//         int indice = 0;
//         Nodo ultimoNodo = new Nodo(unaCadena, unaCantidad, null, null);
//         for (Nodo aux = primerNodo; aux != null; aux = aux.siguiente) {
//             // System.out.println("INDICE POS INSERCION --> " + posInsercion);
//             System.out.println("INDICE --> " + indice);
//             System.out.println("UNA CADENA --> " + unaCadena);
//             System.out.println("AUX CADENA --> " + aux.cadena + " " + indice);
//             System.out.println("unaCadena.compareTo(aux.cadena) --> " + unaCadena.compareTo(aux.cadena));

//             if (aux.siguiente == null) {
//                 ultimoNodo = aux;
//             }

//             if(unaCadena.compareTo(aux.cadena) > 0) {
//                 posInsercion = indice + 1;
//             } else if (unaCadena.compareTo(aux.cadena) == 0) { // Si hay una cadena igual sumamos el atributo cantidad.
//                 aux.cantidad += unaCantidad;
//                 palabraPresente = true;
//                 break;
//             }
//             System.out.println("VECTOR --> " + this.toString());
//             System.out.println("-----------------------------------------------------------------------");
//             indice++;
//         }



//         // Añadimos el nuevo Nodo, sabiendo la posición de Inserción.
//         if (unaCadena.compareTo(ultimoNodo.cadena) > 0 && palabraPresente == false) {
//             posInsercion = talla;
//         }

//         if (posInsercion == talla) { // El nuevo nodo va el ultimo. 
//             palabraPresente = true;
//             for (Nodo aux = primerNodo; aux != null; aux = aux.siguiente) {
//                 if (aux.siguiente == null) {
//                     System.out.println("INSERTO 4");
//                     Nodo nuevoNodo = new Nodo(unaCadena, unaCantidad, aux, null);
//                     aux.siguiente = nuevoNodo;
//                     talla++;
//                     break;
//                 }
//             }
//         }

//         System.out.println("-----------------------------------------------------------------------");
//         System.out.println("PALABRA: " + unaCadena + " SU POS INSERCION ES --> " + posInsercion + "TALLA" + talla);

//         if (palabraPresente == false) {       
//             indice = 0;
//             for (Nodo aux = primerNodo; aux != null; aux = aux.siguiente) {
//                 System.out.println("AUX " + aux.cadena);
//                 // System.out.println("AUX ANTERIOR " + aux.anterior.cadena)
//                 if (aux.siguiente == null) {
//                     System.out.println("AUX SIGUIENTE " + null);
//                 } else {
//                     System.out.println("AUX SIGUIENTE " + aux.siguiente.cadena);
//                 }

//                 if (aux.anterior == null ) {
//                     System.out.println("AUX ANTERIOR " + null);
//                 } else {
//                     System.out.println("AUX ANTERIOR " + aux.anterior.cadena);

//                 }
//                 System.out.println("VECTOR --> " + this.toString());

//                 if (indice == posInsercion) {
//                     // if (aux.siguiente == null) { // Debemos saber si aux es el ultimo elemento. 
//                     //     System.out.println("INSERTO 1");
//                     //     Nodo nuevoNodo = new Nodo(unaCadena, unaCantidad, aux, null);
//                     //     aux.siguiente = nuevoNodo;
//                     //     talla++;
//                     // } else 
//                     if (aux == primerNodo) { // Debemos saber si es el primerNodo, ya que su anterior es null.
//                         System.out.println("INSERTO 2");
//                         Nodo nuevoNodo = new Nodo(unaCadena, unaCantidad, null, aux);
//                         primerNodo = nuevoNodo;
//                         aux.anterior = primerNodo;
//                         talla++;
//                     } else {
//                         System.out.println("INSERTO 3");
//                         Nodo nuevoNodo = new Nodo(unaCadena, unaCantidad, aux.anterior, aux); 
//                         aux.anterior.siguiente = nuevoNodo;
//                         aux.anterior = nuevoNodo;
//                         talla++;
//                     }
//                 }
//                 indice++;
//             }

//         }
//         System.out.println("-----------------------------------------------------------------------");
        
//     }

// }


// -----------------------------------------------------------------------------------------------------------------------

// public void añadir(String unaCadena, int unaCantidad) {
//     if (talla == 0) { // Si la talla es 0, es decir, no hay ningún elemento debemos de crear el primerNodo.
//         primerNodo = new Nodo(unaCadena, unaCantidad, null, null);
//         talla++;
//     } else {
//         // Buscamos la posción de inserción, o añadimos la cantidad de una cadena presente en la lista.
//         boolean palabraPresente = false;
//         int posInsercion = 0;
//         int indice = 0;
//         Nodo ultimoNodo = new Nodo(unaCadena, unaCantidad, null, null);
//         for (Nodo aux = primerNodo; aux != null; aux = aux.siguiente) {
//             if(unaCadena.compareTo(aux.cadena) > 0) {
//                 posInsercion = indice + 1;
//             } else if (unaCadena.compareTo(aux.cadena) == 0) { // Si hay una cadena igual sumamos el atributo cantidad.
//                 aux.cantidad += unaCantidad;
//                 palabraPresente = true; 
//                 break;
//             }
//             if (aux.siguiente == null) { // Nos guardamos el ultimo Nodo.
//                 ultimoNodo = aux;
//             }
//             indice++;
//         }

//         if (posInsercion == talla && palabraPresente == false) { // Si el nuevo Nodo va el ultimo y no hace falta recorrer todo el array. 
//             palabraPresente = true;
//             Nodo nuevoNodo = new Nodo(unaCadena, unaCantidad, ultimoNodo, null);
//             ultimoNodo.siguiente = nuevoNodo;
//             talla++;
//         }
        
//         // Añadimos el nuevo Nodo si no se ha insertado todavía, sabiendo la posición de Inserción.
//         if (palabraPresente == false) {       
//             indice = 0;
//             for (Nodo aux = primerNodo; aux != null; aux = aux.siguiente) {
//                 if (indice == posInsercion) {
//                     if (aux == primerNodo) { // Debemos saber si es el primerNodo, ya que su anterior es null.
//                         Nodo nuevoNodo = new Nodo(unaCadena, unaCantidad, null, aux);
//                         primerNodo = nuevoNodo;
//                         talla++;
//                     } else {
//                         Nodo nuevoNodo = new Nodo(unaCadena, unaCantidad, aux.anterior, aux); 
//                         aux.anterior.siguiente = nuevoNodo;
//                         aux.anterior = nuevoNodo;
//                         talla++;
//                     }
//                     break;
//                 }
//                 indice++;
//             }
//         }
//     }
// }
