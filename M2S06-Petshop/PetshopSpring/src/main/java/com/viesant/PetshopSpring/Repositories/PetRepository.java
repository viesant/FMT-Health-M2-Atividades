package com.viesant.PetshopSpring.Repositories;

import com.viesant.PetshopSpring.models.Pet;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class PetRepository {
  private static List<Pet> pets = new ArrayList<>();
  private int lastId;

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
    }

    return petToUpdate;
  }

  public boolean excluir(int id){
    return pets.removeIf(pet -> pet.getId().equals(id));
  }
}
