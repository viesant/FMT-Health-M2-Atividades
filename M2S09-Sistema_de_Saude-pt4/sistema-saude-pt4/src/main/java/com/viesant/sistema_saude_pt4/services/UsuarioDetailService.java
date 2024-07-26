package com.viesant.sistema_saude_pt4.services;

import com.viesant.sistema_saude_pt4.entities.UsuarioEntity;
import com.viesant.sistema_saude_pt4.repositories.UsuarioRepository;
import lombok.Data;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Data
public class UsuarioDetailService implements UserDetailsService {

  private final UsuarioRepository usuarioRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    UsuarioEntity usuario =
        usuarioRepository
            .findByUsername(username)
            .orElseThrow(
                () -> new UsernameNotFoundException("Usuário não encontrado: " + username));

    return usuario;
  }
}
