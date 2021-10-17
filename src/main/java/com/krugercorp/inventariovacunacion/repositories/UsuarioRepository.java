package com.krugercorp.inventariovacunacion.repositories;

import com.krugercorp.inventariovacunacion.models.UsuarioModel;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends CrudRepository<UsuarioModel, Long> {

    public abstract Optional<UsuarioModel> findByIdentificacion(String identificacion);

}
