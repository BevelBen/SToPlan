package modelo.repositorio;

import modelo.Clase;
import modelo.Estudiante;
import modelo.Rut;
import modelo.Usuario;

import java.util.List;

public interface UsuarioRepositorio {
    void guardarUsuario(Usuario usuario);
    Usuario buscarPorRut(Rut rut);
    List<Estudiante> listarEstudiantes();
    List<Estudiante> buscarPorClase(Clase clase);
}
