import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int numero;
		
		System.out.println("Entre com um numero inteiro: ");
		
		numero = sc.nextInt();
		
		if (numero == 0)
			System.out.println("Numero Nulo!");
		else if (numero % 2==0)
			System.out.println("Numero Par!");
		else
			System.out.println("Numero Impar!");
		
		sc.close();

	}

}
