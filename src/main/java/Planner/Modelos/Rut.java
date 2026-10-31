package Planner.Modelos;

import java.util.Objects;

public final class Rut {
    private final String cuerpo;
    private final char dv;

    public Rut(String cuerpo, char dv) {
        this.cuerpo = cuerpo;
        this.dv = dv;
    }

    /**
     * Genera un objeto de la clase RUT a partir de un RUT en forma de cadena, ya sea con puntos y guion o sin.
     * @param rutCadena el RUT en forma de cadena.
     * @return el objeto RUT correspondiente a la cadena del RUT.
     */
    public static Rut generarRut(String rutCadena) {
        if (rutCadena == null) {
            throw new IllegalArgumentException("El rut no puede estar vacío.");
        }

        String limpio = rutCadena.trim().replace(".", "").replace("-", "").toUpperCase();

        if (!limpio.matches("\\d{7,9}[0-9K]")) {  // Expresión REGEX que contiene 7 a 9 dígitos seguidos por un
                                                        //  carácter del 0 al 9 o K.
            throw new IllegalArgumentException("El formato del rut no es valido.");
        }

        String cuerpo = limpio.substring(0, limpio.length() - 1);
        char dv = limpio.charAt(limpio.length() - 1);

        if (dv != calcularDigitoVerificador(cuerpo)) {
            throw new IllegalArgumentException("El rut no es valido.");
        }
        return new Rut(cuerpo, dv);
    }

    /**
     * Remueve los puntos y guion a partir de un RUT en forma de cadena.
     * @param rutCadena el RUT en forma de cadena.
     * @return el RUT sin puntos ni guion en forma de cadena.
     */
    public String limpiarRut(String rutCadena) {
        return rutCadena.replace(".", "").replace("-", "");
    }

    /**
     * Remueve los puntos y guion a partir del objeto RUT.
     * @return el RUT en forma de cadena sin puntos ni guion.
     */
    public String limpiarRut() {
        String rutCadena = this.cuerpo + this.dv;
        return limpiarRut(rutCadena);
    }

    /**
     * Un cálculo del dígito verificador a partir del cuerpo de un RUT, un cálculo en módulo 11.
     * @param cuerpo el cuerpo del RUT, corresponde al RUT sin el dígito verificador ni caracteres especiales.
     * @return el dígito verificador correspondiente al cuerpo.
     */
    public static char calcularDigitoVerificador(String cuerpo) {
        int suma = 0;
        int factor = 2;
        for (int i = cuerpo.length() - 1; i >= 0; i--) {
            suma += (cuerpo.charAt(i) - '0') * factor;  // Manipulación ASCII (e.g. '2' -> 0x32 y '0' -> 0x30 entonces
                                                        // '2' - '0' -> 2 como entero).
            factor = (factor == 7) ? 2 : factor + 1;
        }
        int resto = 11 - (suma % 11);
        if (resto == 11) {
            return '0';
        }
        if (resto == 10) {
            return 'K';
        }
        return (char) ('0' + resto);    // Manipulación ASCII ahora a la inversa, como '0' -> 0x30, '1' -> 0x31, ...
                                        // '9' -> 0x39 entonces al sumar el número al carácter '0' se obtiene el valor
                                        // del código ASCII en hexadecimal.
    }

    /**
     * La cadena RUT con puntos y guion a partir del objeto Rut.
     * @return
     */
    public String formatear() {
        String conPuntos = String.format("%,d", Long.parseLong(cuerpo)).replace(',', '.');
        return conPuntos + "-" + dv;
    }

    @Override
    public String toString() {
        return formatear();
    }

    @Override
    public boolean equals(Object objeto) {
        if (objeto == null) {
            return false;
        }
        if (objeto.getClass() != this.getClass()) {
            return false;
        }

        Rut otro = (Rut) objeto;
        return cuerpo.equals(otro.cuerpo) && dv == otro.dv;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cuerpo, dv);
    }
}