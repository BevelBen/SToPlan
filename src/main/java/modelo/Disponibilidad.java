package modelo;

import java.time.LocalDate;

/**
 * Representa una disponibilidad en el horario con una fecha, periodo, calificacion y estado.
 */
public class Disponibilidad {
    private final LocalDate dia;
    private final Periodo periodo;
    private EstadoDisponibilidad estadoDisponibilidad;
    private int calificacion;

    public Disponibilidad(LocalDate dia, Periodo periodo) {
        this.dia = dia;
        this.periodo = periodo;
        this.estadoDisponibilidad = EstadoDisponibilidad.NO_DISPONIBLE;
        this.calificacion = 0;
    }

    public void actualizarCalificacion(int nuevaCalificacion) {
        if (estadoDisponibilidad == EstadoDisponibilidad.NO_DISPONIBLE) {
            throw new IllegalStateException("El periodo no se encuentra disponible.");
        }
        if (nuevaCalificacion < 1 || nuevaCalificacion > 5) {
            throw new IllegalArgumentException("La calificación debe estar entre 1 y 5.");
        }
        this.calificacion = nuevaCalificacion;
    }

    public void actualizarDisponibilidad(EstadoDisponibilidad estadoDisponibilidad) {
        this.estadoDisponibilidad = estadoDisponibilidad;
        this.calificacion = (this.estadoDisponibilidad == EstadoDisponibilidad.DISPONIBLE) ? 5 : 0;
    }

    public LocalDate getDia() {
        return dia;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public EstadoDisponibilidad getEstadoDisponibilidad() {
        return estadoDisponibilidad;
    }

    public int getCalificacion() {
        return calificacion;
    }
}
