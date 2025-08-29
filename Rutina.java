
import java.util.ArrayList;

public class Rutina {
    private String nombre;
    private String descripcion;
    private int duracion; 
    private Entrenador entrenadorAsignado;
    private ArrayList<Miembro> participantes;
    private boolean activa;
   
    public Rutina(String nombre, String descripcion, int duracion, Entrenador entrenadorAsignado) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.duracion = duracion;
        this.entrenadorAsignado = entrenadorAsignado;
        this.participantes = new ArrayList<>();
        this.activa = true;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
    
    public int getDuracion() {
        return duracion;
    }
    
    public Entrenador getEntrenadorAsignado() {
        return entrenadorAsignado;
    }
    
    public ArrayList<Miembro> getParticipantes() {
        return participantes;
    }
    
    public boolean isActiva() {
        return activa;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }
    
    public void setEntrenadorAsignado(Entrenador entrenadorAsignado) {
        this.entrenadorAsignado = entrenadorAsignado;
    }
    
    public void setActiva(boolean activa) {
        this.activa = activa;
    }
    public boolean agregarParticipante(Miembro miembro) {
        if (!participantes.contains(miembro)) {
            participantes.add(miembro);
            miembro.asignarRutina(this);
            if (entrenadorAsignado != null) {
                entrenadorAsignado.asignarAlumno(miembro);
            }
            return true;
        }
        return false;
    }
    
    public boolean removerParticipante(Miembro miembro) {
        if (participantes.remove(miembro)) {
            miembro.removerRutina(this);
            return true;
        }
        return false;
    }
    
    public int getCantidadParticipantes() {
        return participantes.size();
    }
    
    @Override
    public String toString() {
        return "Rutina{" +
                "nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", duracion=" + duracion + " min" +
                ", entrenador=" + (entrenadorAsignado != null ? entrenadorAsignado.getNombre() : "Sin asignar") +
                ", participantes=" + participantes.size() +
                ", activa=" + activa +
                '}';
    }
    
    public String getDetalles() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== DETALLES DE LA RUTINA ===\n");
        sb.append("Nombre: ").append(nombre).append("\n");
        sb.append("Descripción: ").append(descripcion).append("\n");
        sb.append("Duración: ").append(duracion).append(" minutos\n");
        sb.append("Entrenador: ").append(entrenadorAsignado != null ? entrenadorAsignado.getNombre() : "Sin asignar").append("\n");
        sb.append("Estado: ").append(activa ? "Activa" : "Inactiva").append("\n");
        sb.append("Participantes: ").append(participantes.size()).append("\n");
        
        if (!participantes.isEmpty()) {
            sb.append("Lista de participantes:\n");
            for (Miembro participante : participantes) {
                sb.append("  - ").append(participante.getNombre()).append("\n");
            }
        }
        
        return sb.toString();
    }
}
