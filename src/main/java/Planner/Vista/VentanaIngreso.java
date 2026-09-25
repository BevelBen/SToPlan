package Planner.Vista;

import Planner.Servicios.GestorEstudiantes;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;


public class VentanaIngreso {
    // --- Componentes de la interfaz gráfica ---
    private final JFrame frame = new JFrame("LogIn - SToPlan");
    private final JPanel panelPrincipal = new JPanel();
    private final JPanel panelBotones = new JPanel();
    private final JLabel lblMatricula = new JLabel("Matricula:");
    private final JTextField txtMatricula = new JTextField();
    private final JLabel lblContraseña = new JLabel("Contraseña:");
    private final JPasswordField txtContraseña = new JPasswordField();
    private final JButton btnIngresar = new JButton("Ingresar");
    private final JButton btnRegistrar = new JButton("Registrar");
    private final Dimension dimensionGeneral = new Dimension(200, 30);


    //Mover luego a controlador
    private final GestorEstudiantes gestor = new GestorEstudiantes();

    //TODO: Configuracion de la ventana
    public VentanaIngreso() {

        SwingUtilities.invokeLater(() -> {
        frame.setSize(800, 600);;
        panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));
        panelPrincipal.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        panelPrincipal.setBorder(new EmptyBorder(200, 200, 0, 200));

        lblMatricula.setAlignmentX(Component.CENTER_ALIGNMENT);
        txtMatricula.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblContraseña.setAlignmentX(Component.CENTER_ALIGNMENT);
        txtContraseña.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnIngresar.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnRegistrar.setAlignmentX(Component.CENTER_ALIGNMENT);

        txtMatricula.setPreferredSize(dimensionGeneral);
        txtMatricula.setMaximumSize(dimensionGeneral);
        txtContraseña.setPreferredSize(dimensionGeneral);
        txtContraseña.setMaximumSize(dimensionGeneral);

        panelPrincipal.add(lblMatricula);
        panelPrincipal.add(txtMatricula);
        panelPrincipal.add(lblContraseña);
        panelPrincipal.add(txtContraseña);


        panelBotones.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        panelBotones.add(btnRegistrar);
        panelBotones.add(btnIngresar);


        //Modificar, solo para comprobar que funciona
        btnIngresar.addActionListener(e -> {verificarLogin();});
        //Se agregara la ventana registro despues
        //btnRegistrar.addActionListener(a -> "Metodo ventana registrar ");
            panelPrincipal.add(panelBotones);
            frame.add(panelPrincipal);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    });
    }
    public void mostrarVentana() {
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
    // TODO: Metodo utilizado para testear el funcionamiento, luego se modificara.
    private void verificarLogin() {

            if (gestor.verificarLogin(txtMatricula.getText(), new String(txtContraseña.getPassword())) == null) {
                JOptionPane.showMessageDialog(frame, "Matricula o contraseña no valida", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(frame, "Bienvenido usuario " + gestor.verificarLogin(txtMatricula.getText(), new String(txtContraseña.getPassword())));
                frame.dispose();
                //Iniciaria siguiente Ventana
            }

    }
}
