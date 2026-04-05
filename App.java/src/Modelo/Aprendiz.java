package Modelo;

// --- CLASE MODELO ---
public class Aprendiz {
    private String id;
    private String nombre;
    private String correo;
    private int edad;

    // Constructor original
    public Aprendiz(String id, String nombre, String correo, int edad) {
        this.id = id;
        this.nombre = nombre;
        setCorreo(correo);
        this.edad = edad;
    }

    // Tu validación de correo original
    public void setCorreo(String nuevoCorreo) {
        if (nuevoCorreo == null || !nuevoCorreo.contains("@")) {
            throw new IllegalArgumentException("El formato del correo '" + nuevoCorreo + "' es inválido.");
        }
        this.correo = nuevoCorreo;
    }

    public String getCorreo() {
        return this.correo;
    }

    // Métodos necesarios para que el Servicio y Préstamo funcionen
    public String getId() {
        return this.id;
    }

    public String getNombre() {
        return this.nombre;
    }

    // Tu método de presentación original
    public String fichaTecnica() {
        return String.format("[ID: %s] | Nombre: %-15s | Email: %-25s | Edad: %d",
                id, nombre, correo, edad);
    }
}