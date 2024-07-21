package com.viesant.pokedex.models;

import com.viesant.pokedex.enums.TipoEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pokemon")
public class Pokemon {

  @Id private Integer numero;

  @Column(nullable = false, unique = true)
  private String nome;

  private String descricao;

  @Column(nullable = false)
  private String imagemUrl;

  @Enumerated(value = EnumType.STRING)
  private TipoEnum tipo;

  private String categoria;

  @Column(nullable = false)
  private String habitat;

  private Float altura;
  private Float peso;
  private Boolean capturado;

  public Integer getNumero() {
    return numero;
  }

  public void setNumero(Integer numero) {
    this.numero = numero;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public String getImagemUrl() {
    return imagemUrl;
  }

  public void setImagemUrl(String imagemUrl) {
    this.imagemUrl = imagemUrl;
  }

  public TipoEnum getTipo() {
    return tipo;
  }

  public void setTipo(TipoEnum tipo) {
    this.tipo = tipo;
  }

  public String getCategoria() {
    return categoria;
  }

  public void setCategoria(String categoria) {
    this.categoria = categoria;
  }

  public String getHabitat() {
    return habitat;
  }

  public void setHabitat(String habitat) {
    this.habitat = habitat;
  }

  public Float getAltura() {
    return altura;
  }

  public void setAltura(Float altura) {
    this.altura = altura;
  }

  public Float getPeso() {
    return peso;
  }

  public void setPeso(Float peso) {
    this.peso = peso;
  }

  public Boolean getCapturado() {
    return capturado;
  }

  public void setCapturado(Boolean capturado) {
    this.capturado = capturado;
  }
}
