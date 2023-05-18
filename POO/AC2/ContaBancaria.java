package POO.AC2;

import java.util.Random;

public class ContaBancaria {
    private static int ultimoNumeroConta = 1000; // Último número de conta utilizado

    private String correntista; // nome do correntista
    private int numeroConta; // número da conta
    private double saldo; // saldo da conta
    private String senha; // senha da conta
    private double cpmf; // imposto 

    public ContaBancaria(String correntista, double saldo) {
        ultimoNumeroConta++;
        this.numeroConta = ultimoNumeroConta;
        this.saldo = saldo;
        this.correntista = correntista;
        this.senha = this.criarSenha();
    }

    public void depositar(double valor) {
        this.saldo = this.saldo + valor;
    }

    public void sacar(double valor) {
        this.saldo = this.saldo - valor;

        double impostoValor = valor * 0.0025;
        this.saldo = this.saldo - impostoValor;
        this.cpmf = this.cpmf + impostoValor;
    }

    public void transferir(double valor, ContaBancaria contaDestino) {
        this.sacar(valor);
        contaDestino.depositar(valor);
    }

    private String criarSenha() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }

    public double getSaldo() {
        return this.saldo;
    }

    public int getNumeroConta() {
        return this.numeroConta;
    }

    public String getSenha() {
        return this.senha;
    }

    public double getCpmf() {
        return this.cpmf;
    }


    public String toString() {
        return "Conta de " + this.correntista + " - Saldo de R$ " + this.saldo;
    }
}