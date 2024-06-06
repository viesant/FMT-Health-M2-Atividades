import java.util.Scanner;

public class Ex03_radar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("[M2S01] Ex. 03 - Sistema de Radares");
        System.out.print("Digite o tempo de deslocamento em segundos: ");
        double tempo = sc.nextDouble();
        // velocidade m/s = distancia / tempo
        // distancia = 1m
        // velocidade em km/h = velocidade em m/s * 3.6
        double velocidadeKmh = 3.6 / tempo;


        System.out.printf("Velocidade: %.0f km/h%n", velocidadeKmh);

        sc.close();
    }
}
/*
O governo do Estado de Santa Catarina está contratando você para desenvolver o sistema
dos radares das estradas. Nesse sistema, haverá um sensor que entrará com o tempo que
o veículo leva para se deslocar entre uma placa e outra. Sabendo que a distância
entre as placas é de 1 metro, ao sensor entrar com o valor referente ao tempo de
deslocamento, o seu algoritmo deverá retornar a velocidade média do veículo.

OBS: Velocidade média = distância/tempo

Tempo: segundos.
 */