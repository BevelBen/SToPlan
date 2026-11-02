package modelo;

import java.time.LocalDate;

public record FranjaSemanal(DiaSemana dia, Periodo periodo) {
    public FranjaSemanal(LocalDate dia, Periodo periodo) {
        this(DiaSemana.desdeDayOfWeek(dia.getDayOfWeek()), periodo);
    }

    @Override
    public String toString() {
        return dia.getAbreviatura() + periodo.getNumero();
    }
}
