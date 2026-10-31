package modelo.repositorio.memoria;

import modelo.Clase;
import modelo.Estudiante;
import modelo.repositorio.UsuarioRepositorio;
import modelo.Rut;
import modelo.Usuario;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class UsuarioRepositorioMemoria implements UsuarioRepositorio {
    private final Map<Rut, Usuario> usuarios = new LinkedHashMap<>();

    public UsuarioRepositorioMemoria() {
        Estudiante estudianteNuevo = new Estudiante(Rut.generarRut("223825087"), "Benjamin", "24", 2025);
        guardarUsuario(estudianteNuevo);
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
