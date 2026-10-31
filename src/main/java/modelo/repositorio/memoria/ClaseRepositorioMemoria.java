package modelo.repositorio.memoria;

import modelo.Clase;
import modelo.repositorio.ClaseRepositorio;

import java.util.ArrayList;
import java.util.List;

public class ClaseRepositorioMemoria implements ClaseRepositorio {
    private final List<Clase> clases = new ArrayList<>();

    @Override
    public List<Clase> listarClases() {
        return List.copyOf(clases);
    }

    @Override
    public void guardarClase(Clase clase) {
        if (clases.contains(clase)) {
            throw new IllegalStateException("Ya existe una clase con dicho código.");
        }
        clases.add(clase);
    }
}
