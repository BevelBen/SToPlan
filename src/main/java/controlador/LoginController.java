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
            Rut rut = Rut.generarRut(vista.getUsuario());
            String password = new String(vista.getPassword());
            Usuario usuario = usuarios.buscarPorRut(rut);

            if (usuario == null) {
                vista.mostrarMensaje("No existe el usuario.");
            } else if (usuario.iniciarSesion(password)) {
                vista.limpiarCampos();
                vista.mostrarMensaje("Se inició sesión con éxito.");
            } else {
                vista.mostrarMensaje("La clave es incorrecta.");
            }
        } catch (IllegalArgumentException | IllegalStateException e) {
            vista.mostrarError(e.getMessage());
        }
    }
}
