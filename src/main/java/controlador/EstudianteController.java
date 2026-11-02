package controlador;

import modelo.Calificacion;
import modelo.Estudiante;
import modelo.Semana;
import vista.EstudianteVista;

import java.time.Clock;
import java.time.LocalDate;

public class EstudianteController {
    private final Estudiante estudiante;
    private final EstudianteVista vista;
    private final Runnable alCerrarSesion;
    private final Clock reloj;

    public EstudianteController(Estudiante estudiante, EstudianteVista vista, Runnable alCerrarSesion, Clock reloj) {
        this.estudiante = estudiante;
        this.vista = vista;
        this.alCerrarSesion = alCerrarSesion;
        this.reloj = reloj;
    }

    /**
     * Establece el estado inicial de la vista.
     */
    public void iniciarVista() {
        vista.mostrarVentana();
        vista.setNombreEstudiante(estudiante.getNombre().toUpperCase());
        vista.setMatriculaEstudiante(estudiante.getMatricula());
        vista.agregarCerrarSesionListener(e -> cerrarSesion());
        popularCalificador();
        semanaInicial();
    }

    /**
     * Lógica al cerrar la sesión.
     */
    public void cerrarSesion() {
        vista.cerrarVentana();
        alCerrarSesion.run();
    }

    /**
     * Rescata el día actual en el que se consulta.
     * @return el día de hoy.
     */
    private LocalDate hoy() {
        return LocalDate.now(reloj);
    }

    private void popularCalificador() {
        Calificacion[] calificaciones = Calificacion.values();
        for (Calificacion c : calificaciones) {
            vista.popularCalificador(c.toString());
        }
    }

    private void semanaInicial() {
        vista.setEtiquetaSemana(Semana.cadenaSemana(LocalDate.now(reloj)));
    }
}
