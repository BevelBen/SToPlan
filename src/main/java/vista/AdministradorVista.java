package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class AdministradorVista {
    private final JFrame frame = new JFrame();
    private final JLabel lblDatosAdministrador = new JLabel();
    private final JButton btnCerrarSesion = new JButton();

    public AdministradorVista() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000,1000);
        frame.setLayout(new BorderLayout(8, 8));

        JPanel encabezado = new JPanel(new BorderLayout());
        encabezado.add(lblDatosAdministrador, BorderLayout.WEST);
        encabezado.add(btnCerrarSesion, BorderLayout.EAST);

        frame.add(encabezado, BorderLayout.CENTER);
    }

    public void mostrarVentana() {
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void setDatosAdministrador(String datos) {
        lblDatosAdministrador.setText(datos);
    }

    public void agregarCerrarSesionListener(ActionListener a) {
        btnCerrarSesion.addActionListener(a);
    }

    public void cerrarVentana() {
        frame.dispose();
    }
}