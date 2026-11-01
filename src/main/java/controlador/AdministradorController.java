package controlador;

import modelo.Administrador;
import vista.AdministradorVista;

import java.time.Clock;

public class AdministradorController {
    private final Administrador administrador;
    private final AdministradorVista vista;
    private final Runnable alCerrarSesion;
    private final Clock reloj;

    public AdministradorController(Administrador administrador, AdministradorVista vista, Runnable alCerrarSesion, Clock reloj) {
        this.administrador = administrador;
        this.vista = vista;
        this.alCerrarSesion = alCerrarSesion;
        this.reloj = reloj;
    }

    /**
     * Establece el estado inicial de la vista.
     */
    public void iniciarVista() {
        vista.mostrarVentana();
        vista.setDatosAdministrador(administrador.toString());
        vista.agregarCerrarSesionListener(e -> cerrarSesion());
    }

    /**
     * Lógica al cerrar la sesión.
     */
    private void cerrarSesion() {
        vista.cerrarVentana();
        alCerrarSesion.run();
    }
}
