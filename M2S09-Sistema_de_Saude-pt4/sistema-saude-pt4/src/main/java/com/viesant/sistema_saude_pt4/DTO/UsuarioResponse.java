package com.viesant.sistema_saude_pt4.DTO;

import com.viesant.sistema_saude_pt4.enums.RolesEnum;
import lombok.Data;

@Data
public class UsuarioResponse {
  private Long id;
  private String username;
  private RolesEnum role;
}
