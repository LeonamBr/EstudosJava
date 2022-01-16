package entities;

public class Retangulo {

	public double base;
	public double altura;

	
	public double area() {
		return base*altura;
	}
	
	public double perimetro() {
		return (2*base + 2*altura);
	}
	
	public double diagonal() {
		return Math.sqrt(Math.pow(altura, 2) + Math.pow(base, 2));
	}
	
	public String toString() {
		
		return "Area: " + String.format("%.2f", area()) + "\n"
			 + "Perimetro: " + String.format("%.2f", perimetro()) + "\n"
			 + "Diagonal: " + String.format("%.2f", diagonal());
	}
	
}
