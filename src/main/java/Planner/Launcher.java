package Planner;

import Planner.Servicios.Emparejador;
import Planner.Servicios.GestorEstudiantes;

public class Launcher {
    static void main(String[] args) {
        GestorEstudiantes gestorEstudiantes = new GestorEstudiantes();
        Emparejador emparejador = new Emparejador();
    }
}
