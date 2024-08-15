package com.viesant.sistema_saude_pt3.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter @Setter
public class NutricionistaRequest {
  private String nome;
  private String matricula;
  private String especialidade;
  private int anosExperiencia;
  private List<String> certificacao;
  private Long enderecoId;
}
