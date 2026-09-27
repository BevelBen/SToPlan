package Planner.Modelos;

public class Periodo {
    private int dia;
    private int periodo;

    public Periodo(int dia, int periodo) {
        this.dia = dia;
        this.periodo = periodo;
    }

    // === GETTERS Y SETTERS ===

    public int getDia() {
        return dia;
    }

    public int getPeriodo() {
        return periodo;
    }

    // === MÉTODOS ===

    public boolean coincidenciaPeriodo(Periodo p) {
        return this.dia == p.getDia() && this.periodo == p.getPeriodo();
    }

    @Override
    public String toString() {
        return "Día: " + dia + " | Periodo: " + periodo;
    }

    // Override que se encarga de permitir la funcionalidad de
    // coincidencia de horario en Emparejador.java.

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Periodo)) {
            return false;
        }
        return coincidenciaPeriodo((Periodo) o);
    }
}
