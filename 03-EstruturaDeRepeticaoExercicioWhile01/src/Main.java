import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int senha = 2002, tentativas;
		
		System.out.println("Entre comn a senha: ");
		tentativas = sc.nextInt();

		while (tentativas != senha) {

			System.out.println("Senha Invalida!!");
			
			System.out.println("Entre comn a senha: ");
			tentativas = sc.nextInt();

		}

		System.out.println("Acesso Parmitido!!");

		sc.close();

	}
}