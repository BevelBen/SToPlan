package Planner.Modelos;

public class Asignatura {
    private final String codigo;
    private final String nombre;

    public Asignatura(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    // === GETTERS Y SETTERS ===

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    // === MÉTODOS ===

    public boolean verificarCodigo(String codigo) {
        return this.codigo.equals(codigo);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }

        if (o.getClass() != this.getClass()) {
            return false;
        }

        Asignatura otro = (Asignatura) o;
        return codigo.equals(otro.getCodigo());
    }

    @Override
    public String toString() {
        return "Código: " + codigo + " | Nombre: " + nombre;
    }
}