package FinalExam.Commands.RemoveFromQueue;

import FinalExam.Utils.Info;
import FinalExam.Utils.Queue;

public class RemoveFromQueue {
    public void execute(Queue queue, Info info) {
        queue.remove(info.hash);
    }
}
