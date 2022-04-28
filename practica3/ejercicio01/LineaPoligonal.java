package practica3.ejercicio01;

import java.util.LinkedList;
import practica2.ejercicio01.*;

public class LineaPoligonal {
    private LinkedList<Punto> linea;
    private int puntosValidos; 

    public LineaPoligonal() {
        this.linea = new LinkedList<Punto>();
        this.puntosValidos = 0; 
    }

    public void añadir(Punto punto) {
        if (this.puntosValidos == this.linea.size()) {
            LinkedList<Punto> nuevaLinea = new LinkedList<Punto>();

            for (int i = 0; i < this.puntosValidos; i++) {
                nuevaLinea.add(i, this.linea.get(i));
            }

            nuevaLinea.add(this.linea.size(), punto); 

            this.linea = nuevaLinea; 
            this.puntosValidos++;
        } else {
            this.linea.add(puntosValidos, punto); 
            this.puntosValidos++;
        }
    }

    public void quitar(int pos) {
        if (pos >= 0 && pos < this.puntosValidos) {
            for (int i = pos; i < this.linea.size() - 1; i++) {
                this.linea.set(i, this.linea.get(i+1));
            }
            this.puntosValidos--;
        }
    }

    public void quitar(Punto punto) {
        for (int i = 0; i < this.puntosValidos; i++) {
            if (this.linea.get(i).equals(punto)) {
                this.quitar(i);
                break;
            }
        }
    }

    public void trasladar(double desplazamientoX, double desplazamientoY) {

        for (int i = 0; i < this.puntosValidos; i++) {
            this.linea.set(i, this.linea.get(i).desplazar(desplazamientoX, desplazamientoY));
        }
        

    }

    public double longitud() {
        if (this.puntosValidos == 0 || this.puntosValidos == 1) {
            return 0;
        } 

        double longitud = 0;

        for (int i = 0; i < this.puntosValidos - 1; i++) {
            longitud += this.linea.get(i).distancia(this.linea.get(i+1));
        }
        return longitud;
    }

    public String toString() {
        String cadena = "";

        if (this.puntosValidos == 1) {
            return this.linea.get(0).toString();
        }

        for (int i = 0; i < this.puntosValidos - 1; i++) {
            cadena += this.linea.get(i).toString() + "--";
        }
        if (cadena != "") {
            cadena += this.linea.get(this.puntosValidos - 1).toString();
        } 

        return cadena;
    } 

    public boolean equals(Object otroObjeto) {
        if (this == otroObjeto){
            return true;
        }
        if (!(otroObjeto instanceof LineaPoligonal)) {
            return false;
        } else {
            LineaPoligonal otraLinea = (LineaPoligonal) otroObjeto;
            for (int i = 0; i < this.puntosValidos; i++) {
                if (this.linea.get(i).equals(otraLinea.linea.get(i)) == false) {
                    return false;
                }
            }
            return true;
        }
    }
}
