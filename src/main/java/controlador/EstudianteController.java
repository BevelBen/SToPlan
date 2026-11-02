package controlador;

import modelo.*;
import vista.EstudianteVista;

import java.time.Clock;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

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

        iniciarTabla();
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
        refrescarTabla();
    }

    private void refrescarEtiquetaSemana() {
        vista.setEtiquetaSemana(Semana.cadenaSemana(semana));
    }

    private void refrescarBotonesNavegacion() {
        vista.setAnteriorSemanaHabilitado(semana.isAfter(semanaActual()));
        vista.setSiguienteSemanaHabilitado(semana.isBefore(semanaActual().plusWeeks(10)));
    }

    private void iniciarTabla() {
        vista.setCelda(0, 0, "Periodo");
        vista.setCelda(5, 0, "Almuerzo " + Periodo.HORA_INICIO_ALMUERZO + " - " + Periodo.HORA_FIN_ALMUERZO);
        for (int columna = 1; columna < 7; columna++) {
            vista.setCelda(5, columna, "Almuerzo");
        }
    }

    private void refrescarTabla() {
        for (int columna = 1; columna < 7; columna++) {
            DiaSemana dia = diaDeColumna(columna);
            vista.setCelda(0, columna, dia.getNombre() + " " + Semana.fechaDelDia(semana, dia.getDayOfWeek()).format(DateTimeFormatter.ofPattern("dd/MM")));
        }

        for (int fila = 1; fila < 12; fila++) {
            if (fila == 5) {
                continue;
            }
            Periodo periodo = periodoDeFila(fila);
            vista.setCelda(fila, 0, periodo.getNumero() + "° " + periodo.etiquetaHorario());
            for (int columna = 1; columna < 7; columna++) {
                vista.setCelda(fila, columna, textoDeCelda(new Franja(Semana.fechaDelDia(semana, diaDeColumna(columna).getDayOfWeek()), periodoDeFila(fila))));
            }
        }
    }

    private String textoDeCelda(Franja franja) {
        Optional<Clase> clase = estudiante.claseEn(franja);
        if (clase.isPresent()) {
            return clase.get().codigo();
        }
        if (!estudiante.esEditable(franja, hoy())) {
            return "-";
        }
        return estudiante.calificacionEn(franja).map(c -> String.valueOf(c.getValor())).orElse("");
    }

    private static Periodo periodoDeFila(int fila) {
        return Periodo.deNumero(fila < 5 ? fila : fila - 1);
    }

    private static DiaSemana diaDeColumna(int columna) {
        return DiaSemana.values()[columna - 1];
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
