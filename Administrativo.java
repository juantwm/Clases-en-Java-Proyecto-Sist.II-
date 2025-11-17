import java.util.ArrayList;
import java.util.List;

public class Administrativo extends Persona implements IGestionable {
    // El administrativo tiene "acceso" a las colecciones de estas entidades para gestionarlas
    private List<Empleado> empleadosGestionados;
    private List<Equipo> equiposGestionados;
    private List<Gasto> gastosGestionados;

    public Administrativo(String nombreApellido, String dni, String telefono, String email, String estadoCivil, int cantidadHijos) {
        super(nombreApellido, dni, telefono, email, estadoCivil, cantidadHijos);
        this.empleadosGestionados = new ArrayList<>();
        this.equiposGestionados = new ArrayList<>();
        this.gastosGestionados = new ArrayList<>();
    }

    // Métodos para gestionar Empleados
    public void altaEmpleado(Empleado nuevoEmpleado) {
        System.out.println("Administrativo " + getNombreApellido() + " dando de alta a empleado: " + nuevoEmpleado.getNombreApellido());
        empleadosGestionados.add(nuevoEmpleado);
        nuevoEmpleado.alta(); // Invoca el comportamiento IGestionable del empleado
    }

    public void bajaEmpleado(Empleado empleadoABorrar) {
        System.out.println("Administrativo " + getNombreApellido() + " dando de baja a empleado: " + empleadoABorrar.getNombreApellido());
        empleadosGestionados.remove(empleadoABorrar);
        empleadoABorrar.baja();
    }

    public void consultarEmpleado(String legajoEmpleado) {
        System.out.println("Administrativo " + getNombreApellido() + " consultando empleado con legajo: " + legajoEmpleado);
        for (Empleado e : empleadosGestionados) {
            if (e.getNumeroLegajo().equals(legajoEmpleado)) {
                e.consultar();
                return;
            }
        }
        System.out.println("Empleado con legajo " + legajoEmpleado + " no encontrado.");
    }

    public void modificarEmpleado(Empleado empleadoAModificar, String nuevoRol) {
        System.out.println("Administrativo " + getNombreApellido() + " modificando rol de empleado: " + empleadoAModificar.getNombreApellido());
        empleadoAModificar.setRol(nuevoRol);
        empleadoAModificar.modificar();
    }

    // Métodos para gestionar Equipos
    public void altaEquipo(Equipo nuevoEquipo) {
        System.out.println("Administrativo " + getNombreApellido() + " dando de alta equipo: " + nuevoEquipo.getNombre());
        equiposGestionados.add(nuevoEquipo);
        nuevoEquipo.alta();
    }

    public void bajaEquipo(Equipo equipoABorrar) {
        System.out.println("Administrativo " + getNombreApellido() + " dando de baja equipo: " + equipoABorrar.getNombre());
        equiposGestionados.remove(equipoABorrar);
        equipoABorrar.baja();
    }

    public void consultarEquipo(String nombreEquipo) {
        System.out.println("Administrativo " + getNombreApellido() + " consultando equipo: " + nombreEquipo);
        for (Equipo e : equiposGestionados) {
            if (e.getNombre().equals(nombreEquipo)) {
                e.consultar();
                return;
            }
        }
        System.out.println("Equipo " + nombreEquipo + " no encontrado.");
    }

    public void modificarEquipo(Equipo equipoAModificar, String nuevaDescripcion) {
        System.out.println("Administrativo " + getNombreApellido() + " modificando descripción de equipo: " + equipoAModificar.getNombre());
        equipoAModificar.setDescripcion(nuevaDescripcion);
        equipoAModificar.modificar();
    }

    // Métodos para gestionar Gastos
    public void altaGasto(Gasto nuevoGasto) {
        System.out.println("Administrativo " + getNombreApellido() + " registrando gasto: " + nuevoGasto.getConcepto());
        gastosGestionados.add(nuevoGasto);
        nuevoGasto.alta();
    }

    public void bajaGasto(Gasto gastoABorrar) {
        System.out.println("Administrativo " + getNombreApellido() + " dando de baja gasto: " + gastoABorrar.getConcepto());
        gastosGestionados.remove(gastoABorrar);
        gastoABorrar.baja();
    }

    public void consultarGasto(String conceptoGasto) {
        System.out.println("Administrativo " + getNombreApellido() + " consultando gasto con concepto: " + conceptoGasto);
        for (Gasto g : gastosGestionados) {
            if (g.getConcepto().equals(conceptoGasto)) {
                g.consultar();
                return;
            }
        }
        System.out.println("Gasto con concepto " + conceptoGasto + " no encontrado.");
    }

    public void modificarGasto(Gasto gastoAModificar, double nuevoMonto) {
        System.out.println("Administrativo " + getNombreApellido() + " modificando monto de gasto: " + gastoAModificar.getConcepto());
        gastoAModificar.setMonto(nuevoMonto);
        gastoAModificar.modificar();
    }


    // Implementación de IGestionable para el Administrativo mismo
    @Override
    public void alta() {
        System.out.println("Administrativo dado de alta: " + getNombreApellido());
    }

    @Override
    public void baja() {
        System.out.println("Administrativo dado de baja: " + getNombreApellido());
    }

    @Override
    public void consultar() {
        System.out.println("Consultando administrativo: " + getNombreApellido() + " - DNI: " + getIdentificacion());
    }

    @Override
    public void modificar() {
        System.out.println("Modificando administrativo: " + getNombreApellido());
    }
}