package com.viesant.sistema_saude_pt4.DTO;

import lombok.Data;

@Data
public class LoginRequest {
  private String usuario;
  private String senha;
}
