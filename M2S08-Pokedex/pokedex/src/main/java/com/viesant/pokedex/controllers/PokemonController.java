package com.viesant.pokedex.controllers;

import com.viesant.pokedex.dto.PokemonCapturadoRequest;
import com.viesant.pokedex.dto.PokemonVistoRequest;
import com.viesant.pokedex.models.Pokemon;
import com.viesant.pokedex.services.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pokemon")
public class PokemonController {
  @Autowired private PokemonService pokemonService;

  @PostMapping("/visto")
  public Pokemon cadastrarPokemonVisto(@RequestBody PokemonVistoRequest pokemonVisto) {
    return pokemonService.cadastrarPokemonVisto(pokemonVisto);
  }

  @PostMapping("/capturado")
  public Pokemon cadastrarPokemonCapturado(@RequestBody PokemonCapturadoRequest pokemonCapturado) {
    return pokemonService.cadastrarPokemonCapturado(pokemonCapturado);
  }
}
