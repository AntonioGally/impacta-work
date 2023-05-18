package FinalExam.Commands.InsertOnHashTable;

import FinalExam.Utils.HashTable;
import FinalExam.Utils.Node;

public class InsertOnHashTable {
    public void execute(HashTable hashTable, Node newNode) {
        hashTable.insert(newNode);
    }
}
