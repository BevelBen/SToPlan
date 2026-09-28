package Planner.Vistas;

import Planner.Modelos.Asignatura;
import Planner.Modelos.Estudiante;
import Planner.Modelos.Periodo;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MenuEstudiante {
    private Scanner scanner;
    private Estudiante estudianteSesion;

    public MenuEstudiante(Scanner scanner, Estudiante estudianteSesion) {
        this.scanner = scanner;
        this.estudianteSesion = estudianteSesion;
    }

    public void Menu() {
        int opcion;
        do {
            mostrarOpciones();
            opcion = pedirOpcion(1, 5);
            ejecutarOpcion(opcion);
        } while (opcion != 5);
    }

    private void mostrarOpciones() {
        IO.println("1. Ver mis asignaturas asignadas");
        IO.println("2. Ver mi disponibilidad");
        IO.println("3. Agregar periodo de disponibilidad");
        IO.println("4. Eliminar periodo de disponibilidad");
        IO.println("\n\n\n5. Volver");
    }

    private int pedirOpcion(int min, int max) {
        while (true) {
            try {
                int opcion;
                opcion = Integer.valueOf(scanner.nextLine());
                if (min > opcion || opcion > max) {
                    IO.println("El numero debe estar entre " + min + " y " + max + ", intente denuevo.");
                } else {
                    return opcion;
                }
            } catch (InputMismatchException e) {
                IO.println("La opción debe ser un número, intente denuevo.");
            } catch (NumberFormatException e) {
                IO.println("La opción debe ser un número, intente denuevo.");
            }
        }
    }

    private void ejecutarOpcion(int o) {
        switch (o) {
            case 1:
                verAsignaturasInteresadas();
                break;
            case 2:
                verDisponibilidad();
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                IO.println("Volviendo al menu principal...");
                break;
        }
    }

    private void verAsignaturasInteresadas() {
        List<Asignatura> asignaturas = estudianteSesion.getAsignaturasInteresadas();
        if (asignaturas.isEmpty()) {
            IO.println("No posees asignaturas inscritas.");
            return;
        }
        for (Asignatura a : asignaturas) {
            IO.println(" > " + a);
        }
    }

    private void verDisponibilidad() {
        List<Periodo> periodos = estudianteSesion.getPeriodosDisponibilidad();
        if (periodos.isEmpty()) {
            IO.println("No tienes horarios disponibles.");
            return;
        }
        for (Periodo p : periodos) {
            IO.println(" > " + p);
        }
    }
}
