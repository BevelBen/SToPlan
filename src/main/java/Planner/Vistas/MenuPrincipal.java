package Planner.Vistas;

import Planner.Modelos.Estudiante;
import Planner.Servicios.Emparejador;
import Planner.Servicios.GestorAsignaturas;
import Planner.Servicios.GestorEstudiantes;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuPrincipal {
    // DATOS PARA ACCEDER A LA CUENTA DE ADMINISTRADOR
    private final String ADMIN_PASSWORD = "admin";

    private Scanner scanner;
    private GestorEstudiantes gestorEstudiantes;
    private GestorAsignaturas gestorAsignaturas;
    private Emparejador emparejador;

    public MenuPrincipal() {
        scanner = new Scanner(System.in);
        gestorEstudiantes = new GestorEstudiantes();
        gestorAsignaturas = new GestorAsignaturas();
        emparejador = new Emparejador();

        gestorEstudiantes.agregarEstudiante("22382508725", "Benjmain", "123");
    }

    // === MÉTODOS ===

    public void Menu() {
        while (true) {
            mostrarOpciones();
            int opcion = pedirOpcion(1, 3);
            if (verificarSalir(opcion)) {
                break;
            }
            ejecutarOpcion(opcion);
        }
        IO.println("Saliendo del programa...");
    }

    private String pedirCadena() {
        return scanner.next();
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

    private void mostrarOpciones() {
        IO.println("1. Iniciar sesión como estudiante");
        IO.println("2. Iniciar sesión como administrador");
        IO.println("3. Salir");
    }

    private void ejecutarOpcion(int o) {
        switch (o) {
            case 1:
                inicioSesionEstudiante();
                break;
            case 2:
                inicioSesionAdministrador();
                break;
        }
    }

    private boolean verificarSalir(int o) {
        return o == 3;
    }

    private void inicioSesionEstudiante() {
        IO.println("Ingrese la matricula:");
        String matricula = pedirCadena();
        IO.println("Ingrese la contraseña:");
        String clave = pedirCadena();

        if (!gestorEstudiantes.existeMatricula(matricula)) {
            IO.println("No existe el usuario ingresado.");
            return;
        }

        if (gestorEstudiantes.verificarLogin(matricula, clave) == null) {
            IO.println("Contraseña incorrecta.");
            return;
        }

        IO.println("Contraseña correcta, ingresando al siguiente menu.");

        // TODO Aca se sigue a la funcionalidad del siguiente menu.
    }

    private void inicioSesionAdministrador() {
        IO.println("Ingrese la contraseña del admministrador");
        String clave = pedirCadena();

        if (!clave.equals(ADMIN_PASSWORD)) {
            IO.println("Contraseña del administrador incorrecta.");
            return;
        }

        IO.println("Contraseña correcta, ingresando al siguiente menu.");

        MenuAdministrador menuAdministrador = new MenuAdministrador(scanner, gestorEstudiantes, gestorAsignaturas, emparejador);
        menuAdministrador.Menu();
    }
}
