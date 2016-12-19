package com.example.Service;

import com.example.Domain.Medalla;
import com.example.Domain.TipoMedalla;
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

    public void testMedalla(){
        Medalla medalla1 = new Medalla(TipoMedalla.BRONCE, "Natación", "Juegos Olímpicos");
        medallaRepository.save(medalla1);

        Medalla medalla2 = new Medalla(TipoMedalla.PLATA, "Baloncesto", "Juegos Olímpicos");
        medallaRepository.save(medalla2);

        Medalla medalla3 = new Medalla(TipoMedalla.PLATA, "100 metros lisos", "Juegos Olímpicos");
        medallaRepository.save(medalla3);

        Medalla medalla4 = new Medalla(TipoMedalla.ORO, "Salto de longitud", "Juegos Olímpicos");
        medallaRepository.save(medalla4);

        Medalla medalla5 = new Medalla(TipoMedalla.BRONCE, "Lanzamiento de peso", "Juegos Olímpicos");
        medallaRepository.save(medalla5);

    }
}
