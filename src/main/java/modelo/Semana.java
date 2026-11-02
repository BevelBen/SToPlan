package modelo;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

    public static LocalDate finSemana(LocalDate hoy) {
        if (hoy.getDayOfWeek() == DayOfWeek.SUNDAY) {
            return hoy.plusDays(6);
        }
        return hoy.with(TemporalAdjusters.nextOrSame(DayOfWeek.SATURDAY));
    }

    public static String cadenaSemana(LocalDate hoy) {
        return inicioSemana(hoy).format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + " - " + finSemana(hoy).format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
}
