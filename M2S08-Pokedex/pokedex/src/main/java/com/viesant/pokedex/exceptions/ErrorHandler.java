package com.viesant.pokedex.exceptions;

import com.viesant.pokedex.exceptions.dto.ErroResponse;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandler {

  @ExceptionHandler(EntityNotFoundException.class)
  public ResponseEntity<Void> trataEntidadeNaoEncontrada() {
    return ResponseEntity.notFound().build();
  }

  @ExceptionHandler(DuplicateKeyException.class)
  public ResponseEntity<ErroResponse> trataEntidadeJaExiste(DuplicateKeyException e) {
    ErroResponse erro = new ErroResponse();
    erro.setCampo("Número");
    erro.setMensagem(e.getMessage());
    return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<List<ErroResponse>> trataErroValidacao(MethodArgumentNotValidException e) {
    List<FieldError> fieldErros = e.getFieldErrors();
    List<ErroResponse> responseList = fieldErros.stream().map(ErroResponse::new).toList();

    return ResponseEntity.badRequest().body(responseList);
  }

  @ExceptionHandler(HttpMessageNotReadableException.class)
  public ResponseEntity<String> trataEnumInvalido(HttpMessageNotReadableException e) {
    return ResponseEntity.badRequest().body(e.getMessage());
  }
}
