package Servicios;

import Modelo.Equipo;
import Modelo.ItemCarrito;
import java.util.ArrayList;
import java.util.List;

public class CarritoServicio {
    private List<ItemCarrito> listaItems;

    public CarritoServicio() {
        this.listaItems = new ArrayList<>();
    }

    // Agregar un equipo al carrito
    public void agregarProducto(Equipo equipo, int cantidad) {
        // Si el producto ya estaba, solo sumamos la cantidad
        for (ItemCarrito item : listaItems) {
            if (item.getEquipo().getCodigo().equals(equipo.getCodigo())) {
                item.incrementarCantidad(cantidad);
                System.out.println("✔ Cantidad actualizada para: " + equipo.getNombre());
                return;
            }
        }
        // Si es nuevo, lo añadimos
        listaItems.add(new ItemCarrito(equipo, cantidad));
        System.out.println("✔ " + equipo.getNombre() + " agregado al carrito.");
    }

    public void mostrarCarrito() {
        System.out.println("\n--- CONTENIDO DEL CARRITO ---");
        if (listaItems.isEmpty()) {
            System.out.println("El carrito está vacío.");
        } else {
            for (ItemCarrito item : listaItems) {
                System.out.println(item.detalle());
            }
        }
    }

    public void vaciarCarrito() {
        listaItems.clear();
        System.out.println("\n🗑 Carrito vaciado.");
    }
}
