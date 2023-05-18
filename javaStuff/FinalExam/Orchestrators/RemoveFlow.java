package FinalExam.Orchestrators;

import FinalExam.Commands.RemoveFromHashTable.RemoveFromHashTable;
import FinalExam.Commands.RemoveFromQueue.RemoveFromQueue;
import FinalExam.Utils.HashTable;
import FinalExam.Utils.Info;
import FinalExam.Utils.Queue;

public class RemoveFlow {
    public void start(Queue queue, HashTable hashTable) {
        Info nodeInfo = new FindNode().start(queue);
        if (nodeInfo == null)
            System.out.println("Esse nome não existe");
        else {
            new RemoveFromQueue().execute(queue, nodeInfo);
            new RemoveFromHashTable().execute(hashTable, nodeInfo);
        }
    }
}
