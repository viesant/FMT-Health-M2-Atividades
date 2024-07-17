package com.viesant.sistema_saude_pt3.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jdk.jfr.DataAmount;
import lombok.Data;

import java.time.LocalDate;

@Entity
//@Data
@Table(name = "consulta")
//@NoArgsConstructor
//@AllArgsConstructor
public class ConsultaEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private LocalDate data;

  @ManyToOne
  @JoinColumn(name = "paciente_id", nullable = false)
  private PacienteEntity paciente;

  @ManyToOne
  @JoinColumn(name = "nutricionista_id", nullable = false)
  private NutricionistaEntity nutricionista;
}
