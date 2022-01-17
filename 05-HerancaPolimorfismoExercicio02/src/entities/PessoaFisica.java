package entities;

public class PessoaFisica extends Pessoa {

	private Double gastoComSaude;

	public PessoaFisica() {
		super();
	}

	public PessoaFisica(String nome, Double rendaAnual, Double gastoComSaude) {
		super(nome, rendaAnual);
		this.gastoComSaude = gastoComSaude;
	}
	
	public Double getGastoComSaude() {
		return gastoComSaude;
	}

	public void setGastoComSaude(Double gastoComSaude) {
		this.gastoComSaude = gastoComSaude;
	}

	@Override
	public Double impostoRenda() {
		if (getRendaAnual() < 20000.00)
			return (getRendaAnual()*0.15) - (gastoComSaude*0.5);
		else
			return (getRendaAnual()*0.25) - (gastoComSaude*0.5);
	}

}
