package com.krugercorp.inventariovacunacion.services;

import com.krugercorp.inventariovacunacion.excepcion.UsuarioException;
import com.krugercorp.inventariovacunacion.models.UsuarioModel;
import com.krugercorp.inventariovacunacion.repositories.UsuarioRepository;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * UsuarioService.java clase de servicios para usuarios del sistema
 *
 * @author jbalcazar
 */

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    /**
     * Modifica/Guardar datos de un usuario. Si la entidad tiene id este se
     * guarada caso contrario se modifica
     *
     * @param usuario entidad usuario que se va a modificar/guardar
     * @return
     */
    public UsuarioModel guardarUsuario(UsuarioModel usuario) {
        return usuarioRepository.save(usuario);
    }

    /**
     * Elimina usuario con primary key
     *
     * @param id primary key de usuario
     * @return retorna true si se elimino con exito, caso contrario retorna
     * false
     */
    public boolean eliminarUsuario(Long id) {
        try {
            usuarioRepository.deleteById(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }

    /**
     * Autenticar usuario con identificacion y contraseña
     *
     * @param identificacion
     * @param contraseña
     * @return retorna true si se elimino con exito, caso contrario retorna
     * false
     * @throws com.krugercorp.inventariovacunacion.excepcion.UsuarioException
     */
    public UsuarioModel autenticar(String identificacion, String contraseña) throws UsuarioException {
        UsuarioModel usuario = usuarioRepository.findByIdentificacion(identificacion).orElse(null);

        if (usuario == null || !usuario.getContrasena().equals(contraseña)) {
            throw new UsuarioException("Usuario/Contraseña incorrecta.");
        }
        return usuario;
    }

    /**
     * Lista todos los usuario de la tabla
     *
     * @return lista de usuarios
     */
    public ArrayList<UsuarioModel> listarTodos() {
        return (ArrayList<UsuarioModel>) usuarioRepository.findAll();
    }

    /**
     * Busca un usuario con el primary key id
     *
     * @param id primary key de usuario
     * @return retorna usuario en el caso que lo encuentre, caso contrario
     * retorna vacio
     */
    public Optional<UsuarioModel> obtenerPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    /**
     * Busca usuario con identificacion (cedula)
     *
     * @param identificacion identificacion del usuario
     * @return retorna la entidad UsuarioModel
     */
    public Optional<UsuarioModel> obtenerPorIdentificacion(String identificacion) {
        return usuarioRepository.findByIdentificacion(identificacion);
    }

}
