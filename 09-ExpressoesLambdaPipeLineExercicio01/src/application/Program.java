package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import entities.Funcionario;

public class Program {

	public static void main(String[] args) {

		System.out.print("Entre com caminho completo do arquivo: ");

		Scanner sc = new Scanner(System.in);

		String path = sc.nextLine();

		
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			System.out.print("Entre com salario a ser filtrado: ");
			double salario = sc.nextDouble();

			List<Funcionario> list = new ArrayList<>();
			
			while (br.ready()) {
				String[] str;

				String tmp = br.readLine();
				
				str = tmp.split(",");
				
				Funcionario funcionario = new Funcionario(str[0], str[1], Double.parseDouble(str[2]));
				
				list.add(funcionario);

			}
			
			List<Funcionario> lista = new ArrayList<>();
			
			lista = list.stream().filter( f -> f.getSalario() > salario).collect(Collectors.toList());
			
			lista = lista.stream().sorted((f1, f2)-> f1.getNome().toUpperCase().compareTo(f2.getNome().toUpperCase())).collect(Collectors.toList());
			
			System.out.println("Salarios que são maior que " + salario);
			
			lista.forEach(f -> System.out.println(f.getEmail()));
			
			List<Double> salarioTeste = new ArrayList<>();
			
			salarioTeste = list.stream().filter(f-> f.getNome().toUpperCase().charAt(0) == 'M').map(f -> f.getSalario()).collect(Collectors.toList());
			
			System.out.print("Soma dos salarios das pessoas que tem nome começado com M: " + salarioTeste.stream().reduce(0.0, (x, y) -> x + y));
			
		} catch (IOException e) {
			e.getStackTrace();
		}

		sc.close();
	}

}
