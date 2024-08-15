package com.viesant.CadastroMedicos.DTO;

import com.viesant.CadastroMedicos.enums.EspecialidadesEnum;
import java.time.LocalDate;

public record MedicoRequest(
    String nome,
    String crm,
    LocalDate dataNascimento,
    EspecialidadesEnum especialidade
) {}
