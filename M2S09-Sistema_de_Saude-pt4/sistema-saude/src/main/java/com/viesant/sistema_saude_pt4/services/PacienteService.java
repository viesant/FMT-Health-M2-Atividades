package com.viesant.sistema_saude_pt4.services;

import com.viesant.sistema_saude_pt4.DTO.PacienteRequest;
import com.viesant.sistema_saude_pt4.DTO.PacienteResponse;
import com.viesant.sistema_saude_pt4.entities.PacienteEntity;
import com.viesant.sistema_saude_pt4.repositories.PacienteRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PacienteService {
  private final PacienteRepository pacienteRepository;

  public PacienteResponse criarPaciente(PacienteRequest request) {
    PacienteEntity paciente = new PacienteEntity();
    paciente.setNome(request.getNome());

    paciente = pacienteRepository.save(paciente);
    return new PacienteResponse(paciente.getId(), paciente.getNome());
  }

  public List<PacienteResponse> listarPacientes() {
    return pacienteRepository.findAll().stream()
        .map(paciente -> new PacienteResponse(paciente.getId(), paciente.getNome()))
        .collect(Collectors.toList());
  }
}
