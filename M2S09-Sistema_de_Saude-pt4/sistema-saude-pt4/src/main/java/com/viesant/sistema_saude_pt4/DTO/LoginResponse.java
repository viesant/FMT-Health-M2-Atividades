package com.viesant.sistema_saude_pt4.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class LoginResponse {
  private String token;
  private Long expiresAt;
}
