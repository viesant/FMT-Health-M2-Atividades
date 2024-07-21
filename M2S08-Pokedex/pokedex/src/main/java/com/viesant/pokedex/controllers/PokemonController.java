package com.viesant.pokedex.controllers;

import com.viesant.pokedex.dto.PokemonCapturadoRequest;
import com.viesant.pokedex.dto.PokemonResponse;
import com.viesant.pokedex.dto.PokemonVistoRequest;
import com.viesant.pokedex.models.Pokemon;
import com.viesant.pokedex.services.PokemonService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pokemon")
public class PokemonController {
  @Autowired private PokemonService pokemonService;

  @PostMapping("/visto")
  @ResponseStatus(HttpStatus.CREATED)
  public Pokemon cadastrarPokemonVisto(@Valid @RequestBody PokemonVistoRequest pokemonVisto) {
    return pokemonService.cadastrarPokemonVisto(pokemonVisto);
  }

  @PostMapping("/capturado")
  @ResponseStatus(HttpStatus.CREATED)
  public Pokemon cadastrarPokemonCapturado(
      @Valid @RequestBody PokemonCapturadoRequest pokemonCapturado) {
    return pokemonService.cadastrarPokemonCapturado(pokemonCapturado);
  }

  @PutMapping("/capturado")
  @ResponseStatus(HttpStatus.ACCEPTED)
  public Pokemon atualizarPokemon(@Valid @RequestBody PokemonCapturadoRequest pokemonCapturado) {
    return pokemonService.atualizarPokemon(pokemonCapturado);
  }

  @DeleteMapping("/{numero}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deletarPokemon(@PathVariable Integer numero) {
    pokemonService.deletarPokemon(numero);
  }

  @GetMapping("/{numero}")
  @ResponseStatus(HttpStatus.OK)
  public Pokemon buscarPokemonPorId(@PathVariable Integer numero) {
    return pokemonService.buscarPokemon(numero);
  }

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<PokemonResponse> listarPokemon() {
    return pokemonService.listarPokemon();
  }
}
