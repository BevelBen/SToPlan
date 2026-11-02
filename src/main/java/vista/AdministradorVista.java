package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class AdministradorVista {
    // encabezado ------------------------------------------------------------------------------------------------------
    private final JFrame frame = new JFrame();
    private final JLabel lblDatosAdministrador = new JLabel();
    private final JButton btnCerrarSesion = new JButton("Cerrar Sesión");

    // calcularPeriodos ------------------------------------------------------------------------------------------------

    // elegirEstudiantes -----------------------------------------------------------------------------------------------
    private final JComboBox<String> cmbClase = new JComboBox<>();
    private final DefaultListModel<String> modeloEstudiantes = new DefaultListModel<>();
    private final JList<String> lstEstudiantes = new JList<>(modeloEstudiantes);

    // cambiarSemana ---------------------------------------------------------------------------------------------------
    private final JButton btnAnteriorSemana = new JButton("Anterior Semana");
    private final JLabel lblEtiquetaSemana = new JLabel();
    private final JButton btnSiguienteSemana = new JButton("Siguiente Semana");

    // calcularPeriodos ------------------------------------------------------------------------------------------------
    private final JButton btnCalcularPeriodos = new JButton("Calcular Periodos");

    public AdministradorVista() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(1400,1000);
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

    private JPanel construirCalcularPeriodos() {
        JPanel panel = new JPanel(new BorderLayout());

        JPanel izquierda = new JPanel(new BorderLayout(0, 10));

        izquierda.add(cmbClase, BorderLayout.NORTH);
        izquierda.add(lstEstudiantes, BorderLayout.CENTER);
        izquierda.add(construirNavegacion(), BorderLayout.SOUTH);

        panel.add(izquierda, BorderLayout.WEST);

        JPanel derecha = new JPanel(new BorderLayout(0, 10));
        derecha.add(btnCalcularPeriodos, BorderLayout.NORTH);
        derecha.add(new JLabel("Aca se verán los resultados del calculador de periodos."), BorderLayout.CENTER);
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

    private JPanel construirNavegacion() {
        JPanel navegacion = new JPanel(new BorderLayout(5, 0));

        navegacion.add(btnAnteriorSemana, BorderLayout.WEST);
        navegacion.add(lblEtiquetaSemana, BorderLayout.CENTER);
        navegacion.add(btnSiguienteSemana, BorderLayout.EAST);

        return navegacion;
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

    public void agregarClase(String clase) {
        cmbClase.addItem(clase);
    }

    public void agregarClaseSeleccionadaListener(ActionListener a) {
        cmbClase.addActionListener(a);
    }

    public int getClaseSeleccionada() {
        return cmbClase.getSelectedIndex();
    }

    public void agregarListaEstudiantes(String estudiante) {
        modeloEstudiantes.addElement(estudiante);
    }

    public void limpiarListaEstudiantes() {
        modeloEstudiantes.clear();
    }

    public int[] getEstudiantesSeleccionados() {
        return lstEstudiantes.getSelectedIndices();
    }

    public void agregarAnteriorSemanaListener(ActionListener a) {
        btnAnteriorSemana.addActionListener(a);
    }

    public void setAnteriorSemanaHabilitado(boolean habilitado) {
        btnAnteriorSemana.setEnabled(habilitado);
    }

    public void setEtiquetaSemana(String etiqueta) {
        lblEtiquetaSemana.setText(etiqueta);
    }

    public void agregarSiguienteSemanaListener(ActionListener a) {
        btnSiguienteSemana.addActionListener(a);
    }

    public void setSiguienteSemanaHabilitado(boolean habilitado) {
        btnSiguienteSemana.setEnabled(habilitado);
    }

    public void agregarCalcularPeriodosListener(ActionListener a) {
        btnCalcularPeriodos.addActionListener(a);
    }

    public void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(frame, mensaje, "Ha ocurrido un error", JOptionPane.WARNING_MESSAGE);
    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(frame, mensaje);
    }
}