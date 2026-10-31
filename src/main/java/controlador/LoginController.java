package controlador;

import modelo.Rut;
import modelo.Usuario;
import modelo.repositorio.UsuarioRepositorio;
import vista.LoginVista;

public class LoginController {
    private final LoginVista vista;
    private final UsuarioRepositorio usuarios;

    public LoginController(LoginVista vista, UsuarioRepositorio usuarios) {
        this.vista = vista;
        this.usuarios = usuarios;
    }

    public void iniciarVista() {
        vista.mostrarVentana();
        vista.agregarLoginListener(e -> intentarLogin());
    }

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

    private void procesarLogin(Usuario usuario, String password) {
        if (usuario == null) {
            vista.mostrarMensaje("No existe el usuario.");
        } else if (usuario.iniciarSesion(password)) {
            vista.limpiarCampos();
            vista.mostrarMensaje("Se inició sesión con éxito.");
        } else {
            vista.mostrarMensaje("La clave es incorrecta.");
        }
    }
}
