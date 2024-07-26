package com.viesant.sistema_saude_pt4.DTO;

import com.viesant.sistema_saude_pt4.enums.RolesEnum;
import lombok.Data;

@Data
public class UsuarioRequest {
  private String username;
  private String password;
  private RolesEnum role;
}
