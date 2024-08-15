package com.viesant.sistema_saude_pt4.repositories;

import com.viesant.sistema_saude_pt4.entities.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {
  Optional<UsuarioEntity> findByUsuario (String usuario);

  Boolean existsByUsuario (String usuario);

}
