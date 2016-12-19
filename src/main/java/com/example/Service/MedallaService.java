package com.example.Service;

import com.example.Domain.Atleta;
import com.example.Domain.Medalla;
import com.example.Domain.TipoMedalla;
import com.example.Repository.AtletaRepository;
import com.example.Repository.MedallaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by DAM on 30/11/16.
 */
@Service
@Transactional
public class MedallaService {

    @Autowired
    private MedallaRepository medallaRepository;

    @Autowired
    private AtletaRepository atletaRepository;

    public void testMedalla(){
        Atleta atleta = atletaRepository.findOne(1L);
        Medalla medalla1 = new Medalla(TipoMedalla.BRONCE, "Natación", "Juegos Olímpicos", atleta);
        medallaRepository.save(medalla1);

        atleta = atletaRepository.findOne(2L);
        Medalla medalla2 = new Medalla(TipoMedalla.PLATA, "Baloncesto", "Juegos Olímpicos", atleta);
        medallaRepository.save(medalla2);

        atleta = atletaRepository.findOne(3L);
        Medalla medalla3 = new Medalla(TipoMedalla.PLATA, "100 metros lisos", "Juegos Olímpicos", atleta);
        medallaRepository.save(medalla3);

        atleta = atletaRepository.findOne(4L);
        Medalla medalla4 = new Medalla(TipoMedalla.ORO, "Salto de longitud", "Juegos Olímpicos", atleta);
        medallaRepository.save(medalla4);

        atleta = atletaRepository.findOne(5L);
        Medalla medalla5 = new Medalla(TipoMedalla.BRONCE, "Lanzamiento de peso", "Juegos Olímpicos", atleta);
        medallaRepository.save(medalla5);

    }
}
