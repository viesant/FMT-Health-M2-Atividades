package com.viesant.CadastroMedicos.services;

import static com.viesant.CadastroMedicos.mappers.MedicoMapper.toEntity;

import com.viesant.CadastroMedicos.DTO.MedicoRequest;
import com.viesant.CadastroMedicos.mappers.MedicoMapper;
import com.viesant.CadastroMedicos.models.Medico;
import com.viesant.CadastroMedicos.repositories.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicoService {
  @Autowired private MedicoRepository medicoRepository;

  public Medico createMedico(MedicoRequest medicoRequest) {

    if (medicoRepository.existsByCrm(medicoRequest.crm())) {
      throw new IllegalArgumentException("CRM já cadastrado: " + medicoRequest.crm());
    }

    return medicoRepository.save(toEntity(medicoRequest));
  }

  public Medico updateMedico(long id, MedicoRequest medicoRequest) {
    Medico medico =
        medicoRepository
            .findById(id)
            .orElseThrow(() -> new RuntimeException("Médico não encontrado com ID: " + id));

    if (medicoRepository.existsByCrmAndIdNot(medicoRequest.crm(), id)) {
      throw new IllegalArgumentException("CRM já cadastrado por outro médico: " + medicoRequest.crm());
    }

    MedicoMapper.updateEntity(medicoRequest, medico);
    return medicoRepository.save(medico);
  }
}
