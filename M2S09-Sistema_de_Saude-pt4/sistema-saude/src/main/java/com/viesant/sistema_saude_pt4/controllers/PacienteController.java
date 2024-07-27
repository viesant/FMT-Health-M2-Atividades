package com.viesant.sistema_saude_pt4.controllers;

import com.viesant.sistema_saude_pt4.DTO.PacienteRequest;
import com.viesant.sistema_saude_pt4.DTO.PacienteResponse;
import com.viesant.sistema_saude_pt4.services.PacienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
@RequiredArgsConstructor
public class PacienteController {

  private final PacienteService pacienteService;

  @PostMapping
  public ResponseEntity<PacienteResponse> criarPaciente(@RequestBody PacienteRequest request) {
    PacienteResponse response = pacienteService.criarPaciente(request);
    return new ResponseEntity<>(response, HttpStatus.CREATED);
  }

  @GetMapping
  public ResponseEntity<List<PacienteResponse>> listarPacientes() {
    List<PacienteResponse> responseList = pacienteService.listarPacientes();
    return new ResponseEntity<>(responseList, HttpStatus.OK);
  }

}
