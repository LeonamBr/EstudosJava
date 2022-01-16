package entities;

public class ConversorDeMoedas {

	public static double preco;
	public static double quantidade;
	public static double iof = 0.06;
	
	public static double quantidadePaga() {
		return (preco*quantidade)+(preco*quantidade*iof);
	}
	
	
	
}
