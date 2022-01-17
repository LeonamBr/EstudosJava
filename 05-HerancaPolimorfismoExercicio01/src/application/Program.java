package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import entities.Produto;
import entities.ProdutoImportado;
import entities.ProdutoUsado;

public class Program {

	public static void main(String[] args) throws ParseException {

		SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");

		Scanner sc = new Scanner(System.in);

		List<Produto> produto = new ArrayList<>();

		System.out.print("Entre com numero de produtos: ");
		int n = sc.nextInt();

		sc.nextLine();

		for (int i = 0; i < n; i++) {

			System.out.println("Entre com os dados do produto #" + (i + 1) + ": ");
			System.out.print("O produto é comum, usado ou importado(c/u/i): ");
			char tipo = sc.next().charAt(0);
			sc.nextLine();

			System.out.print("Nome: ");
			String nome = sc.nextLine();
			System.out.print("Preço: ");
			double preco = sc.nextDouble();

			if (tipo == 'c')
				produto.add(new Produto(nome, preco));
			else if (tipo == 'u') {
				sc.nextLine();
				System.out.print("Data de fabricação(dd/MM/yyyy): ");
				Date data = sd.parse(sc.nextLine());
				produto.add(new ProdutoUsado(nome, preco, data));
			} else {
				System.out.print("Taxa de importação: ");
				double taxa = sc.nextDouble();
				produto.add(new ProdutoImportado(nome, preco, taxa));
			}
		}

		System.out.println("Etiquetas: ");

		for (Produto item : produto) {
			System.out.println(item.etiqueta());
		}

		sc.close();

	}

}
