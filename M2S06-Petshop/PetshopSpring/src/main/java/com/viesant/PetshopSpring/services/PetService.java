package com.viesant.PetshopSpring.services;

import com.viesant.PetshopSpring.Repositories.PetRepository;
import com.viesant.PetshopSpring.models.Pet;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {
  private final PetRepository petRepository;
  public PetService(PetRepository petRepository){
    this.petRepository = petRepository;
  }

  public Pet adicionar(Pet pet){
    return petRepository.adicionar(pet);
  }

  public List<Pet> listar(){
    return petRepository.listar();
  }

  public Pet buscarPorId(Integer id) {
    return petRepository.buscarPorId(id);
  }

  public Pet editar(Pet petInfo) {
    return petRepository.editar(petInfo);
  }
  public boolean excluir(int id){
    return petRepository.excluir(id);
  }
}
