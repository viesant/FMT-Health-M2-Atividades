package com.viesant.CadastroMedicos.services;

import static com.viesant.CadastroMedicos.mappers.MedicoMapper.toEntity;

import com.sun.jdi.request.DuplicateRequestException;
import com.viesant.CadastroMedicos.DTO.MedicoFilterResponse;
import com.viesant.CadastroMedicos.DTO.MedicoRequest;
import com.viesant.CadastroMedicos.enums.EspecialidadesEnum;
import com.viesant.CadastroMedicos.exceptions.ErroValidacaoDTO;
import com.viesant.CadastroMedicos.mappers.MedicoMapper;
import com.viesant.CadastroMedicos.models.Medico;
import com.viesant.CadastroMedicos.repositories.MedicoRepository;
import jakarta.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MedicoService {
  @Autowired private MedicoRepository medicoRepository;

  public Medico createMedico(MedicoRequest medicoRequest) {

    if (medicoRepository.existsByCrm(medicoRequest.crm())) {
      throw new DuplicateRequestException("CRM já cadastrado: " + medicoRequest.crm());
    }

    return medicoRepository.save(toEntity(medicoRequest));
  }

  public Medico updateMedico(long id, MedicoRequest medicoRequest) {
    Medico medico = medicoRepository.findById(id).orElseThrow(EntityNotFoundException::new);

    if (medicoRepository.existsByCrmAndIdNot(medicoRequest.crm(), id)) {
      throw new DuplicateRequestException("CRM já cadastrado: " + medicoRequest.crm());
    }

    MedicoMapper.updateEntity(medicoRequest, medico);
    return medicoRepository.save(medico);
  }

  public List<Medico> getAllMedicos() {
    return medicoRepository.findAll();
  }

  public Page<MedicoFilterResponse> listarMedicos(
      String nome, EspecialidadesEnum especialidade, LocalDate dataNascimento, Pageable pageable) {

    Page<Medico> medicosPage =
        medicoRepository.findByFilters(nome, especialidade, dataNascimento, pageable);

    return medicosPage.map(
        medico ->
            new MedicoFilterResponse(
                medico.getNome(), medico.getEspecialidade(), medico.getDataNascimento()));
  }

  public Medico getMedico(long id) {

    return medicoRepository.findById(id).orElseThrow(EntityNotFoundException::new);
  }

  public void deleteMedico(long id) {
    medicoRepository.deleteById(id);
  }

  public void deleteAll() {
    medicoRepository.deleteAll();
  }
}
