package Planner.Servicios;

import Planner.Modelos.Estudiante;
import Planner.Modelos.Periodo;

import java.util.ArrayList;
import java.util.List;

public class Emparejador {

    // === MÉTODOS ===

    public List<Periodo> periodosComunes(Estudiante estudianteUno, Estudiante estudianteDos) {
        List<Periodo> comun = new ArrayList<>();
        List<Periodo> bloquesDos = estudianteDos.getPeriodosDisponibilidad();
        for (Periodo bloqueDisponibilidad : estudianteUno.getPeriodosDisponibilidad()) {
            if (bloquesDos.contains(bloqueDisponibilidad) && !comun.contains(bloqueDisponibilidad)) {
                comun.add(bloqueDisponibilidad);
            }
        }
        return comun;
    }

    public int cantidadHorariosComunes(Estudiante estudianteUno, Estudiante estudianteDos) {
        return periodosComunes(estudianteUno, estudianteDos).size();
    }
}
