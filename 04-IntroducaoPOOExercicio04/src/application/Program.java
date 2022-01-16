package application;

import java.util.Scanner;

import entities.ConversorDeMoedas;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.print("Qual pre�o do dollar? ");
		ConversorDeMoedas.preco = sc.nextDouble();
		System.out.print("Quantos dollares deseja comprar? ");
		ConversorDeMoedas.quantidade = sc.nextDouble();
		
		System.out.printf("Quantidade a ser paga: R$ %.2f", ConversorDeMoedas.quantidadePaga());

		sc.close();

	}

}
