package com.viesant.sistema_saude_pt3.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
//@Data
@Table(name = "endereco")
//@NoArgsConstructor
//@AllArgsConstructor
public class EnderecoEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(nullable = false)
  private String logradouro;

  @Column(length = 50, nullable = false)
  private String estado;

  @Column(length = 100, nullable = false)
  private String cidade;

  @Column(length = 10, nullable = false)
  private String numero;

  @Column(length = 10, nullable = false)
  private String cep;
}
