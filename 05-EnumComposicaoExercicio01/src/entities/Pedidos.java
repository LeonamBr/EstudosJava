package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.EstatusDoPedido;

public class Pedidos {

	private Date momento;
	private EstatusDoPedido estatus;

	private List<OrdemDeServico> ordem = new ArrayList<>();

	public Pedidos() {
	}

	public Pedidos(Date momento, EstatusDoPedido estatus) {
		this.momento = momento;
		this.estatus = estatus;
	}

	public Date getMomento() {
		return momento;
	}

	public void setMomento(Date momento) {
		this.momento = momento;
	}

	public EstatusDoPedido getEstatus() {
		return estatus;
	}

	public void adicionarItem(OrdemDeServico ordemDeServico) {
		ordem.add(ordemDeServico);
	}

	public void removerItem(OrdemDeServico ordemDeServico) {
		ordem.remove(ordemDeServico);
	}

	public Double total() {
		double sum = 0.0;
		for (OrdemDeServico item : ordem) {
			sum += item.subTotal();
		}
		return sum;
	}

	public String toString() {
		String saida = "";
		for (OrdemDeServico item : ordem) {
			saida += item.getProduto().getNome() + ", " + item.getPreco() + ", Quatidade:"
					+ item.getQuantidade().toString() + ", Subtotal:" + item.subTotal().toString() + "\n";
		}
		return saida;
	}

}
