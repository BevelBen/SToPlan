package modelo;

import java.time.DayOfWeek;

public enum DiaSemana {
    LUNES("Lunes", "LU", DayOfWeek.MONDAY),
    MARTES("Martes", "MA", DayOfWeek.TUESDAY),
    MIERCOLES("Miércoles", "MI", DayOfWeek.WEDNESDAY),
    JUEVES("Jueves", "JU", DayOfWeek.THURSDAY),
    VIERNES("Viernes", "VI", DayOfWeek.FRIDAY),
    SABADO("Sábado", "SA", DayOfWeek.SATURDAY),
    DOMINGO("Domingo", "DO", DayOfWeek.SUNDAY);

    private final String nombre;
    private final String abreviatura;
    private final DayOfWeek dayOfWeek;

    DiaSemana(String nombre, String abreviatura, DayOfWeek dayOfWeek) {
        this.nombre = nombre;
        this.abreviatura = abreviatura;
        this.dayOfWeek = dayOfWeek;
    }

    public static DiaSemana desdeDayOfWeek(DayOfWeek dia) {
        return values()[dia.getValue() - 1];
    }

    public String getNombre() {
        return nombre;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }
}
