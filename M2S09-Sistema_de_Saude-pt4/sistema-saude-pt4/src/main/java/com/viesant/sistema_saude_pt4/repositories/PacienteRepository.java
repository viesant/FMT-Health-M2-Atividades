package com.viesant.sistema_saude_pt4.repositories;

import com.viesant.sistema_saude_pt4.entities.PacienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<PacienteEntity, Long> {}
