package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ProdutoUsado extends Produto {

	private Date dataDefabricacao;
	SimpleDateFormat obj = new SimpleDateFormat("dd/MM/yyyy");

	public ProdutoUsado() {
		super();
	}

	public ProdutoUsado(String nome, Double preco, Date dataDefabricacao) {
		super(nome, preco);
		this.dataDefabricacao = dataDefabricacao;
	}

	public Date getDataDefabricacao() {
		return dataDefabricacao;
	}

	public void setDataDefabricacao(Date dataDefabricacao) {
		this.dataDefabricacao = dataDefabricacao;
	}

	@Override
	public String etiqueta() {
		return getNome() + "(Usado) $ " + getPreco().toString() + " (Data de fabricação: "
				+ obj.format(dataDefabricacao) + ")";
	}

}
