package repositorio;

import entities.Funcionario;

import java.util.ArrayList;

public class ListaFuncionarios {
  static private ArrayList<Funcionario> listaFuncionarios;

  static {
    listaFuncionarios = new ArrayList<>();
  }

  public static void listar() {
    for (Funcionario funcionario : listaFuncionarios) {
      System.out.println(funcionario.getNome());
    }
  }

  public static Funcionario buscarPorId(int id) {
    return listaFuncionarios.get(id);
  }

  public static void adicionar(Funcionario funcionario) {
    listaFuncionarios.add(funcionario);
  }

  public static void removerPorId(int id) {
    listaFuncionarios.remove(id);
  }

  public static void alterarPorId(int id, Funcionario funcionario) {
    listaFuncionarios.set(id, funcionario);
  }
}

