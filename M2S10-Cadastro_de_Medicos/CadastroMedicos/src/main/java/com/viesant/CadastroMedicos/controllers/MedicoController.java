package com.viesant.CadastroMedicos.controllers;

import com.viesant.CadastroMedicos.DTO.MedicoFilterResponse;
import com.viesant.CadastroMedicos.DTO.MedicoRequest;
import com.viesant.CadastroMedicos.enums.EspecialidadesEnum;
import com.viesant.CadastroMedicos.models.Medico;
import com.viesant.CadastroMedicos.services.MedicoService;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medicos")
public class MedicoController {
  @Autowired private MedicoService medicoService;

  @PostMapping
  public Medico createMedico(@RequestBody MedicoRequest medicoRequest) {
    return medicoService.createMedico(medicoRequest);
  }

  @PutMapping("{id}")
  public Medico updateMedico(@PathVariable long id, @RequestBody MedicoRequest medicoRequest) {
    return medicoService.updateMedico(id, medicoRequest);
  }

  @GetMapping
  public Page<MedicoFilterResponse> listarMedicos(
          @RequestParam(required = false) String nome,
          @RequestParam(required = false) EspecialidadesEnum especialidade,
          @RequestParam(required = false) LocalDate dataNascimento,
//          @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataNascimento,
          @PageableDefault(size = 10, sort = "nome") Pageable pageable) {

    return medicoService.listarMedicos(nome, especialidade, dataNascimento, pageable);
  }

  @GetMapping("{id}")
  public Medico getMedico(@PathVariable long id) {
    return medicoService.getMedico(id);
  }

  @DeleteMapping("{id}")
  public void deleteMedico(@PathVariable long id) {
    medicoService.deleteMedico(id);
  }

  // para testes
  @GetMapping("/all")
  public List<Medico> getAllMedicos() {
    return medicoService.getAllMedicos();
  }
}
