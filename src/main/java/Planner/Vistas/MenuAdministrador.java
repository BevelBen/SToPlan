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

    private String pedirCadena() {
        return scanner.next();
    }

    private void registrarEstudiante() {
        IO.println("Ingrese la matrícula del estudiante:");
        String matricula = pedirCadena();
        IO.println("Ingrese el nombre del estudiante:");
        String nombre = pedirCadena();
        IO.println("Ingrese la contraseña del estudiante:");
        String password = pedirCadena();

        if (gestorEstudiantes.agregarEstudiante(matricula, nombre, password)) {
            IO.println("El estudiante fue ingresado exitosamente.");
            return;
        }
        IO.println("Ya existe un estudiante con la matrícula " + matricula);
    }

    private Estudiante escogerEstudiante() {
        List<Estudiante> estudiantes = gestorEstudiantes.totalidadEstudiantes();
        if (estudiantes.isEmpty()) {
            IO.println("No hay estudiantes inscritos.");
            return null;
        }
        verEstudiantes();
        IO.println("Ingrese la matricula del estudiante:");
        String matricula = pedirCadena();

        Estudiante estudiante = gestorEstudiantes.buscarPorMatricula(matricula);
        if (estudiante == null) {
            IO.println("No existe un estudiante con esa matrícula.");
        }
        return estudiante;
    }

    private void verAsignaturas() {
        List<Asignatura> asignaturas = gestorAsignaturas.totalidadAsignaturas();
        if (asignaturas.isEmpty()) {
            IO.println("No hay asignaturas registradas.");
            return;
        }
        for (Asignatura a : asignaturas) {
            IO.println(" > " + a);
        }
    }

    private void eliminarEstudiante() {
        if (gestorEstudiantes.cantidadEstudiantes() == 0) {
            IO.println("No hay estudiantes inscritos.");
            return;
        }
        verAsignaturas();
        IO.println("Ingrese la matrícula del estudiante que desea eliminar:");
        String matricula = pedirCadena();
        if (gestorEstudiantes.eliminarEstudiante(matricula)) {
            IO.println("El estudiante fue eliminado exitosamente.");
            return;
        }
        IO.println("La matrícula ingresada no existe.");
    }

    private void enumerarAsignaturas() {
        List<Asignatura> asignaturas = gestorAsignaturas.totalidadAsignaturas();
        if (asignaturas.isEmpty()) {
            IO.println("No hay asignaturas registradas.");
            return;
        }
        int i = 1;
        for (Asignatura a : asignaturas) {
            IO.println(i + ". " + a);
            i++;
        }
    }

}