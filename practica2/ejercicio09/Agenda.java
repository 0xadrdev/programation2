package practica2.ejercicio09;
import practica2.ejercicio05.*;

public class Agenda {
    private Tarea[] tareas;

    public Agenda() {
        this.tareas = new Tarea[0];
    }

    private int posicionInserción(Tarea tarea) {
        if (this.tareas.length == 0) {
            return 0;
        } else {
            if (tarea.getFecha().compareTo(this.tareas[0].getFecha()) > 0){
                return -1;
            } else { 
                return 1;
            }
        }
    }

    public void añadir(Tarea tarea) {
        int posicion = this.posicionInserción(tarea);
        Tarea[] tareas = new Tarea[this.tareas.length + 1];
        if (posicion == 1) {
            tareas[0] = tarea;

            for (int i = 1; i < tareas.length;) {
                tareas[i] = this.tareas[i - 1];
            }

        } else {
            tareas[this.tareas.length] = tarea;

            for (int i = 0; i < tareas.length - 1; i++) {
                tareas[i] = this.tareas[i];
            }

        }

        this.tareas = tareas;
    }

    public int cantidad() {
        return this.tareas.length;
    }

    public Tarea[] consultar(Fecha fecha) {
        int numeroDeFechas = 0;
        for (int i = 0; i < this.tareas.length; i++) {
            if (this.tareas[i].getFecha().compareTo(fecha) == 0) {
                numeroDeFechas++;
            }
        }
        
        if (numeroDeFechas == 0) {
            return tareas;
        } else{
            Tarea[] tareas = new Tarea[numeroDeFechas];
            for (int i=0, j = 0; i < this.tareas.length; i++) {
                if (this.tareas[i].getFecha().compareTo(fecha) == 0) {
                    tareas[j++] = this.tareas[i];
                }
            } 
            return tareas;
        }
    
    }

    public void borrarPasadas(Fecha fecha) {
        int fechasEliminadas = 0;
        for (int i = 0; i < this.tareas.length; i++) {
            if (this.tareas[i].getFecha().compareTo(fecha) < 0) {
                fechasEliminadas++;
            }
        }
        Tarea[] tareas = new Tarea[fechasEliminadas];
        
        for (int i = 0, j = 0; i < this.tareas.length; i++) {

            if (this.tareas[i].getFecha().compareTo(fecha) < 0) {
                tareas[j++] = this.tareas[i];
            }
        }
    }

    public void borrar() {
        Fecha fechaHoy = new Fecha(8,04,2021);
        borrarPasadas(fechaHoy);
    }

    public String toString() {
        String cadena = "";

        for (int i = 0; i < this.tareas.length; i++) {
            cadena += this.tareas[i].toString() + "\n";
        }
        return cadena;
    }
}
