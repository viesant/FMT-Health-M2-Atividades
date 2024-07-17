package com.viesant.sistema_saude_pt3.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@Getter @Setter
public class PacienteRequestDTO {
  private String nome;
  private LocalDate nascimento;
  private Long enderecoId;
}
