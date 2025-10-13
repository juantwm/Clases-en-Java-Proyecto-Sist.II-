import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate; 
import java.time.format.DateTimeParseException; 

public class GestorDePersonal {

    private List<Empleado> plantilla = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    

    private int leerEntero(String mensaje) {
        
        int valor = 0;
        System.out.print(mensaje);
        while (!scanner.hasNextInt()) {
            System.out.println("❌ ERROR: Ingrese un válido.");
            scanner.next(); 
            System.out.print(mensaje);
        }
        valor = scanner.nextInt();
        scanner.nextLine();
        return valor;
    }
    
    private long leerLong(String mensaje) {
        
        long valor = 0;
        System.out.print(mensaje);
        while (!scanner.hasNextLong()) {
            System.out.println("❌ ERROR: Ingrese un número válido.");
            scanner.next(); 
            System.out.print(mensaje);
        }
        valor = scanner.nextLong();
        scanner.nextLine(); 
        return valor;
    }
    
    private String leerString(String mensaje) {
        // ... (Tu implementación de leerString)
        String input = "";
        System.out.print(mensaje);
        input = scanner.nextLine().trim();
        while (input.isEmpty()) {
            System.out.println("❌ ERROR: El campo no puede estar vacío. Intente de nuevo.");
            System.out.print(mensaje);
            input = scanner.nextLine().trim();
        }
        return input;
    }
    
    

    public boolean verificarDniExistente(int dni) {
        
        for (Empleado e : this.plantilla) {
            if (e.getDNI() == dni) {
                return true; // Encontrado
            }
        }
        return false; // No encontrado
    }

    /**
     * Pide la fecha de nacimiento y la convierte a LocalDate.
     */
    private LocalDate leerFechaNacimiento() {
        LocalDate fecha = null;
        String fechaStr;
        
        while (fecha == null) {
            System.out.print("Fecha de Nacimiento (YYYY-MM-DD): ");
            fechaStr = scanner.nextLine().trim();
            
            try {
                // Intenta convertir la cadena a LocalDate
                fecha = LocalDate.parse(fechaStr);
            } catch (DateTimeParseException e) {
                System.out.println("❌ ERROR de formato: Use el formato YYYY-MM-DD (Ej: 1990-10-25).");
            }
        }
        return fecha;
    }


    public void darAltaEmpleado() {
        System.out.println("\n--- ALTA DE EMPLEADO ---");

        String nombreYapellido = leerString("Nombre y apellido: ");

        // 1. Lectura y verificación del DNI
        int DNI;
        do {
            DNI = leerEntero("DNI: ");
            if (verificarDniExistente(DNI)) {
                System.out.println("❌ ERROR: El DNI " + DNI + " ya se encuentra registrado. Vuelva a intentar.");
            }
        } while (verificarDniExistente(DNI));

        
        String direccion = leerString("Dirección: ");
        long telefono = leerLong("Teléfono: ");
        String mail = leerString("Mail: ");
        
        int rol = leerEntero("Rol (1. Recepcionista --- 2. Administrativo): ");
        
        
        LocalDate fechaNacimiento = leerFechaNacimiento();
        
        String estadoCivil = leerString("Estado Civil: ");
        int cantHijos = leerEntero("Cantidad de hijos: ");

        
        Empleado nuevoEmpleado = new Empleado(nombreYapellido, DNI, direccion,telefono,mail,rol,fechaNacimiento,estadoCivil,cantHijos);

        
        this.plantilla.add(nuevoEmpleado);

        System.out.println("\n✅ Empleado '" + nuevoEmpleado.getNombreYapellido() + "' (DNI: " + DNI + ") dado de alta exitosamente.");  
    }


    private Empleado buscarEmpleadoPorDNI(int dni) {
        for (Empleado e : this.plantilla) {
            if (e.getDNI() == dni) {
                return e;
            }
        }
        return null; // Si no lo encuentra
    }

    private boolean verificarListaVacia() {
        if (plantilla.isEmpty()) {
            System.out.println("⚠️ La plantilla está vacía. No hay empleados para realizar esta operación.");
            return true;
        }
        return false;
    }

    public void consultarDatos() {
        System.out.println("\n--- CONSULTA DE DATOS DE EMPLEADO ---");
        
        if (verificarListaVacia()) {
            return;
        }

        int dniBuscado = leerEntero("Ingrese el DNI del empleado a consultar: ");
        Empleado empleado = buscarEmpleadoPorDNI(dniBuscado);

        if (empleado != null) {
            System.out.println("\n✅ Empleado encontrado. Detalle:");
            System.out.println("----------------------------------------");
            System.out.println("Nombre: " + empleado.getNombreYapellido());
            System.out.println("DNI: " + empleado.getDNI());
            System.out.println("Dirección: " + empleado.getDireccion());
            System.out.println("Teléfono: " + empleado.getTelefono());
            System.out.println("Email: " + empleado.getMail());
            System.out.println("Rol: " + empleado.getRol());
            System.out.println("F. Nacimiento: " + empleado.getFechaNacimiento());
            System.out.println("Estado Civil: " + empleado.getEstadoCivil());
            System.out.println("Hijos: " + empleado.getCantHijos());
            System.out.println("F. Ingreso: " + empleado.getFechaIngreso().toLocalDate());
            System.out.println("Estado Laboral: " + (empleado.isEstadoLaboral() ? "ACTIVO" : "INACTIVO"));
            System.out.println("----------------------------------------");
        } else {
            System.out.println("❌ ERROR: No se encontró ningún empleado con DNI: " + dniBuscado);
        }
    }

    //DAR DE BAJA EMPLEADO (Cambio de estado)

        public void cambiarEstadoDeEmpleado() {
            System.out.println("\n--- CAMBIAR ESTADO LABORAL DE EMPLEADO ---");

            // 1. Control de lista vacía 
            if (verificarListaVacia()) {
                return;
            }

            Empleado empleado = null;
            int dniBuscado = 0;
            
            // 2. Bucle WHILE para solicitar DNI hasta que se encuentre un empleado.
            // Esto garantiza que el proceso no avance hasta que se ingrese un DNI existente.
            while (empleado == null) {
                dniBuscado = leerEntero("Ingrese el DNI del empleado cuyo estado desea cambiar: ");
                empleado = buscarEmpleadoPorDNI(dniBuscado);
                
                // Si el empleado es null (no se encontró), el bucle continúa.
                if (empleado == null) {
                    System.out.println("❌ ERROR: El DNI " + dniBuscado + " no se encuentra registrado. Vuelva a intentar.");
                }
            }

            //El empleado ya está garantizado de existir

            System.out.println("\nEmpleado seleccionado: " + empleado.getNombreYapellido() + " (Estado actual: " + (empleado.isEstadoLaboral() ? "ACTIVO" : "INACTIVO") + ")");
            
            System.out.println("Seleccione el nuevo estado:");
            System.out.println("1. ACTIVO (Contratar/Reactivar)");
            System.out.println("2. INACTIVO (Dar de Baja)");
            
            int opcionEstado;
            boolean estadoDeseado = false;
            boolean opcionValida = false;

            // Bucle para asegurar que la opción sea 1 o 2
            while (!opcionValida) {
                opcionEstado = leerEntero("Opción: ");
                
                if (opcionEstado == 1) {
                    estadoDeseado = true;
                    opcionValida = true;
                } else if (opcionEstado == 2) {
                    estadoDeseado = false;
                    opcionValida = true;
                } else {
                    System.out.println("❌ Opción no válida. Ingrese 1 (ACTIVO) o 2 (INACTIVO).");
                }
            }
            
            // Aplicar el cambio de estado
            if (empleado.isEstadoLaboral() == estadoDeseado) {
                System.out.println("⚠️ El empleado ya se encuentra en el estado deseado (" + (estadoDeseado ? "ACTIVO" : "INACTIVO") + "). No se realizó ningún cambio.");
            } else {
                empleado.setEstadoLaboral(estadoDeseado);
                System.out.println("\n✅ El estado de " + empleado.getNombreYapellido() + " ha sido cambiado a " + (estadoDeseado ? "ACTIVO" : "INACTIVO") + ".");
            }
    }
    //MODIFICAR EMPLEADO (Menú de Opciones)

    public void modificarEmpleado() {
        System.out.println("\n--- MODIFICAR DATOS DE EMPLEADO ---");

        if (verificarListaVacia()) {
            return;
        }

        int dniBuscado = leerEntero("Ingrese el DNI del empleado a modificar: ");
        Empleado empleado = buscarEmpleadoPorDNI(dniBuscado);

        if (empleado == null) {
            System.out.println("❌ ERROR: No se encontró ningún empleado con DNI: " + dniBuscado);
            return;
        }

        System.out.println("\n✅ Empleado encontrado: " + empleado.getNombreYapellido());
        int opcion;

        do {
            System.out.println("\n--- MENU DE MODIFICACIONES ---");
            System.out.println("Empleado a modificar: " + empleado.getNombreYapellido() + " (DNI: " + empleado.getDNI() + ")");
            System.out.println("1. Nombre y Apellido (Actual: " + empleado.getNombreYapellido() + ")");
            System.out.println("2. DNI (Actual: " + empleado.getDNI() + ")");
            System.out.println("3. Dirección (Actual: " + empleado.getDireccion() + ")");
            System.out.println("4. Teléfono (Actual: " + empleado.getTelefono() + ")");
            System.out.println("5. Email (Actual: " + empleado.getMail() + ")");
            System.out.println("6. Rol (Actual: " + empleado.getRol() + ")");
            System.out.println("7. Estado Civil (Actual: " + empleado.getEstadoCivil() + ")");
            System.out.println("8. Cantidad de Hijos (Actual: " + empleado.getCantHijos() + ")");
            System.out.println("0. Finalizar Modificación");
            System.out.print("Seleccione una opción: ");
            
            opcion = leerEntero(""); // Uso leerEntero para obtener la opción

            switch (opcion) {
                case 1: 
                    empleado.setNombreYapellido(leerString("Nuevo Nombre y Apellido: "));
                    break;
                case 2:
                    int nuevoDNI;
                    do {
                        nuevoDNI = leerEntero("Nuevo DNI: ");
                        // El DNI debe ser diferente al actual y no debe existir en otro empleado
                        if (nuevoDNI != empleado.getDNI() && verificarDniExistente(nuevoDNI)) {
                            System.out.println("❌ ERROR: El nuevo DNI ya está registrado en otro empleado.");
                        } else {
                            empleado.setDNI(nuevoDNI);
                            System.out.println("DNI modificado a: " + nuevoDNI);
                            break;
                        }
                    } while (true);
                    break;
                case 3: 
                    empleado.setDireccion(leerString("Nueva Dirección: "));
                    break;
                case 4: 
                    empleado.setTelefono(leerLong("Nuevo Teléfono: "));
                    break;
                case 5: 
                    empleado.setMail(leerString("Nuevo Email: "));
                    break;
                case 6: 
                    empleado.setRol(leerEntero("Nuevo Rol: "));
                    break;
                case 7: 
                    empleado.setEstadoCivil(leerString("Nuevo Estado Civil: "));
                    break;
                case 8: 
                    empleado.setCantHijos(leerEntero("Nueva Cantidad de Hijos: "));
                    break;
                case 0:
                    System.out.println("Modificación finalizada. Datos guardados.");
                    break;
                default:
                    System.out.println("❌ Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 0);
    }
}