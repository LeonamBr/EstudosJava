package application;

import java.util.Scanner;

import entities.Retangulo;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Retangulo retangulo = new Retangulo();
		
		System.out.println("Entre com base e altura do retangulo: ");
		
		retangulo.base = sc.nextDouble();
		retangulo.altura = sc.nextDouble();
		
		System.out.println(retangulo);
		
		sc.close();

	}

}
