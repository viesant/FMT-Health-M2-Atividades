package com.viesant.sistema_saude_pt3.DTO;

import com.viesant.sistema_saude_pt3.entities.EnderecoEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class PacienteResponseDTO {
  private Long id;
  private String nome;
  private LocalDate nascimento;
  private EnderecoResponseDTO endereco;
}
