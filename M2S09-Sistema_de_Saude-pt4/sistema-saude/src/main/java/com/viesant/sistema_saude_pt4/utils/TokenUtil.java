package com.viesant.sistema_saude_pt4.utils;

import lombok.RequiredArgsConstructor;
import lombok.experimental.UtilityClass;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;

import java.time.Instant;

@RequiredArgsConstructor
public class TokenUtil {

  public static long TEMPO_EXPIRACAO = 36000L;
  private final JwtEncoder jwtEncoder;

  public String geraToken(String username) {

    Instant now = Instant.now();
    JwtClaimsSet claimsSet =
        JwtClaimsSet.builder()
            .subject(username)
            .issuedAt(now)
            .expiresAt(now.plusSeconds(TEMPO_EXPIRACAO))
            //            .claim("role", role)
            //            .claim("scope", scopes)
            .build();
    return jwtEncoder.encode(JwtEncoderParameters.from(claimsSet)).getTokenValue();
  }
}
