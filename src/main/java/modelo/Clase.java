package modelo;

import java.util.Objects;

/**
 * Representa un ramo de la universidad.
 */
public class Clase {
    private final String codigo;
    private final String nombre;

    public Clase(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

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
        return codigo.equals(otro.getCodigo());
    }

    @Override
    public String toString() {
        return "Código: " + codigo + " | Nombre: " + nombre;
    }
}