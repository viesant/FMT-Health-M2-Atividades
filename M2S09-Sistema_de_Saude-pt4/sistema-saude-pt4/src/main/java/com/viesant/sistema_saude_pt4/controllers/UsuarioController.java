package com.viesant.sistema_saude_pt4.controllers;

import com.viesant.sistema_saude_pt4.DTO.LoginRequest;
import com.viesant.sistema_saude_pt4.DTO.LoginResponse;
import com.viesant.sistema_saude_pt4.DTO.UsuarioRequest;
import com.viesant.sistema_saude_pt4.DTO.UsuarioResponse;
import com.viesant.sistema_saude_pt4.services.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

  private final UsuarioService usuarioService;

  @PostMapping("/cadastro")
  public ResponseEntity<UsuarioResponse> cadastrarUsuario(@RequestBody UsuarioRequest newUser) {

    return ResponseEntity.ok(usuarioService.cadastraUsuario(newUser));
  }
}
