package com.viesant.sistema_saude_pt4.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter @Setter
public class EnderecoRequest {
  private String logradouro;
  private String estado;
  private String cidade;
  private String numero;
  private String cep;
}
