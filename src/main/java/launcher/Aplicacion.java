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
    private final LoginVista loginVista;
    private final UsuarioRepositorioMemoria usuarios;
    private final LoginController loginController;

    public Aplicacion() {
        this.loginVista = new LoginVista();
        this.usuarios = new UsuarioRepositorioMemoria();
        this.loginController  = new LoginController(loginVista, usuarios, this::iniciarSesion);
    }

    public void iniciar() {
        loginController.iniciarVista();
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
        new EstudianteController(estudiante, estudianteVista, this::cerrarSesion).iniciarVista();
    }

    private void iniciarSesionAdministrador(Administrador administrador) {
        // TODO
        throw new UnsupportedOperationException("No se ha implementado la función.");
    }

    private void cerrarSesion() {
        loginController.mostrarVista();
    }
}
