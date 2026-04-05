package Modelo;

// --- CLASE MODELO EQUIPO ---
public class Equipo {
    private String codigo;
    private String nombre;
    private String categoria;
    private boolean disponible;

    // Constructor con validación de seguridad
    public Equipo(String codigo, String nombre, String categoria) {
        if (codigo == null || codigo.trim().isEmpty()) {
            throw new IllegalArgumentException("El código del equipo no puede estar vacío.");
        }
        this.codigo = codigo;
        this.nombre = nombre;
        this.categoria = categoria;
        this.disponible = true; // Por defecto, todo equipo nuevo está disponible
    }

    // Métodos de estado (Lógica de préstamo)
    public void prestar() {
        if (!disponible) {
            throw new IllegalStateException("El equipo " + codigo + " ya está prestado.");
        }
        this.disponible = false;
    }

    public void devolver() {
        this.disponible = true;
    }

    // Getters
    public String getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public boolean isDisponible() { return disponible; }

    // Método de presentación formateado (Siguiendo tu estilo de Aprendiz)
    public String fichaTecnica() {
        String estado = disponible ? "[DISPONIBLE]" : "[PRESTADO]";
        return String.format("Ref: %-10s | Equipo: %-15s | Cat: %-12s | Estado: %s",
                codigo, nombre, categoria, estado);
    }
}