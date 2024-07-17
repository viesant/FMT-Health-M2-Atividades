package com.viesant.sistema_saude_pt3.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDate;

@Entity
//@Data
@Table(name = "paciente")
//@NoArgsConstructor
//@AllArgsConstructor
public class PacienteEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(nullable = false)
  private String nome;

  @Column(nullable = false)
  private LocalDate nascimento;

  @ManyToOne
  @JoinColumn(name = "endereco_id", nullable = false)
  private EnderecoEntity endereco;

}
