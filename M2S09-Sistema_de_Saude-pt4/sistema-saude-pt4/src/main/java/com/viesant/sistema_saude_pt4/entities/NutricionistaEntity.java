package com.viesant.sistema_saude_pt4.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "nutricionista")
public class NutricionistaEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String nome;

  @Column(length = 10, nullable = false)
  private String matricula;

  @Column(nullable = false, length = 60)
  private String especialidade;

  @Column(nullable = false)
  private int anosExperiencia;

  private List<String> certificacao;

  @ManyToOne
  @JoinColumn(name = "endereco_id", nullable = false)
  private EnderecoEntity endereco;
}
