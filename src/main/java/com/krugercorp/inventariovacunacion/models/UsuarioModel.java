/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.krugercorp.inventariovacunacion.models;

import com.krugercorp.inventariovacunacion.enumeration.TipoRol;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * UsuarioModel.java clase entidad que contiene los usuarios para ingreso al
 * sistema
 *
 * @author jbalcazar
 */
@Entity
@Table(name = "T_USUARIOS")
public class UsuarioModel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(name = "IDENTIFICACION", nullable = false, unique = true, length = 10)
    private String identificacion;

    @Column(name = "CONTRASENA", nullable = false, length = 100)
    private String contrasena;

    @Column(name = "NOMBRES", nullable = false, length = 100)
    private String nombres;

    @Column(name = "ROL", nullable = false, length = 50)
    @Enumerated(EnumType.STRING)
    private TipoRol rol;

    public UsuarioModel() {
    }

    public UsuarioModel(Integer id, String identificacion, String contrasena, String nombres, TipoRol rol) {
        this.identificacion = identificacion;
        this.contrasena = contrasena;
        this.nombres = nombres;
        this.rol = rol;
    }

    public UsuarioModel(EmpleadoModel empleado) {
        this.identificacion = empleado.getIdentificacion();
        this.contrasena = empleado.getIdentificacion();
        this.nombres = empleado.getNombresCompletos();
        this.rol = TipoRol.EMPLEADO;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public TipoRol getRol() {
        return rol;
    }

    public void setRol(TipoRol rol) {
        this.rol = rol;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final UsuarioModel other = (UsuarioModel) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", identificacion=" + identificacion + ", contrasena=" + contrasena + ", nombres=" + nombres + ", rol=" + rol + '}';
    }

}
