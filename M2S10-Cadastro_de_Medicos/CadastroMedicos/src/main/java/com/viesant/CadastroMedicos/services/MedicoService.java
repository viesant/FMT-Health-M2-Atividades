package com.viesant.CadastroMedicos.services;

import static com.viesant.CadastroMedicos.mappers.MedicoMapper.toEntity;

import com.viesant.CadastroMedicos.DTO.MedicoRequest;
import com.viesant.CadastroMedicos.models.Medico;
import com.viesant.CadastroMedicos.repositories.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicoService {
  @Autowired private MedicoRepository medicoRepository;

  public Medico createMedico(MedicoRequest medicoRequest) {

    return medicoRepository.save(toEntity(medicoRequest));
  }
}
