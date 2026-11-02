package modelo;

import java.time.LocalDate;
import java.util.List;

/**
 * Calcula los mejores periodos dado un grupo de estudiantes y una semana en concreto.
 */
public class CalculadorPeriodos {

    /**
     * Calcula los mejores periodos en una semana dada una lista de estudiantes.
     */
    public String calcularPeriodos(List<Estudiante> estudianteList, LocalDate inicioSemana) {
        // TODO (Método de prueba);
        StringBuilder stringBuilder = new StringBuilder();
        for (Estudiante e : estudianteList) {
            stringBuilder.append(e.toString()).append("\n");
        }
        stringBuilder.append(inicioSemana);
        return stringBuilder.toString();
    }
}
