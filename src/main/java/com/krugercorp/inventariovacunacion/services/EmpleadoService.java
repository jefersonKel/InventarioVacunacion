package com.krugercorp.inventariovacunacion.services;

import com.krugercorp.inventariovacunacion.enumeration.TipoVacuna;
import com.krugercorp.inventariovacunacion.excepcion.EmpleadoException;
import com.krugercorp.inventariovacunacion.models.EmpleadoModel;
import com.krugercorp.inventariovacunacion.models.UsuarioModel;
import com.krugercorp.inventariovacunacion.repositories.EmpleadoRepository;
import com.krugercorp.inventariovacunacion.repositories.UsuarioRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * UsuarioService.java clase de servicios para empleados de la compañia
 *
 * @author jbalcazar
 */
@Service
public class EmpleadoService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    EmpleadoRepository empleadoRepository;

    /**
     * Modifica/Guardar datos del empleado. Si la entidad tiene id este se
     * guarada caso contrario se modifica, al guardar un empleado nuevo se crea
     * un usuario para que pueda ingredar al sistema
     *
     * @param empleado
     * @return
     */
    public EmpleadoModel guardarUsuario(EmpleadoModel empleado) {
        EmpleadoModel empleadoNuevo = empleadoRepository.save(empleado);
        UsuarioModel usuario = usuarioRepository
                .findByIdentificacion(empleadoNuevo.getIdentificacion()).orElse(new UsuarioModel());
        System.out.println("usuario: " + usuario.toString());
        if (usuario.getId() == null) {
            UsuarioModel usuarioNuevo = new UsuarioModel(empleadoNuevo);
            usuarioRepository.save(usuarioNuevo);
        }
        return empleadoNuevo;
    }

    /**
     * Actualizo la información del empleado
     *
     * @param empleado entidad empleado que va a modificar
     * @return
     * @throws com.krugercorp.inventariovacunacion.excepcion.EmpleadoException
     */
    public EmpleadoModel ActualizarInformacion(EmpleadoModel empleado) throws EmpleadoException {
        EmpleadoModel empleadoOld = empleadoRepository.findById(empleado.getId()).orElse(null);

        if (empleadoOld == null) {
            throw new EmpleadoException("Empleado no existe para actualización");
        }
        empleadoOld.setFechaNacimiento(empleado.getFechaNacimiento());
        empleadoOld.setDireccionDomicilio(empleado.getDireccionDomicilio());
        empleadoOld.setTelefono(empleado.getTelefono());
        empleadoOld.setVacunado(empleado.getVacunado());
        empleadoOld.setTipoVacuna(empleado.getTipoVacuna());
        empleadoOld.setFechaVacunacion(empleado.getFechaVacunacion());
        empleadoOld.setNumeroDosis(empleado.getNumeroDosis());
        return empleadoRepository.save(empleadoOld);
    }

    /**
     * Elimina empleado con primary key
     *
     * @param id primary key del empleado
     * @return retorna true si se elimino con exito, caso contrario retorna
     * false
     */
    public boolean eliminarEmpelado(Long id) {
        EmpleadoModel empleado = empleadoRepository.findById(id).orElse(null);
        if (empleado != null) {
            UsuarioModel usuario = usuarioRepository
                    .findByIdentificacion(empleado.getIdentificacion()).orElse(null);
            empleadoRepository.deleteById(id);
            usuarioRepository.deleteById(usuario.getId());

        }
        return true;
    }

/**
 * Busca un empleados con el primary key id
 *
 * @param id primary key del empleado
 * @return retorna empleado en el caso que lo encuentre, caso contrario retorna
 * vacio
 */
public Optional<EmpleadoModel> obtenerPorId(Long id) {
        return empleadoRepository.findById(id);
    }

    /**
     * Busca empleado con identificacion (cedula)
     *
     * @param identificacion identificacion del empleado
     * @return retorna la entidad EmpleadoModel
     */
    public Optional<EmpleadoModel> obtenerPorIdentificacion(String identificacion) {
        return empleadoRepository.findByIdentificacion(identificacion);
    }

    /**
     * Lista todos los empleados de la tabla
     *
     * @return lista de empleados
     */
    public ArrayList<EmpleadoModel> listarTodos() {
        return (ArrayList<EmpleadoModel>) empleadoRepository.findAll();
    }

    /**
     * Lista los empleados con los siguiente criterios de busqueda:
     * <li>Filtrar por rango de fecha de vacunación.
     *
     * @param fechaDesde Fecha desde
     * @param fechaHasta Fecha hasta
     * @return lista de empleados
     */
    public List<EmpleadoModel> listarPorFechaVacunacio(Date fechaDesde, Date fechaHasta) {

        return empleadoRepository.findByFechaVacunacionBetween(fechaDesde, fechaHasta);
    }

    /**
     * Lista los empleados con los siguiente criterios de busqueda:
     * <li>Filtrar por estado de vacunacion
     *
     * @param vacunado bandera 1 si esta vacunado / 0 no esta vacunado
     * @return lista de empleados
     */
    public List<EmpleadoModel> listarPorVacunacion(Integer vacunado) {
        return empleadoRepository.findByVacunado(vacunado);
    }

    /**
     * Lista los empleados con los siguiente criterios de busqueda:
     * <li>Filtrar por tipo de vacunacion
     *
     * @param tipoVacuna tipo de vacuna
     * @return lista de empleados
     */
    public List<EmpleadoModel> listarPorTipoVacuna(TipoVacuna tipoVacuna) {
        return empleadoRepository.findByTipoVacuna(tipoVacuna);
    }
}
