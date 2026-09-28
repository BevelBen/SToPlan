package Planner.Servicios;

import Planner.Modelos.Estudiante;
import Planner.Modelos.Periodo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmparejadorTest {

    private Emparejador emparejador;
    private Estudiante ana;
    private Estudiante beto;

    @BeforeEach
    void setUp() {
        emparejador = new Emparejador();
        ana = new Estudiante("1", "Ana", "a");
        beto = new Estudiante("2", "Beto", "b");
        ana.agregarDisponibilidad(new Periodo(1, 1));
        ana.agregarDisponibilidad(new Periodo(1, 2));
        beto.agregarDisponibilidad(new Periodo(1, 2));
        beto.agregarDisponibilidad(new Periodo(2, 3));
    }

    @Test
    void periodosComunesEntreDosEstudiantes() {
        List<Periodo> comunes = emparejador.periodosComunes(ana, beto);
        assertEquals(1, comunes.size());
        assertTrue(comunes.contains(new Periodo(1, 2)));
        assertEquals(1, emparejador.cantidadHorariosComunes(ana, beto));
    }

    @Test
    void periodosDisponiblesConVariosEstudiantes() {
        List<Periodo> resultado = emparejador.periodosDisponibles(List.of(ana, beto));
        assertNotNull(resultado);
        assertEquals(1, resultado.size());
        assertEquals(new Periodo(1, 2), resultado.get(0));
    }

    @Test
    void periodosDisponiblesDevuelveNullSiNoHayComunes() {
        assertNull(emparejador.periodosDisponibles(new ArrayList<>()));

        Estudiante carla = new Estudiante("3", "Carla", "c");
        carla.agregarDisponibilidad(new Periodo(5, 5));
        assertNull(emparejador.periodosDisponibles(List.of(ana, carla)));
    }
}
