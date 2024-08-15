package com.viesant.CadastroMedicos.services;

import com.viesant.CadastroMedicos.repositories.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicoService {
  @Autowired
  private MedicoRepository medicoRepository;

}
