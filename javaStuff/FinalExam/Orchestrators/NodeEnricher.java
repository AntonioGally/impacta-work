package FinalExam.Orchestrators;

import FinalExam.Commands.NodeEnricher.GetHash;
import FinalExam.Commands.NodeEnricher.GetKey;
import FinalExam.Commands.NodeEnricher.GetName;
import FinalExam.Commands.NodeEnricher.GetPriority;
import FinalExam.Utils.Node;

public class NodeEnricher {
    public Node start() {
        String name = new GetName().execute();
        int priority = new GetPriority().execute();
        int hash = new GetHash().execute(name);
        int key = new GetKey().execute(hash);
        
        return new Node(name, priority, hash, key);
    }
}
