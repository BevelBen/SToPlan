package vista;

import javax.swing.*;
import java.awt.*;

public class LoginVista {
    private final JFrame frame = new JFrame("Login");
    private final JTextField txtUsuario = new JTextField();
    private final JPasswordField txtPassword = new JPasswordField();
    private final JButton btnLogin = new JButton("Login");

    public LoginVista() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(500,500);
        frame.setLayout(new FlowLayout());

        frame.add(new JLabel("Usuario:"));
        frame.add(txtUsuario);
        frame.add(new JLabel("Contraseña"));
        frame.add(txtPassword);
        frame.add(btnLogin);
    }

    public void mostrarVentana() {
        frame.setVisible(true);
    }

    public void limpiarCampos() {
        txtUsuario.setText("");
        txtPassword.setText("");
    }
}
