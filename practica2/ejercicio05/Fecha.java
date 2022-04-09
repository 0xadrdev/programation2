package practica2.ejercicio05; 

import java.util.Calendar;
import java.util.Locale;


public class Fecha {
    private int día;
    private int mes;
    private int año;

    public Fecha(int día, int mes, int año) throws ExcepcionFechaInvalida {
        if (día < 0 || día > 31 || mes < 0 || mes > 12 || año < 0 ) {
            throw new ExcepcionFechaInvalida();
        }
        
        this.día = día;
        this.mes = mes;
        this.año = año; 
    }

    public Fecha(Fecha otraFecha) {
        this.día = otraFecha.día;
        this.mes = otraFecha.mes;
        this.año = otraFecha.año;
        // otraFecha = this;
        // Fecha fecha = new Fecha(this.año, this.mes, this.mes);
        // Fecha fecha = otraFecha;
    }

    public String toString() {
        return String.format(Locale.US, "%d", this.getDía()) + "/" + String.format(Locale.US, "%d", this.getMes()) + "/" + String.format(Locale.US, "%d", this.getAño());
    }

    public boolean equals(Fecha otraFecha) {
        if (this.día == otraFecha.día && this.mes == otraFecha.mes && this.año == otraFecha.año) {
            return true;
        } else {
            return false;
        }
    }

    public int compareTo(Fecha otraFecha) {
        if (this.año == otraFecha.año && this.mes == otraFecha.mes && this.día == otraFecha.día) {
            return 0;
        } else {
            if (this.año == otraFecha.año) {
                if (this.mes == otraFecha.mes) {
                    if (this.día > otraFecha.día) {
                        return 1;
                    } else {
                        return -1;
                    }
                } else {
                    if (this.mes > otraFecha.mes) {
                        return 1;
                    } else {
                        return -1;
                    }
                }
            } else {
                if (this.año > otraFecha.año) {
                    return 1;
                } else {
                    return -1;
                }
            }

        }

        // if (otraFecha.equals(this)) {
        //     return 0;
        // } else if () {
        //     return -1;
        // }
    }

    public int getDía() {
        return this.día;
    }
    
    public int getMes() {
        return this.mes;
    }

    public int getAño() {
        return this.año;
    }
        
    public static boolean añoBisiesto(int año) {
        if ((año % 4 == 0 && año % 100 != 0) || año % 400 == 0) {
            return true; 
        } else {
            return false;
        }
    }
    public static int díasMes(int mes, int año) {

        if (mes < 0 || mes > 12 || año < 0 ) {
            throw new ExcepcionFechaInvalida();
        }

        int[] meses = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        if (añoBisiesto(año)) {
            meses[2] = 29;
        } else {
            meses[2] = 28;
        }

        return meses[mes];

    }

    public static Fecha hoy() {
        Calendar calendario = Calendar.getInstance();
        
        int día = calendario.get(Calendar.DAY_OF_MONTH);
        int mes = calendario.get(Calendar.MONTH) + 1;
        int año = calendario.get(Calendar.YEAR);
        
        Fecha fecha = new Fecha(día, mes, año);

        return fecha;
    }

    public Fecha díaSiguiente() {
        int día = 0;
        int mes = 0;
        int año = 0;
        // System.out.println(this.mes + " " + this.día);    
        // System.out.println("--------------------------------------------------");    

        if (this.mes == 12 && this.día == 31) {

            día = 1;
            mes = 1;
            año = this.getAño() + 1;

        } else if (díasMes(this.mes, this.año) == this.día){

            día = 1;
            mes = this.getMes() + 1;
            año = this.getAño();    

        } else {

            día = this.getDía() + 1;
            mes = this.getMes();
            año = this.getAño();    

        }
        
        Fecha fecha = new Fecha(día, mes, año);

        return fecha;

        }

}
