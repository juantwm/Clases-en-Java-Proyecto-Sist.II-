import java.time.LocalDate;

public class Gasto implements IGestionable {
    private LocalDate fecha;
    private String concepto;
    private double monto;
    private String categoria;
    private String observaciones;

    public Gasto(LocalDate fecha, String concepto, double monto, String categoria, String observaciones) {
        this.fecha = fecha;
        this.concepto = concepto;
        this.monto = monto;
        this.categoria = categoria;
        this.observaciones = observaciones;
    }

    // Getters y Setters
    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    // Comportamientos de la interfaz IGestionable
    @Override
    public void alta() {
        System.out.println("Gasto dado de alta: " + concepto);
    }

    @Override
    public void baja() {
        System.out.println("Gasto dado de baja: " + concepto);
    }

    @Override
    public void consultar() {
        System.out.println("Consultando gasto: " + concepto + " - Monto: " + monto);
    }

    @Override
    public void modificar() {
        System.out.println("Modificando gasto: " + concepto);
    }
}
