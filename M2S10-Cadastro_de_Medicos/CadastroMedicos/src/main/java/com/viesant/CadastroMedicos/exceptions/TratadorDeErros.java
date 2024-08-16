package com.viesant.CadastroMedicos.exceptions;

import com.sun.jdi.request.DuplicateRequestException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class TratadorDeErros {

  @ExceptionHandler(DuplicateRequestException.class)
  public ResponseEntity<String> handleDuplicateRequestException(
      DuplicateRequestException ex) {

    return new ResponseEntity<>(ex.getLocalizedMessage(), HttpStatus.CONFLICT);
  }

  @ExceptionHandler(EntityNotFoundException.class)
  public ResponseEntity<Void> trataEntidadeNaoEncontrada() {
    return ResponseEntity.notFound().build();
  }


  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<List<ErroValidacaoDTO>> trataParametroInvalido(MethodArgumentNotValidException ex) {
    List<FieldError> erros = ex.getFieldErrors();
    return ResponseEntity.badRequest().body(
            erros.stream()
                    .map(ErroValidacaoDTO::new).toList());
  }
}
