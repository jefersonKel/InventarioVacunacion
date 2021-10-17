/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.krugercorp.inventariovacunacion.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.krugercorp.inventariovacunacion.enumeration.TipoVacuna;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * EmpleadoModel.java clase entidad que contiene información de los empleados de
 * la compañia
 *
 * @author jbalcazar
 */
@Entity
@Table(name = "T_EMPLEADOS")
public class EmpleadoModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @Size(min = 10, max = 10)
    @NotEmpty(message = "Cédula. no debe estar vacío")
    @Column(name = "IDENTIFICACION", nullable = false, unique = true, length = 10)
    private String identificacion;

    @Pattern(regexp = "[a-zA-Z ]{2,100}")
    @NotEmpty(message = "Nombre no debe estar vacío")
    @Column(name = "NOMBRES", nullable = false, length = 100)
    private String nombres;

    @Pattern(regexp = "[a-zA-Z ]{2,100}")
    @NotEmpty(message = "Apellido no debe estar vacío")
    @Column(name = "APELLIDOS", nullable = false, length = 100)
    private String apellidos;

    @NotEmpty(message = "Correo electronico no debe estar vacío")
    @Email(message = "Correo electronico no valido")
    @Column(name = "CORREO_ELECTRONICO", nullable = false, length = 100)
    private String correoElectronico;

    @Column(name = "FECHA_NACIMIENTO")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaNacimiento;

    @Column(name = "DIRECCION_DOMICILIO", length = 250)
    private String DireccionDomicilio;

    @Column(name = "TELEFONO", length = 25)
    private String telefono;

    @Column(name = "ESTADO_VACUNACION")
    private boolean vacunado;

    @Column(name = "TIPO_VACUNA", length = 50)
    @Enumerated(EnumType.STRING)
    private TipoVacuna tipoVacuna;

    @Column(name = "FECHA_VACUNACION")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaVacunacion;

    @Column(name = "DOSIS")
    private int numeroDosis;

    public EmpleadoModel() {
    }

    public EmpleadoModel(Long id, String identificacion, String nombres, String apellidos, String correoElectronico, Date fechaNacimiento, String DireccionDomicilio, String telefono, boolean vacunado, TipoVacuna tipoVacuna, Date fechaVacunacion, int numeroDosis) {
        this.id = id;
        this.identificacion = identificacion;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correoElectronico = correoElectronico;
        this.fechaNacimiento = fechaNacimiento;
        this.DireccionDomicilio = DireccionDomicilio;
        this.telefono = telefono;
        this.vacunado = vacunado;
        this.tipoVacuna = tipoVacuna;
        this.fechaVacunacion = fechaVacunacion;
        this.numeroDosis = numeroDosis;
    }

    
    @JsonIgnore
    public String getNombresCompletos() {
        return apellidos + " " + nombres;
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

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDireccionDomicilio() {
        return DireccionDomicilio;
    }

    public void setDireccionDomicilio(String DireccionDomicilio) {
        this.DireccionDomicilio = DireccionDomicilio;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public boolean isVacunado() {
        return vacunado;
    }

    public void setVacunado(boolean vacunado) {
        this.vacunado = vacunado;
    }

    public TipoVacuna getTipoVacuna() {
        return tipoVacuna;
    }

    public void setTipoVacuna(TipoVacuna tipoVacuna) {
        this.tipoVacuna = tipoVacuna;
    }

    public Date getFechaVacunacion() {
        return fechaVacunacion;
    }

    public void setFechaVacunacion(Date fechaVacunacion) {
        this.fechaVacunacion = fechaVacunacion;
    }

    public int getNumeroDosis() {
        return numeroDosis;
    }

    public void setNumeroDosis(int numeroDosis) {
        this.numeroDosis = numeroDosis;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.id);
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
        final EmpleadoModel other = (EmpleadoModel) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Empleado{" + "id=" + id + ", identificacion=" + identificacion + ", nombres=" + nombres + ", apellidos=" + apellidos + ", correoElectronico=" + correoElectronico + ", fechaNacimiento=" + fechaNacimiento + ", DireccionDomicilio=" + DireccionDomicilio + ", telefono=" + telefono + ", vacunado=" + vacunado + ", tipoVacuna=" + tipoVacuna + ", fechaVacunacion=" + fechaVacunacion + ", numeroDosis=" + numeroDosis + '}';
    }

}
