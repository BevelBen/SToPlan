package controlador;

import modelo.repositorio.UsuarioRepositorio;
import vista.LoginVista;

public class LoginController {
    private final LoginVista vista;
    private final UsuarioRepositorio usuarios;

    public LoginController(LoginVista vista, UsuarioRepositorio usuarios) {
        this.vista = vista;
        this.usuarios = usuarios;
    }
}
