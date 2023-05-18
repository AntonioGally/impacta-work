package POO.AC3;

public class Confronto {
    public int lutar(SuperHeroi superheroi, Vilao vilao) {
        if (superheroi.getPoderTotal() > vilao.getPoderTotal()) {
            return 1;
        }

        if (superheroi.getPoderTotal() < vilao.getPoderTotal()) {
            return 2;
        }

        return 0;
    }
}
