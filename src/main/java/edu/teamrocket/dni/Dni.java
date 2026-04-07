package edu.teamrocket.dni;

public class Dni {

    private final String dni;
    private Boolean numeroSano = false;
    private Boolean letraSana = false;
    private Boolean dniSano = false;
    private final byte LONGITUD_DNI = 9;
    private TablaAsignacion tabla = new TablaAsignacion();

    public Dni(String dni) {
        this.dni = dni;
    }

    public String getDni() {
        return dni;
    }

    public TablaAsignacion getTabla() {
        return tabla;
    }

    private void setNumeroSano(Boolean sano) {
        this.numeroSano = sano;
    }

    private Boolean isNumeroSano() {
        return this.numeroSano;
    }

    private void setLetraSana(Boolean sano) {
        this.letraSana = sano;
    }

    private Boolean isLetraSana() {
        return this.letraSana;
    }

    private void setDniSano(Boolean sano) {
        this.dniSano = sano;

    }

    private TablaAsignacion getTablaAsignacion() {
        return this.tabla;
    }

    String extraerParteNumericaDni() {
        return dni.substring(0, LONGITUD_DNI - 1);
    }

    Character extraerParteAlfabeticaDni() {
        return dni.charAt(dni.length() - 1);
    }

    Boolean isDniSano() {
        return this.dniSano;
    }

    Boolean isDniNumero(String cadena) {
        for (int i = 0; i < cadena.length(); i++) {
            if (!Character.isDigit(cadena.charAt(i))) {
                return false;
            } else
                ;
        }
        return true;
    }

    private Boolean checkLongitudDni() {
        return getDni().length() == this.LONGITUD_DNI;
    }

    public Boolean checkNumeroDni() {
        setNumeroSano(checkLongitudDni()
                && isDniNumero(extraerParteNumericaDni()));
        return isNumeroSano();
    }

    public Character obtenerLetra() {
        checkNumeroDni();
        if (isNumeroSano()) {
            return getTablaAsignacion().calcularLetra(extraerParteNumericaDni());
        } else {
            // si el DNI no esta bien formado
            return Character.MIN_VALUE;
        }
    }

    private Boolean checkLetraValida() {
        return extraerParteAlfabeticaDni().equals(obtenerLetra());
    }

    public Boolean checkLetra() {
        checkNumeroDni();
        if (isNumeroSano()) {
            setLetraSana(Character.isUpperCase(extraerParteAlfabeticaDni())
                    && checkLetraValida());
            return isLetraSana();
        } else {
            return false;
        }
    }

    public Boolean checkDni() {
        setDniSano(checkNumeroDni() && checkLetra());
        return isDniSano();
    }

}