public interface IPagable {
    void registrarPago();
    void consultarHistorialPagos();
    void modificarEstadoPago();
    void generarAlertaVencimiento();
}