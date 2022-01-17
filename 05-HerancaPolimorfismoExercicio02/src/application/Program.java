package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Pessoa;
import entities.PessoaFisica;
import entities.PessoaJuridica;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		List<Pessoa> lista = new ArrayList<>();
		
		System.out.print("Entre com numero de pessoas: ");
		int n = sc.nextInt();
		for (int i =0; i<n;i++) {
			System.out.println("Informações da pessoa #"+ (i+1)+": ");
			System.out.print("Pessoa fisica ou juridica(f/j)? ");
			char ch = sc.next().charAt(0);
			sc.nextLine();
			System.out.print("Nome: ");
			String nome = sc.nextLine();
			System.out.print("Salario Anual: ");
			double salario = sc.nextDouble();
			if (ch == 'f') {
				System.out.print("Gastos com Saude: ");
				double gasto = sc.nextDouble();
				lista.add(new PessoaFisica(nome, salario, gasto));
			}
			else {
				System.out.print("Numero de funcionarios: ");
				int numeroFuncionarios = sc.nextInt();
				lista.add(new PessoaJuridica(nome, salario, numeroFuncionarios));
			}
			
		}
		
		System.out.println("Pagantes de imposto: ");
		double sum =0.0;
		
		for (Pessoa item: lista) {
			System.out.println(item.getNome() +":  $"+item.impostoRenda());
			sum+=item.impostoRenda();
		}
		
		System.out.println();
		System.out.println("Total de Taxas: " + sum);
		
		sc.close();

	}

}
