import java.util.Scanner;

// public interface IDoubledLinkedList {
//     DoubledLinkedList insertStart(DoubledLinkedList list, int info);

//     DoubledLinkedList insertEnd(DoubledLinkedList list, int info);

//     DoubledLinkedList insertBetween(DoubledLinkedList list, int info, int position);

//     DoubledLinkedList removeStart(DoubledLinkedList list);

//     DoubledLinkedList removeEnd(DoubledLinkedList list);

//     DoubledLinkedList removeBetween(DoubledLinkedList list, int position);

//     void print(DoubledLinkedList list);
//     void printStartToEnd(DoubledLinkedList list);
//     void printEndToStart(DoubledLinkedList list);
// }

// public class DoubledLinkedList implements IDoubledLinkedList {

public class DoubledLinkedList {
    Node head;
    Node foot;

    public class Node {
        int info;
        Node next;
        Node prev;

        Node(int i) {
            info = i;
            next = null;
            prev = null;
        }
    }

    // @Override
    public DoubledLinkedList insertStart(DoubledLinkedList list, int info) {
        Node newNode = new Node(info);
        if (list.head == null || list.foot == null) {
            list.head = newNode;
            list.foot = newNode;
        } else {
            newNode.next = list.head;
            newNode.prev = list.foot;
            list.head.prev = newNode;
            list.head = newNode;
            list.foot.next = list.head;
        }
        return list;
    }

    // @Override
    public DoubledLinkedList insertEnd(DoubledLinkedList list, int info) {
        Node newNode = new Node(info);
        if (list.head == null || list.foot == null) {
            list.head = newNode;
            list.foot = newNode;
        } else {
            newNode.next = list.head;
            newNode.prev = list.foot;
            list.foot.next = newNode;
            list.foot = newNode;
            list.head.prev = list.foot;
        }
        return list;
    }

    // @Override
    public DoubledLinkedList insertBetween(DoubledLinkedList list, int info, int position) {
        Node newNode = new Node(info);
        if (list.head == null || list.foot == null) {
            list.head = newNode;
            list.foot = newNode;
        } else {
            Node positionNode = list.head;
            while (positionNode.info != position) {
                positionNode = positionNode.next;
            }
            newNode.prev = positionNode;
            newNode.next = positionNode.next;
            positionNode.next.prev = newNode;
            positionNode.next = newNode;
        }
        return list;
    }

    // @Override
    public DoubledLinkedList removeStart(DoubledLinkedList list) {
        if (list.head == null || list.foot == null) {
            return list;
        }
        list.head = list.head.next;
        list.head.prev = list.foot;
        list.foot.next = list.head;
        return list;
    }

    // @Override
    public DoubledLinkedList removeEnd(DoubledLinkedList list) {
        if (list.head == null || list.foot == null) {
            return list;
        }
        list.foot = list.foot.prev;
        list.foot.next = list.head;
        list.head.prev = list.foot;
        return list;
    }

    // @Override
    public DoubledLinkedList removeBetween(DoubledLinkedList list, int position) {
        if (list.head == null || list.foot == null) {
            return list;
        }
        if (position == list.head.info) {
            return list.removeStart(list);
        }
        if (position == list.foot.info) {
            return list.removeEnd(list);
        }

        Node positionNode = list.head;
        while (positionNode.info != position) {
            positionNode = positionNode.next;
        }
        positionNode.prev.next = positionNode.next;
        return list;
    }

    // @Override
    public void print(DoubledLinkedList list) {
        clearConsole();
        if (list.head != null) {
            Node currentNode = list.head;
            while (currentNode.info != list.foot.info) {
                System.out.print(currentNode.info + " ");
                currentNode = currentNode.next;
            }
            System.out.println(list.foot.info + " ");
        }
    }

    // @Override
    public void printStartToEnd(DoubledLinkedList list) {
        clearConsole();
        if (list.head != null) {
            Node currentNode = list.head;
            while (currentNode.info != list.foot.info) {
                System.out.print(currentNode.info + " ");
                currentNode = currentNode.next;
            }
            System.out.println(list.foot.info + " ");
        }
    }

    // @Override
    public void printEndToStart(DoubledLinkedList list) {
        clearConsole();
        if (list.foot != null) {
            Node currentNode = list.foot;
            while (currentNode.info != list.head.info) {
                System.out.print(currentNode.info + " ");
                currentNode = currentNode.prev;
            }
            System.out.println(list.head.info + " ");
        }
    }

    public static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void main(String[] args) {
        clearConsole();

        DoubledLinkedList list = new DoubledLinkedList();
        Scanner sc = new Scanner(System.in);

        int menuOp = 0;
        while (menuOp != 13) {
            if (menuOp != 11 && menuOp != 12) {
                list.print(list);
            }
            System.out.println("Inserir: ");
            System.out.println("----------- (1) -> Começo da lista");
            System.out.println("----------- (2) -> Final da lista");
            System.out.println("----------- (3) -> Meio da lista");
            System.out.println("Remover: ");
            System.out.println("----------- (4) -> Começo da lista");
            System.out.println("----------- (5) -> Final da lista");
            System.out.println("----------- (6) -> Meio da lista");
            System.out.println("Fila: ");
            System.out.println("----------- (7) -> Inserir");
            System.out.println("----------- (8) -> Remover");
            System.out.println("Pilha: ");
            System.out.println("----------- (9) -> Push");
            System.out.println("---------- (10) -> Pop");
            System.out.println("Outros: ");
            System.out.println("---------- (11) -> Imprimir do começo ao fim");
            System.out.println("---------- (12) -> Imprimir do fim ao começo");
            System.out.println("---------- (13) -> Sair");

            menuOp = sc.nextInt();

            switch (menuOp) {
                case 1:
                    clearConsole();

                    System.out.print("Digite o numero: ");
                    list = list.insertStart(list, sc.nextInt());
                    break;
                case 2:
                    clearConsole();

                    System.out.print("Digite o numero: ");
                    list = list.insertEnd(list, sc.nextInt());
                    break;
                case 3:
                    clearConsole();

                    System.out.print("Digite o numero: ");
                    int insertBetweenN1 = sc.nextInt();
                    System.out.print("Digite a posição: ");
                    int insertBetweenPosition = sc.nextInt();
                    list = list.insertBetween(list, insertBetweenN1, insertBetweenPosition);
                    break;
                case 4:
                    clearConsole();

                    list = list.removeStart(list);
                    break;
                case 5:
                    clearConsole();

                    list = list.removeEnd(list);
                    break;
                case 6:
                    clearConsole();

                    System.out.print("Digite a posição: ");
                    int removeBetweenPosition = sc.nextInt();
                    list = list.removeBetween(list, removeBetweenPosition);
                    break;
                case 7:
                    clearConsole();
                    list = list.insertStart(list, sc.nextInt());
                    break;
                case 8:
                    clearConsole();
                    list = list.removeEnd(list);
                    break;
                case 9:
                    clearConsole();
                    list = list.insertEnd(list, sc.nextInt());
                    break;
                case 10:
                    clearConsole();
                    list = list.removeEnd(list);
                    break;
                case 11:
                    list.printStartToEnd(list);
                    break;
                case 12:
                    list.printEndToStart(list);
                    break;
                case 13:
                    break;
                case default:
                    System.out.println("Insira uma opção válida");
                    // break;

            }
        }

        sc.close();
    }

}