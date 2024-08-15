package com.viesant.sistema_saude_pt4.controllers;

import com.viesant.sistema_saude_pt4.DTO.UsuarioRequest;
import com.viesant.sistema_saude_pt4.entities.UsuarioEntity;
import com.viesant.sistema_saude_pt4.services.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

      @PostMapping("/usuarios")
    public ResponseEntity<UsuarioEntity> novoUsuario(@RequestBody UsuarioRequest usuarioRequest) {
      return new ResponseEntity<>(usuarioService.novoUsuario(usuarioRequest), HttpStatus.CREATED);
    }

    @GetMapping("/usuarios")
    public ResponseEntity<List<UsuarioEntity>> listarUsuarios() {
      return ResponseEntity.ok(usuarioService.listaUsuarios());
    }

}
