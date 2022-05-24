package practica3.ejercicio04;

public class ListaCadenasEnlaceSimple implements ListaCadenas {
   
    private class Nodo {
        String cadena; 
        Nodo siguiente; 

        Nodo(String cadena, Nodo siguiente) {
            this.cadena = cadena;
            this.siguiente = siguiente;
        }
    }

    private Nodo primerNodo;
    private int talla;

    public boolean add(String s) {
        Nodo nuevoNodo = new Nodo(s,null);
        if (isEmpty()) {
            primerNodo = nuevoNodo;
            talla++;
            return true;
        } else {
            Nodo nodoAnterior = null;
            Nodo nodoActual = primerNodo;
            while (nodoActual != null) {
                nodoAnterior = nodoActual;
                nodoActual = nodoActual.siguiente;
            }
            nodoAnterior.siguiente = new Nodo(s,null);
            talla++;
        }
        return true;
    }

    public void add(int i, String s) {
        if (i < 0 || i > talla) {
            throw new IndexOutOfBoundsException();
        } 
        int indice = 0;
        Nodo nodoAnterior = null;
        Nodo nodoActual = primerNodo;
        if (isEmpty()) {
            primerNodo = new Nodo(s,null);
            talla++;
        } else {
            while(nodoActual != null) {
                if (indice == i || nodoActual.siguiente == null) {
                    if (nodoActual == primerNodo) {
                        if (i == 0) {
                            primerNodo = new Nodo(s, primerNodo);
                        } else {
                            primerNodo.siguiente = new Nodo(s, null);
                        }
                    } else if (nodoActual.siguiente == null && talla == i){
                        nodoActual.siguiente = new Nodo(s, null);
                    } else {
                        nodoAnterior.siguiente = new Nodo(s, nodoActual); 
                    }
                    talla++;
                    break;
                }
                indice++;
                nodoAnterior = nodoActual;
                nodoActual = nodoActual.siguiente;
            }
        }
    }

    public void clear() {
        primerNodo.cadena = "";
        primerNodo.siguiente = null;
        talla = 0;
    }

    public String get(int i) {
        if (i < 0 || i >= size()) {
            throw new IndexOutOfBoundsException();
        }
        int indice = 0;
        for (Nodo aux = primerNodo; aux != null; aux = aux.siguiente) {
            if (indice == i) {
                return aux.cadena;
            }
            indice++;
        }
        return "";
    }

    public int indexOf(String s) {
        int indice = 0;
        for (Nodo aux = primerNodo; aux != null; aux = aux.siguiente) {
            if (aux.cadena == s) {
                return indice;
            }
            indice++;
        }
        return -1;
    }

    public int lastIndexOf(String s) {
        int ultimaPosicion = -1;
        int indice = 0;
        for (Nodo aux = primerNodo; aux != null; aux = aux.siguiente) {
            if (aux.cadena == s) {
                ultimaPosicion = indice;
            }
            indice++;
        }
        return ultimaPosicion;
    }

    public boolean isEmpty() {
        if (talla == 0) {
            return true;
        } else {
            return false;
        }
    }

    public String remove(int i) {
        if (i < 0 || i >= size()) {
            throw new IndexOutOfBoundsException();
        }
        String cadenaEliminada = "";
        Nodo nodoAnterior = null;
        Nodo nodoActual = primerNodo;
        int indice = 0;
        while (nodoActual != null) {
            if (indice == i) {
                if (nodoActual == primerNodo) {
                    primerNodo = nodoActual.siguiente;
                    cadenaEliminada = nodoActual.cadena.toString();
                } else if (nodoActual.siguiente == null) {
                    nodoAnterior.siguiente = null;
                    cadenaEliminada = nodoActual.cadena.toString();
                } else {
                    nodoAnterior.siguiente = nodoActual.siguiente;
                    cadenaEliminada = nodoActual.cadena.toString();
                }
                talla--;
                break;
            } 
            nodoAnterior = nodoActual;
            nodoActual = nodoActual.siguiente;
            indice++;
        }
        return cadenaEliminada; 
    }

    public boolean remove(String s) {
        int posicion = this.indexOf(s); 
        if (posicion == -1) {
            return false;
        } else {
            return this.remove(posicion) == s;
        }
    }

    public String set(int i, String s) {
        if (i < 0 || i >= size()) {
            throw new IndexOutOfBoundsException();
        }
        int indice = 0;
        String cadenaCambiada = "";
        for (Nodo aux = primerNodo; aux != null; aux = aux.siguiente) {
            if (indice == i) {
                cadenaCambiada = aux.cadena;
                aux.cadena = s;
            }
            indice++;
        }
        return cadenaCambiada; 
    }

    public String toString() {
        String cadena = "[";
        if (isEmpty()) {
            return "[]";
        }
        if (talla == 1) {
            return "[" + primerNodo.cadena + "]";
        }
        for (Nodo aux = primerNodo; aux != null; aux = aux.siguiente) {
            if (aux.siguiente == null) {
                return cadena + aux.cadena + "]";
            }
            cadena += aux.cadena + ", ";
        }
        return cadena;
    }

    public int size() {
        return talla;
    }
}

