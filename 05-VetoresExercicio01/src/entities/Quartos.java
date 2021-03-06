package entities;

public class Quartos {

	private String nome;
	private String email;
	private int numero;
	
	public Quartos(String nome, String email, int numero) {
		this.nome = nome;
		this.email = email;
		this.numero = numero;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public int getNumero() {
		return numero;
	}
	
	public String toString() {
		return  numero +": " + nome + ", " + email;
	}

}
