package com.viesant.PetshopSpring.services;

import com.viesant.PetshopSpring.Repositories.PetRepository;
import com.viesant.PetshopSpring.models.Pet;
import com.viesant.PetshopSpring.models.Tutor;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class PetService {
  private final PetRepository petRepository;

  public PetService(PetRepository petRepository, TutorService tutorService) {
    this.petRepository = petRepository;
  }

  public Pet associarPetTutor(Integer petId, Integer tutorId){
    return petRepository.associarPetTutorPorId(petId, tutorId);
  }

  public Pet adicionar(Pet pet) {
    return petRepository.adicionar(pet);
  }

  public List<Pet> listar() {
    return petRepository.listar();
  }

  public Pet buscarPorId(Integer id) {
    return petRepository.buscarPorId(id);
  }

  public Pet editar(Pet petInfo) {
    return petRepository.editar(petInfo);
  }

  public boolean excluir(int id) {
    return petRepository.excluir(id);
  }
}
