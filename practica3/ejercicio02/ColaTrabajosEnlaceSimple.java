package practica3.ejercicio02;

import java.util.NoSuchElementException;

public class ColaTrabajosEnlaceSimple implements ColaTrabajos {


    private static class Nodo {
        TrabajoImpresora trabajo;
        Nodo siguiente;

        Nodo(TrabajoImpresora trabajo, Nodo siguiente) {
            this.trabajo = trabajo;
            this.siguiente = siguiente; 
        }
    }


    private int talla;
    private Nodo primerNodo;
    private Nodo ultimoNodo;

    // Constructor (por defecto)

    public void insertar(TrabajoImpresora t) {
        Nodo nuevo = new Nodo(t, null);
        if (esVacía()) {
            this.primerNodo = nuevo;
            this.ultimoNodo = nuevo;
            this.talla++;
        } else {
            this.ultimoNodo.siguiente = nuevo;
            this.ultimoNodo = nuevo;
            this.talla++;
        }
    }

    public TrabajoImpresora extraerPrimero() {
        if (esVacía()) {
			throw new NoSuchElementException("Esta vacía la cola de trabajos. No hay nada que imprimir.");
        } 
        TrabajoImpresora elemento = primerNodo.trabajo;
        primerNodo = primerNodo.siguiente;
        if (primerNodo == null) {
            ultimoNodo = null;
        }
        this.talla--;
        return elemento; 
    }

    public TrabajoImpresora consultarPrimero() {
        if (esVacía()) {
            throw new NoSuchElementException("Esta vacía la cola de trabajos. No hay nada que imprimir.");
        }
        return primerNodo.trabajo;
    }

    public int getTalla() {
        return talla;
    }

    public String toString() {
        if (esVacía()) {
            return "[]";
        }
        String cadena = "[";
        for (Nodo aux = primerNodo; aux != null; aux = aux.siguiente) {
            if (aux == ultimoNodo) {
                cadena += ultimoNodo.trabajo.toString() + "]";   
            } else {
                cadena += aux.trabajo.toString() + " -> ";
            }
        }
        return cadena;

    }

    public void cancelar(String idUsuario) {
        Nodo nodoAnterior = null;
        Nodo nodoActual = primerNodo;
        while (nodoActual != null) {
            if (nodoActual.trabajo.getIdUsuario() == idUsuario) {
                if (nodoActual == primerNodo) {
                    primerNodo = nodoActual.siguiente;
                } else if (nodoActual == ultimoNodo) {
                    ultimoNodo = nodoAnterior; 
                    ultimoNodo.siguiente = null;
                } else {
                    nodoAnterior.siguiente = nodoActual.siguiente;
                }
            } 
            nodoAnterior = nodoActual;
            nodoActual = nodoActual.siguiente;
        }
    }

    public void adelantar(int idTrabajo) {
        Nodo nodoAnterior = primerNodo;
        Nodo nodoActual = nodoAnterior.siguiente;
        while (nodoActual != null) {
            if (nodoActual.trabajo.getIdTrabajo() == idTrabajo) {
                if (nodoActual == ultimoNodo) {
                    ultimoNodo = nodoAnterior;
                    ultimoNodo.siguiente = null;
                    nodoActual.siguiente = primerNodo;
                    primerNodo = nodoActual;
                } else {
                    nodoAnterior.siguiente = nodoActual.siguiente; 
                    nodoActual.siguiente = primerNodo; 
                    primerNodo = nodoActual;
                }
            } 
            nodoAnterior = nodoActual;
            nodoActual = nodoActual.siguiente;
        }
    }

    public boolean esVacía() {
        return primerNodo == null;
    }

}
