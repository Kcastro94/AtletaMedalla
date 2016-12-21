package com.example.Repository;

import com.example.Domain.Atleta;
import com.example.Domain.TipoMedalla;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 * Created by DAM on 30/11/16.
 */
public interface AtletaRepository extends JpaRepository<Atleta, Long> {

    /**
     *
     1.Devolver todos los Atletas de una nacionalidad determinada
     2.	Devolver todos los atletas que hayan nacido en una fecha anterior a una fecha determinada.
     3.	Devolver todos los atletas agrupados por nacionalidad mediante un Map<String, List <Atleta>>
     4.	Devolver todos los atletas agrupados por tipo de medalla mediante un Map<TipoMedalla, List <Atleta>>

     */

    //public List<Atleta> findByNacionalidad(String nacionalidad);
    public List<Atleta> findByFechaNacimientoBefore(LocalDate fecha);
    public List<Atleta> findByNacionalidad(String nacionalidad);
    @Query("select a from Atleta a, Medalla m where a.id = m.atleta and m.tipoMedalla = :tipoMedalla")
    public List<Atleta> findAtletasByTipoMedalla(@Param("tipoMedalla") TipoMedalla tipoMedalla);

}
