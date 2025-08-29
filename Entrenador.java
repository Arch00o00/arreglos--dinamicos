import java.util.ArrayList;

public class Entrenador {
    private String nombre;
    private String especialidad;
    private String telefono;
    private String email;
    private ArrayList<Miembro> alumnosACargo;
    
    public Entrenador(String nombre, String especialidad, String telefono, String email) {
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.telefono = telefono;
        this.email = email;
        this.alumnosACargo = new ArrayList<>();
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public String getEspecialidad() {
        return especialidad;
    }
    
    public String getTelefono() {
        return telefono;
    }
    
    public String getEmail() {
        return email;
    }
    
    public ArrayList<Miembro> getAlumnosACargo() {
        return alumnosACargo;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public void asignarAlumno(Miembro miembro) {
        if (!alumnosACargo.contains(miembro)) {
            alumnosACargo.add(miembro);
        }
    }
    
    public void removerAlumno(Miembro miembro) {
        alumnosACargo.remove(miembro);
    }
    
    public int getCantidadAlumnos() {
        return alumnosACargo.size();
    }
    
    @Override
    public String toString() {
        return "Entrenador{" +
                "nombre='" + nombre + '\'' +
                ", especialidad='" + especialidad + '\'' +
                ", telefono='" + telefono + '\'' +
                ", email='" + email + '\'' +
                ", alumnosACargo=" + alumnosACargo.size() +
                '}';
    }
    
    public String getDetalles() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== DETALLES DEL ENTRENADOR ===\n");
        sb.append("Nombre: ").append(nombre).append("\n");
        sb.append("Especialidad: ").append(especialidad).append("\n");
        sb.append("Teléfono: ").append(telefono).append("\n");
        sb.append("Email: ").append(email).append("\n");
        sb.append("Alumnos a cargo: ").append(alumnosACargo.size()).append("\n");
        
        if (!alumnosACargo.isEmpty()) {
            sb.append("Lista de alumnos:\n");
            for (Miembro alumno : alumnosACargo) {
                sb.append("  - ").append(alumno.getNombre()).append("\n");
            }
        }
        
        return sb.toString();
    }
}
