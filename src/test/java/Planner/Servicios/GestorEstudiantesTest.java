package Planner.Servicios;

import Planner.Modelos.Asignatura;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GestorEstudiantesTest {

    private GestorEstudiantes gestor;

    @BeforeEach
    void setUp() {
        gestor = new GestorEstudiantes();
    }

    @Test
    void agregarYEliminarEstudiante() {
        assertTrue(gestor.agregarEstudiante("1", "Ana", "pw"));
        assertFalse(gestor.agregarEstudiante("1", "Otra", "pw2")); // matrícula repetida
        assertEquals(1, gestor.cantidadEstudiantes());
        assertTrue(gestor.eliminarEstudiante("1"));
        assertFalse(gestor.existeMatricula("1"));
    }

    @Test
    void verificarLogin() {
        gestor.agregarEstudiante("1", "Ana", "pw");
        assertEquals("Ana", gestor.verificarLogin("1", "pw"));
        assertNull(gestor.verificarLogin("1", "mal"));
        assertNull(gestor.verificarLogin("404", "pw"));
    }

    @Test
    void estudiantesPorAsignatura() {
        Asignatura calculo = new Asignatura("MAT101", "Cálculo I");
        gestor.agregarEstudiante("1", "Ana", "pw");
        gestor.agregarEstudiante("2", "Beto", "pw");
        gestor.agregarAsignaturaInteresada("1", calculo);

        assertEquals(1, gestor.estudiantesPorAsignatura(calculo).size());
        assertEquals("Ana", gestor.estudiantesPorAsignatura(calculo).get(0).getNombre());
    }
}
