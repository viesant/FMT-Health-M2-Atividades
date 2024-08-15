package com.viesant.sistema_saude_pt4.controllers;

import com.viesant.sistema_saude_pt4.DTO.PacienteRequest;
import com.viesant.sistema_saude_pt4.DTO.PacienteResponse;
import com.viesant.sistema_saude_pt4.services.PacienteService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pacientes")
@RequiredArgsConstructor
public class PacienteController {
  private final PacienteService pacienteService;

  @PostMapping
  @PreAuthorize("hasAnyAuthority('SCOPE_ADMIN', 'SCOPE_NUTRICIONISTA')")
  public ResponseEntity<PacienteResponse> criarPaciente(
      @RequestBody PacienteRequest pacienteRequest) {
    PacienteResponse pacienteResponse = pacienteService.criaPaciente(pacienteRequest);
    return new ResponseEntity<>(pacienteResponse, HttpStatus.OK);
  }

  @GetMapping
  @PreAuthorize("hasAnyAuthority('SCOPE_ADMIN', 'SCOPE_NUTRICIONISTA')")
  public ResponseEntity<List<PacienteResponse>> buscarPacientes() {
    List<PacienteResponse> pacientes = pacienteService.buscaPacientes();
    return new ResponseEntity<>(pacientes, HttpStatus.OK);
  }

  @GetMapping("/{id}")
  @PreAuthorize("hasAnyAuthority('SCOPE_ADMIN', 'SCOPE_NUTRICIONISTA', 'SCOPE_PACIENTE')")
  public ResponseEntity<PacienteResponse> buscarPacientePorId(@PathVariable Long id) {
    PacienteResponse pacienteResponse = pacienteService.buscaPacientePorId(id);
    if (pacienteResponse != null) {
      return new ResponseEntity<>(pacienteResponse, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @PutMapping("/{id}")
  @PreAuthorize("hasAnyAuthority('SCOPE_ADMIN', 'SCOPE_NUTRICIONISTA')")
  public ResponseEntity<PacienteResponse> atualizarPaciente(
      @PathVariable Long id, @RequestBody PacienteRequest pacienteRequest) {
    PacienteResponse pacienteAtualizado = pacienteService.atualizaPaciente(id, pacienteRequest);
    if (pacienteAtualizado != null) {
      return new ResponseEntity<>(pacienteAtualizado, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @DeleteMapping("/{id}")
  @PreAuthorize("hasAnyAuthority('SCOPE_ADMIN', 'SCOPE_NUTRICIONISTA')")
  public ResponseEntity<Void> deletarPaciente(@PathVariable Long id) {
    pacienteService.deletaPaciente(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
