package com.viesant.sistema_saude_pt4.services;

import com.viesant.sistema_saude_pt4.DTO.EnderecoRequest;
import com.viesant.sistema_saude_pt4.DTO.EnderecoResponse;
import com.viesant.sistema_saude_pt4.entities.EnderecoEntity;
import com.viesant.sistema_saude_pt4.repositories.EnderecoRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EnderecoService {

  private final EnderecoRepository enderecoRepository;

  // criar endereco
  public EnderecoResponse criaEndereco(EnderecoRequest enderecoRequest) {
    EnderecoEntity enderecoEntity = new EnderecoEntity();
    enderecoEntity.setLogradouro(enderecoRequest.getLogradouro());
    enderecoEntity.setEstado(enderecoRequest.getEstado());
    enderecoEntity.setCidade(enderecoRequest.getCidade());
    enderecoEntity.setNumero(enderecoRequest.getNumero());
    enderecoEntity.setCep(enderecoRequest.getCep());

    EnderecoEntity enderecoSalvo = enderecoRepository.save(enderecoEntity);
    return convertToResponse(enderecoSalvo);
  }

  // buscar endereços
  public List<EnderecoResponse> buscaEnderecos() {
    return enderecoRepository.findAll().stream()
        .map(this::convertToResponse)
        .collect(Collectors.toList());
  }

  // buscar um endereço por ID
  public EnderecoResponse buscaEnderecoPorId(Long id) {
    return enderecoRepository.findById(id).map(this::convertToResponse).orElse(null);
  }

  // atualizar endereço
  public EnderecoResponse atualizaEndereco(Long id, EnderecoRequest enderecoRequest) {
    EnderecoEntity enderecoEntity = enderecoRepository.findById(id).orElse(null);
    if (enderecoEntity != null) {
      enderecoEntity.setLogradouro(enderecoRequest.getLogradouro());
      enderecoEntity.setEstado(enderecoRequest.getEstado());
      enderecoEntity.setCidade(enderecoRequest.getCidade());
      enderecoEntity.setNumero(enderecoRequest.getNumero());
      enderecoEntity.setCep(enderecoRequest.getCep());

      EnderecoEntity enderecoAtualizado = enderecoRepository.save(enderecoEntity);
      return convertToResponse(enderecoAtualizado);
    }
    return null;
  }

  // deletar endereço
  public void deletaEndereco(Long id) {
    if (!enderecoRepository.existsById(id)) {
      return;
    }
    enderecoRepository.deleteById(id);
  }

  // converte entidade em responseDTO
  private EnderecoResponse convertToResponse(EnderecoEntity enderecoEntity) {
    return new EnderecoResponse(
        enderecoEntity.getId(),
        enderecoEntity.getLogradouro(),
        enderecoEntity.getEstado(),
        enderecoEntity.getCidade(),
        enderecoEntity.getNumero(),
        enderecoEntity.getCep());
  }
}
