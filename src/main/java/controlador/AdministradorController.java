package controlador;

import modelo.*;
import modelo.repositorio.ClaseRepositorio;
import modelo.repositorio.UsuarioRepositorio;
import vista.AdministradorVista;

import java.time.Clock;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AdministradorController {
    private final Administrador administrador;
    private final AdministradorVista vista;
    private final ClaseRepositorio clases;
    private final UsuarioRepositorio usuarios;
    private final CalculadorPeriodos calculadorPeriodos;
    private final Runnable alCerrarSesion;
    private final Clock reloj;
    private LocalDate semana;
    private List<Clase> clasesMostradas;
    private List<Estudiante> estudiantesMostrados;

    public AdministradorController(Administrador administrador, AdministradorVista vista, ClaseRepositorio clases, UsuarioRepositorio usuarios, Runnable alCerrarSesion, Clock reloj) {
        this.administrador = administrador;
        this.vista = vista;
        this.clases = clases;
        this.usuarios = usuarios;
        this.calculadorPeriodos = new CalculadorPeriodos();
        this.alCerrarSesion = alCerrarSesion;
        this.reloj = reloj;
        this.semana = Semana.inicioSemana(hoy());
    }

    /**
     * Establece el estado inicial de la vista.
     */
    public void iniciarVista() {
        vista.mostrarVentana();
        vista.setDatosAdministrador(administrador.toString());
        vista.agregarCerrarSesionListener(e -> cerrarSesion());
        vista.agregarAnteriorSemanaListener(e -> anteriorSemana());
        vista.agregarSiguienteSemanaListener(e -> siguienteSemana());
        vista.agregarClaseSeleccionadaListener(e -> alCambiarClase());
        vista.agregarCalcularPeriodosListener(e -> calcularPeriodos());

        refrescarNavegacion();
        actualizarClases();
    }

    /**
     * Lógica al cerrar la sesión.
     */
    private void cerrarSesion() {
        vista.cerrarVentana();
        alCerrarSesion.run();
    }

    private LocalDate hoy() {
        return LocalDate.now(reloj);
    }

    private LocalDate semanaActual() {
        return Semana.inicioSemana(hoy());
    }

    private void actualizarClases() {
        clasesMostradas = clases.listarClases();
        for (Clase c : clasesMostradas) {
            vista.agregarClase(c.toString());
        }
    }

    private void alCambiarClase() {
        actualizarEstudiantes();
    }

    private void actualizarEstudiantes() {
        int indice = vista.getClaseSeleccionada();
        Clase clase = clasesMostradas.get(indice);
        estudiantesMostrados = usuarios.buscarPorClase(clase);
        vista.limpiarListaEstudiantes();
        for (Estudiante e : estudiantesMostrados) {
            vista.agregarListaEstudiantes(e.toString());
        }
    }

    private void refrescarNavegacion() {
        refrescarBotonesNavegacion();
        refrescarEtiquetaSemana();
    }

    private void refrescarBotonesNavegacion() {
        vista.setAnteriorSemanaHabilitado(semana.isAfter(semanaActual()));
        vista.setSiguienteSemanaHabilitado(semana.isBefore(semanaActual().plusWeeks(10)));
    }


    private void refrescarEtiquetaSemana() {
        vista.setEtiquetaSemana(Semana.cadenaSemana(semana));
    }

    private void anteriorSemana() {
        semana = semana.plusWeeks(-1);
        refrescarNavegacion();
    }

    private void siguienteSemana() {
        semana = semana.plusWeeks(1);
        refrescarNavegacion();
    }

    private void calcularPeriodos() {
        List<Estudiante> estudiantesSeleccionados = getEstudiantesSeleccionados();
        vista.mostrarMensaje(calculadorPeriodos.calcularPeriodos(estudiantesSeleccionados, semana));
    }

    private List<Estudiante> getEstudiantesSeleccionados() {
        int[] indices = vista.getEstudiantesSeleccionados();
        List<Estudiante> estudiantesSeleccionados = new ArrayList<>();
        for (int i : indices) {
            estudiantesSeleccionados.add(estudiantesMostrados.get(i));
        }
        return estudiantesSeleccionados;
    }
}
