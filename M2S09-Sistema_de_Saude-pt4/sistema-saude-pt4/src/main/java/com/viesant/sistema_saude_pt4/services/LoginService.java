package com.viesant.sistema_saude_pt4.services;

import com.viesant.sistema_saude_pt4.DTO.LoginRequest;
import com.viesant.sistema_saude_pt4.DTO.LoginResponse;
import com.viesant.sistema_saude_pt4.entities.PerfilEntity;
import com.viesant.sistema_saude_pt4.entities.UsuarioEntity;
import com.viesant.sistema_saude_pt4.repositories.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class LoginService {
  private final UsuarioRepository usuarioRepository;
  private final JwtEncoder jwtEncoder;
  private final BCryptPasswordEncoder passwordEncoder;

  public LoginResponse login(LoginRequest loginRequest) {

    UsuarioEntity usuario =
        usuarioRepository
            .findByUsuario(loginRequest.getUsuario())
            .orElseThrow(
                () -> new RuntimeException("Usuário não encontrado: " + loginRequest.getUsuario()));
    if (!passwordEncoder.matches(loginRequest.getSenha(), usuario.getSenha())) {
      throw new RuntimeException("Senha incorreta");
    }
    Instant now = Instant.now();
    Long expiresAt = 300L;

    String perfis =
            usuario.getPerfil().stream()
                    .map(PerfilEntity::getAuthority)
                    .collect(Collectors.joining(" "));

    JwtClaimsSet claims =
            JwtClaimsSet.builder()
                    .issuer("application")
                    .subject(usuario.getUsuario())
                    .issuedAt(now)
                    .expiresAt(now.plusSeconds(expiresAt))
                    .claim("scope", perfis)
                    .build();

    String token = jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
    return new LoginResponse(token, expiresAt);
  }
}
