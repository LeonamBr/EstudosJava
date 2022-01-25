package entities;

import java.util.Objects;

public class Urna {
	
	private String nome;
	
	private Integer votos;

	public Urna(String nome, Integer votos) {
		this.nome = nome;
		this.votos = votos;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getVotos() {
		return votos;
	}

	public void setVotos(Integer votos) {
		this.votos = votos;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Urna other = (Urna) obj;
		return Objects.equals(nome, other.nome);
	}

	@Override
	public String toString() {
		return "Urna [nome=" + nome + ", votos=" + votos + "]";
	}

}
