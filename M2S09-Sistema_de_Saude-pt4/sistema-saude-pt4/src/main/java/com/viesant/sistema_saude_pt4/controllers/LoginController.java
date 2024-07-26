package com.viesant.sistema_saude_pt4.controllers;

import com.viesant.sistema_saude_pt4.DTO.LoginRequest;
import com.viesant.sistema_saude_pt4.DTO.LoginResponse;
import com.viesant.sistema_saude_pt4.services.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LoginController {
  private final LoginService loginService;

  @PostMapping("/login")
  public ResponseEntity<LoginResponse> validaLogin(@RequestBody LoginRequest user) {

    return ResponseEntity.ok(loginService.validaLogin(user));
  }

}
