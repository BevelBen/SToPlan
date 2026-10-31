package modelo;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa un estudiante de la universidad.
 */
public class Estudiante extends Usuario {
    private final int yearIngreso;
    private final String matricula;
    private final List<Clase> clases = new ArrayList<>();

    public Estudiante(Rut rut, String nombre, String password, int yearIngreso) {
        super(rut, nombre, password);
        this.yearIngreso = yearIngreso;
        this.matricula = generarMatricula();
    }

    public String getMatricula() {
        return matricula;
    }

    public List<Clase> getClases() {
        return List.copyOf(clases);
    }

    public void agregarClase(Clase clase) {
        if (perteneceClase(clase)) {
            throw new IllegalStateException("El estudiante ya pertenece a esa clase.");
        }
        clases.add(clase);
    }

    private String generarMatricula() {
        return rut.limpiarRut() + yearIngreso % 100;
    }

    public boolean perteneceClase(Clase clase) {
        return clases.contains(clase);
    }

    @Override
    public String toString() {
        return "Matrícula: " + matricula + " | Nombre: " + nombre;
    }
}
