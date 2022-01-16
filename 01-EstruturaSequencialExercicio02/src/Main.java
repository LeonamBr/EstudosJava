import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		double raio, area;
		
		System.out.println("Entre com valor do raio da circunferencia: ");
		
		raio = sc.nextDouble();
		
		area = Math.PI*Math.pow(raio, 2);
		
		System.out.printf("A area da circunferencia é: %.4f%n", area);
		
		sc.close();

	}

}
