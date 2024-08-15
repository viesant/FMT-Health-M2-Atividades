package com.viesant.CadastroMedicos.controllers;

import com.viesant.CadastroMedicos.services.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MedicoController {
  @Autowired
  private MedicoService medicoService;

}
