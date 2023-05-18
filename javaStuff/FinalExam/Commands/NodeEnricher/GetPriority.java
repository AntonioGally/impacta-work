package FinalExam.Commands.NodeEnricher;

import java.util.Scanner;

public class GetPriority {
    public int execute() {
        System.out.print("Digite a prioridade: ");
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        if (number <= 0) {
            return 0;
        } else
            return 1;
    }
}
