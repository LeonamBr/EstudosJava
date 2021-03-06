package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entitties.Funcionarios;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		List<Funcionarios> funcionarios = new ArrayList<>();

		System.out.print("Quantos funcionarios v?o ser registrados? ");
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {

			System.out.printf("Funcionario: %d%n", i + 1);
			System.out.print("ID: ");
			int id = sc.nextInt();
			sc.nextLine();
			System.out.print("Nome: ");
			String nome = sc.nextLine();
			System.out.print("Salario: ");
			double salario = sc.nextDouble();

			funcionarios.add(new Funcionarios(id, nome, salario));

		}

		System.out.print("Entre com id do funcionario que vai receber um aumento: ");
		int id = sc.nextInt();
		boolean test = true;

		for (int i = 0; i < funcionarios.size(); i++) {
			if (funcionarios.get(i).getId() == id) {
				System.out.print("Entre com a porcentagem: ");
				int porc = sc.nextInt();
				funcionarios.get(i).aumentarSalario(porc);
				test = true;
				break;
			} else
				test = false;
		}
		
		if(!test)
			System.out.println("Funcionario n?o Existe!!");

		System.out.println();
		System.out.println("Lista de funcionarios: ");

		for (Funcionarios item : funcionarios) {
			System.out.println(item);
		}

		sc.close();

	}

}
