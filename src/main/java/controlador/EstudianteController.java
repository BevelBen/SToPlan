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
    private LocalDate semana;

    public EstudianteController(Estudiante estudiante, EstudianteVista vista, Runnable alCerrarSesion, Clock reloj) {
        this.estudiante = estudiante;
        this.vista = vista;
        this.alCerrarSesion = alCerrarSesion;
        this.reloj = reloj;
        this.semana = Semana.inicioSemana(hoy());
    }

    /**
     * Establece el estado inicial de la vista.
     */
    public void iniciarVista() {
        vista.mostrarVentana();
        vista.setNombreEstudiante(estudiante.getNombre().toUpperCase());
        vista.setMatriculaEstudiante(estudiante.getMatricula());

        popularCalificador();

        // Listeners
        vista.agregarCerrarSesionListener(e -> cerrarSesion());
        vista.agregarAnteriorSemanaListener(e -> anteriorSemana());
        vista.agregarSiguienteSemanaListener(e -> siguienteSemana());

        refrescarNavegacion();
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

    private LocalDate semanaActual() {
        return Semana.inicioSemana(hoy());
    }

    private void popularCalificador() {
        Calificacion[] calificaciones = Calificacion.values();
        for (Calificacion c : calificaciones) {
            vista.popularCalificador(c.toString());
        }
    }

    private void refrescarNavegacion() {
        refrescarEtiquetaSemana();
        refrescarBotonesNavegacion();
    }

    private void refrescarEtiquetaSemana() {
        vista.setEtiquetaSemana(Semana.cadenaSemana(semana));
    }

    private void refrescarBotonesNavegacion() {
        vista.setAnteriorSemanaHabilitado(semana.isAfter(semanaActual()));
        vista.setSiguienteSemanaHabilitado(semana.isBefore(semanaActual().plusWeeks(10)));
    }

    private void anteriorSemana() {
        semana = semana.plusWeeks(-1);
        refrescarNavegacion();
    }

    private void siguienteSemana() {
        semana = semana.plusWeeks(1);
        refrescarNavegacion();
    }
}
