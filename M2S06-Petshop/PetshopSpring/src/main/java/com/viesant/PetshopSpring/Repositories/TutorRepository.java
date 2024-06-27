package com.viesant.PetshopSpring.Repositories;

import com.viesant.PetshopSpring.models.Tutor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TutorRepository {  private static List<Tutor> tutores = new ArrayList<>();
  private int lastId;

  public Tutor adicionar(Tutor tutor) {
    tutor.setId(++lastId);
    tutores.add(tutor);
    return tutor;
  }
  public List<Tutor> listar(){
    return tutores;
  }

  public Tutor buscarPorId(Integer id) {
    return tutores.stream().filter(tutor -> tutor.getId().equals(id)).findFirst().orElse(null);
  }

  public Tutor editar(Tutor tutorInfo) {

    Tutor tutorToUpdate = buscarPorId(tutorInfo.getId());
    if (tutorToUpdate != null) {
      tutorToUpdate.setNome(tutorInfo.getNome());
      tutorToUpdate.setEndereco(tutorInfo.getEndereco());
      tutorToUpdate.setEmail(tutorInfo.getEmail());
      tutorToUpdate.setTelefone(tutorInfo.getTelefone());
    }

    return tutorToUpdate;
  }

  public boolean excluir(int id){
    return tutores.removeIf(tutor -> tutor.getId().equals(id));
  }
}
