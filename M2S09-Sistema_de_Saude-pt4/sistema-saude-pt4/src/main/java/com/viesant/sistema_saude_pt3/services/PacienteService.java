package com.viesant.sistema_saude_pt3.services;

import com.viesant.sistema_saude_pt3.DTO.PacienteRequest;
import com.viesant.sistema_saude_pt3.DTO.PacienteResponse;
import com.viesant.sistema_saude_pt3.entities.EnderecoEntity;
import com.viesant.sistema_saude_pt3.entities.PacienteEntity;
import com.viesant.sistema_saude_pt3.repositories.EnderecoRepository;
import com.viesant.sistema_saude_pt3.repositories.PacienteRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PacienteService {

  private final PacienteRepository pacienteRepository;
  private final EnderecoRepository enderecoRepository;

  // criar paciente
  public PacienteResponse criaPaciente(PacienteRequest paciente) {
    EnderecoEntity endereco = enderecoRepository.findById(paciente.getEnderecoId()).orElse(null);
    if (endereco != null) {
      PacienteEntity pacienteEntity = new PacienteEntity();
      pacienteEntity.setNome(paciente.getNome());
      pacienteEntity.setNascimento(paciente.getNascimento());
      pacienteEntity.setEndereco(endereco);

      PacienteEntity pacienteSalvo = pacienteRepository.save(pacienteEntity);
      return convertToResponse(pacienteSalvo);
    }
    return null;
  }

  // busca pacientes
  public List<PacienteResponse> buscaPacientes() {
    return pacienteRepository.findAll().stream()
        .map(this::convertToResponse)
        .collect(Collectors.toList());
  }

  // buscar paciente por ID
  public PacienteResponse buscaPacientePorId(Long id) {
    return pacienteRepository.findById(id).map(this::convertToResponse).orElse(null);
  }

  // atualizar paciente
  public PacienteResponse atualizaPaciente(Long id, PacienteRequest pacienteRequest) {
    PacienteEntity paciente = pacienteRepository.findById(id).orElse(null);
    EnderecoEntity enderecoEntity =
        enderecoRepository.findById(pacienteRequest.getEnderecoId()).orElse(null);

    if (paciente != null && enderecoEntity != null) {
      paciente.setNome(pacienteRequest.getNome());
      paciente.setNascimento(pacienteRequest.getNascimento());
      paciente.setEndereco(enderecoEntity);
      PacienteEntity pacienteSalvo = pacienteRepository.save(paciente);
      return convertToResponse(pacienteSalvo);
    }
    return null;
  }

  // deletar paciente
  public void deletaPaciente(Long id) {
    if (pacienteRepository.existsById(id)) {
      pacienteRepository.deleteById(id);
    }
  }

  // converte entidade em responseDTO
  private PacienteResponse convertToResponse(PacienteEntity pacienteEntity) {
    return new PacienteResponse(
        pacienteEntity.getId(),
        pacienteEntity.getNome(),
        pacienteEntity.getNascimento(),
        pacienteEntity.getEndereco().getId());
  }
}
