package Planner.Modelos;

import Planner.Modelos.Asignatura;

import java.util.ArrayList;
import java.util.List;

public class Estudiante {
    private String matricula;
    private String nombre;
    private String password;
    private List<Asignatura> asignaturasInteresadas;
    private List<Periodo> periodosDisponibilidad;

    public Estudiante(String m, String n, String p) {
        this.matricula = m;
        this.nombre = n;
        this.password = p;
        this.asignaturasInteresadas = new ArrayList<>();
        this.periodosDisponibilidad = new ArrayList<>();
    }

    // === GETTERS Y SETTERS ===

    public String getMatricula() {
        return matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Asignatura> getAsignaturasInteresadas() {
        return asignaturasInteresadas;
    }

    public List<Periodo> getPeriodosDisponibilidad() {
        return periodosDisponibilidad;
    }

    // === MÉTODOS ===

    public boolean verificarPassword(String p) {
        if (password.equals(p)) {
            return true;
        }
        return false;
    }

    public boolean verificarMatricula (String m) {
        if (matricula.equals(m)) {
            return true;
        }
        return false;
    }

    public boolean agregarDisponibilidad(Periodo p) {
        if (!periodosDisponibilidad.contains(p)) {
            periodosDisponibilidad.add(p);
            return true;
        }
        return false;
    }

    public boolean eliminarDisponibilidad(Periodo p) {
        if (periodosDisponibilidad.contains(p)) {
            periodosDisponibilidad.remove(p);
            return true;
        }
        return false;
    }

    public boolean agregarAsignaturaInteresada(Asignatura a) {
        if (!asignaturasInteresadas.contains(a)) {
            asignaturasInteresadas.add(a);
            return true;
        }
        return false;
    }

    public boolean eliminarAsignaturaInteresada(Asignatura a) {
        if (asignaturasInteresadas.contains(a)) {
            asignaturasInteresadas.remove(a);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Matrícula: " + matricula + " | Nombre: " + nombre;
    }
}
