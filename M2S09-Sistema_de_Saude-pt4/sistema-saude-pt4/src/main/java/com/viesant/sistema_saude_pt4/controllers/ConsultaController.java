package com.viesant.sistema_saude_pt4.controllers;

import com.viesant.sistema_saude_pt4.DTO.ConsultaRequest;
import com.viesant.sistema_saude_pt4.DTO.ConsultaResponse;
import com.viesant.sistema_saude_pt4.services.ConsultaService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consultas")
@RequiredArgsConstructor
public class ConsultaController {
  private final ConsultaService consultaService;

  @PostMapping
  public ResponseEntity<ConsultaResponse> criarConsulta(
      @RequestBody ConsultaRequest consultaRequest) {
    try {
      ConsultaResponse consultaResponse = consultaService.criaConsulta(consultaRequest);
      return new ResponseEntity<>(consultaResponse, HttpStatus.CREATED);
    } catch (RuntimeException e) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }

  @GetMapping
  public ResponseEntity<List<ConsultaResponse>> buscarConsultas() {
    List<ConsultaResponse> consultas = consultaService.buscaConsultas();
    return new ResponseEntity<>(consultas, HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<ConsultaResponse> buscarConsultaPorId(@PathVariable Long id) {
    try {
      ConsultaResponse consultaResponse = consultaService.buscaConsultaPorId(id);
      return new ResponseEntity<>(consultaResponse, HttpStatus.OK);
    } catch (RuntimeException e) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @PutMapping("/{id}")
  public ResponseEntity<ConsultaResponse> atualizarConsulta(
      @PathVariable Long id, @RequestBody ConsultaRequest consultaRequest) {
    try {
      ConsultaResponse consultaAtualizada = consultaService.atualizaConsulta(id, consultaRequest);
      return new ResponseEntity<>(consultaAtualizada, HttpStatus.OK);
    } catch (RuntimeException e) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deletarConsulta(@PathVariable Long id) {
    try {
      consultaService.deletarConsulta(id);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch (RuntimeException e) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }
}
