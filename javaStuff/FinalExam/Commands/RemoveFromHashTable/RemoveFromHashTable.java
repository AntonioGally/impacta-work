package FinalExam.Commands.RemoveFromHashTable;

import FinalExam.Utils.HashTable;
import FinalExam.Utils.Info;

public class RemoveFromHashTable {
    public void execute(HashTable hashTable, Info nodeInfo) {
        hashTable.remove(nodeInfo);
    }
}
