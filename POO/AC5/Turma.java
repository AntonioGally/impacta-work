package POO.AC5;

import java.util.ArrayList;

public class Turma {
    private int numeroDeAlunos;
    private String horario;
    private int duracao;
    private Atividade atividade;
    private Instrutor instrutor;
    private Aluno monitor;
    private ArrayList<Aluno> alunos;
    private ArrayList<Aluno> faltas;

    // Cria um construtor
    public Turma(int numeroDeAlunos, String horario, int duracao, Atividade atividade, Instrutor instrutor,
            Aluno monitor) {
        this.numeroDeAlunos = numeroDeAlunos;
        this.horario = horario;
        this.duracao = duracao;
        this.atividade = atividade;
        this.instrutor = instrutor;
        this.monitor = monitor;
        this.alunos = new ArrayList<Aluno>();
        this.faltas = new ArrayList<Aluno>();
    }

    // Método para adicionar um aluno à turma
    public void adicionarAluno(Aluno aluno) {
        alunos.add(aluno);
    }

    public void adicionarFalta(Aluno aluno) {
        faltas.add(aluno);
    }

    public int getNumeroDeAlunos() {
        return this.numeroDeAlunos;
    }

    public void setNumeroDeAlunos(int numeroDeAlunos) {
        this.numeroDeAlunos = numeroDeAlunos;
    }

    public String getHorario() {
        return this.this.horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public int getDuracao() {
        return this.duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public Atividade getAtividade() {
        return this.atividade;
    }

    public void setAtividade(Atividade atividade) {
        this.atividade = atividade;
    }

    public Instrutor getInstrutor() {
        return this.instrutor;
    }

    public void setInstrutor(Instrutor instrutor) {
        this.instrutor = instrutor;
    }

    public Aluno getMonitor() {
        return this.monitor;
    }

    public void setMonitor(Aluno monitor) {
        this.monitor = monitor;
    }

    public ArrayList<Aluno> getAlunos() {
        return this.alunos;
    }

    public ArrayList<Aluno> getFaltas() {
        return faltas;
    }
}
