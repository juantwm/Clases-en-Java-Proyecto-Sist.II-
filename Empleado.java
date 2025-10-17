public class Empleado extends Persona implements IGestionable {
    private String rol;
    private boolean estadoLaboral;
    private String numeroLegajo; // Atributo agregado como solicitaste.

    public Empleado(String nombreApellido, String dni, String telefono, String email, String estadoCivil, int cantidadHijos, String rol, boolean estadoLaboral, String numeroLegajo) {
        super(nombreApellido, dni, telefono, email, estadoCivil, cantidadHijos);
        this.rol = rol;
        this.estadoLaboral = estadoLaboral;
        this.numeroLegajo = numeroLegajo;
    }

    // Getters y Setters específicos de Empleado
    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public boolean getEstadoLaboral() {
        return estadoLaboral;
    }

    public void setEstadoLaboral(boolean estadoLaboral) {
        this.estadoLaboral = estadoLaboral;
    }

    public String getNumeroLegajo() {
        return numeroLegajo;
    }

    public void setNumeroLegajo(String numeroLegajo) {
        this.numeroLegajo = numeroLegajo;
    }

    // Comportamientos de la interfaz IGestionable
    @Override
    public void alta() {
        System.out.println("Empleado dado de alta: " + getNombreApellido() + " - Legajo: " + numeroLegajo);
    }

    @Override
    public void baja() {
        System.out.println("Empleado dado de baja: " + getNombreApellido());
    }

    @Override
    public void consultar() {
        System.out.println("Consultando empleado: " + getNombreApellido() + " - Rol: " + rol);
    }

    @Override
    public void modificar() {
        System.out.println("Modificando empleado: " + getNombreApellido());
    }

    // Otros comportamientos específicos de Empleado
    public void registrarAsistencia() {
        System.out.println("Asistencia registrada para el empleado: " + getNombreApellido());
    }
}
