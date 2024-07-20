package com.viesant.pokedex.repositories;

import com.viesant.pokedex.models.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PokemonRepository extends JpaRepository<Pokemon, Long> {}
