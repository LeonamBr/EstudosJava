import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		int escolha, gasolina = 0, diesel = 0, alcool = 0;
		Scanner sc = new Scanner(System.in);

		System.out.println("Entre com valores a seguir: ");
		System.out.println("-------------------------------");
		System.out.println("1- Alcool\n2- Gasolina\n3- Diesel\n4- Sair");

		escolha = sc.nextInt();

		while (escolha != 4) {

			if (escolha == 1)
				alcool++;
			else if (escolha == 2)
				gasolina++;
			else if (escolha == 3)
				diesel++;
			else {
				System.out.println("Opção invalida, Digite novamente: ");
				escolha = sc.nextInt();
			}
			
			System.out.println("Vai abastecer com?");
			escolha = sc.nextInt();

		}

		System.out.printf("Muito Obrigado!!%nAlcool: %d%nGasolina: %d%nDiesel: %d%n", alcool, gasolina, diesel);
		
		sc.close();

	}

}
