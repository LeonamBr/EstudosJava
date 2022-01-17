package entities;

public class ProdutoImportado extends Produto {

	private Double taxaDeImportacao;

	public ProdutoImportado() {
		super();
	}

	public ProdutoImportado(String nome, Double preco, Double taxaDeImportacao) {
		super(nome, preco);
		this.taxaDeImportacao = taxaDeImportacao;
	}

	public Double getTaxaDeImpotacao() {
		return taxaDeImportacao;
	}

	public void setTaxaDeImpotacao(Double taxaDeImpotacao) {
		this.taxaDeImportacao = taxaDeImpotacao;
	}

	public Double precoTotal() {
		return getPreco() + taxaDeImportacao;
	}

	@Override
	public String etiqueta() {
		return getNome() + " $ " + precoTotal().toString() + " Taxa de importação: " + taxaDeImportacao.toString();
	}
}
