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
}
