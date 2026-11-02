package modelo;

import java.time.LocalTime;

/**
 * Representa un periodo de la universidad.
 */
public enum Periodo {
    P1(1, 8, 30),
    P2(2, 9, 40),
    P3(3, 10, 50),
    P4(4, 12, 0),
    P5(5, 14, 30),
    P6(6, 15, 40),
    P7(7, 16, 50),
    P8(8, 18, 0),
    P9(9, 19, 10),
    P10(10, 20, 20);

    public static LocalTime HORA_INICIO_ALMUERZO = LocalTime.of(13, 0);
    public static LocalTime HORA_FIN_ALMUERZO = LocalTime.of(14, 10);

    private final int numero;
    private final LocalTime horaInicio;
    private final LocalTime horaFin;

    Periodo(int numero, int hora, int minuto) {
        this.numero = numero;
        this.horaInicio = LocalTime.of(hora, minuto);
        final int DURACION = 60;
        this.horaFin = horaInicio.plusMinutes(DURACION);
    }

    public static Periodo deNumero(int numero) {
        for (Periodo p : Periodo.values()) {
            if (p.getNumero() == numero) {
                return p;
            }
        }
        throw new IllegalArgumentException("No existe tal numero de periodo");
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

    public String etiquetaHorario() {
        return horaInicio + " " + horaFin;
    }

    @Override
    public String toString() {
        return "Periodo " + numero + " (" + etiquetaHorario() + ")";
    }
}
