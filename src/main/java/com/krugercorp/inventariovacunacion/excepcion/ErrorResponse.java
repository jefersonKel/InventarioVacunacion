/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.krugercorp.inventariovacunacion.excepcion;

import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jbalcazar
 */
@XmlRootElement(name = "error")
public class ErrorResponse {

    public ErrorResponse(String message, List<String> details) {
        super();
        this.message = message;
        this.details = details;
    }

    private String message;
    private List<String> details;

}
