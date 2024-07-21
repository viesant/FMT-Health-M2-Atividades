package com.viesant.pokedex.mappers;

import com.viesant.pokedex.dto.PokemonCapturadoRequest;
import com.viesant.pokedex.dto.PokemonResponse;
import com.viesant.pokedex.dto.PokemonVistoRequest;
import com.viesant.pokedex.models.Pokemon;

public class PokemonMapper {
  private PokemonMapper() {}

  public static Pokemon map(PokemonVistoRequest source) {
    if (source == null) return null;

    Pokemon target = new Pokemon();
    target.setNumero(source.getNumero());
    target.setNome(source.getNome());
    target.setImagemUrl(source.getImagemURL());
    target.setHabitat(source.getHabitat());
    target.setCapturado(false);
    return target;
  }

  public static Pokemon map(PokemonCapturadoRequest source) {
    if (source == null) return null;

    Pokemon target = new Pokemon();
    target.setNumero(source.getNumero());
    target.setNome(source.getNome());
    target.setDescricao(source.getDescricao());
    target.setImagemUrl(source.getImagemURL());
    target.setTipo(source.getTipo());
    target.setCategoria(source.getCategoria());
    target.setHabitat(source.getHabitat());
    target.setAltura(source.getAltura());
    target.setPeso(source.getPeso());
    target.setCapturado(true);
    return target;
  }

  public static PokemonResponse map(Pokemon source) {
    if (source == null) return null;

    PokemonResponse target = new PokemonResponse();
    target.setNumero(source.getNumero());
    target.setNome(source.getNome());
    target.setCapturado(source.getCapturado());
    return target;
  }
}
