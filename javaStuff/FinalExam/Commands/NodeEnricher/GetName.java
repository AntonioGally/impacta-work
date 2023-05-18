package FinalExam.Commands.NodeEnricher;

import java.util.Scanner;

public class GetName {
    public String execute() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o nome: ");
        String name = sc.nextLine();
        return name.trim();
    }
}
