import java.util.Scanner;

public class Ex01_area {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("[M2S01] Ex. 01 - Calcular Área");
        System.out.print("Digite largura do terreno (em metros): ");
        double largura = sc.nextDouble();
        System.out.print("Digite o comprimento do terreno (em metros): ");
        double comprimento = sc.nextDouble();
            double area = (largura * comprimento);

            System.out.printf("O terreno possui %.2f m² de área%n", area);

            sc.close();
        }
    }


/*
Desenvolva um programa para calcular a área de um terreno.
O usuário deverá informar a largura e o comprimento do terreno e,
o seu algoritmo, deverá retornar a área.

Ex: O terreno possui 10 m² de área.
*/
