package entities;

import java.util.ArrayList;
import java.util.List;

public class Paciente {

  private String nome;
  private int idade;
  private double peso;
  private double altura;
  private int pressaoSistolica;
  private int pressaoDiastolica;
  private int freqCardiaca;
  private String dietaAlimentar;
  private List<String> atividadesFisicas;

  public Paciente() {
    atividadesFisicas = new ArrayList<>();
  }

  public Paciente(String nome, int idade, double peso, double altura, int pressaoSistolica, int pressaoDiastolica, int freqCardiaca, String dietaAlimentar, List<String> atividadesFisicas) {
    this.nome = nome;
    this.idade = idade;
    this.peso = peso;
    this.altura = altura;
    this.pressaoSistolica = pressaoSistolica;
    this.pressaoDiastolica = pressaoDiastolica;
    this.freqCardiaca = freqCardiaca;
    this.dietaAlimentar = dietaAlimentar;
    this.atividadesFisicas = atividadesFisicas;
  }


  public Paciente(String nome, int idade, double peso, double altura) {
    this.nome = nome;
    this.idade = idade;
    this.peso = peso;
    this.altura = altura;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public int getIdade() {
    return idade;
  }

  public void setIdade(int idade) {
    this.idade = idade;
  }

  public double getPeso() {
    return peso;
  }

  public void setPeso(double peso) {
    this.peso = peso;
  }

  public double getAltura() {
    return altura;
  }

  public void setAltura(double altura) {
    this.altura = altura;
  }

  public int getPressaoSistolica() {
    return pressaoSistolica;
  }

  public void setPressaoSistolica(int pressaoSistolica) {
    this.pressaoSistolica = pressaoSistolica;
  }

  public int getPressaoDiastolica() {
    return pressaoDiastolica;
  }

  public void setPressaoDiastolica(int pressaoDiastolica) {
    this.pressaoDiastolica = pressaoDiastolica;
  }

  public int getFreqCardiaca() {
    return freqCardiaca;
  }

  public void setFreqCardiaca(int freqCardiaca) {
    this.freqCardiaca = freqCardiaca;
  }

  public String getDietaAlimentar() {
    return dietaAlimentar;
  }

  public void setDietaAlimentar(String dietaAlimentar) {
    this.dietaAlimentar = dietaAlimentar;
  }

  public List<String> getAtividadesFisicas() {
    return atividadesFisicas;
  }

  public void setAtividadesFisicas(List<String> atividadesFisicas) {
    this.atividadesFisicas = atividadesFisicas;
  }

  public double calculoIMC() {
    return peso / (altura * altura);
  }

  public void monitoramentoPaciente() {
    System.out.printf("""
            Nome: %s
            Idade: %d anos
            Peso: %s kg
            Altura: %.2f m
            IMC: %.1f""", nome, idade, peso, altura, calculoIMC());
  }

  public void registroAtividades(String atividade) {
    atividadesFisicas.add(atividade);
  }

  @Override
  public String toString() {
    return "Paciente{" + "nome='" + nome + '\'' + ", idade=" + idade + ", peso=" + peso + ", altura=" + altura + ", pressaoSistolica=" + pressaoSistolica + ", pressaoDiastolica=" + pressaoDiastolica + ", freqCardiaca=" + freqCardiaca + ", dietaAlimentar='" + dietaAlimentar + '\'' + ", atividadesFisicas=" + atividadesFisicas + '}';
  }
}
