import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("Entre com um numero inteiro: ");
		
		Scanner sc = new Scanner(System.in);
		
		int x = 0;
		
		String texto, texto2;
		
		x = sc.nextInt();
		sc.nextLine();
		System.out.println("Entre com um texto: ");
		
		texto = sc.nextLine();
		
		System.out.println("Entre com outro texto: ");
		
		texto2 = sc.nextLine();
		
		System.out.printf("O inteiro que voce digitou foi: %d %nO primeiro texto foi: %s %nO segundo texto foi: %s %n", x, texto, texto2);
		
		sc.close();

	}

}
