package Planner.Vistas;

import Planner.Modelos.Asignatura;
import Planner.Modelos.Estudiante;
import Planner.Modelos.Periodo;
import Planner.Servicios.Emparejador;
import Planner.Servicios.GestorAsignaturas;
import Planner.Servicios.GestorEstudiantes;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MenuAdministrador {
    private Scanner scanner;
    private GestorEstudiantes gestorEstudiantes;
    private GestorAsignaturas gestorAsignaturas;
    private Emparejador emparejador;

    public MenuAdministrador(Scanner scanner, GestorEstudiantes gestorEstudiantes, GestorAsignaturas gestorAsignaturas, Emparejador emparejador) {
        this.scanner = scanner;
        this.gestorEstudiantes = gestorEstudiantes;
        this.gestorAsignaturas = gestorAsignaturas;
        this.emparejador = emparejador;
    }
}