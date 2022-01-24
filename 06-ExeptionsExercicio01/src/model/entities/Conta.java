package model.entities;

import model.exception.ContaException;

public class Conta {

	private Integer numero;
	private String titular;
	private Double saldo;
	private Double limiteSaque;

	public Conta() {
	}

	public Conta(Integer numero, String titular, Double saldo, Double limiteSaque) {
		this.numero = numero;
		this.titular = titular;
		this.saldo = saldo;
		this.limiteSaque = limiteSaque;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void depositar(Double quantidade) {
		saldo += quantidade;
	}

	public void sacar(Double quantidade) throws ContaException {
		if (quantidade > limiteSaque)
			throw new ContaException("Limite de saque extrapolado!!");
		else if (quantidade > saldo)
			throw new ContaException("Sem saldo suficiente!!");
		else
			saldo -= quantidade;
	}

	public Double getLimiteSaque() {
		return limiteSaque;
	}

	public void setLimiteSaque(Double limiteSaque) {
		this.limiteSaque = limiteSaque;
	}

}
