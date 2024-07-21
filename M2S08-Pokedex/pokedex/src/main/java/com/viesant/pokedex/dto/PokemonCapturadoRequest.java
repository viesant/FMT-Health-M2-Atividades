package com.viesant.pokedex.dto;

import com.viesant.pokedex.enums.TipoEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class PokemonCapturadoRequest {
  @NotNull private Integer numero;
  @NotBlank private String nome;
  @NotBlank private String descricao;
  @NotBlank private String imagemURL;
  @NotNull private TipoEnum tipo;
  @NotBlank private String categoria;
  @NotBlank private String habitat;
  @NotNull private Float altura;
  @NotNull private Float peso;

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

  public String getImagemURL() {
    return imagemURL;
  }

  public void setImagemURL(String imagemURL) {
    this.imagemURL = imagemURL;
  }

  public @NotNull TipoEnum getTipo() {
    return tipo;
  }

  public void setTipo(@NotNull TipoEnum tipo) {
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
}
