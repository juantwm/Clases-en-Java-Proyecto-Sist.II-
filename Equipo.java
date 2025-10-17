import java.time.LocalDate;

public class Equipo implements IGestionable {
    private String nombre;
    private String categoria;
    private LocalDate fechaIngreso;
    private String modelo;
    private String descripcion;

    public Equipo(String nombre, String categoria, LocalDate fechaIngreso, String modelo, String descripcion) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.fechaIngreso = fechaIngreso;
        this.modelo = modelo;
        this.descripcion = descripcion;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    // Comportamientos de la interfaz IGestionable
    @Override
    public void alta() {
        System.out.println("Equipo dado de alta: " + nombre);
    }

    @Override
    public void baja() {
        System.out.println("Equipo dado de baja: " + nombre);
    }

    @Override
    public void consultar() {
        System.out.println("Consultando equipo: " + nombre + " - Modelo: " + modelo);
    }

    @Override
    public void modificar() {
        System.out.println("Modificando equipo: " + nombre);
    }
}