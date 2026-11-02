package launcher;

import controlador.AdministradorController;
import controlador.EstudianteController;
import controlador.LoginController;
import modelo.Administrador;
import modelo.Estudiante;
import modelo.Usuario;
import modelo.repositorio.memoria.ClaseRepositorioMemoria;
import modelo.repositorio.memoria.UsuarioRepositorioMemoria;
import vista.AdministradorVista;
import vista.EstudianteVista;
import vista.LoginVista;

import java.time.Clock;

public class Aplicacion {
    private final LoginVista loginVista;
    private final UsuarioRepositorioMemoria usuarios;
    private final ClaseRepositorioMemoria clases;
    private final LoginController loginController;
    private final Clock reloj;

    public Aplicacion() {
        this.loginVista = new LoginVista();
        this.usuarios = new UsuarioRepositorioMemoria();
        this.clases = new ClaseRepositorioMemoria();
        this.loginController  = new LoginController(loginVista, usuarios, this::iniciarSesion);
        this.reloj = Clock.systemDefaultZone();
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
        new EstudianteController(estudiante, estudianteVista, this::cerrarSesion, reloj).iniciarVista();
    }

    private void iniciarSesionAdministrador(Administrador administrador) {
        AdministradorVista administradorVista = new AdministradorVista();
        new AdministradorController(administrador, administradorVista, clases, usuarios, this::cerrarSesion, reloj).iniciarVista();
    }

    private void cerrarSesion() {
        loginController.mostrarVista();
    }
}
