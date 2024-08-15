package com.viesant.CadastroMedicos.repositories;

import com.viesant.CadastroMedicos.models.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long> {
  boolean existsByCrm(String crm);

  boolean existsByCrmAndIdNot(String crm, long id);
}
