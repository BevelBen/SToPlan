package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class AdministradorVista {
    private final JFrame frame = new JFrame();
    private final JLabel lblDatosAdministrador = new JLabel();
    private final JButton btnCerrarSesion = new JButton("Cerrar Sesión");

    public AdministradorVista() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(800,600);
        frame.setLayout(new BorderLayout(8, 8));
        ((JComponent) frame.getContentPane()).setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));

        JPanel encabezado = new JPanel(new BorderLayout());
        encabezado.add(lblDatosAdministrador, BorderLayout.WEST);
        encabezado.add(btnCerrarSesion, BorderLayout.EAST);
        frame.add(encabezado, BorderLayout.NORTH);

        JTabbedPane tabs = new JTabbedPane();
        tabs.addTab("Calcular periodos", construirCalcularPeriodos());
        tabs.addTab("Estudiantes", construirEditarEstudiantes());
        frame.add(tabs, BorderLayout.CENTER);
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

    private JPanel construirCalcularPeriodos() {
        JPanel panel = new JPanel(new BorderLayout());

        JPanel izquierda = new JPanel();
        izquierda.add(new JLabel("Elegir estudiantes y clase"));
        panel.add(izquierda, BorderLayout.WEST);

        JPanel derecha = new JPanel();
        derecha.add(new JLabel("Ver resultados y calcular los periodos, elegir semana"));
        panel.add(derecha, BorderLayout.EAST);

        return panel;
    }

    private JPanel construirEditarEstudiantes() {
        JPanel panel = new JPanel(new BorderLayout());

        JPanel arriba = new JPanel();
        arriba.add(new JLabel("Registrar estudiantes"));
        panel.add(arriba, BorderLayout.NORTH);

        JPanel abajo = new JPanel();
        abajo.add(new JLabel("Ver estudiantes en tabla"));
        panel.add(abajo, BorderLayout.SOUTH);

        return panel;
    }
}