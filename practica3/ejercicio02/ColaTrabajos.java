package practica3.ejercicio02;

public interface ColaTrabajos {
    void insertar(TrabajoImpresora t);
    TrabajoImpresora extraerPrimero();
    TrabajoImpresora consultarPrimero();
    int getTalla();
    boolean esVacía();
    void cancelar(String idUsuario);
    void adelantar(int idTrabajo);
}
