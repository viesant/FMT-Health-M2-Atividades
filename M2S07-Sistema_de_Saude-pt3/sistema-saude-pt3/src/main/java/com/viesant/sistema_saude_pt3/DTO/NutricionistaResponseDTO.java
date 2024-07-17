package com.viesant.sistema_saude_pt3.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class NutricionistaResponseDTO {
  private Long id;
  private String nome;
  private String matricula;
  private String especialidade;
  private EnderecoResponseDTO endereco;
}
