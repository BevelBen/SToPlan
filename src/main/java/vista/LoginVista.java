package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class LoginVista {
    private final JFrame frame = new JFrame("Login");
    private final JTextField txtUsuario = new JTextField();
    private final JPasswordField txtPassword = new JPasswordField();
    private final JButton btnLogin = new JButton("Login");

    public LoginVista() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(500,500);
        frame.setLayout(new GridLayout(5, 1, 5, 5));
        frame.setLocationRelativeTo(null);

        frame.add(new JLabel("Usuario:"));
        frame.add(txtUsuario);
        frame.add(new JLabel("Contraseña"));
        frame.add(txtPassword);
        frame.add(btnLogin);
    }

    public void mostrarVentana() {
        frame.setVisible(true);
    }

    public void ocultarVentana() {
        frame.setVisible(false);
    }

    public void limpiarCampos() {
        txtUsuario.setText("");
        txtPassword.setText("");
    }

    public String getUsuario() {
        return txtUsuario.getText();
    }

    public char[] getPassword() {
        return txtPassword.getPassword();
    }

    public void agregarLoginListener(ActionListener a) {
        btnLogin.addActionListener(a);
    }

    public void mostrarError(String errorMessage) {
        JOptionPane.showMessageDialog(frame, errorMessage, "Ha ocurrido un error", JOptionPane.WARNING_MESSAGE);
    }

    public void mostrarMensaje(String dialogMessage) {
        JOptionPane.showMessageDialog(frame, dialogMessage);
    }
}
