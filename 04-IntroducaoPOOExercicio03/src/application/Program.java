package application;

import java.util.Scanner;

import entities.Aluno;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Aluno aluno = new Aluno();

		System.out.println("Entre com os dados do aluno: ");
		System.out.print("Aluno: ");
		aluno.nome = sc.nextLine();
		System.out.print("Nota 1: ");
		aluno.nota1 = sc.nextDouble();
		System.out.print("Nota 2: ");
		aluno.nota2 = sc.nextDouble();
		System.out.print("Nota 3: ");
		aluno.nota3 = sc.nextDouble();

		System.out.println(aluno);
		aluno.testeAprovacao();

		sc.close();

	}
}
