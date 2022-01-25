package model.services;

public class PagamentoPayPal implements PagamentoOnline {

	private static final double JUROS_SIMPLES = 0.01;
	
	private static final double TAXA_PAGAMENTO = 0.02;
	
	public PagamentoPayPal() {
	}
	
	@Override
	public Double calculoTaxa(Double valor, Integer idxParcela) {

		valor = valor + (valor*idxParcela)*JUROS_SIMPLES;
		
		valor = valor + (valor*TAXA_PAGAMENTO);
		
		return valor;
	}

}
