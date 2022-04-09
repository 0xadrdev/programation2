package practica2.ejercicio09;
import practica2.ejercicio05.Fecha;
import java.util.Locale;
import java.util.Calendar;

public class Tarea {

    private Fecha fecha; 
    private String descripcion;

    public Tarea(Fecha fecha, String descripcion) {
        this.fecha = fecha;
        this.descripcion = descripcion;
    }

    public Fecha getFecha() {
        return this.fecha;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public String toString() {
        return String.format(Locale.US, "%s", this.getFecha()) + ": " + String.format(Locale.US, "%s", this.getDescripcion());
    }
    
}
