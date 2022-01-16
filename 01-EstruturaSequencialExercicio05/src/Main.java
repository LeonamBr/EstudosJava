import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int numero1, numero2, quantidade1, quantidade2;
		double preco1, preco2, total;
		
		System.out.println("Entre com numero da peça seguidos de quantidade e preço separados por espaços: ");
		System.out.println("Peça 1 : ");
		
		numero1 = sc.nextInt();
		quantidade1 = sc.nextInt();
		preco1 = sc.nextDouble();
		
		System.out.println("Peça 2: ");
		
		numero2 = sc.nextInt();
		quantidade2 = sc.nextInt();
		preco2 = sc.nextDouble();
		
		total = (quantidade1*preco1) + (quantidade2*preco2);
		
		System.out.printf("Preço total de peça %d e %d: %.2f", numero1, numero2, total);
		
		
		sc.close();
		
	}

}
