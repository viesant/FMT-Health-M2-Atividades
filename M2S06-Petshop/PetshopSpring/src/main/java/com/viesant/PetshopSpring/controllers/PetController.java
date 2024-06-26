package com.viesant.PetshopSpring.controllers;

import com.viesant.PetshopSpring.models.Pet;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pets")
public class PetController {
  List<Pet> pets = new ArrayList<>();
  private int lastId;

  @PostMapping
  public Pet createPet(@RequestBody Pet pet) {
    pet.setId(++lastId);
    pets.add(pet);
    return pet;
  }

  @GetMapping
  public List<Pet> getAllPets() {
    return pets;
  }

  @GetMapping("/{id}")
  public Pet getPetById(@PathVariable Integer id) {
    return pets.stream().filter(pet -> pet.getId().equals(id)).findFirst().orElse(null);
  }

  @PutMapping("/{id}")
  public Pet updatePet(@PathVariable int id, @RequestBody Pet petInfo) {
    Pet petToUpdate = pets.stream().filter(pet -> pet.getId().equals(id)).findFirst().orElse(null);
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

  @DeleteMapping("/{id}")
  public boolean deletePet(@PathVariable int id) {
    return pets.removeIf(pet -> pet.getId().equals(id));
  }
}
