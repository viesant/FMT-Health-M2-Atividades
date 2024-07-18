package com.viesant.sistema_saude_pt3.repositories;

import com.viesant.sistema_saude_pt3.entities.NutricionistaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NutricionistaRepository extends JpaRepository<NutricionistaEntity, Long> {
  boolean existsByNome(String nome);
}
