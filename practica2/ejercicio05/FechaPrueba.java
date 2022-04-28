package practica2.ejercicio05;

public class FechaPrueba {
    public static void main(String[] args) {
		Fecha hombreEnLaLuna = new Fecha(1, 1, 1901);
        System.out.println(hombreEnLaLuna.toString());
        System.out.println(hombreEnLaLuna.díaSiguiente().toString());
        System.out.println(hombreEnLaLuna.toString());
        // testDíaSiguienteAño(1901);
		testDíaSiguienteAño(1901);
		testDíaSiguienteAño(2000);

	

    }
    private static void testDíaSiguienteAño(int año) {
		for (int mes = 1 ; mes <= 12 ; mes++ ) {
			int ndías = Fecha.díasMes(mes, año);	
            // System.out.println("MES --> " + mes);
			for (int día = 1 ; día <= ndías ; día++) {
                Fecha fecha = new Fecha(día, mes, año);
				Fecha siguiente = fecha.díaSiguiente();
				Fecha fecha2 = new Fecha(fecha);
                // System.out.println("ESTADO -->" + fecha.equals(fecha2));
                // System.out.println(fecha == fecha2);

                // if (fecha.getMes() == 1) {
                //     System.out.println("FECHA ACTUAL --> " + fecha.toString());
                //     System.out.println("FECHA SIGUIENTE  --> " + siguiente.toString()); 
                //     System.out.println("FECHA ACTUAL --> " + fecha.toString());
                //     System.out.println("----------------------------------------------");
                // } 


                if (fecha2.equals(fecha) == false) {
                    System.out.println("FECHA ACTUAL --> " + fecha.toString());
                    System.out.println("FECHA SIGUIENTE  --> " + siguiente.toString()); 
                    System.out.println("FECHA ACTUAL --> " + fecha.toString());
                    System.out.println("----------------------------------------------");
                }

			// 	} else if (mes < 12) {

 

			// }
            }
		}
	}
    
}
