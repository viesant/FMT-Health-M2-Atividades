package com.viesant.sistema_saude_pt3.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class ConsultaResponse {
  private Long id;
  private LocalDate data;
  private Long pacienteId;
  private String nomePaciente;
  private Long nutricionistaId;
  private String nomeNutricionista;
}
