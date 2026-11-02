package modelo;

import java.time.LocalDate;
import java.util.*;

/**
 * Representa un estudiante de la universidad.
 */
public class Estudiante extends Usuario {
    private final int yearIngreso;
    private final String matricula;
    private final Set<Clase> clases = new HashSet<>();
    private final Map<FranjaSemanal, Clase> horarioLectivo = new HashMap<>();
    private final Map<Franja, Calificacion> disponibilidades = new HashMap<>();

    public Estudiante(Rut rut, String nombre, String password, int yearIngreso) {
        super(rut, nombre, password);
        this.yearIngreso = yearIngreso;
        this.matricula = generarMatricula();
    }

    // Matricula

    private String generarMatricula() {
        return rut.limpiarRut() + yearIngreso % 100;
    }

    // Clases

    public boolean perteneceClase(Clase clase) {
        return clases.contains(clase);
    }

    public void agregarClase(Clase clase) {
        if (perteneceClase(clase)) {
            throw new IllegalStateException("El estudiante ya pertenece a esa clase.");
        }
        clases.add(clase);
    }

    public List<Clase> clasesEstudiante() {
        return List.copyOf(clases);
    }

    // Horario Lectivo

    public void agregarHorarioLectivo(FranjaSemanal franjaSemanal, Clase clase) {
        if (!perteneceClase(clase)) {
            throw new IllegalStateException("El estudiante no pertenece a esa clase.");
        }
        validarFranja(franjaSemanal, clase);
        horarioLectivo.put(franjaSemanal, clase);
    }

    private void validarFranja(FranjaSemanal franjaSemanal, Clase clase) {
        Clase actual = horarioLectivo.get(franjaSemanal);
        if (actual != null && !actual.equals(clase)) {
            throw new IllegalStateException("Choque de horario en " + franjaSemanal + ": ya tiene " + actual.getCodigo() + ".");
        }
    }

    public boolean ocupadoEn(Franja franja) {
        return horarioLectivo.containsKey(franja.semanal());
    }

    public Optional<Clase> claseEn(Franja franja) {
        return Optional.ofNullable(horarioLectivo.get(franja.semanal()));
    }

    // Disponibilidades

    public boolean esEditable(Franja franja, LocalDate hoy) {
        return franja.esFuturo(hoy) && !ocupadoEn(franja);
    }

    public void calificarEn(Franja franja, Calificacion calificacion, LocalDate hoy) {
        Objects.requireNonNull(calificacion);
        validarEditable(franja, hoy);
        disponibilidades.put(franja, calificacion);
    }

    public void quitarCalificacion(Franja franja, LocalDate hoy) {
        validarEditable(franja, hoy);
        disponibilidades.remove(franja);
    }

    public Optional<Calificacion> calificacionEn(Franja franja) {
        if (ocupadoEn(franja)) {
            return Optional.empty();
        }
        return Optional.ofNullable(disponibilidades.get(franja));
    }

    // Getters y Setters

    public String getMatricula() {
        return matricula;
    }

    public List<Clase> getClases() {
        return List.copyOf(clases);
    }

    public Map<FranjaSemanal, Clase> getHorarioLectivo() {
        return Collections.unmodifiableMap(new TreeMap<>(horarioLectivo));
    }

    // Validaciones ----------------------------------------------------------------------------------------------------

    private void validarEditable(Franja franja, LocalDate hoy) {
        if (!franja.esFuturo(hoy)) {
            throw new IllegalStateException("No se puede modificar un periodo que ya pasó o es de hoy.");
        }
        Optional<Clase> clase = claseEn(franja);
        if (clase.isPresent()) {
            throw new IllegalStateException("Tienes clase en ese periodo (" + clase.get().getCodigo() + ").");
        }
    }

    @Override
    public String toString() {
        return "Matrícula: " + matricula + " | Nombre: " + nombre;
    }
}
