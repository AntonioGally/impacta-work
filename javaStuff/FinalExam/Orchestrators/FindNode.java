package FinalExam.Orchestrators;

import FinalExam.Commands.NodeEnricher.GetHash;
import FinalExam.Commands.NodeEnricher.GetName;
import FinalExam.Utils.Info;
import FinalExam.Utils.Queue;

public class FindNode {
    public Info start(Queue queue) {
        String name = new GetName().execute();
        int hash = new GetHash().execute(name);

        return queue.has(hash);
    }
}
