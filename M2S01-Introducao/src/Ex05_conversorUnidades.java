import java.util.Scanner;

public class Ex05_conversorUnidades {
    public static void main(String[] args) {
        System.out.println("[M2S01] Ex. 05 - Conversor de Unidades");

        Scanner sc = new Scanner(System.in);

        String msgComprimento = "Escolha uma unidade de %s\n\t1. Metros (m)\n\t2. Centímetros (cm)\n\t3. Polegadas (in)\nOpção: ";
        String msgPeso = "Escolha uma unidade de %s\n\t1. Quilogramas (kg)\n\t2. Gramas (g)\n\t3. Libras (lb)\nOpção: ";
        String entrada = "", saida = "";

        double valorInicial, valorFinal;

        System.out.print("Escolha a categoria:\n\t1. Comprimento\n\t2. Peso\nOpção: ");

        switch (sc.next()) {
            case "1":
                System.out.println("Você escolheu <Comprimento>");

                System.out.printf(msgComprimento, "entrada");
                switch (sc.next()) {
                    case "1":
                        entrada = "Metros";
                        break;
                    case "2":
                        entrada = "Centimetros";
                        break;
                    case "3":
                        entrada = "Polegadas";
                        break;
                    default:
                        System.out.println("Opção inválida, encerrando programa");
                        return;
                }
                System.out.println("Você escolheu " + entrada);

                System.out.printf(msgComprimento, "saída");
                switch (sc.next()) {
                    case "1":
                        saida = "Metros";
                        break;
                    case "2":
                        saida = "Centimetros";
                        break;
                    case "3":
                        saida = "Polegadas";
                        break;
                    default:
                        System.out.println("Opção inválida, encerrando programa");
                        return;
                }
                System.out.println("Você escolheu " + saida);

                break;
            case "2":
                System.out.println("Você escolheu <Peso>");
                System.out.printf(msgPeso, "entrada");
                switch (sc.next()) {
                    case "1":
                        entrada = "Quilogramas";
                        break;
                    case "2":
                        entrada = "Gramas";
                        break;
                    case "3":
                        entrada = "Libras";
                        break;
                    default:
                        System.out.println("Opção inválida, encerrando programa");
                        return;
                }
                System.out.println("Você escolheu " + entrada);

                System.out.printf(msgPeso, "saída");
                switch (sc.next()) {
                    case "1":
                        saida = "Quilogramas";
                        break;
                    case "2":
                        saida = "Gramas";
                        break;
                    case "3":
                        saida = "Libras";
                        break;
                    default:
                        System.out.println("Opção inválida, encerrando programa");
                        return;
                }

                System.out.println("Você escolheu " + saida);
                break;
            default:
                System.out.println("Opção inválida, encerrando programa");

        }

        System.out.print("Digite o valor a ser convertido: ");
        valorInicial = sc.nextDouble();
        System.out.print("Resultado da conversão: ");
        String conversao = entrada + saida;
        switch (conversao) {
            case "MetrosMetros":
                valorFinal = valorInicial;
                System.out.printf("%s m = %s m", valorInicial, valorFinal);
                break;
            case "MetrosCentimetros":
                valorFinal = valorInicial * 100;
                System.out.printf("%s m = %s cm", valorInicial, valorFinal);
                break;
            case "MetrosPolegadas":
                valorFinal = valorInicial * 39.37;
                System.out.printf("%s m = %s in", valorInicial, valorFinal);
                break;
            case "CentimetrosMetros":
                valorFinal = valorInicial / 100;
                System.out.printf("%s cm = %s m", valorInicial, valorFinal);
                break;
            case "CentimetrosCentimetros":
                valorFinal = valorInicial;
                System.out.printf("%s cm = %s cm", valorInicial, valorFinal);
                break;
            case "CentimetrosPolegadas":
                valorFinal = valorInicial / 2.54;
                System.out.printf("%s cm = %s in", valorInicial, valorFinal);
                break;
            case "PolegadasMetros":
                valorFinal = valorInicial * 0.0254;
                System.out.printf("%s in = %s m", valorInicial, valorFinal);
                break;
            case "PolegadasCentimetros":
                valorFinal = valorInicial * 2.54;
                System.out.printf("%s in = %s cm", valorInicial, valorFinal);
                break;
            case "PolegadasPolegadas":
                valorFinal = valorInicial;
                System.out.printf("%s in = %s in", valorInicial, valorFinal);
                break;
            case "QuilogramasQuilogramas":
                valorFinal = valorInicial;
                System.out.printf("%s kg = %s kg", valorInicial, valorFinal);
                break;
            case "QuilogramasGramas":
                valorFinal = valorInicial * 1000;
                System.out.printf("%s kg = %s g", valorInicial, valorFinal);
                break;
            case "QuilogramasLibras":
                valorFinal = valorInicial * 2.20462;
                System.out.printf("%s kg = %s lb", valorInicial, valorFinal);
                break;
            case "GramasQuilogramas":
                valorFinal = valorInicial / 1000;
                System.out.printf("%s g = %s kg", valorInicial, valorFinal);
                break;
            case "GramasGramas":
                valorFinal = valorInicial;
                System.out.printf("%s g = %s g", valorInicial, valorFinal);
                break;
            case "GramasLibras":
                valorFinal = valorInicial / 453.592;
                System.out.printf("%s g = %s lb", valorInicial, valorFinal);
                break;
            case "LibrasQuilogramas":
                valorFinal = valorInicial * 0.453592;
                System.out.printf("%s lb = %s kg", valorInicial, valorFinal);
                break;
            case "LibrasGramas":
                valorFinal = valorInicial * 453.592;
                System.out.printf("%s lb = %s g", valorInicial, valorFinal);
                break;
            case "LibrasLibras":
                valorFinal = valorInicial;
                System.out.printf("%s lb = %s lb", valorInicial, valorFinal);
                break;
            default:
                return;
        }

        sc.close();
    }
}
