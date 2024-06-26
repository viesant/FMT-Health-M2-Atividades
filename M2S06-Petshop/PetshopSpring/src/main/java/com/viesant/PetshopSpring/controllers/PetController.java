package com.viesant.PetshopSpring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pets")
public class PetController {
  @PostMapping
  public String createPet(){
    return "pet: POST";
  }

  @GetMapping
  public String readPets() {
    return "pet: GET";
  }


  @PutMapping
  public String updatePet(){
    return "pet: PUT";
  }

  @DeleteMapping
  public String deletePet(){
    return "pet: DELETE";
  }

}
