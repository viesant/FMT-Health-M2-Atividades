package com.viesant.sistema_saude_pt4.controllers;

import com.viesant.sistema_saude_pt4.DTO.NutricionistaRequest;
import com.viesant.sistema_saude_pt4.DTO.NutricionistaResponse;
import com.viesant.sistema_saude_pt4.services.NutricionistaService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/nutricionistas")
@RequiredArgsConstructor
public class NutricionistaController {

  private final NutricionistaService nutricionistaService;

  @PostMapping
  public ResponseEntity<NutricionistaResponse> criarNutricionista(
      @RequestBody NutricionistaRequest nutricionistaRequest) {
    try {
      NutricionistaResponse nutricionistaResponse =
          nutricionistaService.criaNutricionista(nutricionistaRequest);
      return new ResponseEntity<>(nutricionistaResponse, HttpStatus.CREATED);
    } catch (RuntimeException e) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }

  @GetMapping
  public ResponseEntity<List<NutricionistaResponse>> buscarNutricionistas() {
    List<NutricionistaResponse> nutricionistas = nutricionistaService.buscaNutricionistas();
    return new ResponseEntity<>(nutricionistas, HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<NutricionistaResponse> buscarNutricionistaPorId(@PathVariable Long id) {
    NutricionistaResponse nutricionistaResponse = nutricionistaService.buscaNutricionistaPorId(id);
    if (nutricionistaResponse != null) {
      return new ResponseEntity<>(nutricionistaResponse, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @PutMapping("/{id}")
  public ResponseEntity<NutricionistaResponse> atualizarNutricionista(
      @PathVariable Long id, @RequestBody NutricionistaRequest nutricionistaRequest) {
    NutricionistaResponse nutricionistaAtualizado =
        nutricionistaService.atualizaNutricionista(id, nutricionistaRequest);
    if (nutricionistaAtualizado != null) {
      return new ResponseEntity<>(nutricionistaAtualizado, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deletarNutricionista(@PathVariable Long id) {
    if (nutricionistaService.buscaNutricionistaPorId(id) != null) {
      nutricionistaService.deletaNutricionista(id);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @PatchMapping("/{id}/inc-anos-experiencia")
  public ResponseEntity<NutricionistaResponse> incrementarAnosExperiencia(@PathVariable Long id) {
    NutricionistaResponse nutricionistaResponse = nutricionistaService.incAnosExperiencia(id);
    if (nutricionistaResponse != null) {
      return new ResponseEntity<>(nutricionistaResponse, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }
}
