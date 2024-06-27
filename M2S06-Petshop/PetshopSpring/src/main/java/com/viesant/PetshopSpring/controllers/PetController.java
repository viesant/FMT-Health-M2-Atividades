package com.viesant.PetshopSpring.controllers;

import com.viesant.PetshopSpring.models.Pet;
import com.viesant.PetshopSpring.services.PetService;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pets")
public class PetController {

  private final PetService petService;

  public PetController(PetService petService) {
    this.petService = petService;
  }

  @PostMapping
  public Pet createPet(@RequestBody Pet pet) {
    return petService.adicionar(pet);
  }

  @GetMapping
  public List<Pet> getAllPets() {
    return petService.listar();
  }

  @GetMapping("/{id}")
  public Pet getPetById(@PathVariable Integer id) {
    return petService.buscarPorId(id);
  }

  @PutMapping("/{id}")
  public Pet updatePet(@PathVariable int id, @RequestBody Pet petInfo) {
    return petService.editar(petInfo);
  }

  @PatchMapping("/{petId}/{tutorId}")
  public Pet linkPetTutorByIds(@PathVariable Integer petId,@PathVariable Integer tutorId) {
    return petService.associarPetTutor(petId, tutorId);
  }

  @DeleteMapping("/{id}")
  public boolean deletePet(@PathVariable int id) {
    return petService.excluir(id);
  }
}
