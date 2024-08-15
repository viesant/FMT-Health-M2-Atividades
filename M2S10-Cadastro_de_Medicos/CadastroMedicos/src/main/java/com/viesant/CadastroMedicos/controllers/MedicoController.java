package com.viesant.CadastroMedicos.controllers;

import com.viesant.CadastroMedicos.DTO.MedicoRequest;
import com.viesant.CadastroMedicos.models.Medico;
import com.viesant.CadastroMedicos.services.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medicos")
public class MedicoController {
  @Autowired
  private MedicoService medicoService;

  @PostMapping
  public Medico createMedico(@RequestBody MedicoRequest medicoRequest){
    return medicoService.createMedico(medicoRequest);
  }

  @PutMapping("{id}")
  public Medico updateMedico(@PathVariable long id, @RequestBody MedicoRequest medicoRequest){
    return medicoService.updateMedico(id, medicoRequest);
  }

}
