package FinalExam.Orchestrators;

import java.util.ArrayList;

import FinalExam.Utils.HashTable;
import FinalExam.Utils.Info;

public class PrintAll {
    public void start(HashTable hashTable) {
        for (int i = 0; i < hashTable.data.size(); i++) {
            ArrayList<Info> tablePosition = hashTable.data.get(i);
            System.out.println("<------------ HashTable[" + i + "] ------------>");
            if (tablePosition != null) {
                for (int j = 0; j < tablePosition.size(); j++) {
                    Info nodeInfo = tablePosition.get(j);
                    System.out.println("{");
                    System.out.println("\t name: " + nodeInfo.name);
                    System.out.println("\t priority: " + nodeInfo.priority);
                    System.out.println("\t hash: " + nodeInfo.hash);
                    System.out.println("\t key: " + nodeInfo.key);
                    System.out.println("}");
                }
            } else {
                System.out.println("{");
                System.out.println("\t Empty");
                System.out.println("}");
            }
        }
    }
}
