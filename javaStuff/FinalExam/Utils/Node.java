package FinalExam.Utils;

public class Node {
    String name;
    int priority;
    int hash;
    int key;
    Node next;
    Node prev;

    public static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public Node(String n, int p, int h, int k) {
        clearConsole();
        System.out.println("");
        System.out.println("-----------------------");
        System.out.println("Nome ---------> " + n);
        System.out.println("Prioridade ---> " + p);
        System.out.println("Hash ---------> " + h);
        System.out.println("Chave --------> " + k);
        System.out.println("-----------------------");
        System.out.println("");
        name = n;
        priority = p;
        hash = h;
        key = k;
        next = null;
        prev = null;
    }
}
