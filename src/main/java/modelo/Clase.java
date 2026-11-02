package modelo;

import java.util.Objects;

/**
 * Representa un ramo de la universidad.
 */
public record Clase(String codigo, String nombre) {

    public boolean verificarCodigo(String codigo) {
        return this.codigo.equals(codigo);
    }

    @Override
    public boolean equals(Object objeto) {
        if (objeto == null) {
            return false;
        }

        if (objeto.getClass() != this.getClass()) {
            return false;
        }

        Clase otro = (Clase) objeto;
        return codigo.equals(otro.codigo());
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }

    @Override
    public String toString() {
        return "Código: " + codigo + " | Nombre: " + nombre;
    }
}