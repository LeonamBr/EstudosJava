package model.entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Contrato {

	private Integer numero;

	private Integer numParcelas;

	private Date data;

	private Double valor;

	private List<Parcelas> parcelas = new ArrayList<>();
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public Contrato() {
	}

	public Contrato(Integer numero, Date data, Double valor, Integer numParcelas) {
		this.numero = numero;
		this.data = data;
		this.valor = valor;
		this.numParcelas = numParcelas;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
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

	public Integer getNumParcelas() {
		return numParcelas;
	}

	public void setNumParcelas(Integer numParcelas) {
		this.numParcelas = numParcelas;
	}

	public List<Parcelas> getParcelas() {
		return parcelas;
	}

	public void setParcelas(Parcelas parcela) {
		this.parcelas.add(parcela);
	}

	@Override
	public String toString() {
		String tmp = "";
		for(Parcelas parcela : parcelas) {
			tmp += sdf.format(parcela.getData()).toString() + " - " + String.format("%.2f", parcela.getValor()) + "\n";
		};	
	
		return tmp;
	}
}
