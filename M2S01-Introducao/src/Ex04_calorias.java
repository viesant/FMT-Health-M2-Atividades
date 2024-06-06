import java.util.Scanner;

public class Ex04_calorias {
    public static void main(String[] args) {
        System.out.println("[M2S01] Ex. 04 - Monitoramento de Calorias");

        // variáveis:
        Scanner sc = new Scanner(System.in);
        String[] dias = {"Segunda","Terça","Quarta","Quinta","Sexta","Sábado","Domingo"};
        int[] calorias = new int[dias.length];
        int soma = 0;
        String diasPassouLimite = "";

        System.out.println("Digite as calorias consumidas em cada dia da semana");
        // recebe o consumo de segunda a domingo e armazena no array calorias[i]
        for (int i = 0; i < dias.length; i++) {
            System.out.printf("%s: ", dias[i]);
            calorias[i] = sc.nextInt();
            //se calorias passou do limite, armazena o dia em uma string
            if (calorias[i] > 2000) {
                diasPassouLimite += dias[i]+ '\n';
            }
            //soma os valores do dia com valor armazenado:
            soma += calorias[i];
        }

        //calcula media:
        double media = soma / (double) dias.length;

        //mostra resultados:
        System.out.printf("Consumo total da semana: %s kcal%nMédia diária: %.2f kcal%n",soma, media);
        System.out.printf("Dias que passou do limite de 2000kcal:%n%s",diasPassouLimite);

        sc.close();
    }
}
