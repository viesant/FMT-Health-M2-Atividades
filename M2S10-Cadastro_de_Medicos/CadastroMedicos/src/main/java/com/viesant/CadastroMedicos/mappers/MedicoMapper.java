package com.viesant.CadastroMedicos.mappers;

import com.viesant.CadastroMedicos.DTO.MedicoRequest;
import com.viesant.CadastroMedicos.models.Medico;

public class MedicoMapper {

  public static Medico toEntity(MedicoRequest source) {
    Medico target = new Medico();

    updateEntity(source, target);

    return target;
  }

  public static void updateEntity(MedicoRequest source, Medico target) {
    target.setNome(source.nome());
    target.setCrm(source.crm());
    target.setDataNascimento(source.dataNascimento());
    target.setEspecialidade(source.especialidade());
  }
}
