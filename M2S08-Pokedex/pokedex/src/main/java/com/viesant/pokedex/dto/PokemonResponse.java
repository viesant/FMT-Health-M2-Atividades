package com.viesant.pokedex.dto;

public class PokemonResponse {
  private Long id;
  private Integer numero;
  private String nome;
  private Boolean capturado;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

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

  public Boolean getCapturado() {
    return capturado;
  }

  public void setCapturado(Boolean capturado) {
    this.capturado = capturado;
  }
}
