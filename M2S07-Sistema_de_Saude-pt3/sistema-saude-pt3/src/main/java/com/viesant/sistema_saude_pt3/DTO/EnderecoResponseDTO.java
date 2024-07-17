package com.viesant.sistema_saude_pt3.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class EnderecoResponseDTO {
  private Long id;
  private String logradouro;
  private String estado;
  private String cidade;
  private String numero;
  private String cep;
}
