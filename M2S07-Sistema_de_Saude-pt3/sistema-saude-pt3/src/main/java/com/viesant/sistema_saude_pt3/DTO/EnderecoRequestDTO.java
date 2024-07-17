package com.viesant.sistema_saude_pt3.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter @Setter
public class EnderecoRequestDTO {
  private String logradouro;
  private String estado;
  private String cidade;
  private String numero;
  private String cep;
}
