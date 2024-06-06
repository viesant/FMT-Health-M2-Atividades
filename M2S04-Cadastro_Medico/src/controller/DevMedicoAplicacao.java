package controller;

import enums.Operacao;

import java.util.ArrayList;
import java.util.Scanner;

public class DevMedicoAplicacao {
  ArrayList<Medico> listaMedico;

  public DevMedicoAplicacao() {
    listaMedico = new ArrayList<>();
  }

  public void executar() {
    Scanner sc = new Scanner(System.in);
    Operacao opcao = null;

    boolean run = true;

    while (run) {
      MedicoCLI.exibirMenu();

      opcao = MedicoCLI.respostaMenu(sc);

      switch (opcao) {
        case ADICIONAR:
          try{
          addNovoMedico(sc);
          }catch (Exception e) {
//            e.printStackTrace();
            System.out.println("Valor inválido. Voltando ao menu principal");
          }
          enterContinuar(sc);
          break;
        case LISTAR:
          listarMedico();
          enterContinuar(sc);
          break;
        case SAIR:
          System.out.println("SAIR");
          run = false;
          break;
        case INVALIDO:
          System.out.println("Opção inválida, tente novamente!");
          break;
      }
    }
    System.out.println("SISTEMA ENCERRADO!");
  }

  private void listarMedico() {
    if (listaMedico.isEmpty()) {
      System.out.println("Nenhum médico cadastrado");
    } else {
      listaMedico.forEach(System.out::println);
    }
  }

  private void addNovoMedico(Scanner sc) {
    System.out.println("Cadastro de Medico");
    System.out.print("Nome: ");
    String nome = sc.nextLine();
    System.out.print("CRM: ");
    String crm = sc.nextLine();

    for (Medico medico : listaMedico) {
      if (medico.getCrm().equals(crm)) {
        System.out.println("CRM já cadastrado, tente novamente");
        return;
      }
    }

    System.out.print("Idade: ");
    int idade = sc.nextInt();
    sc.nextLine(); //que ódio dessa bosta!!!!
    if (idade <0){
      System.out.println("Valor inválido");
      return;
    }

    System.out.print("Telefone: ");
    String telefone = sc.nextLine();

    System.out.print("Especialidade: ");
    String especialidade = sc.nextLine();

    listaMedico.add(new Medico(nome, crm, idade, telefone, especialidade));
    System.out.printf("Médico %s cadastrado com sucesso!\n", nome);
  }

  private void enterContinuar(Scanner sc) {
    System.out.print("Pressione enter para continuar...");
    sc.nextLine();
  }
}
