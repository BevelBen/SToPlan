package Planner.Modelos;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EstudianteTest {

    private Estudiante estudiante;

    @BeforeEach
    void setUp() {
        estudiante = new Estudiante("2023001", "Ana", "clave123");
    }

    @Test
    void verificarPasswordCorrectaEIncorrecta() {
        assertTrue(estudiante.verificarPassword("clave123"));
        assertFalse(estudiante.verificarPassword("otra"));
    }

    @Test
    void agregarYEliminarDisponibilidad() {
        Periodo p = new Periodo(1, 1);
        assertTrue(estudiante.agregarDisponibilidad(p));
        assertFalse(estudiante.agregarDisponibilidad(new Periodo(1, 1))); // duplicado
        assertTrue(estudiante.eliminarDisponibilidad(p));
        assertTrue(estudiante.getPeriodosDisponibilidad().isEmpty());
    }

    @Test
    void agregarYEliminarAsignaturaInteresada() {
        Asignatura a = new Asignatura("MAT101", "Cálculo I");
        assertTrue(estudiante.agregarAsignaturaInteresada(a));
        assertTrue(estudiante.interesadoAsignatura(a));
        assertTrue(estudiante.eliminarAsignaturaInteresada(a));
        assertFalse(estudiante.interesadoAsignatura(a));
    }
}
