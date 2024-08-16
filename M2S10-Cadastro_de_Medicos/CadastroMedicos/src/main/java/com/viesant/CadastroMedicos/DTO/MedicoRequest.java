package com.viesant.CadastroMedicos.DTO;

import com.viesant.CadastroMedicos.enums.EspecialidadesEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record MedicoRequest(
    @NotNull(message = "Campo 'nome' é obrigatório.") String nome,
    @NotNull(message = "Campo 'crm' é obrigatório.") String crm,
    @NotNull(message = "Campo 'dataNascimento' é obrigatório.") LocalDate dataNascimento,
    @NotNull(message = "Campo 'especialidades' é obrigatório.") EspecialidadesEnum especialidade) {}
