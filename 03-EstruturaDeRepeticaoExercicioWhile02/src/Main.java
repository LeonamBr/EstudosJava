import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Entre com valor para x e y separados por espaço: ");
		
		double x, y;
		
		x = sc.nextDouble();
		y = sc.nextDouble();
		
		while(x != 0 || y != 0) {
			
			if (x > 0 && y > 0)
				System.out.println("Primeiro Quadrante");
			else if(x < 0 && y > 0)
				System.out.println("Segundo Quadrante");
			else if(x < 0 && y < 0)
				System.out.println("Terceiro Quadrante");
			else if(x > 0 && y < 0)
				System.out.println("Quarto Quadrante");
			
			System.out.println("Entre com outros valores: ");
			
			x = sc.nextDouble();
			y = sc.nextDouble();
			
			sc.close();
			
		}				

	}

}
