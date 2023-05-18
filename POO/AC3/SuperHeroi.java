package POO.AC3;

public class SuperHeroi extends Personagem {

    public SuperHeroi(String nome, String nomeVidaReal) {
        super(nome, nomeVidaReal);

    }

    @Override
    public double getPoderTotal() {
        double totalPower = super.getPoderTotal();
        return totalPower * 1.1;
    }
}
