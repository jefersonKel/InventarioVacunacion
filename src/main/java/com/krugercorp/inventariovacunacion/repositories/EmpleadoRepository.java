package com.krugercorp.inventariovacunacion.repositories;

import com.krugercorp.inventariovacunacion.enumeration.TipoVacuna;
import com.krugercorp.inventariovacunacion.models.EmpleadoModel;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import javax.persistence.TemporalType;
import org.springframework.data.jpa.repository.Temporal;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepository extends CrudRepository<EmpleadoModel, Long> {

    public abstract Optional<EmpleadoModel> findByIdentificacion(String identificacion);

    public abstract List<EmpleadoModel> findByVacunado(Integer vacunado);

    public abstract List<EmpleadoModel> findByTipoVacuna(TipoVacuna tipo);

    public abstract List<EmpleadoModel> findByFechaVacunacionBetween(@Temporal(TemporalType.DATE) @Param("startDate") Date startDate,@Temporal(TemporalType.DATE) @Param("endDate")Date endDate);
}
