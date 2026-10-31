package launcher;

import controlador.EstudianteController;
import controlador.LoginController;
import modelo.Administrador;
import modelo.Estudiante;
import modelo.Usuario;
import modelo.repositorio.memoria.UsuarioRepositorioMemoria;
import vista.EstudianteVista;
import vista.LoginVista;

public class Aplicacion {
    public void iniciar() {
        UsuarioRepositorioMemoria usuarios = new UsuarioRepositorioMemoria();
        LoginVista loginVista = new LoginVista();
        new LoginController(loginVista, usuarios, this::iniciarSesion).iniciarVista();
    }

    private void iniciarSesion(Usuario usuario) {
        if (usuario instanceof Estudiante) {
            iniciarSesionEstudiante((Estudiante) usuario);
        } else if (usuario instanceof Administrador) {
            iniciarSesionAdministrador((Administrador) usuario);
        }
    }

    private void iniciarSesionEstudiante(Estudiante estudiante) {
        EstudianteVista estudianteVista = new EstudianteVista();
        new EstudianteController(estudiante, estudianteVista).iniciarVista();
    }

    private void iniciarSesionAdministrador(Administrador administrador) {
        // TODO
        throw new UnsupportedOperationException("No se ha implementado la función.");
    }
}
