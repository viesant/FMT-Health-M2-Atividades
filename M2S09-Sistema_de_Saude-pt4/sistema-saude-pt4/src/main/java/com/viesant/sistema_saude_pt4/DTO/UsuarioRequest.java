package com.viesant.sistema_saude_pt4.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
public class UsuarioRequest {
  private String usuario;
  private String senha;
  private Set<String> perfil;
}
