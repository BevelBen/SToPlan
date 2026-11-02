package modelo.repositorio.memoria;

import modelo.Clase;
import modelo.repositorio.ClaseRepositorio;

import java.util.ArrayList;
import java.util.List;

public class ClaseRepositorioMemoria implements ClaseRepositorio {
    private final List<Clase> clases = new ArrayList<>();

    public ClaseRepositorioMemoria() {
        clases.add(new Clase("MAT101", "Multi"));
        clases.add(new Clase("FIS101", "Física 1"));
    }

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
