
# Sistema de Gestión de Gimnasio

## Descripción
Sistema completo de gestión para gimnasios desarrollado en Java como parte del Ejercicio 3 de Programación Orientada a Objetos (POO). El sistema permite gestionar miembros, entrenadores y rutinas de ejercicio de manera eficiente.

## Características Principales

### 🏋️‍♂️ Gestión de Miembros
- Registro de nuevos miembros con información personal
- Asignación de rutinas a miembros
- Seguimiento de rutinas asignadas por miembro

### 💪 Gestión de Entrenadores
- Registro de entrenadores con especialidades
- Asignación automática de alumnos
- Seguimiento de alumnos a cargo

### 📋 Gestión de Rutinas
- Creación de rutinas personalizadas
- Asignación de entrenadores a rutinas
- Control de participantes por rutina
- Estado activo/inactivo de rutinas

### 📊 Reportes y Estadísticas
- Rutina más popular (mayor número de participantes)
- Entrenador con más alumnos
- Lista de rutinas activas
- Estadísticas generales del gimnasio

## Estructura del Proyecto

```
el nombre de la carpeta /
├── Miembro.java      # Clase para gestionar miembros del gimnasio
├── Entrenador.java   # Clase para gestionar entrenadores
├── Rutina.java       # Clase para gestionar rutinas de ejercicio
├── Gimnasio.java     # Clase principal que coordina todo el sistema
└── Main.java         # Programa principal con menú interactivo
```

## Tecnologías Utilizadas
- **Java**: Lenguaje de programación principal
- **ArrayList**: Para manejo dinámico de colecciones
- **Scanner**: Para entrada de datos del usuario

## Funcionalidades del Menú

1. **👤 Registrar Miembro**: Permite registrar nuevos miembros con validación de datos
2. **💪 Registrar Entrenador**: Registro de entrenadores con especialidades
3. **📋 Crear Rutina**: Creación de rutinas con asignación de entrenador
4. **🔗 Asignar Rutina a Miembro**: Vinculación de miembros con rutinas
5. **📊 Generar Reportes**: Reportes estadísticos del gimnasio
6. **📝 Mostrar Listas**: Visualización de miembros, entrenadores y rutinas
7. **📈 Mostrar Estadísticas Generales**: Resumen completo del gimnasio
8. **🚪 Salir**: Terminar el programa

## Cómo Ejecutar

### Compilación \\bash / Terminal
```bash / Terminal
mkdir -p bin 
javac -d bin src (nombre de la carpeta en donde  se clona) /*.java
```

### Ejecución \\ bash / Terminal
```bash / Terminal
java -cp bin Main
```

## Datos de Prueba
El sistema incluye datos de prueba precargados:
- 3 entrenadores con diferentes especialidades
- 4 miembros registrados
- 3 rutinas creadas
- Asignaciones de rutinas a miembros

## Validaciones Implementadas
- ✅ Verificación de emails únicos para miembros y entrenadores
- ✅ Validación de edad (16-100 años)
- ✅ Verificación de formato de email
- ✅ Prevención de rutinas duplicadas
- ✅ Validación de duración de rutinas
- ✅ Verificación de existencia de entrenadores al crear rutinas

## Características Técnicas
- **Encapsulación**: Todos los atributos son privados con getters/setters apropiados
- **Relaciones**: Implementación de relaciones entre clases (composición y agregación)
- **Colecciones Dinámicas**: Uso de ArrayList para manejo flexible de datos
- **Interfaz de Usuario**: Menú interactivo con validaciones y mensajes informativos
- **Manejo de Errores**: Validación de entrada y manejo de excepciones
