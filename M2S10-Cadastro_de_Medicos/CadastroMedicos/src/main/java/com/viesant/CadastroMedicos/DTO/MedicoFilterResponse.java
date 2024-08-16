package com.viesant.CadastroMedicos.DTO;

import com.viesant.CadastroMedicos.enums.EspecialidadesEnum;
import java.time.LocalDate;

public record MedicoFilterResponse(
        String nome,
        EspecialidadesEnum especialidade,
        LocalDate dataNascimento
) {}
