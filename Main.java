
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    private static Gimnasio gimnasio;
    private static Scanner scanner;
    
    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        gimnasio = new Gimnasio("FitLife Gym");
        
        cargarDatosDePrueba();
        
        System.out.println("=================================================");
        System.out.println("    BIENVENIDO AL SISTEMA DE GESTIÓN DE GIMNASIO");
        System.out.println("                  " + gimnasio.getNombre());
        System.out.println("=================================================");
        
        boolean continuar = true;
        while (continuar) {
            mostrarMenu();
            int opcion = leerOpcion();
            
            switch (opcion) {
                case 1:
                    registrarMiembro();
                    break;
                case 2:
                    registrarEntrenador();
                    break;
                case 3:
                    crearRutina();
                    break;
                case 4:
                    asignarRutinaAMiembro();
                    break;
                case 5:
                    generarReportes();
                    break;
                case 6:
                    mostrarListas();
                    break;
                case 7:
                    mostrarEstadisticas();
                    break;
                case 8:
                    continuar = false;
                    System.out.println("\n¡Gracias por usar el Sistema de Gestión de Gimnasio!");
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("\n❌ Opción inválida. Por favor, seleccione una opción del 1 al 8.");
            }
            
            if (continuar) {
                System.out.println("\nPresione Enter para continuar...");
                scanner.nextLine();
            }
        }
        
        scanner.close();
    }
    
    private static void mostrarMenu() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("              MENÚ PRINCIPAL");
        System.out.println("=".repeat(50));
        System.out.println("1. 👤 Registrar Miembro");
        System.out.println("2. 💪 Registrar Entrenador");
        System.out.println("3. 📋 Crear Rutina");
        System.out.println("4. 🔗 Asignar Rutina a Miembro");
        System.out.println("5. 📊 Generar Reportes");
        System.out.println("6. 📝 Mostrar Listas");
        System.out.println("7. 📈 Mostrar Estadísticas Generales");
        System.out.println("8. 🚪 Salir");
        System.out.println("=".repeat(50));
        System.out.print("Seleccione una opción (1-8): ");
    }
    
    private static int leerOpcion() {
        try {
            int opcion = Integer.parseInt(scanner.nextLine().trim());
            return opcion;
        } catch (NumberFormatException e) {
            return -1;
        }
    }
    
    private static void registrarMiembro() {
        System.out.println("\n" + "=".repeat(40));
        System.out.println("        REGISTRAR NUEVO MIEMBRO");
        System.out.println("=".repeat(40));
        
        System.out.print("Nombre completo: ");
        String nombre = scanner.nextLine().trim();
        
        if (nombre.isEmpty()) {
            System.out.println("❌ El nombre no puede estar vacío.");
            return;
        }
        
        System.out.print("Edad: ");
        int edad;
        try {
            edad = Integer.parseInt(scanner.nextLine().trim());
            if (edad < 16 || edad > 100) {
                System.out.println("❌ La edad debe estar entre 16 y 100 años.");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("❌ Por favor, ingrese una edad válida.");
            return;
        }
        
        System.out.print("Teléfono: ");
        String telefono = scanner.nextLine().trim();
        
        System.out.print("Email: ");
        String email = scanner.nextLine().trim();
        
        if (email.isEmpty() || !email.contains("@")) {
            System.out.println("❌ Por favor, ingrese un email válido.");
            return;
        }
        
        if (gimnasio.registrarMiembro(nombre, edad, telefono, email)) {
            System.out.println("✅ Miembro registrado exitosamente!");
            System.out.println("Nombre: " + nombre);
            System.out.println("Email: " + email);
        } else {
            System.out.println("❌ Error: Ya existe un miembro con ese email.");
        }
    }
    
    private static void registrarEntrenador() {
        System.out.println("\n" + "=".repeat(40));
        System.out.println("       REGISTRAR NUEVO ENTRENADOR");
        System.out.println("=".repeat(40));
        
        System.out.print("Nombre completo: ");
        String nombre = scanner.nextLine().trim();
        
        if (nombre.isEmpty()) {
            System.out.println("❌ El nombre no puede estar vacío.");
            return;
        }
        
        System.out.print("Especialidad: ");
        String especialidad = scanner.nextLine().trim();
        
        System.out.print("Teléfono: ");
        String telefono = scanner.nextLine().trim();
        
        System.out.print("Email: ");
        String email = scanner.nextLine().trim();
        
        if (email.isEmpty() || !email.contains("@")) {
            System.out.println("❌ Por favor, ingrese un email válido.");
            return;
        }
        
        if (gimnasio.registrarEntrenador(nombre, especialidad, telefono, email)) {
            System.out.println("✅ Entrenador registrado exitosamente!");
            System.out.println("Nombre: " + nombre);
            System.out.println("Especialidad: " + especialidad);
            System.out.println("Email: " + email);
        } else {
            System.out.println("❌ Error: Ya existe un entrenador con ese email.");
        }
    }
    
    private static void crearRutina() {
        System.out.println("\n" + "=".repeat(40));
        System.out.println("           CREAR NUEVA RUTINA");
        System.out.println("=".repeat(40));
        
        if (gimnasio.getEntrenadores().isEmpty()) {
            System.out.println("❌ No hay entrenadores registrados. Debe registrar al menos un entrenador primero.");
            return;
        }
        
        System.out.print("Nombre de la rutina: ");
        String nombre = scanner.nextLine().trim();
        
        if (nombre.isEmpty()) {
            System.out.println("❌ El nombre de la rutina no puede estar vacío.");
            return;
        }
        
        System.out.print("Descripción: ");
        String descripcion = scanner.nextLine().trim();
        
        System.out.print("Duración (en minutos): ");
        int duracion;
        try {
            duracion = Integer.parseInt(scanner.nextLine().trim());
            if (duracion <= 0) {
                System.out.println("❌ La duración debe ser mayor a 0 minutos.");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("❌ Por favor, ingrese una duración válida.");
            return;
        }
        
        System.out.println("\nEntrenadores disponibles:");
        gimnasio.listarEntrenadores();
        
        System.out.print("\nEmail del entrenador asignado: ");
        String emailEntrenador = scanner.nextLine().trim();
        
        if (gimnasio.crearRutina(nombre, descripcion, duracion, emailEntrenador)) {
            System.out.println("✅ Rutina creada exitosamente!");
            System.out.println("Nombre: " + nombre);
            System.out.println("Duración: " + duracion + " minutos");
            System.out.println("Entrenador: " + emailEntrenador);
        } else {
            System.out.println("❌ Error: No se pudo crear la rutina. Verifique que el entrenador exista y que no haya una rutina con el mismo nombre.");
        }
    }
    
    private static void asignarRutinaAMiembro() {
        System.out.println("\n" + "=".repeat(40));
        System.out.println("       ASIGNAR RUTINA A MIEMBRO");
        System.out.println("=".repeat(40));
        
        if (gimnasio.getRutinas().isEmpty()) {
            System.out.println("❌ No hay rutinas creadas. Debe crear al menos una rutina primero.");
            return;
        }
        
        if (gimnasio.getMiembros().isEmpty()) {
            System.out.println("❌ No hay miembros registrados. Debe registrar al menos un miembro primero.");
            return;
        }
        
        System.out.println("Rutinas disponibles:");
        gimnasio.listarRutinas();
        
        System.out.print("\nNombre de la rutina: ");
        String nombreRutina = scanner.nextLine().trim();
        
        System.out.println("\nMiembros registrados:");
        gimnasio.listarMiembros();
        
        System.out.print("\nEmail del miembro: ");
        String emailMiembro = scanner.nextLine().trim();
        
        if (gimnasio.asignarRutinaAMiembro(nombreRutina, emailMiembro)) {
            System.out.println("✅ Rutina asignada exitosamente!");
            System.out.println("Rutina: " + nombreRutina);
            System.out.println("Miembro: " + emailMiembro);
        } else {
            System.out.println("❌ Error: No se pudo asignar la rutina. Verifique que la rutina y el miembro existan, y que la rutina esté activa.");
        }
    }
    
    private static void generarReportes() {
        System.out.println("\n" + "=".repeat(40));
        System.out.println("              REPORTES");
        System.out.println("=".repeat(40));
        
        System.out.println("1. Rutina más popular");
        System.out.println("2. Entrenador con más alumnos");
        System.out.println("3. Rutinas activas");
        System.out.print("\nSeleccione el tipo de reporte (1-3): ");
        
        int opcion = leerOpcion();
        
        switch (opcion) {
            case 1:
                mostrarRutinaMasPopular();
                break;
            case 2:
                mostrarEntrenadorConMasAlumnos();
                break;
            case 3:
                mostrarRutinasActivas();
                break;
            default:
                System.out.println("❌ Opción inválida.");
        }
    }
    
    private static void mostrarRutinaMasPopular() {
        System.out.println("\n" + "=".repeat(40));
        System.out.println("         RUTINA MÁS POPULAR");
        System.out.println("=".repeat(40));
        
        Rutina rutinaMasPopular = gimnasio.getRutinaMasPopular();
        if (rutinaMasPopular != null) {
            System.out.println(rutinaMasPopular.getDetalles());
        } else {
            System.out.println("❌ No hay rutinas registradas.");
        }
    }
    
    private static void mostrarEntrenadorConMasAlumnos() {
        System.out.println("\n" + "=".repeat(40));
        System.out.println("      ENTRENADOR CON MÁS ALUMNOS");
        System.out.println("=".repeat(40));
        
        Entrenador entrenadorConMasAlumnos = gimnasio.getEntrenadorConMasAlumnos();
        if (entrenadorConMasAlumnos != null) {
            System.out.println(entrenadorConMasAlumnos.getDetalles());
        } else {
            System.out.println("❌ No hay entrenadores registrados.");
        }
    }
    
    private static void mostrarRutinasActivas() {
        System.out.println("\n" + "=".repeat(40));
        System.out.println("           RUTINAS ACTIVAS");
        System.out.println("=".repeat(40));
        
        ArrayList<Rutina> rutinasActivas = gimnasio.getRutinasActivas();
        if (rutinasActivas.isEmpty()) {
            System.out.println("❌ No hay rutinas activas.");
        } else {
            for (int i = 0; i < rutinasActivas.size(); i++) {
                System.out.println((i + 1) + ". " + rutinasActivas.get(i).toString());
            }
        }
    }
    
    private static void mostrarListas() {
        System.out.println("\n" + "=".repeat(40));
        System.out.println("               LISTAS");
        System.out.println("=".repeat(40));
        
        System.out.println("1. Lista de Miembros");
        System.out.println("2. Lista de Entrenadores");
        System.out.println("3. Lista de Rutinas");
        System.out.print("\nSeleccione qué lista mostrar (1-3): ");
        
        int opcion = leerOpcion();
        
        switch (opcion) {
            case 1:
                gimnasio.listarMiembros();
                break;
            case 2:
                gimnasio.listarEntrenadores();
                break;
            case 3:
                gimnasio.listarRutinas();
                break;
            default:
                System.out.println("❌ Opción inválida.");
        }
    }
    
    private static void mostrarEstadisticas() {
        System.out.println("\n" + gimnasio.getEstadisticasGenerales());
    }
     
    
   private static void cargarDatosDePrueba() {
        gimnasio.registrarEntrenador("Carlos Mendoza", "Entrenamiento Funcional", "555-0101", "carlos@fitlife.com");
        gimnasio.registrarEntrenador("Ana García", "Yoga y Pilates", "555-0102", "ana@fitlife.com");
        gimnasio.registrarEntrenador("Miguel Torres", "Musculación", "555-0103", "miguel@fitlife.com");
        
        gimnasio.registrarMiembro("Juan Pérez", 28, "555-1001", "juan@email.com");
        gimnasio.registrarMiembro("María López", 32, "555-1002", "maria@email.com");
        gimnasio.registrarMiembro("Pedro Rodríguez", 25, "555-1003", "pedro@email.com");
        gimnasio.registrarMiembro("Laura Martínez", 29, "555-1004", "laura@email.com");
        
        gimnasio.crearRutina("CrossFit Básico", "Entrenamiento funcional de alta intensidad", 60, "carlos@fitlife.com");
        gimnasio.crearRutina("Yoga Matutino", "Sesión de yoga para comenzar el día", 45, "ana@fitlife.com");
        gimnasio.crearRutina("Fuerza y Masa", "Entrenamiento de musculación para ganar masa muscular", 90, "miguel@fitlife.com");
        
        gimnasio.asignarRutinaAMiembro("CrossFit Básico", "juan@email.com");
        gimnasio.asignarRutinaAMiembro("CrossFit Básico", "pedro@email.com");
        gimnasio.asignarRutinaAMiembro("Yoga Matutino", "maria@email.com");
        gimnasio.asignarRutinaAMiembro("Yoga Matutino", "laura@email.com");
        gimnasio.asignarRutinaAMiembro("Fuerza y Masa", "juan@email.com");
    } 
}