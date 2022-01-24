package application;

import java.util.Scanner;

import model.entities.Conta;
import model.exception.ContaException;

public class Program {

	public static void main(String[] args) {

		boolean rodar = true;
		Scanner sc = new Scanner(System.in);

		do

			try {

				System.out.println();
				System.out.println("Entre com os dados do titular da conta: ");
				System.out.print("Numero: ");
				int numero = sc.nextInt();
				sc.nextLine();
				System.out.print("Titular: ");
				String titular = sc.nextLine();
				System.out.print("Saldo Inicial: ");
				double saldoInicial = sc.nextDouble();
				System.out.print("Limite de Saque: ");
				double limiteSaque = sc.nextDouble();

				Conta conta = new Conta(numero, titular, saldoInicial, limiteSaque);

				System.out.print("Entre uma quantidade para sacar: ");
				double saque = sc.nextDouble();
				conta.sacar(saque);
				System.out.println("Novo Saldo: " + conta.getSaldo());
				sc.nextLine();

				System.out.print("Deseja rodar o programa novamente?(s/n): ");
				char ch = sc.next().charAt(0);
				if (ch == 'n')
					rodar = false;

			} catch (ContaException e) {
				System.out.println("Erro na operação: " + e.getMessage());
				System.out.print("Deseja rodar o programa novamente?(s/n): ");
				char ch = sc.next().charAt(0);
				if (ch == 'n')
					rodar = false;

			} catch (RuntimeException e) {
				System.out.println("Erro inesperado!!");
				break;
			}
		while (rodar);

		sc.close();
	}

}
