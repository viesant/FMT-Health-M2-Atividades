package com.viesant.sistema_saude_pt4.DTO;

import lombok.Data;

@Data
public class LoginResponse {
  private String token;
  private Long tempo_expiracao;
}
