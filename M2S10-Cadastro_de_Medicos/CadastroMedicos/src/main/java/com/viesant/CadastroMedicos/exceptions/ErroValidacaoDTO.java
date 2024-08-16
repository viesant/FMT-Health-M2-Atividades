package com.viesant.CadastroMedicos.exceptions;

import org.springframework.validation.FieldError;

public class ErroValidacaoDTO {
  private String campo;
  private String mensagem;

  public ErroValidacaoDTO(FieldError erro) {
    this.campo = erro.getField();
    this.mensagem = erro.getDefaultMessage();
  }
  public ErroValidacaoDTO(String campo, String mensagem) {
    this.campo = campo;
    this.mensagem = mensagem;
  }

  public String getCampo() {
    return campo;
  }

  public void setCampo(String campo) {
    this.campo = campo;
  }

  public String getMensagem() {
    return mensagem;
  }

  public void setMensagem(String mensagem) {
    this.mensagem = mensagem;
  }
}
