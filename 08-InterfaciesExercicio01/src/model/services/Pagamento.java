package model.services;

import java.util.Calendar;
import java.util.Date;

import model.entities.Contrato;
import model.entities.Parcelas;

public class Pagamento {
	
	private PagamentoOnline pagamento;
	
	Calendar calendario = Calendar.getInstance();
	
	public Pagamento(PagamentoOnline pagamento) {
		this.pagamento = pagamento;
	}
	
	public void gerarContrato(Contrato contrato) {
		
		Date data = contrato.getData();
		
		calendario.setTime(data);
		
		int parcelas = contrato.getNumParcelas();
		
		double valor = contrato.getValor();
		
		for(int i = 1; i<=parcelas;i++) {
		calendario.add(Calendar.MONTH, 1);
		contrato.setParcelas(new Parcelas(calendario.getTime(), pagamento.calculoTaxa(valor/parcelas, i)));
		}
	}

}
