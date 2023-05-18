package POO.Ex08;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        // ArrayList de Strings
        ArrayList<String> listaNomes = new ArrayList<String>();
        listaNomes.add("Paulo");
        listaNomes.add("Maria");

        // ArrayList de int
        ArrayList<Integer> listaNumeros = new ArrayList<Integer>();
        listaNumeros.add(34);
        listaNumeros.add(100);

        // ArrayList de objetos da classe Pessoa
        ArrayList<Pessoa> listaPessoas = new ArrayList<Pessoa>();
        Pessoa pessoa1 = new Pessoa("Paulo", 20);
        Pessoa pessoa2 = new Pessoa("Joaquim", 35);
        listaPessoas.add(pessoa1);
        listaPessoas.add(pessoa2);

        // percorre os elementos pelos indices
        for (int i = 0; i < listaPessoas.size(); i++) {
            Pessoa p = listaPessoas.get(i);
            System.out.println("Nome: " + p.nome);
        }
        System.out.println("-----------------------------");

        // percorre os elementos utilizando iteracao (foreach)
        for (Pessoa p : listaPessoas) {
            System.out.println("Nome: " + p.nome);
        }
        System.out.println("-----------------------------");

        // Comparacao de objetos
        Pessoa pessoa3 = new Pessoa("Marcelo", 30);
        Pessoa pessoa4 = new Pessoa("Marcelo", 30);

        // Para o metodo equals comparar oconteudo dos objetos é necessário sobrescrever
        // o metodo equals na classe Pessoa
        if (pessoa3.equals(pessoa4)) {
            System.out.println("Igual");
        } else {
            System.out.println("Diferente");
        }
    }
}