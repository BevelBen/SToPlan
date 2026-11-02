package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class LoginVista {
    private final JFrame frame = new JFrame("Login - Study Together Planner");
    private final JTextField txtUsuario = new JTextField();
    private final JPasswordField txtPassword = new JPasswordField();
    private final JButton btnLogin = new JButton("Login");

    public LoginVista() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        frame.add(construirLogin(), BorderLayout.CENTER);
        frame.getRootPane().setDefaultButton(btnLogin);
        frame.pack();
    }

    private JPanel construirLogin() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(28, 40, 28, 40));

        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.anchor = GridBagConstraints.WEST;

        JLabel titulo = new JLabel("Study Together Planner", SwingConstants.CENTER);
        titulo.setFont(titulo.getFont().deriveFont(Font.BOLD, 22f));
        c.gridy = 0;
        c.insets = new Insets(0, 0, 0, 0);
        panel.add(titulo, c);

        c.gridy = 1;
        c.insets = new Insets(0, 0, 4, 0);
        panel.add(new JLabel("RUT"), c);

        txtUsuario.setPreferredSize(new Dimension(200, 32));
        c.gridy = 2;
        c.insets = new Insets(0, 0, 14, 0);
        panel.add(txtUsuario, c);

        c.gridy = 3;
        c.insets = new Insets(0, 0, 4, 0);
        panel.add(new JLabel("Clave"), c);

        txtPassword.setPreferredSize(new Dimension(280, 32));
        c.gridy = 4;
        c.insets = new Insets(0, 0, 22, 0);
        panel.add(txtPassword, c);

        btnLogin.setPreferredSize(new Dimension(280, 36));
        c.gridy = 5;
        panel.add(btnLogin, c);

        return panel;
    }

    public void mostrarVentana() {
        frame.setLocationRelativeTo(null);
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
