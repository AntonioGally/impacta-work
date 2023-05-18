package FinalExam.Commands.InsertOnQueue;

import FinalExam.Utils.Node;
import FinalExam.Utils.Queue;

public class InsertOnQueue {
    public void execute(Queue queue, Node newNode) {
        queue.insert(newNode);
    }
}
