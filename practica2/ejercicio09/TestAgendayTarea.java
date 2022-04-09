package practica2.ejercicio09;
import practica2.ejercicio05.*;

public class TestAgendayTarea {
    public static void main(String[] args){
        Agenda agenda = new Agenda();

        Fecha fecha1 = new Fecha(22,3,2021);
        Fecha fecha2 = new Fecha(12,4,2021);
        Fecha fecha3 = new Fecha(19,4,2021);
        Fecha fecha4 = new Fecha(17,5,2023);
        Fecha fecha5 = new Fecha(17,5,2023);


        Tarea tarea1 = new Tarea(fecha1, "EI1007-C1");
        
        Tarea tarea2 = new Tarea(fecha2, "EI1007-C2");
        
        Tarea tarea3 = new Tarea(fecha3, "EI1007-C3");
        
        Tarea tarea4 = new Tarea(fecha4, "EI1007-C4");

        agenda.añadir(tarea1);
        agenda.añadir(tarea4);
        agenda.añadir(tarea2);
        agenda.añadir(tarea3);

    
        int consultar = agenda.cantidad();
        
        System.out.println(consultar);
        System.out.println(agenda.toString());
    }

}
