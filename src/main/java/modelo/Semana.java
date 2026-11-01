package modelo;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public final class Semana {
    private Semana() {
        // Esta clase está destinada a métodos comunes entre los dos controladores.
    }

    public static LocalDate inicioSemana(LocalDate hoy) {
        if (hoy.getDayOfWeek() == DayOfWeek.SUNDAY) {
            return hoy.plusDays(1);
        }
        return hoy.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
    }
}
