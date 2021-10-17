package com.krugercorp.inventariovacunacion.repositories;

import com.krugercorp.inventariovacunacion.enumeration.TipoVacuna;
import com.krugercorp.inventariovacunacion.models.EmpleadoModel;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepository extends CrudRepository<EmpleadoModel, Long> {

    public abstract Optional<EmpleadoModel> findByIdentificacion(String identificacion);

    @Query(value = "SELECT e FROM T_EMPLEADO e WHERE (e.vacunado=:vacunado or :vacunado is null) or (e.tipo_Vacuna=:tipoVacuna or :tipoVacuna is null) or ((e.fecha_Vacunacion BETWEEN :fechaDesde and :fechaHasta) or :fechaDesde is null or :fechaHasta is null)", nativeQuery = true)
    public abstract List<EmpleadoModel> findByCriterio(
            @Param("vacunado") Integer vacunado, @Param("tipoVacuna") TipoVacuna tipoVacuna,
            @Param("fechaDesde") Date fechaDesde, @Param("fechaHasta") Date fechaHasta);

}
