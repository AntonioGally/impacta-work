package FinalExam;

import java.util.*;

import FinalExam.Orchestrators.InsertFlow;
import FinalExam.Orchestrators.PrintAll;
import FinalExam.Orchestrators.RemoveFlow;
import FinalExam.Utils.Queue;
import FinalExam.Utils.HashTable;

public class FinalExam {
    public static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void main(String args[]) {
        clearConsole();
        Scanner sc = new Scanner(System.in);
        Queue queue = new Queue();
        HashTable hashTable = new HashTable();

        int menuOp = 0;
        while (menuOp != 4) {
            System.out.println("Fila: ");
            System.out.println("----------- (1) -> Inserir");
            System.out.println("----------- (2) -> Remover");
            System.out.println("----------- (3) -> Imprimir");
            System.out.println("----------- (4) -> Sair");
            System.out.println("---------- (10) -> Imprimir fila");
            System.out.println("---------- (11) -> Limpar console");

            menuOp = sc.nextInt();
            switch (menuOp) {
                case 1:
                    clearConsole();
                    new InsertFlow().start(queue, hashTable);
                    break;
                case 2:
                    clearConsole();
                    new RemoveFlow().start(queue, hashTable);
                    break;
                case 3:
                    clearConsole();
                    new PrintAll().start(hashTable);
                    break;
                case 10:
                    queue.print();
                    break;
                case 11:
                    clearConsole();
                    break;
                default:
                    System.out.println("Selecione uma opção válida");
                    break;
            }

        }
        sc.close();
    }
}
