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

    public void Menu() {
        int opcion;
        do {
            mostrarOpciones();
            opcion = pedirOpcion(1, 8);
            ejecutarOpcion(opcion);
        } while (opcion != 8);
    }

    private void ejecutarOpcion(int o) {
        switch (o) {
            case 1:
                verEstudiantes();
                break;
            case 2:
                registrarEstudiante();
                break;
            case 3:
                eliminarEstudiante();
                break;
            case 4:
                agregarAsignatura();
                break;
            case 5:
                agregarAsignaturaInteres();
                break;
            case 6:
                eliminarAsignaturaInteres();
                break;
            case 7:
                horariosComunes();
                break;
            case 8:
                IO.println("Volviendo al menu principal...");
                break;
        }
    }

    private void mostrarOpciones() {
        IO.println("=== ESTUDIANTES ===");
        IO.println("1. Ver estudiantes inscritos");
        IO.println("2. Registrar un estudiante");
        IO.println("3. Eliminar un estudiante");
        IO.println("\n=== ASIGNATURAS ===");
        IO.println("4. Agregar una asignatura");
        IO.println("5. Asignar una asignatura a un estudiante");
        IO.println("6. Eliminar una asignatura a un estudiante");
        IO.println("\n=== GENERACION DE HORARIOS ===");
        IO.println("7. Generar horarios disponibles");
        IO.println("\n\n\n8. Volver");
    }

    private int pedirOpcion(int min, int max) {
        while (true) {
            try {
                int opcion;
                opcion = scanner.nextInt();
                if (min > opcion || opcion > max) {
                    IO.println("El numero debe estar entre " + min + " y " + max + ", intente denuevo.");
                } else {
                    return opcion;
                }
            } catch (InputMismatchException e) {
                IO.println("La opción debe ser un número, intente denuevo.");
            }
        }
    }

    private boolean verEstudiantes() {
        List<Estudiante> estudiantes = gestorEstudiantes.totalidadEstudiantes();
        if (estudiantes.isEmpty()) {
            IO.println("No hay estudiantes inscritos.");
            return false;
        }
        for (Estudiante e : estudiantes) {
            IO.println(" > " + e);
        }
        return true;
    }

}