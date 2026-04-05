package Servicios;

import Modelo.Aprendiz;
import Modelo.Equipo;
import Modelo.Prestamo;
import java.util.ArrayList;
import java.util.List;

public class GestionPrestamos {
    private List<Aprendiz> listaAprendices = new ArrayList<>();
    private List<Equipo> inventarioEquipos = new ArrayList<>();
    private List<Prestamo> registroPrestamos = new ArrayList<>();

    public void registrarAprendiz(Aprendiz a) {
        listaAprendices.add(a);
    }

    public void registrarEquipo(Equipo e) {
        inventarioEquipos.add(e);
    }

    public void realizarPrestamo(String idAprendiz, String codEquipo) {
        Aprendiz a = buscarAprendiz(idAprendiz);
        Equipo e = buscarEquipo(codEquipo);

        if (a != null && e != null) {
            try {
                Prestamo nuevo = new Prestamo(a, e);
                registroPrestamos.add(nuevo);
            } catch (Exception error) {
                System.err.println(error.getMessage());
            }
        }
    }

    private Aprendiz buscarAprendiz(String id) {
        for (Aprendiz a : listaAprendices) {
            if (a.getId().equals(id)) return a;
        }
        return null;
    }

    private Equipo buscarEquipo(String codigo) {
        for (Equipo e : inventarioEquipos) {
            if (e.getCodigo().equals(codigo)) return e;
        }
        return null;
    }
}