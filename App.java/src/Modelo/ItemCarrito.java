package Modelo;

public class ItemCarrito {
    private Equipo equipo;
    private int cantidad;

    public ItemCarrito(Equipo equipo, int cantidad) {
        this.equipo = equipo;
        this.cantidad = cantidad;
    }

    public Equipo getEquipo() { return equipo; }
    public int getCantidad() { return cantidad; }
    
    public void incrementarCantidad(int cant) {
        this.cantidad += cant;
    }

    public String detalle() {
        return String.format("Producto: %-15s | Cantidad: %d", 
                equipo.getNombre(), cantidad);
    }
}
