package com.viesant.sistema_saude_pt3.DTO;

import com.viesant.sistema_saude_pt3.entities.NutricionistaEntity;
import com.viesant.sistema_saude_pt3.entities.PacienteEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@Getter @Setter
public class ConsultaRequestDTO {
  private LocalDate data;
  private Long pacienteId;
  private Long nutricionistaId;
}
