package FinalExam.Orchestrators;

import FinalExam.Commands.InsertOnHashTable.InsertOnHashTable;
import FinalExam.Commands.InsertOnQueue.InsertOnQueue;
import FinalExam.Utils.HashTable;
import FinalExam.Utils.Node;
import FinalExam.Utils.Queue;

public class InsertFlow {
    public void start(Queue queue, HashTable hashTable) {
        Node newNode = new NodeEnricher().start();
        new InsertOnQueue().execute(queue, newNode);
        new InsertOnHashTable().execute(hashTable, newNode);
    }
}
