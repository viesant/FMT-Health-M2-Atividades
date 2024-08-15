package com.viesant.sistema_saude_pt4.services;

import com.sun.jdi.request.DuplicateRequestException;
import com.viesant.sistema_saude_pt4.DTO.UsuarioRequest;
import com.viesant.sistema_saude_pt4.entities.PerfilEntity;
import com.viesant.sistema_saude_pt4.entities.UsuarioEntity;
import com.viesant.sistema_saude_pt4.repositories.PerfilRepository;
import com.viesant.sistema_saude_pt4.repositories.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UsuarioService {
  private final UsuarioRepository usuarioRepository;
  private final PerfilRepository perfilRepository;
  private final BCryptPasswordEncoder passwordEncoder;

  public UsuarioEntity novoUsuario(UsuarioRequest usuarioRequest) {
    if (usuarioRepository.existsByUsuario(usuarioRequest.getUsuario())) {
      throw new DuplicateRequestException(
          "Já existe usuário cadastrado com nome: " + usuarioRequest.getUsuario());
    }

    Set<PerfilEntity> perfis =
            usuarioRequest.getPerfil().stream()
                    .map(
                            nomePerfil -> {
                              PerfilEntity perfil =
                                      perfilRepository
                                              .findByNome(nomePerfil)
                                              .orElseThrow(
                                                      () ->
                                                              new EntityNotFoundException(
                                                                      "Perfil não encontrado: " + nomePerfil));
                              return perfil;
                            })
                    .collect(Collectors.toSet());

    UsuarioEntity usuario = new UsuarioEntity();
    usuario.setUsuario(usuarioRequest.getUsuario());
    usuario.setSenha(passwordEncoder.encode(usuarioRequest.getSenha()));



    usuario.setPerfil(perfis);

    return usuarioRepository.save(usuario);
  }

  public List<UsuarioEntity> listaUsuarios() {
    return usuarioRepository.findAll();
  }
}
