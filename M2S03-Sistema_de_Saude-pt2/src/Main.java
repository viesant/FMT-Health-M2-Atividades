import entities.*;
import repositorio.ListaConsultas;
import repositorio.ListaFuncionarios;
import repositorio.ListaNutricionista;
import repositorio.ListaPacientes;

import java.util.Scanner;

public class Main {

  private static final Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
    System.out.println("[M2S02] - Sistema de Saúde");

    String opcao;

    boolean running = true;
    while (running) {
      System.out.print("""
              Escolha uma opção:
               1 - Cadastrar paciente
               2 - Listar pacientes
               3 - Alterar informações de paciente
               4 - Mostrar informações de paciente
               5 - Registrar atividade física para paciente
               6 - Remover paciente
               7 - Cadastrar funcionário
               8 - Cadastrar nutricionista
               9 - Listar funcionários e nutricionistas
               10 - Criar consulta
               11 - Listar consultas
               12 - Realizar consulta
               S - Sair
              Opção:\s""");
      opcao = sc.next().toLowerCase();
      sc.nextLine();
      switch (opcao) {
        case "1":
          cadastrarPaciente();
          break;
        case "2":
          listarPacientes();
          break;
        case "3":
          alterarInfoPaciente();
          break;
        case "4":
          mostrarInfoPaciente();
          break;
        case "5":
          addAtividadePaciente();
          break;
        case "6":
          removerPaciente();
          break;
        case "7":
          cadastrarFuncionario();
          break;
        case "8":
          cadastrarNutricionista();
          break;
        case "9":
          listarFuncionarios();
          break;
        case "10":
          criarConsulta();
          break;
        case "11":
          listarConsultas();
          break;
        case "12":
          realizarConsulta();
          break;
        case "s":
          running = false;
          System.out.println("Encerrando o programa!");
          break;
        default:
          System.out.println("Opção inválida");
      }
    }
    sc.close();
  }


  private static void cadastrarPaciente() {

    Paciente novoPaciente = new Paciente();
    System.out.println("\nCADASTRAR NOVO PACIENTE");
    System.out.println("Preencha os campos com os dados do novo paciente");
    System.out.print("Nome: ");
    novoPaciente.setNome(sc.nextLine());
    System.out.print("Idade: ");
    novoPaciente.setIdade(sc.nextInt());
    System.out.print("Peso (kg): ");
    novoPaciente.setPeso(sc.nextDouble());
    System.out.print("Altura (m):");
    novoPaciente.setAltura(sc.nextDouble());

    ListaPacientes.adicionarPaciente(novoPaciente);
  }

  private static void listarPacientes() {
    System.out.printf("EXIBIR LISTA DE PACIENTES - TOTAL: %d PACIENTES\n", ListaPacientes.listaPaciente.size());
    System.out.println("ID - NOME");
    ListaPacientes.listarPacientes();
    System.out.println("## FIM DA LISTA ##");
    System.out.print("Pressione Enter para voltar ao menu inicial");
    sc.nextLine();
  }

  private static void alterarInfoPaciente() {
    System.out.println("ALTERAR INFORMAÇÕES DE PACIENTES");
    System.out.println("Escolha um id para editar:");
    int id = Integer.parseInt(sc.nextLine());

    if (id > 0 && id <= ListaPacientes.listaPaciente.size()) {
      Paciente tempPaciente = ListaPacientes.buscarPacienteId(id - 1);
      System.out.print("Peso(kg): ");
      tempPaciente.setPeso(sc.nextDouble());

      System.out.print("Altura (m): ");
      tempPaciente.setAltura(sc.nextDouble());

      System.out.print("Pressão Arterial Sistólica: ");
      tempPaciente.setPressaoSistolica(sc.nextInt());

      System.out.print("Pressão Arterial Diastólica: ");
      tempPaciente.setPressaoDiastolica(sc.nextInt());

      System.out.print("Frequência Cardíaca (bpm): ");
      tempPaciente.setFreqCardiaca(sc.nextInt());
    } else {
      System.out.println("Id inválido");
    }
    System.out.print("\nPressione Enter para voltar ao menu inicial");
    sc.nextLine();
  }

  private static void mostrarInfoPaciente() {
    System.out.println("EXIBIR INFORMAÇÕES DE PACIENTES");
    System.out.println("Escolha um id para exibir:");
    int id = Integer.parseInt(sc.nextLine());

    if (id > 0 && id <= ListaPacientes.listaPaciente.size()) {
      Paciente tempPaciente = ListaPacientes.buscarPacienteId(id - 1);
      System.out.println(tempPaciente);
      System.out.printf("\n\n\n\n");
      System.out.println(ListaPacientes[0]);
      System.out.println("Nome: " + tempPaciente.getNome());
      System.out.println("Idade: " + tempPaciente.getIdade());
      System.out.println("Peso: " + tempPaciente.getPeso());
      System.out.println("Altura: " + tempPaciente.getAltura());
      System.out.println("Pressão Arterial: " + tempPaciente.getPressaoDiastolica() + " x " + tempPaciente.getPressaoSistolica());
      System.out.println("Frequência Cardíaca: " + tempPaciente.getFreqCardiaca() + "bpm");
      System.out.println("Lista de atividades físicas:\n" + tempPaciente.getAtividadesFisicas());
    } else {
      System.out.println("Id inválido");
    }
    System.out.print("\nPressione Enter para voltar ao menu inicial");
    sc.nextLine();
  }

  private static void addAtividadePaciente() {
    System.out.println("ADICIONAR ATIVIDADE AO PACIENTE");
    System.out.println("Escolha um id para adicionar atividade:");
    int id = Integer.parseInt(sc.nextLine());
    if (id > 0 && id <= ListaPacientes.listaPaciente.size()) {
      Paciente tempPaciente = ListaPacientes.buscarPacienteId(id - 1);

      System.out.println("Digite o nome do atividade:");
      tempPaciente.getAtividadesFisicas().add(sc.nextLine());

      ListaPacientes.alterarPaciente(id - 1, tempPaciente);
    } else {
      System.out.println("Id inválido");
    }
    System.out.print("\nPressione Enter para voltar ao menu inicial");
    sc.nextLine();
  }

  private static void removerPaciente() {
    System.out.println("REMOVER PACIENTE");
    System.out.println("Escolha um id para remover:");
    int id = Integer.parseInt(sc.nextLine());
    if (id > 0 && id <= ListaPacientes.listaPaciente.size()) {
      Paciente tempPaciente = ListaPacientes.buscarPacienteId(id - 1);
      System.out.printf("Remover paciente %d - %s? s/N\n", id, tempPaciente.getNome());

      if (sc.nextLine().equalsIgnoreCase("s")) {
        ListaPacientes.removerPaciente(id - 1);
        System.out.println("entidades.Paciente removido com sucesso!");
      } else {
        System.out.println("Operação cancelada!");
      }
    } else {
      System.out.println("Id inválido");
    }
    System.out.print("\nPressione Enter para voltar ao menu inicial");
    sc.nextLine();
  }

  private static void cadastrarFuncionario() {
    Funcionario novoFuncionario = new Funcionario();
    System.out.println("\nCADASTRAR NOVO FUNCIONARIO");
    System.out.println("Preencha os campos com os dados do novo funcionario");
    System.out.print("Nome: ");
    novoFuncionario.setNome(sc.nextLine());
    System.out.print("Idade: ");
    novoFuncionario.setIdade(sc.nextInt());
    //    novoFuncionario.setIdade(Integer.parseInt(sc.nextLine()));
    System.out.print("Salário: ");
    novoFuncionario.setSalario(sc.nextDouble());
    //    novoFuncionario.setSalario(Double.parseDouble(sc.nextLine()));
    novoFuncionario.setEndereco(cadastrarEndereco());
  }


  private static void cadastrarNutricionista() {
    Nutricionista novoNutricionista = new Nutricionista();
    boolean nomeUnico = false;
    System.out.println("\nCADASTRAR NOVO NUTRICIONISTA");
    System.out.println("Preencha os campos com os dados do novo funcionario");
    do {
      System.out.print("Nome: ");
      String nome = sc.nextLine();
      if (ListaNutricionista.existe(nome)) {
        System.out.println("Este nome já está cadastrado");
      } else {
        novoNutricionista.setNome(sc.nextLine());
        nomeUnico = true;
      }
    } while (!nomeUnico);

    System.out.print("Idade: ");
    novoNutricionista.setIdade(sc.nextInt());
    //    novoNutricionista.setIdade(Integer.parseInt(sc.nextLine()));
    System.out.print("Salário: ");
    novoNutricionista.setSalario(sc.nextDouble());
    //    novoNutricionista.setSalario(Double.parseDouble(sc.nextLine()));
    novoNutricionista.setEndereco(cadastrarEndereco());
    System.out.println("Tempo de experiência em anos: ");
    novoNutricionista.setTempoExperiencia(sc.nextInt());
  }

  private static Endereco cadastrarEndereco() {
    Endereco novoEndereco = new Endereco();
    System.out.println("\nCADASTRAR ENDEREÇO");
    System.out.println("Logradouro:");
    novoEndereco.setLogradouro(sc.nextLine());
    System.out.println("Estado:");
    novoEndereco.setEstado(sc.nextLine());
    System.out.println("Cidade:");
    novoEndereco.setCidade(sc.nextLine());
    System.out.println("Número:");
    novoEndereco.setNumero(sc.nextLine());
    System.out.println("CEP:");
    novoEndereco.setCep(sc.nextLine());
    return novoEndereco;
  }

  private static void listarFuncionarios() {
    System.out.println("Lista de Nutricionistas:");
    ListaNutricionista.listar();

    System.out.println("Lista demais funcionários:");
    ListaFuncionarios.listar();
  }

  private static void criarConsulta() {
    Consulta novaConsulta = new Consulta();
    System.out.println("\nCADASTRAR CONSULTA");
    System.out.println("Nome do nutricionista:");
    String nomeNutri = sc.nextLine();
    if (ListaNutricionista.existe(nomeNutri)) {
      novaConsulta.setNomeNutricionista(nomeNutri);
    } else {
      System.out.println("Nutricionista não cadastrado");
    }
    System.out.println("Nome do paciente:");
    String nomePaciente = sc.nextLine();
    if (ListaPacientes.existeNome(nomePaciente)) {
      novaConsulta.setNomePaciente(nomePaciente);
    } else {
      System.out.println("Paciente não cadastrado");
    }
  }

  private static void listarConsultas() {
    ListaConsultas.listar();
  }

  private static void realizarConsulta() {
    System.out.println("Escolha um id de consulta para realizar:");
    int id = Integer.parseInt(sc.nextLine());
    ListaConsultas.realizarConsulta(id);
  }
}
