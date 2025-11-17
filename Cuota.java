import java.time.LocalDate;

public class Cuota implements IPagable {
    private String idPago;
    private LocalDate fechaPago;
    private LocalDate fechaVencimiento;
    private double monto;
    private String medioPago;
    private String estado; // Pendiente, Pagado, Vencido, etc.

    public Cuota(String idPago, LocalDate fechaPago, LocalDate fechaVencimiento, double monto, String medioPago, String estado) {
        this.idPago = idPago;
        this.fechaPago = fechaPago;
        this.fechaVencimiento = fechaVencimiento;
        this.monto = monto;
        this.medioPago = medioPago;
        this.estado = estado;
    }

    // Getters y Setters
    public String getIdPago() {
        return idPago;
    }

    public void setIdPago(String idPago) {
        this.idPago = idPago;
    }

    public LocalDate getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(LocalDate fechaPago) {
        this.fechaPago = fechaPago;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getMedioPago() {
        return medioPago;
    }

    public void setMedioPago(String medioPago) {
        this.medioPago = medioPago;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    // Comportamientos de la interfaz IPagable
    @Override
    public void registrarPago() {
        System.out.println("Registrando pago ID: " + idPago);
        this.estado = "Pagado"; // Ejemplo de cambio de estado
    }

    @Override
    public void consultarHistorialPagos() {
        System.out.println("Consultando historial de pago ID: " + idPago);
    }

    @Override
    public void modificarEstadoPago() {
        System.out.println("Modificando estado de pago ID: " + idPago);
    }

    @Override
    public void generarAlertaVencimiento() {
        System.out.println("Generando alerta de vencimiento para pago ID: " + idPago);
    }
}