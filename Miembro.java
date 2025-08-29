
import java.util.ArrayList;

public class Miembro {
    private String nombre;
    private int edad;
    private String telefono;
    private String email;
    private ArrayList<Rutina> rutinasAsignadas;
    
    public Miembro(String nombre, int edad, String telefono, String email) {
        this.nombre = nombre;
        this.edad = edad;
        this.telefono = telefono;
        this.email = email;
        this.rutinasAsignadas = new ArrayList<>();
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public int getEdad() {
        return edad;
    }
    
    public String getTelefono() {
        return telefono;
    }
    
    public String getEmail() {
        return email;
    }
    
    public ArrayList<Rutina> getRutinasAsignadas() {
        return rutinasAsignadas;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public void asignarRutina(Rutina rutina) {
        if (!rutinasAsignadas.contains(rutina)) {
            rutinasAsignadas.add(rutina);
        }
    }
    
    public void removerRutina(Rutina rutina) {
        rutinasAsignadas.remove(rutina);
    }
    
    public int getCantidadRutinas() {
        return rutinasAsignadas.size();
    }
    
    @Override
    public String toString() {
        return "Miembro{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", telefono='" + telefono + '\'' +
                ", email='" + email + '\'' +
                ", rutinasAsignadas=" + rutinasAsignadas.size() +
                '}';
    }
    
    public String getDetalles() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== DETALLES DEL MIEMBRO ===\n");
        sb.append("Nombre: ").append(nombre).append("\n");
        sb.append("Edad: ").append(edad).append(" años\n");
        sb.append("Teléfono: ").append(telefono).append("\n");
        sb.append("Email: ").append(email).append("\n");
        sb.append("Rutinas asignadas: ").append(rutinasAsignadas.size()).append("\n");
        
        if (!rutinasAsignadas.isEmpty()) {
            sb.append("Lista de rutinas:\n");
            for (Rutina rutina : rutinasAsignadas) {
                sb.append("  - ").append(rutina.getNombre()).append("\n");
            }
        }
        
        return sb.toString();
    }
}
