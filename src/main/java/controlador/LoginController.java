package controlador;

import modelo.Rut;
import modelo.Usuario;
import modelo.repositorio.UsuarioRepositorio;
import vista.LoginVista;

import java.util.function.Consumer;

public class LoginController {
    private final LoginVista vista;
    private final UsuarioRepositorio usuarios;
    private final Consumer<Usuario> alIniciarSesion;

    public LoginController(LoginVista vista, UsuarioRepositorio usuarios, Consumer<Usuario> alIniciarSesion) {
        this.vista = vista;
        this.usuarios = usuarios;
        this.alIniciarSesion = alIniciarSesion;
    }

    /**
     * Establece el estado inicial de la vista.
     */
    public void iniciarVista() {
        vista.mostrarVentana();
        vista.agregarLoginListener(e -> intentarLogin());
    }

    /**
     * El intento inicial del login, rescata los datos de la vista.
     */
    private void intentarLogin() {
        try {
            Rut rut = leerRut();
            String password = leerPassword();
            Usuario usuario = usuarios.buscarPorRut(rut);

            procesarLogin(usuario, password);
        } catch (IllegalArgumentException | IllegalStateException e) {
            vista.mostrarError(e.getMessage());
        }
    }

    private Rut leerRut() {
        return Rut.generarRut(vista.getUsuario());
    }

    private String leerPassword() {
        return new String(vista.getPassword());
    }

    /**
     * Se procesan los datos del login y actúa sobre ello.
     * @param usuario el usuario en forma de cadena..
     * @param password la contraseña en forma de cadena.
     */
    private void procesarLogin(Usuario usuario, String password) {
        if (usuario == null) {
            vista.mostrarMensaje("No existe el usuario.");
        } else if (usuario.iniciarSesion(password)) {
            vista.limpiarCampos();
            iniciarSesion(usuario);
        } else {
            vista.mostrarMensaje("La clave es incorrecta.");
        }
    }

    /**
     * Lógica al iniciar sesión.
     * @param usuario
     */
    private void iniciarSesion(Usuario usuario) {
        vista.ocultarVentana();
        alIniciarSesion.accept(usuario);
    }

    public void mostrarVista() {
        vista.mostrarVentana();
    }
}
