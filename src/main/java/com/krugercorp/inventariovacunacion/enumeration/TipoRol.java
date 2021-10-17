package com.krugercorp.inventariovacunacion.enumeration;

import java.util.Arrays;
import java.util.List;

/**
 * TipoRol.java clase enumeracion para clasificar los roles de usuarios
 *
 * @author jbalcazar
 */
public enum TipoRol {

    ADMINISTRADOR("Administrador"),
    EMPLEADO("Empleado");

    private final String descripcion;
    public static final List<TipoRol> ENUMS = Arrays.asList(TipoRol.values());

    private TipoRol(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

}
