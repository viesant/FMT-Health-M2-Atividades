package com.viesant.PetshopSpring.controllers;

import com.viesant.PetshopSpring.models.Tutor;
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
@RequestMapping("/tutores")
public class TutorController {
  List<Tutor> tutores = new ArrayList<>();
  private int lastid;

  @PostMapping
  public Tutor createTutor(@RequestBody Tutor tutor) {
    tutor.setId(++lastid);
    tutores.add(tutor);
    return tutor;
  }

  @GetMapping
  public List<Tutor> getAllTutores() {
    return tutores;
  }

  @GetMapping("/{id}")
  public Tutor getTutorById(@PathVariable Integer id) {
    return tutores.stream().filter(tutor -> tutor.getId().equals(id)).findFirst().orElse(null);
  }

  @PutMapping("/{id}")
  public Tutor updateTutor(@PathVariable int id, @RequestBody Tutor tutorInfo) {
    Tutor tutorToUpdate = tutores.stream().filter(tutor -> tutor.getId().equals(id)).findFirst().orElse(null);
    if (tutorToUpdate != null) {
      tutorToUpdate.setNome(tutorInfo.getNome());
      tutorToUpdate.setEndereco(tutorInfo.getEndereco());
      tutorToUpdate.setEmail(tutorInfo.getEmail());
      tutorToUpdate.setTelefone(tutorInfo.getTelefone());
    }

    return tutorToUpdate;
  }

  @DeleteMapping("/{id}")
  public boolean deleteTutor(@PathVariable int id) {
    return tutores.removeIf(tutor -> tutor.getId().equals(id));
  }
}
