package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class EstudianteVista {
    private final JFrame frame = new JFrame();

    // encabezado       ------------------------------------------------------------------------------------------------
    private final JLabel lblNombreEstudiante = new JLabel();
    private final JLabel lblMatriculaEstudiante = new JLabel();
    private final JButton btnCerrarSesion = new JButton("Cerrar Sesión");

    // verSemana        ------------------------------------------------------------------------------------------------
    private final JButton btnAnteriorSemana = new JButton("Anterior Semana");
    private final JLabel lblEtiquetaSemana = new JLabel();
    private final JButton btnSiguienteSemana = new JButton("Siguiente Semana");

    // calificarSemana  ------------------------------------------------------------------------------------------------
    private final JComboBox<String> cmbCalificaciones = new JComboBox<>();
    private final JButton btnCalificar = new JButton("Aplicar Calificación");

    public EstudianteVista() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
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
        verSemana.add(new JLabel("TABLA", SwingConstants.CENTER), BorderLayout.CENTER);

        return verSemana;
    }

    private JPanel construirCalificarSemana() {
        JPanel calificarSemana = new JPanel(new BorderLayout());

        // SELECTOR DE CALIFICACIÓN A LA IZQUIERDA
        // popularCalificador();
        calificarSemana.add(cmbCalificaciones, BorderLayout.WEST);

        // APLICADOR DE CALIFICACIÓN A LA DERECHA
        calificarSemana.add(btnCalificar, BorderLayout.EAST);

        return calificarSemana;
    }

    private void popularCalificador() {
        // TODO
        throw new UnsupportedOperationException("No se ha implementado el método");
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

    public void setEtiquetaSemana(String etiquetaSemana) {
        lblEtiquetaSemana.setText(etiquetaSemana);
    }

    public void agregarSiguienteSemanaListener(ActionListener a) {
        btnSiguienteSemana.addActionListener(a);
    }

    public void agregarCalificarListener(ActionListener a) {
        btnCalificar.addActionListener(a);
    }

    public void cerrarVentana() {
        frame.dispose();
    }
}
