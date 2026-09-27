package Planner;

import Planner.Servicios.Emparejador;
import Planner.Servicios.GestorEstudiantes;
import Planner.Vistas.VentanaIngreso;

public class Launcher {
    static void main(String[] args) {
        GestorEstudiantes gestorEstudiantes = new GestorEstudiantes();
        Emparejador emparejador = new Emparejador();
        VentanaIngreso ventanalogin = new VentanaIngreso();
        ventanalogin.mostrarVentana();
    }
}
