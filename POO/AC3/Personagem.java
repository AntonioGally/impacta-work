package POO.AC3;

import java.util.ArrayList;

public class Personagem {
    private String nome;
    private String nomeVidaReal;
    private ArrayList<SuperPoder> poderes;

    public Personagem(String nome, String nomeVidaReal) {
        this.nome = nome;
        this.nomeVidaReal = nomeVidaReal;
        this.poderes = new ArrayList<SuperPoder>();
    }

    public void adicionarSuperPoder(SuperPoder superpoder) {
        if (!this.poderes.contains(superpoder)) {
            this.poderes.add(superpoder);
        }
    }

    public double getPoderTotal() {
        double count_category = 0;
        for (SuperPoder category : this.poderes) {
            count_category += category.getCategoria();
        }
        return count_category;
    }
}
