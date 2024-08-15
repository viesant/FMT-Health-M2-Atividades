package com.viesant.CadastroMedicos.models;

import com.viesant.CadastroMedicos.enums.EspecialidadesEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDate;

@Entity
public class Medico {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String nome;

  @Column(nullable = false)
  private String crm;

  @Column(nullable = false)
  private LocalDate dataNascimento;

  @Column(nullable = false)
  @Enumerated(value = EnumType.STRING)
  private EspecialidadesEnum especialidade;

  //Getters e Setters
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getCrm() {
    return crm;
  }

  public void setCrm(String crm) {
    this.crm = crm;
  }

  public LocalDate getDataNascimento() {
    return dataNascimento;
  }

  public void setDataNascimento(LocalDate dataNascimento) {
    this.dataNascimento = dataNascimento;
  }

  public EspecialidadesEnum getEspecialidade() {
    return especialidade;
  }

  public void setEspecialidade(EspecialidadesEnum especialidade) {
    this.especialidade = especialidade;
  }
}
