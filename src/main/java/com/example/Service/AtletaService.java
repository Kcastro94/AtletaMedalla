package com.example.Service;

import com.example.Domain.Atleta;
import com.example.Domain.Medalla;
import com.example.Domain.TipoMedalla;
import com.example.Repository.AtletaRepository;
import com.example.Repository.MedallaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

/**
 * Created by DAM on 30/11/16.
 */
@Service
@Transactional
public class AtletaService {

    @Autowired
    private AtletaRepository atletaRepository;

    public void testAtleta(){


        LocalDate date = LocalDate.of(1994,12,11);
        Atleta atleta1 = new Atleta("Kevin", "Castro", "Ruso", date);
        atletaRepository.save(atleta1);


        date = LocalDate.of(1994,10,6);
        Atleta atleta2 = new Atleta("Anna", "Barnet", "Espanyol", date);
        atletaRepository.save(atleta2);


        date = LocalDate.of(1990,6,6);
        Atleta atleta3 = new Atleta("James", "McGucci", "Israel", date);
        atletaRepository.save(atleta3);


        date = LocalDate.of(1995, 2, 15);
        Atleta atleta4 = new Atleta("David", "Guevara", "Cuba", date);
        atletaRepository.save(atleta4);


        date = LocalDate.of(1985, 6, 30);
        Atleta atleta5 = new Atleta("Pablo", "Hasél", "Perú", date);
        atletaRepository.save(atleta5);

        System.out.println(atletaRepository.findByNacionalidad("Israel"));
        date = LocalDate.of(1992,1,1);
        System.out.println(atletaRepository.findByFechaNacimientoBefore(date));
        System.out.println(atletaRepository.findAtletasByTipoMedalla(TipoMedalla.PLATA));
    }
}
