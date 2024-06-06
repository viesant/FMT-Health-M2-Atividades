package repositorio;

import entities.Consulta;

import java.util.ArrayList;

public class ListaConsultas {
  static private ArrayList<Consulta> listaConsultas;

  static {
    listaConsultas = new ArrayList<>();
  }

  public static void listar() {
    for (Consulta consulta : listaConsultas) {
      //      System.out.println(consulta);

      System.out.println("Data e hora: " + consulta.getDataHora());
      System.out.println("Nome Nutricionista: " + consulta.getNomeNutricionista());
      System.out.println("Nome Paciente: " + consulta.getNomePaciente());
    }
  }

  public static Consulta buscarPorId(int id) {
    return listaConsultas.get(id);
  }

  public static void adicionar(Consulta consulta) {
    String nutri = consulta.getNomeNutricionista();
    //TODO: buscar nutri pelo nome e nutricionista.incNumConsultas()
    listaConsultas.add(consulta);
  }

  public static void removerPorId(int id) {
    listaConsultas.remove(id);
  }

  public static void alterarPorId(int id, Consulta consulta) {
    listaConsultas.set(id, consulta);
  }

  public static void realizarConsulta(int id){
    Consulta consulta = listaConsultas.get(id);
    consulta.setConsultaRealizada(true);
  }
}
