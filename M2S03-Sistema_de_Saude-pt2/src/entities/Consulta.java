package entities;

import java.time.LocalDateTime;

public class Consulta {
  private String nomeNutricionista;
  private String nomePaciente;
  private LocalDateTime dataHora;
  private boolean consultaRealizada;

  public Consulta() {
  }

  public Consulta(String nomeNutricionista, String nomePaciente, LocalDateTime dataHora, boolean consultaRealizada) {
    this.nomeNutricionista = nomeNutricionista;
    this.nomePaciente = nomePaciente;
    this.dataHora = dataHora;
    this.consultaRealizada = consultaRealizada;
  }

  public String getNomeNutricionista() {
    return nomeNutricionista;
  }

  public void setNomeNutricionista(String nomeNutricionista) {
    this.nomeNutricionista = nomeNutricionista;
  }

  public String getNomePaciente() {
    return nomePaciente;
  }

  public void setNomePaciente(String nomePaciente) {
    this.nomePaciente = nomePaciente;
  }

  public LocalDateTime getDataHora() {
    return dataHora;
  }

  public void setDataHora(LocalDateTime dataHora) {
    this.dataHora = dataHora;
  }

  public boolean isConsultaRealizada() {
    return consultaRealizada;
  }

  public void setConsultaRealizada(boolean consultaRealizada) {
    this.consultaRealizada = consultaRealizada;
  }

  @Override
  public String toString() {
    return "Consulta{" + "nomeNutricionista='" + nomeNutricionista + '\'' + ", nomePaciente='" + nomePaciente + '\'' + ", dataHora=" + dataHora + ", consultaRealizada=" + consultaRealizada + '}';
  }
}
