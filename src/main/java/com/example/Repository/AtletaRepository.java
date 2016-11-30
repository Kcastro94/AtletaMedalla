package com.example.Repository;

import com.example.Domain.Atleta;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by DAM on 30/11/16.
 */
public interface AtletaRepository extends JpaRepository<Atleta, Long> {
}
