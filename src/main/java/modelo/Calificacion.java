package modelo;

/**
 * Representa una calificación individual.
 */
public enum Calificacion {
    NO_ME_ACOMODA(1, "No me acomoda"),
    ME_SIENTO_INDIFERENTE(2, "Me siento indiferente"),
    ME_ACOMODA(3, "Se me acomoda");

    private final int valor;
    private final String etiqueta;

    Calificacion(int valor, String etiqueta) {
        this.valor = valor;
        this.etiqueta = etiqueta;
    }

    public int getValor() {
        return valor;
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    public static Calificacion desdeValor(int valor) {
        for (Calificacion c : Calificacion.values()) {
            if (c.getValor() == valor) {
                return c;
            }
        }
        throw new IllegalArgumentException("No existe tal calificación.");
    }

    @Override
    public String toString() {
        return valor + " - " + etiqueta;
    }
}
