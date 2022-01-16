package application;

import java.util.Scanner;

import entities.Funcionarios;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Funcionarios funcionario = new Funcionarios();
		
		System.out.print("Entre com nome do Funcionario: ");
		funcionario.nome = sc.nextLine();
		System.out.print("Salario bruto: ");
		funcionario.salarioBruto = sc.nextDouble();
		System.out.print("Taxa: ");
		funcionario.taxa = sc.nextDouble();
		
		System.out.println();
		
		System.out.println("Funcionario: " + funcionario);
		
		System.out.println();
		
		System.out.print("Quanto porcentos deseja inclementar do salario: ");
		
		double porcentagem = sc.nextDouble();
		
		funcionario.aumentarSalario(porcentagem);
		
		System.out.println();
		
		System.out.println("Dados atualizados: " + funcionario);
		
		sc.close();

	}

}
