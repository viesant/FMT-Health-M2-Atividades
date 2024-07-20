package com.viesant.pokedex.services;

import static com.viesant.pokedex.mappers.PokemonMapper.map;

import com.viesant.pokedex.dto.PokemonCapturadoRequest;
import com.viesant.pokedex.dto.PokemonVistoRequest;
import com.viesant.pokedex.models.Pokemon;
import com.viesant.pokedex.repositories.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PokemonService {

  @Autowired private PokemonRepository pokemonRepository;

  public Pokemon cadastrarPokemonVisto(PokemonVistoRequest pokemonVisto) {

    Pokemon pokemon = map(pokemonVisto);
    return pokemonRepository.save(pokemon);
  }

  public Pokemon cadastrarPokemonCapturado(PokemonCapturadoRequest pokemonCapturado) {
    Pokemon pokemon = map(pokemonCapturado);
    return pokemonRepository.save(pokemon);
  }

  public Pokemon atualizarPokemon(Long id, PokemonCapturadoRequest pokemonCapturado) {
    Pokemon pokemon = pokemonRepository.findById(id).orElse(null);

    if (pokemon != null) {
      pokemon = map(pokemonCapturado);
      pokemon.setId(id);
      return pokemonRepository.save(pokemon);
    }
    return null;
  }

  public Boolean deletarPokemon(Long id) {
    if (pokemonRepository.existsById(id)) {
      pokemonRepository.deleteById(id);
      return true;
    }
    return false;
  }
}
