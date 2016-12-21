package com.example.Controller;


import com.example.Domain.Medalla;
import com.example.Repository.MedallaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Created by DAM on 30/11/16.
 */
@RestController
@RequestMapping("/medallas")
public class MedallaController {

    @Autowired
    private MedallaRepository medallaRepository;

    // POST
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Medalla createPlayer(@RequestBody Medalla medalla) {
        return medallaRepository.save(medalla);
    }

    // PUT
    @PutMapping
    public Medalla updatePlayer(@RequestBody Medalla medalla) {
        return medallaRepository.save(medalla);
    }

    // GET TODAS
    @GetMapping
    public List<Medalla> findAll() {
        return medallaRepository.findAll();
    }

    // GET UNA
    @GetMapping("/{id}")
    public Medalla findById(@PathVariable Long id) {
        Medalla medalla = medallaRepository.findOne(id);
        return medalla;
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void deleteMedalla(@PathVariable Long id) {medallaRepository.delete(id);}
}