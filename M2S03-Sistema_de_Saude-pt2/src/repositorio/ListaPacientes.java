package repositorio;

import entities.Paciente;

import java.util.ArrayList;

public class ListaPacientes {
  public static ArrayList<Paciente> listaPaciente;

  static {
    listaPaciente = new ArrayList<>();
  }

  public static void listarPacientes() {
    for (int i = 0; i < listaPaciente.size(); i++) {
      System.out.printf(" %d - %s\n", i + 1, listaPaciente.get(i).getNome());
    }
  }

  public static void adicionarPaciente(Paciente p) {
    listaPaciente.add(p);
  }

  public static void removerPaciente(int index) {

    listaPaciente.remove(index);
  }
  public static boolean existeNome(String nome) {
    for (Paciente paciente : listaPaciente) {
      if (paciente.getNome().equals(nome)) {
        return true;
      }
    }
    return false;
  }

  public static void alterarPaciente(int index, Paciente p) {
    listaPaciente.set(index, p);
  }

  public static Paciente buscarPacienteId(int id) {
    return listaPaciente.get(id);
  }

  // ex2:
  // Lista deve ter os métodos listar, buscarPorId, adicionar, remover e alterar
  // feito
}
