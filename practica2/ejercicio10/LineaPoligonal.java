package practica2.ejercicio10;
import practica2.ejercicio01.*;

public class LineaPoligonal {

    private Punto[] linea;
    private int puntosValidos; 

    public LineaPoligonal() {
        this.linea = new Punto[10];
        this.puntosValidos = 0; 
    }

    public void añadir(Punto punto) {
        if (this.puntosValidos == this.linea.length) {
            Punto[] nuevaLinea = new Punto[this.linea.length * 2];
            for (int i = 0; i < this.linea.length; i++) {
                nuevaLinea[i] = this.linea[i];
            }
            nuevaLinea[this.linea.length] = punto; 
            this.linea = nuevaLinea; 
            this.puntosValidos++;
        } else {
            this.linea[puntosValidos] = punto; 
            this.puntosValidos++;
        }
    }

    public void quitar(int pos) {
        if (pos >= 0 && pos < this.puntosValidos) {
            for (int i = pos; i < this.linea.length - 1; i++) {
                this.linea[i] = this.linea[i+1];
            }
            this.puntosValidos--;
        }
    }

    public void quitar(Punto punto) {
        for (int i = 0; i < this.puntosValidos; i++) {
            if (this.linea[i].equals(punto)) {
                this.quitar(i);
                break;
            }
        }
    }

    public void trasladar(double desplazamientoX, double desplazamientoY) {

        for (int i = 0; i < puntosValidos; i++) {
            linea[i] = linea[i].desplazar(desplazamientoX, desplazamientoY);
        }
        

    }

    public double longitud() {
        if (this.puntosValidos == 0 || this.puntosValidos == 1) {
            return 0;
        } 

        double longitud = 0;

        for (int i = 0; i < this.puntosValidos - 1; i++) {
            longitud += this.linea[i].distancia(this.linea[i+1]);
        }
        return longitud;
    }

    public String toString() {
        String cadena = "";

        if (this.puntosValidos == 1) {
            return this.linea[0].toString();
        }

        for (int i = 0; i < this.puntosValidos - 1; i++) {
            cadena += this.linea[i].toString() + "--";
        }
        if (cadena != "") {
            cadena += this.linea[this.puntosValidos - 1].toString();
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
                if (this.linea[i].equals(otraLinea.linea[i]) == false) {
                    return false;
                }
            }
            return true;
        }
    }
}

