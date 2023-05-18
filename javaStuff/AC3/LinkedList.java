import java.util.Scanner;

public class LinkedList {
    Node head;

    static class Node {
        int info;
        Node next;

        Node(int i) {
            info = i;
            next = null;
        }
    }

    // ---- INSERT ---- //

    public static LinkedList insertFirst(LinkedList list, int info) {
        Node newNode = new Node(info);

        if (list.head == null) {
            list.head = newNode;
        } else {
            newNode.next = list.head;
            list.head = newNode;
        }

        return list;
    }

    public static LinkedList insertBetween(LinkedList list, int info, int positionInfo) {
        Node newNode = new Node(info);

        if (list.head == null) {
            list.head = newNode;
        } else {
            Node temp = list.head;
            while (temp.info != positionInfo) {
                temp = temp.next;
            }
            Node tempNext = temp.next;
            temp.next = newNode;
            newNode.next = tempNext;
        }
        return list;
    }

    public static LinkedList insertLast(LinkedList list, int info) {
        Node newNode = new Node(info);
        if (list.head == null) {
            list.head = newNode;
        } else {
            Node last = list.head;
            while (last.next != null) {
                last = last.next;
            }

            last.next = newNode;
        }
        return list;
    }

    // ---- REMOVE ---- //

    public static LinkedList removeFirst(LinkedList list) {
        if (list.head == null) {
            System.out.println("A lista está vazia!");
            return list;
        }
        Node temp = list.head;
        list.head = temp.next;
        return list;
    }

    public static LinkedList removeBetween(LinkedList list, int item) {
        if (list.head == null) {
            System.out.println("A lista está vazia!");
            return list;
        }
        Node oneBefore = list.head;
        while (oneBefore.next.info != item) {
            oneBefore = oneBefore.next;
        }
        oneBefore.next = oneBefore.next.next;
        return list;
    }

    public static LinkedList removeLast(LinkedList list) {
        if (list.head == null) {
            System.out.println("A lista está vazia!");
            return list;
        }
        Node oneBefore = list.head;
        while (oneBefore.next.next != null) {
            oneBefore = oneBefore.next;
        }
        oneBefore.next = null;
        return list;
    }
    // ---- PRINT ---- //

    public static void printList(LinkedList list) {
        clearConsole();
        Node currentNode = list.head;
        if (currentNode == null) {
            System.out.println("A lista está vazia");
        }
        System.out.print("LinkedList: [ ");
        while (currentNode != null) {

            if (currentNode.next == null)
                System.out.println(currentNode.info + " ] \n");
            else
                System.out.print(currentNode.info + ", ");

            currentNode = currentNode.next;
        }
    }

    public static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void main(String[] args) {
        clearConsole();
        LinkedList list = new LinkedList();
        Scanner sc = new Scanner(System.in);
        int op = 0;        
        while (op != 8) {
            // Remover no interior com 2 posições
            System.out.println("1 inserir inicio da lista");
            System.out.println("2 inserir fim da lista");
            System.out.println("3 inserir interior da lista");
            System.out.println("4 remover inicio da lista");
            System.out.println("5 remover fim da lista");
            System.out.println("6 remover interior da lista");
            System.out.println("7 imprimir lista");
            System.out.println("8 sair");

            System.out.println("------------------");

            System.out.print("Digite a opção: ");
            op = sc.nextInt();

            switch (op) {
                case 1:
                    clearConsole();
                    System.out.print("Digite o numero: ");
                    list = insertFirst(list, sc.nextInt());
                    printList(list);
                    break;
                case 2:
                    clearConsole();
                    System.out.print("Digite o numero: ");
                    list = insertLast(list, sc.nextInt());
                    printList(list);
                    break;
                case 3:
                    clearConsole();
                    printList(list);
                    System.out.print("Digite o numero: ");
                    int n1 = sc.nextInt();
                    System.out.print("Digite a posição que deseja inserir após: ");
                    int n2 = sc.nextInt();
                    list = insertBetween(list, n1, n2);
                    printList(list);
                    break;
                case 4:
                    clearConsole();
                    list = removeFirst(list);
                    printList(list);
                    break;
                case 5:
                    clearConsole();
                    list = removeLast(list);
                    printList(list);
                    break;
                case 6:
                    clearConsole();
                    printList(list);
                    System.out.print("Digite a posição que deseja remover: ");
                    int n3 = sc.nextInt();
                    list = removeBetween(list, n3);
                    printList(list);
                    break;
                case 7:
                    clearConsole();
                    printList(list);
                    break;
            }
        }
        sc.close();
    }
}