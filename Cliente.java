
public class Cliente extends Persona implements IPagable { 

    public Cliente(String nombreApellido, String dni, String telefono, String email, String estadoCivil, int cantidadHijos) {
        super(nombreApellido, dni, telefono, email, estadoCivil, cantidadHijos);
    }

    // Métodos propios del Cliente (interacción con el sistema)
    public boolean login(String password) {
        System.out.println("Cliente " + getNombreApellido() + " intentando iniciar sesión.");
        
        return true; 
    }

    public void consultarMiHistorialPagos() {
        System.out.println("Cliente " + getNombreApellido() + " consultando su historial de pagos.");
    }

    public void consultarMisRutinas() {
        System.out.println("Cliente " + getNombreApellido() + " consultando sus rutinas de entrenamiento.");
    }

    public void recibirAlertaVencimientoCuota() {
        System.out.println("Cliente " + getNombreApellido() + ": ¡Alerta! Su cuota está por vencer o ya venció.");
    }


    //Por si en algun momento, se decide implementar que el cliente registre los pagos manuales.
    @Override
    public void registrarPago() { /* ... */ }
    @Override
    public void consultarHistorialPagos() { /* ... */ }
    @Override
    public void modificarEstadoPago() { /* ... */ }
    @Override
    public void generarAlertaVencimiento() { /* ... */ }

}