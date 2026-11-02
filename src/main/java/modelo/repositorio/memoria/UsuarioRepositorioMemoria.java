package modelo.repositorio.memoria;

import modelo.*;
import modelo.repositorio.UsuarioRepositorio;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class UsuarioRepositorioMemoria implements UsuarioRepositorio {
    private final Map<Rut, Usuario> usuarios = new LinkedHashMap<>();

    public UsuarioRepositorioMemoria() {
        Estudiante estudiante1 = new Estudiante(Rut.generarRut("223825087"), "Benjamín Rodrigo Morales Moreno", "24", 2025);
        guardarUsuario(estudiante1);

        // Clases

        Clase multivariable = new Clase("MAT101", "Multi");
        estudiante1.agregarClase(multivariable);
        estudiante1.agregarHorarioLectivo(new FranjaSemanal(DiaSemana.MARTES, Periodo.P3), multivariable);
        estudiante1.agregarHorarioLectivo(new FranjaSemanal(DiaSemana.MARTES, Periodo.P2), multivariable);

        // -----

        Estudiante estudiante2 = new Estudiante(Rut.generarRut("108704578"), "NuevoEstudiante", "24", 2023);
        guardarUsuario(estudiante2);

        // Clases

        Clase fisica = new Clase("FIS101", "Física 1");
        estudiante2.agregarClase(multivariable);
        estudiante2.agregarClase(fisica);
        estudiante2.agregarHorarioLectivo(new FranjaSemanal(DiaSemana.JUEVES, Periodo.P7), multivariable);

        // -----

        Administrador administrador1 = new Administrador(Rut.generarRut("11.111.111-1"), "Funcionario1", "admin");
        guardarUsuario(administrador1);
    }

    @Override
    public void guardarUsuario(Usuario usuario) {
        if (usuarios.containsKey(usuario.getRut())) {
            throw new IllegalStateException("Ya existe un usuario con ese rut.");
        }
        usuarios.put(usuario.getRut(), usuario);
    }

    @Override
    public Usuario buscarPorRut(Rut rut) {
        return usuarios.get(rut);
    }

    @Override
    public List<Estudiante> listarEstudiantes() {
        return usuarios.values().stream().filter(u -> u instanceof Estudiante).map(u -> (Estudiante) u).toList();
    }

    @Override
    public List<Estudiante> buscarPorClase(Clase clase) {
        return listarEstudiantes().stream().filter(e -> e.perteneceClase(clase)).toList();
    }
}
