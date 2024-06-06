package entidades;

import java.util.ArrayList;
import java.util.List;

public class Paciente {

  public String nome;
  public int idade;
  public double peso;
  public double altura;
  public int pressaoSistolica;
  public int pressaoDiastolica;
  public double freqCardiaca;
  public String dietaAlimentar;
  public List<String> atividadesFisicas = new ArrayList<String>();

  //ex1:
  //nome: String;
  //idade: int;
  //peso: double;
  //altura: double;
  //pressão arterial: double;
  //frequência cardíaca: double;
  //dietaAlimentar: String;
  //atividadesFisicas: Lista de String.

  public double calculoIMC() {
    return peso / (altura * altura);
  }

  public void monitoramentoPaciente() {
    System.out.printf("""
            Nome: %s
            Idade: %d anos
            Peso: %s kg
            Altura: %s m
            IMC: %.1f""", nome, idade, peso, altura, calculoIMC());
  }

  public void registroAtividades(String atividade) {
    atividadesFisicas.add(atividade);
  }
  //ex3:
  //Calculo IMC
  //Monitoramento de entidades.Paciente
  //Registro de Atividades Fisicas
}
