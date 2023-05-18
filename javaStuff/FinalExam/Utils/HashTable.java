package FinalExam.Utils;

import java.util.ArrayList;

public class HashTable {

    public ArrayList<ArrayList<Info>> data = new ArrayList<ArrayList<Info>>();

    public void insert(Node newNode) {

        if (data.size() != 10) {
            for (int i = 0; i < 10; i++) {
                data.add(null);
            }
        }
        Info newInfo = new Info(newNode.name, newNode.priority, newNode.hash, newNode.key);

        ArrayList<Info> tablePosition = data.get(newNode.key);
        if (tablePosition == null) {
            tablePosition = new ArrayList<>();
            tablePosition.add(newInfo);
        } else {
            if (newNode.priority == 0) {
                for (int i = 0; i < tablePosition.size(); i++) {
                    Info info = tablePosition.get(i);
                    if (info.priority == 1) {
                        tablePosition.add(i, newInfo);
                        break;
                    }
                }
                if (tablePosition.get(tablePosition.size() - 1).priority == 0) {
                    tablePosition.add(newInfo);
                }
            } else {
                tablePosition.add(newInfo);
            }
        }
        data.set(newNode.key, tablePosition);
    }

    public void remove(Info nodeInfo) {
        ArrayList<Info> tablePosition = data.get(nodeInfo.key);
        for (int i = 0; i < tablePosition.size(); i++) {
            Info info = tablePosition.get(i);
            if (info.hash == nodeInfo.hash) {
                tablePosition.remove(i);
                break;
            }
        }
        data.set(nodeInfo.key, tablePosition);
    }
}
