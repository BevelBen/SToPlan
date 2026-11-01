package modelo;

import java.time.LocalDate;
import java.util.Optional;

/**
 * Representa una disponibilidad en el horario con una fecha, periodo, calificacion y estado.
 */
public class Disponibilidad {
    private final LocalDate dia;
    private final Periodo periodo;
    private EstadoDisponibilidad estadoDisponibilidad;
    private Calificacion calificacion;

    public Disponibilidad(LocalDate dia, Periodo periodo) {
        this.dia = dia;
        this.periodo = periodo;
        this.estadoDisponibilidad = EstadoDisponibilidad.NO_DISPONIBLE;
        this.calificacion = Calificacion.NO_ME_ACOMODA;
    }

    public void actualizarCalificacion(Calificacion calificacion) {
        if (estadoDisponibilidad == EstadoDisponibilidad.NO_DISPONIBLE) {
            throw new IllegalStateException("El periodo no se encuentra disponible.");
        }
        this.calificacion = calificacion;
    }

    public void actualizarCalificacion(int nuevaCalificacion) {
        actualizarCalificacion(Calificacion.desdeValor(nuevaCalificacion));
    }

    public void marcarDispnible(Calificacion calificacion) {
        this.estadoDisponibilidad = EstadoDisponibilidad.DISPONIBLE;
        this.calificacion = calificacion;
    }

    public void marcarNoDisponible() {
        this.estadoDisponibilidad = EstadoDisponibilidad.NO_DISPONIBLE;
        this.calificacion = null;
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

    public Optional<Calificacion> getCalificacion() {
        return Optional.ofNullable(calificacion);
    }
}
