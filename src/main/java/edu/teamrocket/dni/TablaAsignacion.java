package edu.teamrocket.dni;

public class TablaAsignacion {
    private final char[] tabla = { 'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D',
            'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L',
            'C', 'K', 'E' };

    char calcularLetra(String numeroDni) {
        int dni = Integer.parseInt(numeroDni);
        return getLetra(dni % 23);
    }

    char getLetra(int position) throws ArrayIndexOutOfBoundsException {
        try {
            return this.tabla[position];
        } catch (ArrayIndexOutOfBoundsException exception) {
            throw new ArrayIndexOutOfBoundsException(
                    "Posicion fuera de los limites de la tabla de asignacion");
        }

    }

    Boolean isLetraPermitida(char letra) {
        String tablaString = String.valueOf(tabla);
        return tablaString.contains(Character.toString(letra));
    }

}