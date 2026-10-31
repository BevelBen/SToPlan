package modelo;

/**
 * Representa un administrador de la universidad (funcionario).
 */
public class Administrador extends Usuario {
    public Administrador(Rut rut, String nombre, String password) {
        super(rut, nombre, password);
    }

    @Override
    public String toString() {
        return "RUT: " + rut.formatear() + " | Nombre: " + nombre;
    }
}