package POO.Ex08;

public class Pessoa {
    public String nome;
    public int idade;

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    // sobreescrever o metodo equals para comparar dois objetos
    @Override
    public boolean equals(Object obj) {

        Pessoa p = (Pessoa) obj; // converte obj para um objeto Pessoa

        if (p.nome == this.nome && p.idade == this.idade) {
            return true;
        } else {
            return false;
        }
    }
}