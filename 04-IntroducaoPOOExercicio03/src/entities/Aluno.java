package entities;

public class Aluno {

	public double nota1;
	public double nota2;
	public double nota3;
	public String nome;
	
	public double notaTotal() {
		return nota1+nota2+nota3;
	}
	
	public void testeAprovacao() {
		
		if (notaTotal()> 60.0)
			System.out.println("Aprovado");
		else
			System.out.printf("Reprovado%nFaltou %.1f pontos", 60.0-notaTotal());
		
	}
	
	public String toString() {
		return String.format("Nota final: %.1f", notaTotal());
	}
}
