package com.viesant.CadastroMedicos.repositories;

import com.viesant.CadastroMedicos.enums.EspecialidadesEnum;
import com.viesant.CadastroMedicos.models.Medico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.time.LocalDate;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long> {
  boolean existsByCrm(String crm);

  boolean existsByCrmAndIdNot(String crm, long id);

  @Query(
      "SELECT m FROM Medico m "
          + "WHERE (:nome IS NULL OR m.nome ILIKE %:nome%) "
          + "AND (:especialidade IS NULL OR m.especialidade = :especialidade) "
           + "AND (:dataNascimento IS NULL OR m.dataNascimento = :dataNascimento)")
  Page<Medico> findByFilters(
      @Param("nome") String nome,
      @Param("especialidade") EspecialidadesEnum especialidade,
      @Param("dataNascimento") LocalDate dataNascimento,
      Pageable pageable);
}
