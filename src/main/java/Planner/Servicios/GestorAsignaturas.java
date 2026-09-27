package Planner.Servicios;

import Planner.Modelos.Asignatura;

import java.util.ArrayList;
import java.util.List;

public class GestorAsignaturas {
    private List<Asignatura> listaAsignaturas;

    public GestorAsignaturas() {
        this.listaAsignaturas = new ArrayList<>();
    }

    public boolean existeCodigo(String codigo) {
        for (Asignatura a : listaAsignaturas) {
            if (a.verificarCodigo(codigo)) {
                return true;
            }
        }
        return false;
    }
}
