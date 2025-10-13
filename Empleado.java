import java.time.LocalDate;
import java.time.LocalDateTime;


public class Empleado {

    private String nombreYapellido;
    private int DNI;
    private String direccion;
    private long telefono;
    private String mail;
    private  final LocalDateTime fechaIngreso;
    private int rol;
    private boolean estadoLaboral;
    private LocalDate fechaNacimiento; 
    private String estadoCivil;
    private int cantHijos;


    public Empleado(String nombreYapellido, int DNI, String direccion, long telefono, String mail, int rol, LocalDate fechaNacimiento, String estadoCivil, int cantHijos)
    {
        this.nombreYapellido = nombreYapellido;
        this.DNI = DNI;
        this.direccion = direccion;
        this.telefono = telefono;
        this.mail = mail;
        this.fechaIngreso = LocalDateTime.now();
        this.rol = rol;
        this.estadoLaboral = true;
        this.fechaNacimiento = fechaNacimiento;
        this.estadoCivil = estadoCivil;
        this.cantHijos = cantHijos;
    }


    public LocalDateTime getFechaIngreso()
    {
        return fechaIngreso;
    }

    public String getNombreYapellido()
    {
        return nombreYapellido;
    }

    public void setNombreYapellido(String nombreYapellido)
    {
        this.nombreYapellido = nombreYapellido;
    }

    public int getDNI() {
        return DNI;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
    }

    // Direccion
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    // Telefono
    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    // Mail
    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
    
    // Rol
    public int getRol() {
        return rol;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }

    public boolean isEstadoLaboral() {
        return estadoLaboral;
    }

    // Setter de EstadoLaboral
    public void setEstadoLaboral(boolean estadoLaboral) {
        this.estadoLaboral = estadoLaboral;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil)
    {
        this.estadoCivil = estadoCivil;
    }
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento)
    {
        this.fechaNacimiento = fechaNacimiento;
    }
    public long getCantHijos() {
        return cantHijos;
    }

    public void setCantHijos(int cantHijos)
    {
        this.cantHijos = cantHijos;
    }

}
/* System.out.println("\n--- ALTA DE EMPLEADO ---");

        System.out.println("Nombre y apellido: ");
        String nombreYapellido = scanner.nextLine();

            while(!scanner.hasNextLine())
            {
                System.out.println("ERROR. Ingreso un numero. \n");
                scanner.next();
            }
                nombreYapellido = scanner.nextLine();

            while(nombreYapellido.length()<0)
            {
                System.out.println("ERROR. Debe ingresar un nombre valido. Vuelva a intentarlo");
                nombreYapellido = scanner.nextLine();
            }
            scanner.nextLine();*/