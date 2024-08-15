package com.viesant.sistema_saude_pt4.controllers;

import com.viesant.sistema_saude_pt4.DTO.EnderecoRequest;
import com.viesant.sistema_saude_pt4.DTO.EnderecoResponse;
import com.viesant.sistema_saude_pt4.services.EnderecoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/enderecos")
@RequiredArgsConstructor
public class EnderecoController {
  private final EnderecoService enderecoService;

  @PostMapping
  public ResponseEntity<EnderecoResponse> criarEndereco(@RequestBody EnderecoRequest enderecoRequest) {
    EnderecoResponse enderecoResponse = enderecoService.criaEndereco(enderecoRequest);
    return new ResponseEntity<>(enderecoResponse, HttpStatus.CREATED);
  }

  @GetMapping
  public ResponseEntity<List<EnderecoResponse>> buscarEnderecos() {
    List<EnderecoResponse> enderecos = enderecoService.buscaEnderecos();
    return new ResponseEntity<>(enderecos, HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<EnderecoResponse> buscarEnderecoPorId(@PathVariable Long id) {
    EnderecoResponse endereco = enderecoService.buscaEnderecoPorId(id);
    return new ResponseEntity<>(endereco, HttpStatus.OK);
  }

  @PutMapping("/{id}")
  public ResponseEntity<EnderecoResponse> atualizarEndereco(@PathVariable Long id, @RequestBody EnderecoRequest enderecoRequest) {
    EnderecoResponse enderecoAtualizado = enderecoService.atualizaEndereco(id, enderecoRequest);
    return new ResponseEntity<>(enderecoAtualizado, HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deletarEndereco(@PathVariable Long id) {
    enderecoService.deletaEndereco(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

}
