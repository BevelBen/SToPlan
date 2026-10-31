package controlador;

import modelo.Administrador;
import vista.AdministradorVista;

public class AdministradorController {
    private final Administrador administrador;
    private final AdministradorVista vista;
    private final Runnable alCerrarSesion;

    public AdministradorController(Administrador administrador, AdministradorVista vista, Runnable alCerrarSesion) {
        this.administrador = administrador;
        this.vista = vista;
        this.alCerrarSesion = alCerrarSesion;
    }

    public void iniciarVista() {
        vista.mostrarVentana();
        vista.setDatosAdministrador(administrador.toString());
        vista.agregarCerrarSesionListener(e -> cerrarSesion());
    }

    private void cerrarSesion() {
        vista.cerrarVentana();
        alCerrarSesion.run();
    }
}
