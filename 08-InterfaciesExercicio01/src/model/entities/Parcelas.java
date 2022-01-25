package model.entities;

import java.util.Date;

public class Parcelas {
	
	private Date data;
	
	private Double valor;
	
	public Parcelas() {
	}
	
	public Parcelas(Date data, Double valor) {
		this.data = data;
		this.valor = valor;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	

}
