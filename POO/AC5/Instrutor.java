package POO.AC5;

import java.util.Date;
import java.util.ArrayList;

public class Instrutor extends Pessoa {
    private String especialidade;
    private String telefoneContato;
    private ArrayList<Turma> turmas;

    public Instrutor(String nome, String cpf, String rg, Date dataNascimento, String especialidade,
            String telefoneContato) {
        super(nome, cpf, rg, dataNascimento);
        this.especialidade = especialidade;
        this.telefoneContato = telefoneContato;
        this.turmas = new ArrayList<>();
    }

    public void addTurma(Turma turma) {
        turmas.add(turma);
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getTelefoneContato() {
        return telefoneContato;
    }

    public void setTelefoneContato(String telefoneContato) {
        this.telefoneContato = telefoneContato;
    }

    public ArrayList<Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(ArrayList<Turma> turmas) {
        this.turmas = turmas;
    }
}
