package vista;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ArrayList;

public class EstudianteVista {
    private final JFrame frame = new JFrame("Estudiante - Study Together Planner");

    // encabezado       ------------------------------------------------------------------------------------------------
    private final JLabel lblNombreEstudiante = new JLabel();
    private final JLabel lblMatriculaEstudiante = new JLabel();
    private final JButton btnCerrarSesion = new JButton("Cerrar Sesión");

    // verSemana        ------------------------------------------------------------------------------------------------
    private final JButton btnAnteriorSemana = new JButton("Anterior Semana");
    private final JLabel lblEtiquetaSemana = new JLabel();
    private final JButton btnSiguienteSemana = new JButton("Siguiente Semana");
    private final DefaultTableModel modeloTabla = new DefaultTableModel(12, 7);
    private final JTable tabla = new JTable(modeloTabla);

    // calificarSemana  ------------------------------------------------------------------------------------------------
    private final JComboBox<String> cmbCalificaciones = new JComboBox<>();
    private final JButton btnCalificar = new JButton("Aplicar Calificación");
    private final JButton btnEliminarDisponibilidad = new JButton("Eliminar Disponibilidad");

    public EstudianteVista() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(new BorderLayout(8, 8));
        ((JComponent) frame.getContentPane()).setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));

        frame.add(construirEncabezado(), BorderLayout.NORTH);
        frame.add(construirVerSemana(), BorderLayout.CENTER);
        frame.add(construirCalificarSemana(), BorderLayout.SOUTH);
    }

    private JPanel construirEncabezado() {
        JPanel encabezado = new JPanel(new BorderLayout());

        // DATOS DEL ESTUDIANTE A LA IZQUIERDA
        JPanel datosEstudiante = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.gridx = 0;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.anchor = GridBagConstraints.WEST;

        c.gridy = 0;
        c.insets = new Insets(0, 0, 2, 0);
        datosEstudiante.add(lblNombreEstudiante, c);

        c.gridy = 1;
        lblMatriculaEstudiante.setFont(lblMatriculaEstudiante.getFont().deriveFont(Font.PLAIN));
        datosEstudiante.add(lblMatriculaEstudiante, c);

        encabezado.add(datosEstudiante, BorderLayout.WEST);

        // BOTÓN DE CIERRE DE SESIÓN A LA DERECHA
        encabezado.add(btnCerrarSesion, BorderLayout.EAST);

        return encabezado;
    }

    private JPanel construirVerSemana() {
        JPanel verSemana = new JPanel(new BorderLayout());

        // NAVEGADOR DE SEMANAS ARRIBA
        JPanel navegadorSemana = new JPanel(new BorderLayout());

        navegadorSemana.add(btnAnteriorSemana, BorderLayout.WEST);

        lblEtiquetaSemana.setHorizontalAlignment(SwingConstants.CENTER);
        navegadorSemana.add(lblEtiquetaSemana, BorderLayout.CENTER);

        navegadorSemana.add(btnSiguienteSemana, BorderLayout.EAST);

        verSemana.add(navegadorSemana, BorderLayout.NORTH);

        // TABLA DE SEMANAS
        verSemana.add(construirTabla(), BorderLayout.CENTER);

        return verSemana;
    }

    private JScrollPane construirTabla() {
        tabla.setTableHeader(null);
        tabla.setCellSelectionEnabled(true);
        tabla.setRowHeight(32);
        tabla.getColumnModel().getColumn(0).setPreferredWidth(190);
        ((DefaultTableCellRenderer) tabla.getDefaultRenderer(Object.class)).setHorizontalAlignment(SwingConstants.CENTER);
        return new JScrollPane(tabla);
    }

    private JPanel construirCalificarSemana() {
        JPanel calificarSemana = new JPanel(new BorderLayout());

        // SELECTOR DE CALIFICACIÓN A LA IZQUIERDA
        // popularCalificador();
        calificarSemana.add(cmbCalificaciones, BorderLayout.WEST);

        // CONFIGURACIÓN DE DISPONIBILIDAD A LA DERECHA
        JPanel configuracionDisponibilidad = new JPanel(new BorderLayout(5, 0));
        configuracionDisponibilidad.add(btnCalificar, BorderLayout.WEST);
        configuracionDisponibilidad.add(btnEliminarDisponibilidad, BorderLayout.EAST);

        calificarSemana.add(configuracionDisponibilidad, BorderLayout.EAST);

        return calificarSemana;
    }

    public void setCelda(int fila, int columna, String texto) {
        modeloTabla.setValueAt(texto, fila, columna);
    }

    public List<int[]> getCeldasSeleccionadas() {
        List<int[]> seleccionadas = new ArrayList<>();
        for (int fila : tabla.getSelectedRows()) {
            for (int columna : tabla.getSelectedColumns()) {
                seleccionadas.add(new int[]{fila, columna});
            }
        }
        return seleccionadas;
    }

    public void limpiarSeleccion() {
        tabla.clearSelection();
    }

    public void popularCalificador(String item) {
        cmbCalificaciones.addItem(item);
    }

    public int getCalificacionSeleccionada() {
        return cmbCalificaciones.getSelectedIndex();
    }

    public void mostrarVentana() {
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void setNombreEstudiante(String nombre) {
        lblNombreEstudiante.setText(nombre);
    }

    public void setMatriculaEstudiante(String matricula) {
        lblMatriculaEstudiante.setText(matricula);
    }

    public void agregarCerrarSesionListener(ActionListener a) {
        btnCerrarSesion.addActionListener(a);
    }

    public void agregarAnteriorSemanaListener(ActionListener a) {
        btnAnteriorSemana.addActionListener(a);
    }

    public void setAnteriorSemanaHabilitado(boolean habilitado) {
        btnAnteriorSemana.setEnabled(habilitado);
    }

    public void setEtiquetaSemana(String etiquetaSemana) {
        lblEtiquetaSemana.setText(etiquetaSemana);
    }

    public void agregarSiguienteSemanaListener(ActionListener a) {
        btnSiguienteSemana.addActionListener(a);
    }

    public void setSiguienteSemanaHabilitado(boolean habilitado) {
        btnSiguienteSemana.setEnabled(habilitado);
    }

    public void agregarCalificarListener(ActionListener a) {
        btnCalificar.addActionListener(a);
    }

    public void agregarEliminarDisponibilidadListener(ActionListener a) {
        btnEliminarDisponibilidad.addActionListener(a);
    }

    public void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(frame, mensaje, "Ha ocurrido un error", JOptionPane.WARNING_MESSAGE);
    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(frame, mensaje);
    }

    public void cerrarVentana() {
        frame.dispose();
    }
}
