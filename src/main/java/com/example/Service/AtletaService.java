package com.example.Service;

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
public class AtletaService {

    @Autowired
    private AtletaRepository atletaRepository;

    @Autowired
    private MedallaRepository medallaRepository;

    public void testAtleta(){

    }
}
