import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
Scanner sc = new Scanner(System.in);
		
		int numero1, numero2;
		
		System.out.println("Entre com dois numeros inteiros separados por espa�o: ");
		
		numero1 = sc.nextInt();
		numero2 = sc.nextInt();
		
		if (numero1 > numero2)
			if (numero1 % numero2 == 0)
				System.out.println("Os numeros s�o multiplos!!");
			else
				System.out.println("Os numeros n�o s�o multiplos!!");
		else
			if (numero2 % numero1 == 0)
				System.out.println("Os numeros s�o multiplos!!");
			else
				System.out.println("Os numeros n�o s�o multiplos!!");
		
		sc.close();

	}

}
