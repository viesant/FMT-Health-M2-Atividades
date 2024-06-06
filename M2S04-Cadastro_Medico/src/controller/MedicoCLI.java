package controller;

import enums.Operacao;

import java.util.Scanner;

public class MedicoCLI {
  public static void exibirMenu() {
    System.out.print("""
            ******* MENU *******
            1 - Adicionar
            2 - Listar
            0 - Sair
            """);
  }

  public static Operacao respostaMenu(Scanner sc) {
    System.out.print("Escolha uma opção: ");
    try {
      return Operacao.values()[Integer.parseInt(sc.nextLine())];
    } catch (Exception e) {
      return Operacao.INVALIDO;
    }
  }
}
