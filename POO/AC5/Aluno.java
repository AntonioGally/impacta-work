package POO.AC5;

public class Aluno extends Pessoa {
    private int codigoMatricula;
    private String endereco;
    private String telefone;
    private float altura;
    private float peso;

    // Cria um construtor
    public Aluno(String nome, String cpf, String rg, Date dataNascimento, int codigoMatricula, String endereco,
            String telefone, float altura, float peso) {
        super(nome, cpf, rg, dataNascimento);
        this.codigoMatricula = codigoMatricula;
        this.endereco = endereco;
        this.telefone = telefone;
        this.altura = altura;
        this.peso = peso;
    }

    public int getCodigoMatricula() {
        return this.codigoMatricula;
    }

    public void setCodigoMatricula(int codigoMatricula) {
        this.codigoMatricula = codigoMatricula;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public float getAltura() {
        return this.altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public float getPeso() {
        return this.peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }
}