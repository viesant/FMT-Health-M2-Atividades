package com.viesant.sistema_saude_pt4.services;

import com.viesant.sistema_saude_pt4.DTO.LoginRequest;
import com.viesant.sistema_saude_pt4.DTO.LoginResponse;
import com.viesant.sistema_saude_pt4.entities.UsuarioEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@RequiredArgsConstructor
public class LoginService {
  private final TokenService tokenService;
  private final UsuarioService usuarioService;

  public LoginResponse validaLogin(@RequestBody LoginRequest user) {

    UsuarioEntity usuario = usuarioService.validaUsuario(user);

    String token = tokenService.geraToken(usuario.getUsername(), usuario.getRole().toString());

    LoginResponse response = new LoginResponse();
    response.setToken(token);
    response.setTempo_expiracao(TokenService.getTempoExpiracao());
    return response;
  }
}
