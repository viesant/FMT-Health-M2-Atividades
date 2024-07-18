package com.viesant.sistema_saude_pt3.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@Getter @Setter
public class ConsultaRequest {
  private LocalDate data;
  private Long pacienteId;
  private Long nutricionistaId;
}
