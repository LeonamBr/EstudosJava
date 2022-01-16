import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Entre com dois valores a serem somados: ");
		
		double x,y;
		
		x = sc.nextDouble();
		y = sc.nextDouble();
		
		System.out.println("O Resultado da soma é: " + (x+y));
		
		sc.close();

	}

}
