package Planner.Modelos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AsignaturaTest {

    @Test
    void constructorGuardaCodigoYNombre() {
        Asignatura a = new Asignatura("MAT101", "Cálculo I");
        assertEquals("MAT101", a.getCodigo());
        assertEquals("Cálculo I", a.getNombre());
    }

    @Test
    void verificarCodigoCorrectoEIncorrecto() {
        Asignatura a = new Asignatura("MAT101", "Cálculo I");
        assertTrue(a.verificarCodigo("MAT101"));
        assertFalse(a.verificarCodigo("FIS101"));
    }

    @Test
    void equalsSeBasaEnElCodigo() {
        assertEquals(new Asignatura("MAT101", "Cálculo I"), new Asignatura("MAT101", "Otro nombre"));
        assertNotEquals(new Asignatura("MAT101", "Cálculo I"), new Asignatura("FIS101", "Cálculo I"));
    }
}
