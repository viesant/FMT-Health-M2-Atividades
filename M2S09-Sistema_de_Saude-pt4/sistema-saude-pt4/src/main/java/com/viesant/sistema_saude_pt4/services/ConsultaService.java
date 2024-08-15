package com.viesant.sistema_saude_pt4.services;

import com.viesant.sistema_saude_pt4.DTO.ConsultaRequest;
import com.viesant.sistema_saude_pt4.DTO.ConsultaResponse;
import com.viesant.sistema_saude_pt4.entities.ConsultaEntity;
import com.viesant.sistema_saude_pt4.entities.NutricionistaEntity;
import com.viesant.sistema_saude_pt4.entities.PacienteEntity;
import com.viesant.sistema_saude_pt4.repositories.ConsultaRepository;
import com.viesant.sistema_saude_pt4.repositories.NutricionistaRepository;
import com.viesant.sistema_saude_pt4.repositories.PacienteRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ConsultaService {
  private final ConsultaRepository consultaRepository;
  private final NutricionistaRepository nutricionistaRepository;
  private final PacienteRepository pacienteRepository;

  // criar consulta
  public ConsultaResponse criaConsulta(ConsultaRequest consultaRequest) {
    PacienteEntity paciente =
        pacienteRepository
            .findById(consultaRequest.getPacienteId())
            .orElseThrow(() -> new RuntimeException("Paciente não encontrado"));
    NutricionistaEntity nutricionista =
        nutricionistaRepository
            .findById(consultaRequest.getNutricionistaId())
            .orElseThrow(() -> new RuntimeException("Nutricionista não encontrado"));

    ConsultaEntity consultaEntity = new ConsultaEntity();
    consultaEntity.setData(consultaRequest.getData());
    consultaEntity.setPaciente(paciente);
    consultaEntity.setNutricionista(nutricionista);

    ConsultaEntity consultaSalva = consultaRepository.save(consultaEntity);
    return convertToResponse(consultaSalva);
  }

  // buscar consultas
  public List<ConsultaResponse> buscaConsultas() {
    return consultaRepository.findAll().stream()
        .map(this::convertToResponse)
        .collect(Collectors.toList());
  }

  // buscar consulta por ID
  public ConsultaResponse buscaConsultaPorId(Long id) {
    return consultaRepository
        .findById(id)
        .map(this::convertToResponse)
        .orElseThrow(() -> new RuntimeException("Consulta não encontrada"));
  }

  // atualizar consulta
  public ConsultaResponse atualizaConsulta(Long id, ConsultaRequest consultaRequest) {
    ConsultaEntity consultaEntity =
        consultaRepository
            .findById(id)
            .orElseThrow(() -> new RuntimeException("Consulta não encontrada"));
    PacienteEntity paciente =
        pacienteRepository
            .findById(consultaRequest.getPacienteId())
            .orElseThrow(() -> new RuntimeException("Paciente não encontrado"));
    NutricionistaEntity nutricionista =
        nutricionistaRepository
            .findById(consultaRequest.getNutricionistaId())
            .orElseThrow(() -> new RuntimeException("Nutricionista não encontrado"));

    consultaEntity.setData(consultaRequest.getData());
    consultaEntity.setPaciente(paciente);
    consultaEntity.setNutricionista(nutricionista);

    ConsultaEntity consultaAtualizada = consultaRepository.save(consultaEntity);
    return convertToResponse(consultaAtualizada);
  }

  // deletar consulta
  public void deletarConsulta(Long id) {
    if (!consultaRepository.existsById(id)) {
      throw new RuntimeException("Consulta não encontrada");
    }
    consultaRepository.deleteById(id);
  }

  // converte entidade em responseDTO
  private ConsultaResponse convertToResponse(ConsultaEntity consultaEntity) {
    return new ConsultaResponse(
        consultaEntity.getId(),
        consultaEntity.getData(),
        consultaEntity.getPaciente().getId(),
        consultaEntity.getPaciente().getNome(),
        consultaEntity.getNutricionista().getId(),
        consultaEntity.getNutricionista().getNome());
  }
}
