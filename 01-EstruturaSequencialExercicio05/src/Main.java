import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int numero1, numero2, quantidade1, quantidade2;
		double preco1, preco2, total;
		
		System.out.println("Entre com numero da pe�a seguidos de quantidade e pre�o separados por espa�os: ");
		System.out.println("Pe�a 1 : ");
		
		numero1 = sc.nextInt();
		quantidade1 = sc.nextInt();
		preco1 = sc.nextDouble();
		
		System.out.println("Pe�a 2: ");
		
		numero2 = sc.nextInt();
		quantidade2 = sc.nextInt();
		preco2 = sc.nextDouble();
		
		total = (quantidade1*preco1) + (quantidade2*preco2);
		
		System.out.printf("Pre�o total de pe�a %d e %d: %.2f", numero1, numero2, total);
		
		
		sc.close();
		
	}

}
