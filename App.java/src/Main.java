import Modelo.*;
import Servicios.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // 1) Instanciación de objetos
        Aprendiz userA = new Aprendiz("10102020", "Kevin Rodriguez", "kevin.dev@sena.edu.co", 20);
        Aprendiz userB = new Aprendiz("30304040", "Laura Casallas", "l.casallas@etb.net", 22);
        Aprendiz userC = new Aprendiz("50506060", "Andrés Páez", "apaez@gmail.com", 19);

        // 2) Lista
        List<Aprendiz> listaAprendices = new ArrayList<>();
        listaAprendices.add(userA);
        listaAprendices.add(userB);
        listaAprendices.add(userC);

        // 3) Reporte Inicial
        System.out.println("=== REGISTRO DE APRENDICES SENA ===");
        for (Aprendiz temp : listaAprendices) {
            System.out.println(temp.fichaTecnica());
        }

        // 4) Pruebas de seguridad
        System.out.println("\n--- Intentando actualizaciones de seguridad ---");

        try {
            // Intento exitoso
            userA.setCorreo("kevin.rodriguez@outlook.com");
            System.out.println("✔ Correo actualizado: " + userA.getCorreo());

            // Intento fallido (Aquí saltará al catch)
            System.out.println("Intentando asignar correo inválido a userB...");
            userB.setCorreo("lauragmail.com");

        } catch (IllegalArgumentException e) {
            // Usamos System.out en lugar de System.err para que no se desordene el texto
            System.out.println("✘ Error detectado: " + e.getMessage());
        }

        // 5) Verificación final
        System.out.println("\nEstado final del primer registro:");
        System.out.println(userA.fichaTecnica());

        // ==========================================================
        // 6) AÑADIDO: PRUEBA DEL CARRITO DE COMPRAS
        // ==========================================================
        System.out.println("\n--- Iniciando Módulo de Carrito ---");
        
        // Creamos unos equipos para comprar
        Equipo eq1 = new Equipo("DELL-01", "Laptop Latitude", "Computo");
        Equipo eq2 = new Equipo("LOGI-09", "Mouse Pro", "Periféricos");
        
        CarritoServicio carrito = new CarritoServicio();
        
        // Agregamos productos al carrito
        carrito.agregarProducto(eq1, 1);
        carrito.agregarProducto(eq2, 3);
        
        // Mostramos el contenido
        carrito.mostrarCarrito();
        // ==========================================================

        System.out.println("\n--- Proceso Finalizado con Éxito ---");
    }
}
