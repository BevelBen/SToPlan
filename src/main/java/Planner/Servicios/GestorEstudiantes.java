package Planner.Servicios;

import Planner.Modelos.Estudiante;

import java.util.ArrayList;
import java.util.List;

public class GestorEstudiantes {
    private List<Estudiante> listaEstudiantes;

    public GestorEstudiantes() {
        this.listaEstudiantes = new ArrayList<>();
    }

    // === MÉTODOS ===

    public boolean agregarEstudiante(String matricula, String nombre, String password) {
        if (existeMatricula(matricula)) {
            return false;
        }
        Estudiante nuevoEstudiante = new Estudiante(matricula, nombre, password);
        listaEstudiantes.add(nuevoEstudiante);
        return true;
    }

    public boolean existeMatricula(String m) {
        for (Estudiante e : listaEstudiantes) {
            if (e.getMatricula().equals(m)) {
                return true;
            }
        }
        return false;
    }

    private Estudiante buscarPorMatricula(String m) {
        for (Estudiante e : listaEstudiantes) {
            if (e.getMatricula().equals(m)) {
                return e;
            }
        }
        return null;
    }

    public String nombrePorMatricula(String m) {
        Estudiante estudianteMatricula = buscarPorMatricula(m);
        if (estudianteMatricula != null) {
            return estudianteMatricula.getMatricula();
        }
        return null;
    }

    public String[] formatoEstudiantes() {
        String[] listaFormatos = new String[listaEstudiantes.size()];
        int i = 0;
        for (Estudiante e : listaEstudiantes) {
            listaFormatos[i] = e.getNombre();
            i++;
        }
        return listaFormatos;
    }

    public String verificarLogin(String m, String p) {
        Estudiante estudianteLogin = buscarPorMatricula(m);
        if (estudianteLogin == null) {
            return null;
        }
        if (estudianteLogin.verificarPassword(p)) {
            return estudianteLogin.getNombre();
        }
        return null;
    }

    public List<Estudiante> totalidadEstudiantes() {
        return listaEstudiantes;
    }
}