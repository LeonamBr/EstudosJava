package application;

import java.util.Scanner;

import entities.Banco;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("Entre com numero da conta: ");
		int conta = sc.nextInt();
		System.out.print("Entre o nome do assinante da conta: ");
		sc.nextLine();
		String nome = sc.nextLine();
		System.out.print("Deseja fazer um deposito inicial(S/N)? ");
		char escolha = sc.next().charAt(0);
		double deposito;
		Banco assinante;
		
		if (escolha == 'S' || escolha == 's') {
			System.out.print("Entre o valor a ser depositado: ");
			deposito = sc.nextDouble();
			assinante = new Banco(conta, nome, deposito);
		} else
			assinante = new Banco(conta, nome);

		System.out.println("Dados da conta: ");
		System.out.println(assinante);
		
		System.out.print("Entre com um valor de deposito: ");
		deposito = sc.nextDouble();
		
		assinante.aumentaSaldo(deposito);
		
		System.out.println("Dados Atualizados da conta: ");
		System.out.println(assinante);
		
		System.out.println("Entre com um valor pra retirar da conta: ");
		deposito = sc.nextDouble();
		
		assinante.diminuiSaldo(deposito);
		
		System.out.println("Dados Atualizados da conta: ");
		System.out.println(assinante);
		
		sc.close();

	}

}
