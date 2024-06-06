import java.util.Scanner;

public class Ex02_salario {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double minimo = 1412.00;
        System.out.println("[M2S01] Ex. 02 - Calcular Salário");
        System.out.print("Digite o seu salário: ");
        double salario = sc.nextDouble();

        double salarios = (salario / minimo);
        System.out.printf("Você recebe %.1f salários mínimos%n", salarios);

        sc.close();
    }
}


/*
Desenvolva um programa para calcular a quantidade de salários mínimos.
Sabendo que o salário mínimo hoje é R$1.412,00,
o usuário deverá informar seu salário e, o seu algoritmo,
deverá informar quantos salários ele recebe.

Ex: Você recebe 1 mínimo.
 */