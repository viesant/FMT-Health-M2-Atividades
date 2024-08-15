package com.viesant.sistema_saude_pt4.services;

import com.viesant.sistema_saude_pt4.repositories.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UsuarioService {
  private final UsuarioRepository usuarioRepository;
}
