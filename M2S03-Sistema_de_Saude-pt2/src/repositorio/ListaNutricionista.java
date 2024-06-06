package repositorio;

import entities.Nutricionista;

import java.util.ArrayList;

public class ListaNutricionista {
  static private ArrayList<Nutricionista> listaNutricionistas;

  static {
    listaNutricionistas = new ArrayList<>();
  }

  public static void listar() {
    for (Nutricionista nutricionista : listaNutricionistas) {
      System.out.println(nutricionista.getNome());
    }
  }

  public static Nutricionista buscarPorId(int id) {
    return listaNutricionistas.get(id);
  }

  public static boolean existe(String nome) {
    for (Nutricionista nutricionista : listaNutricionistas) {
      if (nutricionista.getNome().equals(nome)) {
        return true;
      }
    }
    return false;
  }

  public static void adicionar(Nutricionista nutricionista) {
    listaNutricionistas.add(nutricionista);
  }

  public static void removerPorId(int id) {
    listaNutricionistas.remove(id);
  }

  public static void alterarPorId(int id, Nutricionista nutricionista) {
    listaNutricionistas.set(id, nutricionista);
  }
}
