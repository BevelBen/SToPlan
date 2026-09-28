package Planner.Servicios;

import Planner.Modelos.Asignatura;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GestorAsignaturasTest {

    private GestorAsignaturas gestor;

    @BeforeEach
    void setUp() {
        gestor = new GestorAsignaturas();
    }

    @Test
    void agregarAsignaturaNuevaYRechazarDuplicada() {
        assertTrue(gestor.agregarAsignatura("MAT101", "Cálculo I"));
        assertFalse(gestor.agregarAsignatura("MAT101", "Otro nombre"));
        assertEquals(1, gestor.totalidadAsignaturas().size());
    }

    @Test
    void buscarPorCodigoYExisteCodigo() {
        gestor.agregarAsignatura("MAT101", "Cálculo I");
        Asignatura a = gestor.buscarPorCodigo("MAT101");
        assertNotNull(a);
        assertEquals("Cálculo I", a.getNombre());
        assertNull(gestor.buscarPorCodigo("NOPE"));
        assertTrue(gestor.existeCodigo("MAT101"));
    }

    @Test
    void eliminarAsignaturaExistenteEInexistente() {
        gestor.agregarAsignatura("MAT101", "Cálculo I");
        assertTrue(gestor.eliminarAsignatura("MAT101"));
        assertFalse(gestor.eliminarAsignatura("MAT101"));
        assertTrue(gestor.totalidadAsignaturas().isEmpty());
    }
}
