package Planner.Modelos;

public class Asignatura {
    private String codigo;
    private String nombre;

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
        if (this == o) {
            return true;
        }
        if (!(o instanceof Asignatura)) {
            return false;
        }
        return codigo.equals(((Asignatura) o).getCodigo());
    }

    @Override
    public String toString() {
        return "Código: " + codigo + " | Nombre: " + nombre;
    }
}