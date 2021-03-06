package com.example.Controller;

import com.example.Domain.Atleta;
import com.example.Domain.TipoMedalla;
import com.example.Repository.AtletaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.*;
import static java.util.stream.Collectors.groupingBy;


/**
 * Created by DAM on 30/11/16.
 */
@RestController
@RequestMapping("/atletas")
public class AtletaController {

    @Autowired
    private AtletaRepository atletaRepository;

    // POST
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Atleta createPlayer(@RequestBody Atleta atleta) {
        return atletaRepository.save(atleta);
    }

    // PUT
    @PutMapping
    public Atleta updatePlayer(@RequestBody Atleta atleta) {
        return atletaRepository.save(atleta);
    }

    // GET TODOS
    @GetMapping
    public List<Atleta> findAll() {
        return atletaRepository.findAll();
    }

    // GET UNO
    @GetMapping("/{id}")
    public Atleta findById(@PathVariable Long id) {
        Atleta atleta = atletaRepository.findOne(id);
        return atleta;
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void deleteAtleta(@PathVariable Long id) {atletaRepository.delete(id);}


    // 1. Devolver todos los Atletas de una nacionalidad determinada
    @GetMapping("/nacionaliad/{nacionalidad}")
    public List<Atleta> findByNacionalidad(@PathVariable String nacionalidad) {
        return atletaRepository.findByNacionalidad(nacionalidad);
    }

    // 2. Devolver todos los atletas que hayan nacido en una fecha anterior a una fecha determinada.
    @GetMapping("/fechaNacimientoBefore/{fechaNacimiento}")
    public List<Atleta> findByfechaNacimientoBefore(@PathVariable("fechaNacimiento") LocalDate fechaNacimiento) {
        return atletaRepository.findByFechaNacimientoBefore(fechaNacimiento);
    }

    // 3. Devolver todos los atletas agrupados por nacionalidad mediante un Map<String, List<Atleta>>;
    @GetMapping("/GroupByNacionalidad")
    public Map<String, List<Atleta>> getAtletaByNacionalidad(){
        return atletaRepository
                .findAll()
                .parallelStream()
                .collect(groupingBy(Atleta::getNacionalidad));
    }

    // 4. Retornar todos los atletas agrupados por tipo de medalla mediante un Map<TipoMedalla, List<Atleta>>
    @GetMapping("/groupByTipoMedalla")
    public Map<TipoMedalla, List<Atleta>> getAtletasGroupByTipoMedalla(){
        return atletaRepository.findAll().parallelStream().collect(groupingBy(atleta -> {
                    if(atleta.getMedallas().stream().anyMatch(medalla -> medalla.getTipoMedalla() == TipoMedalla.ORO)){
                        return TipoMedalla.ORO;
                    }else if(atleta.getMedallas().stream().anyMatch(medalla -> medalla.getTipoMedalla() == TipoMedalla.PLATA)){
                        return TipoMedalla.PLATA;
                    }else if(atleta.getMedallas().stream().anyMatch(medalla -> medalla.getTipoMedalla() == TipoMedalla.BRONCE)){
                        return TipoMedalla.BRONCE;
                    }else {
                        return TipoMedalla.NO;
                    }
                }));
    }
}