package com.viesant.PetshopSpring.controllers;

import com.viesant.PetshopSpring.models.Tutor;
import com.viesant.PetshopSpring.services.TutorService;
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
  private final TutorService tutorService;

  public TutorController(TutorService tutorService) {
    this.tutorService = tutorService;
  }

  @PostMapping
  public Tutor createTutor(@RequestBody Tutor tutor) {
    return tutorService.adicionar(tutor);
  }

  @GetMapping
  public List<Tutor> getAllTutores() {
    return tutorService.listar();
  }

  @GetMapping("/{id}")
  public Tutor getTutorById(@PathVariable Integer id) {
    return tutorService.buscarPorId(id);
  }

  @PutMapping("/{id}")
  public Tutor updateTutor(@PathVariable int id, @RequestBody Tutor tutorInfo) {
    return tutorService.editar(tutorInfo);
  }

  @DeleteMapping("/{id}")
  public boolean deleteTutor(@PathVariable int id) {
    return tutorService.excluir(id);
  }
}
