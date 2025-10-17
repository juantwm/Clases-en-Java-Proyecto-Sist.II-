import java.util.ArrayList;
import java.util.List;

public class Recepcionista extends Persona implements IGestionable { 
    private List<Cliente> clientesGestionados; 

    public Recepcionista(String nombreApellido, String dni, String telefono, String email, String estadoCivil, int cantidadHijos) {
        super(nombreApellido, dni, telefono, email, estadoCivil, cantidadHijos);
        this.clientesGestionados = new ArrayList<>(); // Inicializa la lista
    }

    // Métodos de gestión de Clientes por parte del Recepcionista
    public void altaCliente(Cliente nuevoCliente) {
        System.out.println("Recepcionista " + getNombreApellido() + " dando de alta a cliente: " + nuevoCliente.getNombreApellido());
        clientesGestionados.add(nuevoCliente);
        
    }

    public void bajaCliente(Cliente clienteABorrar) {
        System.out.println("Recepcionista " + getNombreApellido() + " dando de baja a cliente: " + clienteABorrar.getNombreApellido());
        clientesGestionados.remove(clienteABorrar);
    }

    public Cliente consultarCliente(String dniCliente) {
        System.out.println("Recepcionista " + getNombreApellido() + " consultando cliente con DNI: " + dniCliente);
        for (Cliente c : clientesGestionados) {
            if (c.getIdentificacion().equals(dniCliente)) {
                return c;
            }
        }
        return null;
    }

    public void modificarCliente(Cliente clienteAModificar, String nuevoTelefono, String nuevoEmail) {
        System.out.println("Recepcionista " + getNombreApellido() + " modificando datos de cliente: " + clienteAModificar.getNombreApellido());
        clienteAModificar.setTelefono(nuevoTelefono);
        clienteAModificar.setEmail(nuevoEmail);
        
    }

    //Recepcionista también puede desencadenar acciones en el Cliente:
    public void solicitarAlertaVencimiento(Cliente cliente) {
        cliente.recibirAlertaVencimientoCuota();
    }

    // Los métodos IGestionable para la Recepcionista misma (ej. un administrador gestiona a las recepcionistas)
    @Override
    public void alta() {
        System.out.println("Recepcionista dada de alta: " + getNombreApellido());
    }

    @Override
    public void baja() {
        System.out.println("Recepcionista dada de baja: " + getNombreApellido());
    }

    @Override
    public void consultar() {
        System.out.println("Consultando recepcionista: " + getNombreApellido() + " - DNI: " + getIdentificacion());
    }

    @Override
    public void modificar() {
        System.out.println("Modificando recepcionista: " + getNombreApellido());
    }
}