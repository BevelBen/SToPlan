package modelo;

import java.util.Objects;

/**
 * Representa un usuario de la aplicación, ya sea un estudiante o un funcionario (administrador).
 */
public abstract class Usuario {
    protected final Rut rut;
    protected final String nombre;
    protected final String password;

    public Usuario(Rut rut, String nombre, String password) {
        this.rut = rut;
        this.nombre = nombre;
        this.password = password;
    }

    public Rut getRut() {
        return rut;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPassword() {
        return password;
    }

    public boolean iniciarSesion(String password) {
        return this.password.equals(password);
    }

    @Override
    public boolean equals(Object objeto) {
        if (objeto == null) {
            return false;
        }

        if (objeto.getClass() != this.getClass()) {
            return false;
        }

        final Usuario otro = (Usuario) objeto;
        return rut.equals(otro.rut);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getClass(), rut);
    }
}