package Planner.Servicios;

import Planner.Modelos.Asignatura;
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

    public boolean eliminarEstudiante(String matricula) {
        Estudiante estudiante = buscarPorMatricula(matricula);
        if (estudiante == null) {
            return false;
        }
        listaEstudiantes.remove(estudiante);
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

    public Estudiante buscarPorMatricula(String matricula) {
        for (Estudiante e : listaEstudiantes) {
            if (e.getMatricula().equals(matricula)) {
                return e;
            }
        }
        return null;
    }

    public boolean agregarAsignaturaInteresada(String matricula, Asignatura asignatura) {
        Estudiante estudiante = buscarPorMatricula(matricula);
        if (estudiante == null) {
            return false;
        }
        return estudiante.agregarAsignaturaInteresada(asignatura);
    }

    public boolean eliminarAsignaturaInteresada(String matricula, Asignatura asignatura) {
        Estudiante estudiante = buscarPorMatricula(matricula);
        if (estudiante == null) {
            return false;
        }
        return estudiante.eliminarAsignaturaInteresada(asignatura);
    }

    public String nombrePorMatricula(String m) {
        Estudiante estudianteMatricula = buscarPorMatricula(m);
        if (estudianteMatricula != null) {
            return estudianteMatricula.getNombre();
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

    public int cantidadEstudiantes() {
        return listaEstudiantes.size();
    }

    public List<Estudiante> estudiantesPorAsignatura(Asignatura a) {
        List<Estudiante> estudiantesAsignatura = new ArrayList<>();
        for (Estudiante e : listaEstudiantes) {
            if (e.interesadoAsignatura(a)) {
                estudiantesAsignatura.add(e);
            }
        }
        return estudiantesAsignatura;
    }
}