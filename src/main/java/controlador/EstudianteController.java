package controlador;

import modelo.Estudiante;
import vista.EstudianteVista;

public class EstudianteController {
    private final Estudiante estudiante;
    private final EstudianteVista vista;
    private final Runnable alCerrarSesion;

    public EstudianteController(Estudiante estudiante, EstudianteVista vista, Runnable alCerrarSesion) {
        this.estudiante = estudiante;
        this.vista = vista;
        this.alCerrarSesion = alCerrarSesion;
    }

    public void iniciarVista() {
        vista.mostrarVentana();
        vista.setDatosEstudiante(estudiante.toString());
        vista.agregarCerrarSesionListener(e -> cerrarSesion());
    }

    public void cerrarSesion() {
        vista.cerrarVentana();
        alCerrarSesion.run();
    }
}
