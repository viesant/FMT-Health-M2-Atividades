package com.viesant.PetshopSpring.Repositories;

import com.viesant.PetshopSpring.models.Pet;
import java.util.ArrayList;
import java.util.List;

import com.viesant.PetshopSpring.models.Tutor;
import org.springframework.stereotype.Repository;

@Repository
public class PetRepository {
  private static final List<Pet> pets = new ArrayList<>();
  private int lastId;
  private final TutorRepository tutorRepository;
  public PetRepository(TutorRepository tutorRepository) {
    this.tutorRepository = tutorRepository;
  }

  public Pet associarPetTutorPorId(Integer petId, Integer tutorID){
    Pet pet = buscarPorId(petId);
    if (pet != null){
      Tutor tutor = tutorRepository.buscarPorId(tutorID);
      if (tutor != null){
        pet.setTutor(tutor);
        return pet;
      }
      //tutor não encontrado

    }
    // pet não encontrado
    return null;
  }

  public Pet adicionar(Pet pet) {
    pet.setId(++lastId);
    pets.add(pet);
    return pet;
  }
  public List<Pet> listar(){
    return pets;
  }

  public Pet buscarPorId(Integer id) {
    return pets.stream().filter(pet -> pet.getId().equals(id)).findFirst().orElse(null);
  }

  public Pet editar(Pet petInfo) {

    Pet petToUpdate = buscarPorId(petInfo.getId());
    if (petToUpdate != null) {
      petToUpdate.setNome(petInfo.getNome());
      petToUpdate.setDataNascimento(petInfo.getDataNascimento());
      petToUpdate.setEspecie(petInfo.getEspecie());
      petToUpdate.setRaca(petInfo.getRaca());
      petToUpdate.setSexo(petInfo.getSexo());
      petToUpdate.setPeso(petInfo.getPeso());
//      petToUpdate.setTutor(petInfo.getTutor());
    }

    return petToUpdate;
  }

  public boolean excluir(int id){
    return pets.removeIf(pet -> pet.getId().equals(id));
  }
}
