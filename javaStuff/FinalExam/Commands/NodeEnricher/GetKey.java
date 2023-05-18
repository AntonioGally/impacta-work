package FinalExam.Commands.NodeEnricher;

public class GetKey {
    public int execute(int hash) {
        int key = hash;
        while (key >= 10) {
            key = key % 10;
        }
        return key;
    }
}
