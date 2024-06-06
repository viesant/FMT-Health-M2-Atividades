import entidades.Paciente;
import repositorio.ListaPaciente;
// Ex11
import java.util.Scanner;

public class Main {


  public static void main(String[] args) {
    System.out.println("[M2S02] - Sistema de Saúde");
    Scanner sc = new Scanner(System.in);


    String opcao;

    boolean running = true;
    while (running) {
      //Ex 4
      System.out.print("""
              Escolha uma opção:
               1 - Cadastrar um novo paciente
               2 - Listar todos os pacientes
               3 - Alterar informações do paciente
               4 - Mostrar informações de um paciente
               5 - Registrar atividade física para um paciente
               6 - Remover paciente
               S - Sair
              Opção:\s""");
      opcao = sc.next().toLowerCase();
      sc.nextLine();
      switch (opcao) {
        case "1":
          cadastrarPaciente(sc);
          break;
        case "2":
          listarPacientes(sc);
          break;
        case "3":
          alterarInfoPaciente(sc);
          break;
        case "4":
          mostrarInfoPaciente(sc);
          break;
        case "5":
          addAtividadePaciente(sc);
          break;
        case "6":
          removerPaciente(sc);
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

  private static void cadastrarPaciente(Scanner sc) {
    //Ex5:

    Paciente novoPaciente = new Paciente();
    System.out.println("\nCADASTRAR NOVO PACIENTE");
    System.out.println("Preencha os campos com os dados do novo paciente");
    System.out.print("Nome: ");
    novoPaciente.nome = sc.nextLine();
    System.out.print("Idade: ");
    novoPaciente.idade = sc.nextInt();
    System.out.print("Peso (kg): ");
    novoPaciente.peso = sc.nextDouble();
    System.out.print("Altura (m):");
    novoPaciente.altura = sc.nextDouble();

    ListaPaciente.adicionarPaciente(novoPaciente);
  }

  private static void listarPacientes(Scanner sc) {
    //Ex6
    System.out.printf("EXIBIR LISTA DE PACIENTES - TOTAL: %d PACIENTES\n", ListaPaciente.listaPaciente.size());
    System.out.println("ID - NOME");
    ListaPaciente.listarPacientes();
    System.out.println("## FIM DA LISTA ##");
    System.out.print("Pressione Enter para voltar ao menu inicial");
    sc.nextLine();
  }

  private static void alterarInfoPaciente(Scanner sc) {
    //Ex7
    System.out.println("ALTERAR INFORMAÇÕES DE PACIENTES");
    System.out.println("Escolha um id para editar:");
    int id = Integer.parseInt(sc.nextLine());

    if (id > 0 && id <= ListaPaciente.listaPaciente.size()) {
      Paciente tempPaciente = ListaPaciente.buscarPacienteId(id - 1);
      System.out.print("Peso(kg): ");
      tempPaciente.peso = sc.nextDouble();

      System.out.print("Altura (m): ");
      tempPaciente.altura = sc.nextDouble();

      System.out.print("Pressão Arterial Sistólica: ");
      tempPaciente.pressaoSistolica = sc.nextInt();

      System.out.print("Pressão Arterial Diastólica: ");
      tempPaciente.pressaoDiastolica = sc.nextInt();

      System.out.print("Frequência Cardíaca (bpm): ");
      tempPaciente.freqCardiaca = sc.nextInt();

    } else {
      System.out.println("Id inválido");
    }
    System.out.print("\nPressione Enter para voltar ao menu inicial");
    sc.nextLine();
  }

  private static void mostrarInfoPaciente(Scanner sc) {
    //Ex8
    System.out.println("EXIBIR INFORMAÇÕES DE PACIENTES");
    System.out.println("Escolha um id para exibir:");
    int id = Integer.parseInt(sc.nextLine());

    if (id > 0 && id <= ListaPaciente.listaPaciente.size()) {
      Paciente tempPaciente = ListaPaciente.buscarPacienteId(id - 1);
      System.out.println("Nome: " + tempPaciente.nome);
      System.out.println("Idade: " + tempPaciente.idade);
      System.out.println("Peso: " + tempPaciente.peso);
      System.out.println("Altura: " + tempPaciente.altura);
      System.out.println("Pressão Arterial: " + tempPaciente.pressaoDiastolica + " x " + tempPaciente.pressaoSistolica);
      System.out.println("Frequência Cardíaca: "+ tempPaciente.freqCardiaca+ "bpm");
      System.out.println("Lista de atividades físicas:\n"+ tempPaciente.atividadesFisicas);

    } else {
      System.out.println("Id inválido");
    }
    System.out.print("\nPressione Enter para voltar ao menu inicial");
    sc.nextLine();
  }

  private static void addAtividadePaciente(Scanner sc) {
    //Ex9
    System.out.println("ADICIONAR ATIVIDADE AO PACIENTE");
    System.out.println("Escolha um id para adicionar atividade:");
    int id = Integer.parseInt(sc.nextLine());
    if (id > 0 && id <= ListaPaciente.listaPaciente.size()) {
      Paciente tempPaciente = ListaPaciente.buscarPacienteId(id-1);

      System.out.println("Digite o nome do atividade:");
      tempPaciente.atividadesFisicas.add(sc.nextLine());

      ListaPaciente.alterarPaciente(id-1, tempPaciente);

    } else {
      System.out.println("Id inválido");
    }
    System.out.print("\nPressione Enter para voltar ao menu inicial");
    sc.nextLine();
  }

  private static void removerPaciente(Scanner sc) {
    //Ex10
    System.out.println("REMOVER PACIENTE");
    System.out.println("Escolha um id para remover:");
    int id = Integer.parseInt(sc.nextLine());
    if (id > 0 && id <= ListaPaciente.listaPaciente.size()) {
      Paciente tempPaciente = ListaPaciente.buscarPacienteId(id - 1);
      System.out.printf("Remover paciente %d - %s? s/N\n", id, tempPaciente.nome);

      if (sc.nextLine().equalsIgnoreCase("s")) {
        ListaPaciente.removerPaciente(id - 1);
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
}
