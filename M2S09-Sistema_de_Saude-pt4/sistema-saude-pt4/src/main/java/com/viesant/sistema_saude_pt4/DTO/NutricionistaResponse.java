package com.viesant.sistema_saude_pt4.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class NutricionistaResponse {
  private Long id;
  private String nome;
  private String matricula;
  private String especialidade;
  private int anosExperiencia;
  private List<String> certificacao;
  private Long enderecoId;
}
