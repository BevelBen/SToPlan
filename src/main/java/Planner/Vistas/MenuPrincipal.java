package Planner.Vistas;

import Planner.Servicios.Emparejador;
import Planner.Servicios.GestorEstudiantes;

import java.util.Scanner;

public class MenuPrincipal {
    private Scanner scanner;
    private GestorEstudiantes gestorEstudiantes;
    private Emparejador emparejador;

    public MenuPrincipal() {
        scanner = new Scanner(System.in);
        gestorEstudiantes = new GestorEstudiantes();
        emparejador = new Emparejador();

        gestorEstudiantes.agregarEstudiante("22382508725", "Bnejmain", "123");
    }

    public void Menu() {
        while (true) {
            mostrarOpciones();
            int opcion = pedirOpcion(1, 3);
            if (verificarSalir(opcion)) {
                break;
            }
            ejecutarOpcion(opcion);
        }
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
            } catch (NumberFormatException e) {
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
        }

        IO.println("Contraseña correcta, ingresando al siguiente menu.");
    }
}
