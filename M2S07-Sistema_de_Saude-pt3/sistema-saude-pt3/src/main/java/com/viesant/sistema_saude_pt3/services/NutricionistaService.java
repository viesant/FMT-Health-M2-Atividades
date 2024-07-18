package com.viesant.sistema_saude_pt3.services;

import com.viesant.sistema_saude_pt3.DTO.NutricionistaRequest;
import com.viesant.sistema_saude_pt3.DTO.NutricionistaResponse;
import com.viesant.sistema_saude_pt3.entities.EnderecoEntity;
import com.viesant.sistema_saude_pt3.entities.NutricionistaEntity;
import com.viesant.sistema_saude_pt3.repositories.EnderecoRepository;
import com.viesant.sistema_saude_pt3.repositories.NutricionistaRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NutricionistaService {
  private final NutricionistaRepository nutricionistaRepository;
  private final EnderecoRepository enderecoRepository;

  // criar nutricionista
  public NutricionistaResponse criaNutricionista(NutricionistaRequest nutricionistaRequest) {

    EnderecoEntity endereco =
        enderecoRepository
            .findById(nutricionistaRequest.getEnderecoId())
            .orElseThrow(() -> new RuntimeException("Endereço não encontrado"));

    NutricionistaEntity nutricionistaEntity = new NutricionistaEntity();
    nutricionistaEntity.setNome(nutricionistaRequest.getNome());
    nutricionistaEntity.setMatricula(nutricionistaRequest.getMatricula());
    nutricionistaEntity.setEspecialidade(nutricionistaRequest.getEspecialidade());
    nutricionistaEntity.setEndereco(endereco);

    NutricionistaEntity entitySalva = nutricionistaRepository.save(nutricionistaEntity);
    return convertToResponse(entitySalva);
  }

  // buscar nutricionistas
  public List<NutricionistaResponse> buscaNutricionistas() {
    return nutricionistaRepository.findAll().stream()
        .map(this::convertToResponse)
        .collect(Collectors.toList());
  }

  // buscar nutricionista por ID
  public NutricionistaResponse buscaNutricionistaPorId(Long id) {
    return nutricionistaRepository.findById(id).map(this::convertToResponse).orElse(null);
  }

  // atualizar nutricionista
  public NutricionistaResponse atualizaNutricionista(
      Long id, NutricionistaRequest nutricionistaRequest) {
    NutricionistaEntity nutricionistaEntity = nutricionistaRepository.findById(id).orElse(null);
    EnderecoEntity enderecoEntity =
        enderecoRepository.findById(nutricionistaRequest.getEnderecoId()).orElse(null);
    if (nutricionistaEntity != null && enderecoEntity != null) {
      nutricionistaEntity.setNome(nutricionistaRequest.getNome());
      nutricionistaEntity.setEspecialidade(nutricionistaRequest.getEspecialidade());
      nutricionistaEntity.setMatricula(nutricionistaRequest.getMatricula());
      nutricionistaEntity.setEndereco(enderecoEntity);

      NutricionistaEntity nutricionistaSalvo = nutricionistaRepository.save(nutricionistaEntity);
      return convertToResponse(nutricionistaSalvo);
    }
    return null;
  }

  // deletar nutricionista
  public void deletaNutricionista(Long id) {
    if (nutricionistaRepository.existsById(id)) {
      nutricionistaRepository.deleteById(id);
    }
  }

  // converte entidade em responseDTO
  private NutricionistaResponse convertToResponse(NutricionistaEntity nutricionistaEntity) {
    return new NutricionistaResponse(
        nutricionistaEntity.getId(),
        nutricionistaEntity.getNome(),
        nutricionistaEntity.getMatricula(),
        nutricionistaEntity.getEspecialidade(),
        nutricionistaEntity.getEndereco().getId());
  }
}
