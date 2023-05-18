package FinalExam.Utils;

public class Queue {
    Node head;
    Node foot;
    Node lastHighPriorityInserted;

    public void insert(Node newNode) {
        if (head == null || foot == null) {
            head = newNode;
            foot = newNode;
            if (newNode.priority == 0)
                lastHighPriorityInserted = newNode;
        } else {

            if (newNode.priority == 0) {
                if (lastHighPriorityInserted == null) {
                    newNode.next = head;
                    newNode.prev = foot;
                    head.prev = newNode;
                    head = newNode;
                    foot.next = head;
                    lastHighPriorityInserted = newNode;
                } else {
                    Node positionNode = head;
                    while (positionNode.hash != lastHighPriorityInserted.hash) {
                        positionNode = positionNode.next;
                    }
                    newNode.prev = positionNode;
                    if (positionNode.next == null) {
                        positionNode.next = newNode;
                        newNode.next = head;
                        foot = newNode;
                    } else
                        newNode.next = positionNode.next;
                    positionNode.next.prev = newNode;
                    positionNode.next = newNode;

                    lastHighPriorityInserted = newNode;
                }
            } else {
                newNode.next = head;
                newNode.prev = foot;
                foot.next = newNode;
                foot = newNode;
                head.prev = foot;
            }
        }
    }

    public Info has(int hash) {
        if (head == null | foot == null)
            return null;
        Node positionNode = head;
        while (positionNode != null && positionNode.hash != hash) {
            // if ()
            positionNode = positionNode.next;
        }
        if (positionNode != null) {
            return new Info(positionNode.name, positionNode.priority, positionNode.hash, positionNode.key);
        }
        return null;
    }

    public void remove(int hash) {
        if (head != null | foot != null) {
            Node positionNode = head;
            while (positionNode.hash != hash) {
                positionNode = positionNode.next;
            }
            if (positionNode.prev == null) {
                head = null;
            } else if (positionNode.next == null) {
                foot = null;
            } else {
                positionNode.prev.next = positionNode.next;
            }
        }
    }

    public void print() {
        if (head != null) {
            Node currentNode = head;
            while (currentNode.hash != foot.hash) {
                System.out.print("{ name: " + currentNode.name + ", hash: " + currentNode.hash + " } ");
                currentNode = currentNode.next;
            }
            System.out.println("{ name: " + foot.name + ", hash: " + foot.hash + " } ");
        }
    }
}
