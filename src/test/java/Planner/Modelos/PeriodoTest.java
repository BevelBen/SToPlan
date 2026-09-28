package Planner.Modelos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PeriodoTest {

    @Test
    void constructorGuardaDiaYPeriodo() {
        Periodo p = new Periodo(2, 3);
        assertEquals(2, p.getDia());
        assertEquals(3, p.getPeriodo());
    }

    @Test
    void coincidenciaPeriodoConIgualesYDistintos() {
        Periodo p = new Periodo(1, 2);
        assertTrue(p.coincidenciaPeriodo(new Periodo(1, 2)));
        assertFalse(p.coincidenciaPeriodo(new Periodo(2, 2)));
    }

    @Test
    void equalsCompararPeriodos() {
        assertEquals(new Periodo(4, 1), new Periodo(4, 1));
        assertNotEquals(new Periodo(4, 1), new Periodo(4, 2));
    }
}
