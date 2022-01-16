package entities;

public class Funcionarios {

	public String nome;
	public double salarioBruto;
	public double taxa;

	public double salarioLiquido() {

		return salarioBruto - taxa;
	}

	public void aumentarSalario(double porcentagem) {
		salarioBruto += salarioBruto*porcentagem/100;
	}
	
	public String toString() {
		return String.format("%s", nome) + ", $ " + String.format("%.2f", salarioLiquido());
	}

}
