package com.krugercorp.inventariovacunacion.excepcion;

/**
 * UsuarioException.java Clase de Exception para errores de la logica de
 * empleados
 *
 * @author jbalcazar
 */
public class EmpleadoException extends Exception {

    private static final long serialVersionUID = 1L;

    public EmpleadoException() {
        super();
    }

    public EmpleadoException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return getMessage();
    }

}
