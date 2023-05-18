//----------- PARTICIPANTES -----------\\
// --- Alex Carvalho - 2102085
// --- Antônio Gally - 2102145
// --- Edson Fagundes - 2102719
// --- Íris Zarate - 2102682

package POO.AC3;

public class Principal {
    public static void main(String[] args) {

        SuperHeroi superHeroi = new SuperHeroi("Homem-Aranha", "Peter Park");
        Vilao vilao = new Vilao("Duende Verde", "Norman Osbourn", 3);

        superHeroi.adicionarSuperPoder(new SuperPoder("Soltar teia", 3));
        superHeroi.adicionarSuperPoder(new SuperPoder("Andar em paredes", 2));
        superHeroi.adicionarSuperPoder(new SuperPoder("Sentido apurado", 1));

        vilao.adicionarSuperPoder(new SuperPoder("força", 5));

        Confronto confronto = new Confronto();
        int resultado_confronto = confronto.lutar(superHeroi, vilao);

        if (resultado_confronto == 0) {
            System.out.println("Houve empate!");
        }

        if (resultado_confronto == 1) {
            System.out.println("Super herói é o vencedor!");
        }

        if (resultado_confronto == 2) {
            System.out.println("Vilão é o vencedor!");
        }
    }
}
