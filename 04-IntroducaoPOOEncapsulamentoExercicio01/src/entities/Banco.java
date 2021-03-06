package entities;

public class Banco {

	private int numeroConta;
	private String nome;
	private double saldo;

	public Banco() {
	}

	public Banco(int numeroConta, String nome, double saldo) {
		this.numeroConta = numeroConta;
		this.nome = nome;
		this.saldo = saldo;
	}

	public Banco(int numeroConta, String nome) {
		this.numeroConta = numeroConta;
		this.nome = nome;
	}

	public int getNumeroConta() {
		return numeroConta;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getSaldo() {
		return saldo;
	}

	public void aumentaSaldo(double deposito) {
		this.saldo += deposito;
	}

	public void diminuiSaldo(double saque) {
		this.saldo -= (saque+5.00);
	}

	public String toString() {
		return "Conta: " + numeroConta + ", " + " Assinante: " +  nome + ", " + "Saldo: " + String.format("%.2f", saldo);
	}

}
