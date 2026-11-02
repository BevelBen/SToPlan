package modelo;

import java.time.LocalDate;

/**
 * Representa una fecha y periodo específico.
 */
public record Franja(LocalDate fecha, Periodo periodo) {
    public boolean esFuturo(LocalDate dia) {
        return fecha.isAfter(dia);
    }

    public FranjaSemanal semanal() {
        return new FranjaSemanal(fecha, periodo);
    }
}
