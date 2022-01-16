package entitties;

public class Funcionarios {

	private int id;
	private String nome;
	private double salario;

	public Funcionarios(int id, String nome, double salario) {
		this.id = id;
		this.nome = nome;
		this.salario = salario;
	}

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public double aumentarSalario(double porcentagem) {
		return this.salario += (this.salario * porcentagem) / 100;
	}

	public String toString() {
		return  id + ", " + nome + ", " + salario;
	}

}
