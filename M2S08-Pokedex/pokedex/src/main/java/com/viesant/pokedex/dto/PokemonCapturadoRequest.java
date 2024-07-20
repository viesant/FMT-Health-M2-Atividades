package com.viesant.pokedex.dto;

public class PokemonCapturadoRequest {
  private Integer numero;
  private String nome;
  private String descricao;
  private String imagemURL;
  private String tipo;
  private String categoria;
  private String habitat;
  private Float altura;
  private Float peso;

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

  public String getTipo() {
    return tipo;
  }

  public void setTipo(String tipo) {
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
