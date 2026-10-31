package launcher;

import controlador.LoginController;
import modelo.repositorio.memoria.UsuarioRepositorioMemoria;
import vista.LoginVista;

public class Aplicacion {
    public void iniciar() {
        UsuarioRepositorioMemoria usuarios = new UsuarioRepositorioMemoria();
        LoginVista loginVista = new LoginVista();
        new LoginController(loginVista, usuarios).iniciarVista();
    }
}
