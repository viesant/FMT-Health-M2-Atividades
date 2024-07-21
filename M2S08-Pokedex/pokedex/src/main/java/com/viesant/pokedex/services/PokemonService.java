package com.viesant.pokedex.services;

import static com.viesant.pokedex.mappers.PokemonMapper.map;

import com.viesant.pokedex.dto.PokemonCapturadoRequest;
import com.viesant.pokedex.dto.PokemonResponse;
import com.viesant.pokedex.dto.PokemonVistoRequest;
import com.viesant.pokedex.mappers.PokemonMapper;
import com.viesant.pokedex.models.Pokemon;
import com.viesant.pokedex.repositories.PokemonRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

@Service
public class PokemonService {

  @Autowired private PokemonRepository pokemonRepository;

  public Pokemon cadastrarPokemonVisto(PokemonVistoRequest pokemonVisto) {
    if (pokemonRepository.existsById(pokemonVisto.getNumero())) {
      throw new DuplicateKeyException("Já existe um pokemon com esse número");
    }
    return pokemonRepository.save(map(pokemonVisto));
  }

  public Pokemon cadastrarPokemonCapturado(PokemonCapturadoRequest pokemonCapturado) {
    if (pokemonRepository.existsById(pokemonCapturado.getNumero())) {
      throw new DuplicateKeyException("Já existe um pokemon com esse número");
    }
    return pokemonRepository.save(map(pokemonCapturado));
  }

  public Pokemon atualizarPokemon(PokemonCapturadoRequest pokemonCapturado) {

    if (!pokemonRepository.existsById(pokemonCapturado.getNumero())) {
      throw new EntityNotFoundException();
    }

    return pokemonRepository.save(map(pokemonCapturado));
  }

  public void deletarPokemon(Integer numero) {
    if (pokemonRepository.existsById(numero)) {
      pokemonRepository.deleteById(numero);
    } else {
      throw new EntityNotFoundException();
    }
  }

  public Pokemon buscarPokemon(Integer numero) {
    return pokemonRepository.findById(numero).orElseThrow(EntityNotFoundException::new);
  }

  public List<PokemonResponse> listarPokemon() {
    return pokemonRepository.findAll().stream().map(PokemonMapper::map).toList();
  }
}
