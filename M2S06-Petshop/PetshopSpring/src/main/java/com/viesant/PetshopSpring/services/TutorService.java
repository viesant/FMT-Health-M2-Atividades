package com.viesant.PetshopSpring.services;


import com.viesant.PetshopSpring.Repositories.TutorRepository;
import com.viesant.PetshopSpring.models.Tutor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TutorService {
  private final TutorRepository tutorRepository;
  public TutorService(TutorRepository tutorRepository){
    this.tutorRepository = tutorRepository;
  }

  public Tutor adicionar(Tutor tutor){
    return tutorRepository.adicionar(tutor);
  }

  public List<Tutor> listar(){
    return tutorRepository.listar();
  }

  public Tutor buscarPorId(Integer id) {
    return tutorRepository.buscarPorId(id);
  }

  public Tutor editar(Tutor tutorInfo) {
    return tutorRepository.editar(tutorInfo);
  }
  public boolean excluir(int id){
    return tutorRepository.excluir(id);
  }
}
