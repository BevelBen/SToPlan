package controlador;

import modelo.Estudiante;
import vista.EstudianteVista;

public class EstudianteController {
    private final Estudiante estudiante;
    private final EstudianteVista vista;

    public EstudianteController(Estudiante estudiante, EstudianteVista vista) {
        this.estudiante = estudiante;
        this.vista = vista;
    }

    public void iniciarVista() {
        vista.mostrarVentana();
        vista.setDatosEstudiante(estudiante.toString());
    }
}
