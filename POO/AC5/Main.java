package POO.AC5;

import java.util.Date;

public class Main {
        // ----------- PARTICIPANTES -----------\\
        // --- Alex Carvalho - 2102085
        // --- Antônio Gally - 2102145
        // --- Edson Fagundes - 2102719
        // --- Íris Zarate - 2102682
        // --- Luciano Silva - 2102690

        public static void main(String[] args) {
                Atividade natacao = new Atividade("Natação");
                Instrutor intrutor = new Instrutor("Alex", "362-614-418-06", "12.345.678-9", new Date(), "Natação",
                                "(11)98655-3689");

                Aluno aluno01 = new Aluno("Antonio", "111.222.333-44", "11.222.333", new Date(), 1, "Rua A, 123",
                                "(31) 91234-5678",
                                1.93f, 75f);
                Aluno aluno02 = new Aluno("Luciano", "111.222.333-44", "11.222.333", new Date(), 1, "Rua A, 123",
                                "(31) 91234-5678",
                                1.93f, 75f);

                Turma turma01 = new Turma(2, "10:00", 60, natacao, intrutor, aluno01);
                turma01.adicionarAluno(aluno01);
                turma01.adicionarAluno(aluno02);

                intrutor.addTurma(turma01);

                // Printando informações para testar
                System.out.println("Instrutor " + intrutor.getNome() + " está dando aula de "
                                + turma01.getAtividade().getTipo() + " às " + turma01.getHorario());
                System.out.println("Alunos da turma de " + turma01.getAtividade().getTipo() + ":");
                for (Aluno aluno : turma01.getAlunos()) {
                        System.out.println(" - " + aluno.getNome());
                }
        }
}
