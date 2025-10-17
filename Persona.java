public abstract class Persona implements IEntidadConID, IInformacionContacto {
    private String nombreApellido;
    private String dni;
    private String telefono;
    private String email;
    private String estadoCivil;
    private int cantidadHijos;

    public Persona(String nombreApellido, String dni, String telefono, String email, String estadoCivil, int cantidadHijos) {
        this.nombreApellido = nombreApellido;
        this.dni = dni;
        this.telefono = telefono;
        this.email = email;
        this.estadoCivil = estadoCivil;
        this.cantidadHijos = cantidadHijos;
    }

    // Getters y Setters
    public String getNombreApellido() {
        return nombreApellido;
    }

    public void setNombreApellido(String nombreApellido) {
        this.nombreApellido = nombreApellido;
    }

    @Override
    public String getIdentificacion() {
        return dni;
    }

    @Override
    public void setIdentificacion(String dni) {
        this.dni = dni;
    }

    @Override
    public String getTelefono() {
        return telefono;
    }

    @Override
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public int getCantidadHijos() {
        return cantidadHijos;
    }

    public void setCantidadHijos(int cantidadHijos) {
        this.cantidadHijos = cantidadHijos;
    }

}