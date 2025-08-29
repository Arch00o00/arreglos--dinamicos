
import java.util.ArrayList;
import java.util.Scanner;

public class Gimnasio {
    private ArrayList<Miembro> miembros;
    private ArrayList<Entrenador> entrenadores;
    private ArrayList<Rutina> rutinas;
    private String nombre;
  
    public Gimnasio(String nombre) {
        this.nombre = nombre;
        this.miembros = new ArrayList<>();
        this.entrenadores = new ArrayList<>();
        this.rutinas = new ArrayList<>();
    }
    
    public ArrayList<Miembro> getMiembros() {
        return miembros;
    }
    
    public ArrayList<Entrenador> getEntrenadores() {
        return entrenadores;
    }
    
    public ArrayList<Rutina> getRutinas() {
        return rutinas;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public boolean registrarMiembro(String nombre, int edad, String telefono, String email) {
        for (Miembro miembro : miembros) {
            if (miembro.getEmail().equalsIgnoreCase(email)) {
                return false; 
            }
        }
        
        Miembro nuevoMiembro = new Miembro(nombre, edad, telefono, email);
        miembros.add(nuevoMiembro);
        return true;
    }
    
    public Miembro buscarMiembro(String email) {
        for (Miembro miembro : miembros) {
            if (miembro.getEmail().equalsIgnoreCase(email)) {
                return miembro;
            }
        }
        return null;
    }
    
    public boolean registrarEntrenador(String nombre, String especialidad, String telefono, String email) {
        for (Entrenador entrenador : entrenadores) {
            if (entrenador.getEmail().equalsIgnoreCase(email)) {
                return false; 
            }
        }
        
        Entrenador nuevoEntrenador = new Entrenador(nombre, especialidad, telefono, email);
        entrenadores.add(nuevoEntrenador);
        return true;
    }
    
    public Entrenador buscarEntrenador(String email) {
        for (Entrenador entrenador : entrenadores) {
            if (entrenador.getEmail().equalsIgnoreCase(email)) {
                return entrenador;
            }
        }
        return null;
    }
    
    public boolean crearRutina(String nombre, String descripcion, int duracion, String emailEntrenador) {
        for (Rutina rutina : rutinas) {
            if (rutina.getNombre().equalsIgnoreCase(nombre)) {
                return false;
            }
        }
        
        Entrenador entrenador = buscarEntrenador(emailEntrenador);
        if (entrenador == null) {
            return false; 
        }
        
        Rutina nuevaRutina = new Rutina(nombre, descripcion, duracion, entrenador);
        rutinas.add(nuevaRutina);
        return true;
    }
    
    public Rutina buscarRutina(String nombre) {
        for (Rutina rutina : rutinas) {
            if (rutina.getNombre().equalsIgnoreCase(nombre)) {
                return rutina;
            }
        }
        return null;
    }
    
    public boolean asignarRutinaAMiembro(String nombreRutina, String emailMiembro) {
        Rutina rutina = buscarRutina(nombreRutina);
        Miembro miembro = buscarMiembro(emailMiembro);
        
        if (rutina != null && miembro != null && rutina.isActiva()) {
            return rutina.agregarParticipante(miembro);
        }
        return false;
    }
    
    public Rutina getRutinaMasPopular() {
        if (rutinas.isEmpty()) return null;
        
        Rutina masPopular = rutinas.get(0);
        for (Rutina rutina : rutinas) {
            if (rutina.getCantidadParticipantes() > masPopular.getCantidadParticipantes()) {
                masPopular = rutina;
            }
        }
        return masPopular;
    }
    
    public Entrenador getEntrenadorConMasAlumnos() {
        if (entrenadores.isEmpty()) return null;
        
        Entrenador conMasAlumnos = entrenadores.get(0);
        for (Entrenador entrenador : entrenadores) {
            if (entrenador.getCantidadAlumnos() > conMasAlumnos.getCantidadAlumnos()) {
                conMasAlumnos = entrenador;
            }
        }
        return conMasAlumnos;
    }
    
    public ArrayList<Rutina> getRutinasActivas() {
        ArrayList<Rutina> rutinasActivas = new ArrayList<>();
        for (Rutina rutina : rutinas) {
            if (rutina.isActiva()) {
                rutinasActivas.add(rutina);
            }
        }
        return rutinasActivas;
    }
    
    public String getEstadisticasGenerales() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== ESTADÍSTICAS GENERALES DEL GIMNASIO ===\n");
        sb.append("Nombre del Gimnasio: ").append(nombre).append("\n");
        sb.append("Total de Miembros: ").append(miembros.size()).append("\n");
        sb.append("Total de Entrenadores: ").append(entrenadores.size()).append("\n");
        sb.append("Total de Rutinas: ").append(rutinas.size()).append("\n");
        sb.append("Rutinas Activas: ").append(getRutinasActivas().size()).append("\n");
        
        if (!rutinas.isEmpty()) {
            Rutina masPopular = getRutinaMasPopular();
            sb.append("Rutina más popular: ").append(masPopular.getNombre())
              .append(" (").append(masPopular.getCantidadParticipantes()).append(" participantes)\n");
        }
        
        if (!entrenadores.isEmpty()) {
            Entrenador conMasAlumnos = getEntrenadorConMasAlumnos();
            sb.append("Entrenador con más alumnos: ").append(conMasAlumnos.getNombre())
              .append(" (").append(conMasAlumnos.getCantidadAlumnos()).append(" alumnos)\n");
        }
        
        return sb.toString();
    }
    
    public void listarMiembros() {
        if (miembros.isEmpty()) {
            System.out.println("No hay miembros registrados.");
            return;
        }
        
        System.out.println("=== LISTA DE MIEMBROS ===");
        for (int i = 0; i < miembros.size(); i++) {
            System.out.println((i + 1) + ". " + miembros.get(i).toString());
        }
    }
    
    public void listarEntrenadores() {
        if (entrenadores.isEmpty()) {
            System.out.println("No hay entrenadores registrados.");
            return;
        }
        
        System.out.println("=== LISTA DE ENTRENADORES ===");
        for (int i = 0; i < entrenadores.size(); i++) {
            System.out.println((i + 1) + ". " + entrenadores.get(i).toString());
        }
    }
    
    public void listarRutinas() {
        if (rutinas.isEmpty()) {
            System.out.println("No hay rutinas creadas.");
            return;
        }
        
        System.out.println("=== LISTA DE RUTINAS ===");
        for (int i = 0; i < rutinas.size(); i++) {
            System.out.println((i + 1) + ". " + rutinas.get(i).toString());
        }
    }
}
