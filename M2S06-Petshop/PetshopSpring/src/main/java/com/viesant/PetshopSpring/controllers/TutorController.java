package com.viesant.PetshopSpring.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tutores")
public class TutorController {
  @PostMapping
  public String createTutor(){
    return "tutor: POST";
  }

  @GetMapping
  public String readTutores() {
    return "tutor: GET";
  }


  @PutMapping
  public String updateTutor(){
    return "tutor: PUT";
  }

  @DeleteMapping
  public String deleteTutor(){
    return "tutor: DELETE";
  }
}
