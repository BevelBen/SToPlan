package Planner.Servicios;

import Planner.Modelos.Asignatura;

import java.util.ArrayList;
import java.util.List;

public class GestorAsignaturas {
    private List<Asignatura> listaAsignaturas;

    public GestorAsignaturas() {
        this.listaAsignaturas = new ArrayList<>();
    }

    // === MÉTODOS ===

    public boolean existeCodigo(String codigo) {
        for (Asignatura a : listaAsignaturas) {
            if (a.verificarCodigo(codigo)) {
                return true;
            }
        }
        return false;
    }

    public boolean agregarAsignatura(String codigo, String nombre) {
        if (existeCodigo(codigo)) {
            return false;
        }
        Asignatura nuevaAsignatura = new Asignatura(codigo, nombre);
        listaAsignaturas.add(nuevaAsignatura);
        return true;
    }

    public boolean eliminarAsignatura(String codigo) {
        Asignatura asignatura = buscarPorCodigo(codigo);
        if (asignatura == null) {
            return false;
        }
        listaAsignaturas.remove(asignatura);
        return true;
    }

    public Asignatura buscarPorCodigo(String codigo) {
        for (Asignatura asignatura : listaAsignaturas) {
            if (asignatura.verificarCodigo(codigo)) {
                return asignatura;
            }
        }
        return null;
    }
}
