package entities;

public class OrdemDeServico {
	
	private Integer quantidade;
	private Double preco;
	
	Produto produto = new Produto();
	
	public OrdemDeServico() {
	}

	public OrdemDeServico(Integer quantidade, Double preco, Produto produto) {
		this.quantidade = quantidade;
		this.preco = preco;
		this.produto = produto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPreco() {
		return preco;
	}

	public Produto getProduto() {
		return this.produto;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
	public Double subTotal() {
		return quantidade*preco;		
	}
	
}
