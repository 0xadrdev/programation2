package practica3.ejercicio05;

import java.util.Arrays;


public class Diccionario {
    private class Nodo {
        int cantidad;
        String cadena;
        Nodo siguiente;

        Nodo(String cadena, int cantidad, Nodo siguiente) {
            this.cadena = cadena;
            this.cantidad = cantidad;
            this.siguiente = siguiente;
        }
    }   

    private Nodo primerNodo;
    private int talla;

    public void añadir(String unaCadena, int unaCantidad) {
        Nodo nodoAnterior = null;
        Nodo nodoActual = primerNodo;
        if (talla == 0) {
            primerNodo = new Nodo(unaCadena, unaCantidad, null);
        } else { 
            while (nodoActual != null) {
                if (nodoActual.cadena.compareTo(unaCadena) == 0 || unaCadena.compareTo(nodoActual.cadena) < 0) {
                    break;
                } else {
                    nodoAnterior = nodoActual; 
                    nodoActual = nodoActual.siguiente;
                }
            }
            if (nodoActual == null) {
                nodoAnterior.siguiente = new Nodo(unaCadena, unaCantidad, null);
            } else if (nodoActual.cadena.compareTo(unaCadena) == 0){
                nodoActual.cantidad += unaCantidad;
            } else if (nodoActual == primerNodo) {
                primerNodo = new Nodo(unaCadena, unaCantidad, primerNodo);
            } else {
                nodoAnterior.siguiente = new Nodo(unaCadena,unaCantidad, nodoActual);
            }
        }
        talla++;
    }
    

    public String cadenaConMayorCantidad() {
        if (talla == 0) {
            return null;
        }
        String cadenaConMayorCantidad = primerNodo.cadena;
        int mayorCantidad = primerNodo.cantidad;
        for (Nodo aux = primerNodo; aux != null; aux = aux.siguiente) { 
            if (cantidad(aux.cadena) > mayorCantidad) {
                mayorCantidad = aux.cantidad;
                cadenaConMayorCantidad = aux.cadena;
            }
        }
        return cadenaConMayorCantidad;
    }

    public int cantidad(String unaCadena) {
        for (Nodo aux = primerNodo; aux != null; aux = aux.siguiente) {
            if(unaCadena == aux.cadena) {
                return aux.cantidad;
            }
        }
        return 0;
    }

    public String toString() {
        if (talla == 0) {
            return "{}";
        }
        if (talla == 1) {
            // System.out.println("PRIMER NODO CANTIDIDAD " + primerNodo.cantidad);
            return "{" + primerNodo.cadena + "-->" + primerNodo.cantidad + "}";
        }
        String cadena = "{";
        for (Nodo aux = primerNodo; aux != null; aux = aux.siguiente) {
            if (aux.siguiente == null) {
                cadena += aux.cadena + "-->" + aux.cantidad + "}";
                break;
            }
            cadena += aux.cadena + "-->" + aux.cantidad + ", ";
        }
        return cadena; 
    }
}
// public void añadir(String unaCadena, int unaCantidad) {
//     Nodo nodoAnterior = null;
//     Nodo nodoActual = primerNodo;
//     System.out.println("UNA CADENA --> " + unaCadena);
//     if (talla == 0) {
//         primerNodo = new Nodo(unaCadena, unaCantidad, null);
//     } else { 
//         while (nodoActual != null) {

//             if (nodoAnterior == null) {
//                 System.out.println("NODO ANTERIOR --> NULL");
//             } else {
//                 System.out.println("NODO ANTERIOR --> " + nodoAnterior.cadena);
//             }
//             System.out.println("NODO ACTUAL --> " + nodoActual.cadena);
//             System.out.println("COMPARE TO --> " + nodoActual.cadena.compareTo(unaCadena));
//             if (nodoActual.cadena.compareTo(unaCadena) == 0) {
//                 System.out.println("ENTRO 1 + NODO ACTUAL --> " + nodoActual.cadena);
//                 break;
//             } else if (unaCadena.compareTo(nodoActual.cadena) < 0) {
//                 System.out.println("ENTRO 2 + NODO ACTUAL --> " + nodoActual.cadena);
//                 break;
//             } else {
//                 System.out.println("ENTRO 3");
//                 nodoAnterior = nodoActual; 
//                 nodoActual = nodoActual.siguiente;
//             }
//         }
//         if (nodoActual == null) {
//             System.out.println("NODO ACTUAL --> NULL");
//         } else {
//             System.out.println("NODO ACTUAL --> " + nodoActual.cadena);
//         }

//         if (nodoAnterior == null) {
//             System.out.println("NODO ANTERIOR --> NULL");
//         } else {
//             System.out.println("NODO ANTERIOR --> " + nodoAnterior.cadena);
//         }

//         if (nodoActual == null) {
            
//             nodoAnterior.siguiente = new Nodo(unaCadena, unaCantidad, null);
//         } else if (nodoActual.cadena.compareTo(unaCadena) == 0){
//             nodoActual.cantidad += unaCantidad;
//         } else if (nodoActual == primerNodo) {
//             primerNodo = new Nodo(unaCadena, unaCantidad, primerNodo);
//         } else {
//             nodoAnterior.siguiente = new Nodo(unaCadena,unaCantidad, nodoActual);
//         }
//     }
//     System.out.println("------------------------------------------------------------");
//     talla++;