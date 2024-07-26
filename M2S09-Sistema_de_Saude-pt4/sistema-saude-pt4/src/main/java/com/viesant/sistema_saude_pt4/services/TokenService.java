package com.viesant.sistema_saude_pt4.services;

import java.time.Instant;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TokenService {


  public static long TEMPO_EXPIRACAO = 36000L;
  private final JwtEncoder jwtEncoder;
  private final JwtDecoder jwtDecoder;

  public static long getTempoExpiracao() {
    return TEMPO_EXPIRACAO;
  }
  // ricardo123, ADMIN, [create, read, delete, update]
  // user1, NUTRI, [read]
  //  public String geraToken(String username, String role, List<String> scopes) {

  public String geraToken(String username, String role) {

    Instant now = Instant.now();
    JwtClaimsSet claimsSet =
        JwtClaimsSet.builder()
            .subject(username)
            .issuedAt(now)
            .expiresAt(now.plusSeconds(TEMPO_EXPIRACAO))
            .claim("role", role)
            //            .claim("scope", scopes)
            .build();
    return jwtEncoder.encode(JwtEncoderParameters.from(claimsSet)).getTokenValue();
  }

//  public void validaToken(String token, String role) {
//    //    if (token.isBlank()) {
//    //      throw new RuntimeException("Token Vazio");
//    //    }
//
//    Jwt jwtDecoded = jwtDecoder.decode(token);
//
//    String claimSub = jwtDecoded.getSubject();
//    if (!jwtDecoded.getClaimAsString("role").equals(role)) {
//      throw new RuntimeException("Usuário " + claimSub + " não tem acesso a " + role);
//    }
//
//    if (jwtDecoded.getExpiresAt().isBefore(Instant.now())) {
//      throw new RuntimeException("Token Expirado");
//    }
//  }
}
