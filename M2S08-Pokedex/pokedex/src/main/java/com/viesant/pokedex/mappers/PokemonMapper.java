package com.viesant.pokedex.mappers;

import com.viesant.pokedex.dto.PokemonCapturadoRequest;
import com.viesant.pokedex.dto.PokemonVistoRequest;
import com.viesant.pokedex.models.Pokemon;

public class PokemonMapper {
  private PokemonMapper() {}

  public static Pokemon map(PokemonVistoRequest source) {
    Pokemon target = new Pokemon();
    target.setNumero(source.getNumero());
    target.setNome(source.getNome());
    target.setImagemURL(source.getImagemURL());
    target.setHabitat(source.getHabitat());

    return target;
  }

  public static Pokemon map(PokemonCapturadoRequest source) {
    Pokemon target = new Pokemon();
    target.setNumero(source.getNumero());
    target.setNome(source.getNome());
    target.setDescricao(source.getDescricao());
    target.setImagemURL(source.getImagemURL());
    target.setTipo(source.getTipo());
    target.setCategoria(source.getCategoria());
    target.setHabitat(source.getHabitat());
    target.setAltura(source.getAltura());
    target.setPeso(source.getPeso());
    target.setCapturado(true);
    return target;
  }
}
