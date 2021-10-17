package com.krugercorp.inventariovacunacion.enumeration;

import java.util.Arrays;
import java.util.List;

/**
 * TipoVacuna.java clase enumeracion para clasificar los tipos de vacunas aplicadas en la compañia
 *
 * @author jbalcazar
 */
public enum TipoVacuna {

    SPUTNIK("Sputnik"),
    ASTRAZENECA("AstraZeneca"),
    PFIZER("Pfizer"),
    JHONSON_JHONSON("Jhonson&Jhonson");

    private final String descripcion;
    public static final List<TipoVacuna> ENUMS = Arrays.asList(TipoVacuna.values());

    private TipoVacuna(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

}
