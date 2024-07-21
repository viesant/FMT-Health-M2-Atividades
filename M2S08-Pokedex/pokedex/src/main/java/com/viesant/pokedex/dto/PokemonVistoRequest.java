package com.viesant.pokedex.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class PokemonVistoRequest {
  @NotNull private Integer numero;
  @NotBlank private String nome;
  @NotBlank private String imagemURL;
  @NotBlank private String habitat;

  public PokemonVistoRequest() {}

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

  public String getImagemURL() {
    return imagemURL;
  }

  public void setImagemURL(String imagemURL) {
    this.imagemURL = imagemURL;
  }

  public String getHabitat() {
    return habitat;
  }

  public void setHabitat(String habitat) {
    this.habitat = habitat;
  }
}
