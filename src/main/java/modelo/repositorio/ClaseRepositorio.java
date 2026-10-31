package modelo.repositorio;

import modelo.Clase;

import java.util.List;

public interface ClaseRepositorio {
    List<Clase> listarClases();
    void guardarClase(Clase clase);
}
