package application;

import java.util.Scanner;

import entities.Quartos;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Quartos[] quartos = new Quartos[10];

		System.out.print("Quantos quartos v?o ser alugados? ");
		int n = sc.nextInt();
		sc.nextLine();

		for (int i = 0; i < n; i++) {
			System.out.printf("Aluguel #%d: %n", i + 1);
			System.out.print("Nome: ");
			String nome = sc.nextLine();
			System.out.print("E-mail: ");
			String email = sc.nextLine();
			System.out.print("Quarto: ");
			int quarto = sc.nextInt();
			sc.nextLine();

			quartos[quarto] = new Quartos(nome, email, quarto);
		}


		System.out.println("Quartos ocupados: ");
		for (int i = 0; i < quartos.length; i++) {
			if (quartos[i] != null) {
				System.out.println(quartos[i]);
			}

		}

		sc.close();
	}

}
