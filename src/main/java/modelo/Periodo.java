package modelo;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Representa un periodo de la universidad.
 */
public class Periodo {
    public static final int PERIODOS_EARLY = 4;
    public static final int PERIODOS_LATE = 6;
    public static final int DURACION_MINUTOS = 60;
    public static final int RECESO_MINUTOS = 10;

    public static final List<Periodo> PERIODOS_DIA = construirPeriodos();

    private final int numero;
    private final LocalTime horaInicio;
    private final LocalTime horaFin;

    public Periodo(int numero, LocalTime horaInicio, LocalTime horaFin) {
        this.numero = numero;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    public static List<Periodo> construirPeriodos() {
        List<Periodo> periodos = new ArrayList<>();
        int numero = 1;
        int paso = DURACION_MINUTOS + RECESO_MINUTOS;

        LocalTime inicio = LocalTime.of(8, 30);
        for (int i = 0; i < PERIODOS_EARLY; i++) {
            periodos.add(new Periodo(numero++, inicio, inicio.plusMinutes(DURACION_MINUTOS)));
            inicio = inicio.plusMinutes(paso);
        }

        inicio = LocalTime.of(14, 30);
        for (int i = 0; i < PERIODOS_LATE; i++) {
            periodos.add(new Periodo(numero++, inicio, inicio.plusMinutes(DURACION_MINUTOS)));
            inicio = inicio.plusMinutes(paso);
        }

        return List.copyOf(periodos);
    }

    public String etiquetaHorario() {
        return horaInicio + " " + horaFin;
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
