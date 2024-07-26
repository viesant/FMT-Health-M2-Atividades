package com.viesant.sistema_saude_pt4.services;

import com.viesant.sistema_saude_pt4.DTO.LoginRequest;
import com.viesant.sistema_saude_pt4.DTO.UsuarioRequest;
import com.viesant.sistema_saude_pt4.DTO.UsuarioResponse;
import com.viesant.sistema_saude_pt4.entities.UsuarioEntity;
import com.viesant.sistema_saude_pt4.repositories.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

  private final UsuarioRepository usuarioRepository;
  private final BCryptPasswordEncoder passwordEncoder;

  public UsuarioResponse cadastraUsuario(UsuarioRequest newUser) {
    if (usuarioRepository.findByUsername(newUser.getUsername()).isPresent()) {
      throw new RuntimeException("Já existe usuário com nome: " + newUser.getUsername());
    }

    UsuarioEntity usuario = new UsuarioEntity();
    usuario.setUsername(newUser.getUsername());
    usuario.setPassword(passwordEncoder.encode(newUser.getPassword()));
    usuario.setRole(newUser.getRole());
    UsuarioEntity usuarioSalvo = usuarioRepository.save(usuario);

    UsuarioResponse usuarioResponse = new UsuarioResponse();
    usuarioResponse.setId(usuarioSalvo.getId());
    usuarioResponse.setUsername(usuarioSalvo.getUsername());
    usuarioResponse.setRole(usuarioSalvo.getRole());

    return usuarioResponse;
  }

  public UsuarioEntity validaUsuario(LoginRequest loginRequest) {
    UsuarioEntity usuarioEntity =
        usuarioRepository
            .findByUsername(loginRequest.getUsername())
            .orElseThrow(
                () ->
                    new RuntimeException(
                        "Usuário não existe com o nome " + loginRequest.getUsername()));

    if (!passwordEncoder.matches(loginRequest.getPassword(), usuarioEntity.getPassword())) {
      throw new RuntimeException(
          "Senha errada para usuário com nome " + loginRequest.getUsername());
    }

    return usuarioEntity;
  }
}
