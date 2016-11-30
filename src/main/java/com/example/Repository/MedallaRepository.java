package com.example.Repository;

import com.example.Domain.Medalla;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by DAM on 30/11/16.
 */
public interface MedallaRepository extends JpaRepository<Medalla, Long> {
}
