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
                agregarPeriodoDisponibilidad();
                break;
            case 4:
                eliminarPeriodoDisponibilidad();
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

    private void agregarPeriodoDisponibilidad() {
        IO.println("Ingrese el día de disponibilidad:\n1. Lunes\n2. Martes\n3. Miércoles\n4. Jueves\n5. Viernes\n6. Sabado");
        int dia = pedirOpcion(1, 5);
        IO.println("Ingrese el periodo de disponibilidad:\n1. 8:30 - 9:30\n2. 9:40-10:40\n3. 10:50-11:50\n4. 12:00-13:00\n5. 14:30-15:30\n6. 15:40-16:40\n7. 16:50-17:50\n8. 18:00-19:00\n9. 19:10-20:10\n10. 20:20-21:20");
        int periodo = pedirOpcion(1, 10);

        Periodo nuevoPeriodo = new Periodo(dia, periodo);
        if (estudianteSesion.agregarDisponibilidad(nuevoPeriodo)) {
            IO.println("El periodo fue agregado exitosamente.");
            return;
        }
        IO.println("El periodo ya se encontraba ingresado.");
    }

    private void eliminarPeriodoDisponibilidad() {
        List<Periodo> periodos = estudianteSesion.getPeriodosDisponibilidad();
        if (periodos.isEmpty()) {
            IO.println("No se encuentran periodos registrados.");
            return;
        }
        enumerarDisponibilidad();
        IO.println("Ingrese el número del periodo que desea eliminar:");
        int opcion = pedirOpcion(1, periodos.size());

        Periodo periodoEliminado = periodos.get(opcion - 1);
        estudianteSesion.eliminarDisponibilidad(periodoEliminado);
        IO.println("El periodo ha sido elininado exitosamente.");
    }

    private void enumerarDisponibilidad() {
        List<Periodo> periodos = estudianteSesion.getPeriodosDisponibilidad();
        if (periodos.isEmpty()) {
            IO.println("No tienes horarios disponibles.");
            return;
        }
        int i = 1;
        for (Periodo p : periodos) {
            IO.println(i + ". " + p);
            i++;
        }
    }
}
