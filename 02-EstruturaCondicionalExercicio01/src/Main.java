import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int numero;
		
		System.out.println("Entre com um numero inteiro: ");
		
		numero = sc.nextInt();
		
		if (numero > 0)
			System.out.println("NÃO NEGATIVO!!");
		else if(numero <0)
			System.out.println("NEGATIVO!!");
		else
			System.out.println("NULO!!");
		sc.close();

	}

}
