package modelo;

import java.time.LocalTime;
import java.util.Objects;

/**
 * Representa un periodo de la universidad.
 */
public class Periodo {
    private final int numero;
    private final LocalTime horaInicio;
    private final LocalTime horaFin;

    public Periodo(int numero, LocalTime horaInicio, LocalTime horaFin) {
        this.numero = numero;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    public String etiquetaHorario() {
        return horaInicio + " " +horaFin;
    }

    public int getNumero() {
        return numero;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }

    @Override
    public boolean equals(Object objeto) {
        if (objeto == null) {
            return false;
        }
        if (objeto.getClass() != this.getClass()) {
            return false;
        }

        Periodo otro = (Periodo) objeto;
        return (this.numero == otro.numero);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero);
    }

    @Override
    public String toString() {
        return "Periodo " + numero + " (" + etiquetaHorario() + ")";
    }
}
