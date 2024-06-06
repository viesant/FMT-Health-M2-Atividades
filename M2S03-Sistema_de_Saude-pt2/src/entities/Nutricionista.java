package entities;

import java.util.ArrayList;

public class Nutricionista extends Funcionario {
  private ArrayList<String> certificados;
  private int numConsultas;
  private int tempoExperiencia;

  public Nutricionista() {
  }

  public Nutricionista(String nome, int idade, Endereco endereco, double salario, ArrayList<String> certificados, int numConsultas, int tempoExperiencia) {
    super(nome, idade, endereco, salario);
    this.certificados = certificados;
    this.numConsultas = numConsultas;
    this.tempoExperiencia = tempoExperiencia;
  }


  public ArrayList<String> getCertificados() {
    return certificados;
  }

  public void setCertificados(ArrayList<String> certificados) {
    this.certificados = certificados;
  }

  public int getNumConsultas() {
    return numConsultas;
  }

  public void setNumConsultas(int numConsultas) {
    this.numConsultas = numConsultas;
  }

  public int getTempoExperiencia() {
    return tempoExperiencia;
  }

  public void setTempoExperiencia(int tempoExperiencia) {
    this.tempoExperiencia = tempoExperiencia;
  }

  public void incNumConsultas() {
    this.numConsultas++;
  }

  public void incAnoExperiencia() {
    this.tempoExperiencia++;
  }

  public void addCertificado(String certificado) {
    this.certificados.add(certificado);
  }

  @Override
  public String toString() {
    return "Nutricionista{" + "certificados=" + certificados + ", numConsultas=" + numConsultas + ", tempoExperiencia=" + tempoExperiencia + '}';
  }
}
