package Modelo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// --- CLASE MODELO PRESTAMO ---
public class Prestamo {
    private Aprendiz usuario;
    private Equipo elemento;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
    private boolean activo;

    // Constructor que vincula las dos clases anteriores
    public Prestamo(Aprendiz aprendiz, Equipo equipo) {
        if (!equipo.isDisponible()) {
            throw new IllegalStateException("Error: El equipo " + equipo.getNombre() + " no está disponible para préstamo.");
        }

        this.usuario = aprendiz;
        this.elemento = equipo;
        this.fechaInicio = LocalDateTime.now(); // Fecha y hora actual automática
        this.activo = true;

        // Marcamos el equipo como prestado inmediatamente
        equipo.prestar();
    }

    // Método para finalizar el préstamo
    public void finalizarPrestamo() {
        if (activo) {
            this.fechaFin = LocalDateTime.now();
            this.activo = false;
            this.elemento.devolver(); // El equipo vuelve a estar disponible
        }
    }

    // Método de presentación formateado (Siguiendo tu estándar)
    public String fichaTecnica() {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        String estado = activo ? "[EN CURSO]" : "[DEVUELTO el " + fechaFin.format(formato) + "]";

        return String.format("PRÉSTAMO: %s | Usuario: %-15s | Equipo: %-10s | %s",
                fechaInicio.format(formato),
                usuario.getNombre(),
                elemento.getNombre(),
                estado);
    }
}