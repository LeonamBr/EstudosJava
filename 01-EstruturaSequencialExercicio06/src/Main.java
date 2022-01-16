import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		double A, B, C, triangulo, circulo, trapezio, quadrado, retangulo;
		
		System.out.println("Entre com valores para A,B e C separados por espaço: ");
		
		A = sc.nextDouble();
		B = sc.nextDouble();
		C = sc.nextDouble();
		
		triangulo = (A*C)/2.0;
		circulo = Math.PI*Math.pow(C, 2);
		trapezio = (A+B)*C/2.0;
		quadrado = Math.pow(B, 2);
		retangulo = A*B;
		
		System.out.printf("TRIANGULO: %.3f%nCIRCULO: %.3f%nTRAPEZIO: %.3f%nQUADRADO: %.3f%nRETANGULO: %.3f%n", triangulo, circulo, trapezio, quadrado, retangulo);		
		
		sc.close();

	}

}
