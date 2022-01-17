package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Cliente;
import entities.OrdemDeServico;
import entities.Pedidos;
import entities.Produto;
import entities.enums.EstatusDoPedido;

public class Program {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);

		SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println("Entre com dados dos clientes: ");
		System.out.print("Nome: ");
		String nome = sc.nextLine();
		System.out.print("E-mail: ");
		String email = sc.nextLine();
		System.out.println("Data de aniversario: (DD/MM/AAAA)");
		Date dt = data.parse(sc.next());
		sc.nextLine();

		Cliente cliente = new Cliente(nome, email, dt);

		System.out.println("Entre com dados da ordem de serviço: ");
		System.out.print("Estatus: ");
		String estatus = sc.nextLine();

		Pedidos pedido = new Pedidos(new Date(), EstatusDoPedido.valueOf(estatus));

		System.out.print("Quantos pedidos para essa ordem? ");

		int n = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < n; i++) {
			System.out.println("Entre com os dados do produto #" + (i+1)+": ");
			System.out.print("Nome do produto: ");
			String name = sc.nextLine();
			System.out.print("Preço do produto: ");
			double preco = sc.nextDouble();
			System.out.print("Quantidade: ");
			int quantidade = sc.nextInt();
			sc.nextLine();

			Produto produto = new Produto(name, preco);
			OrdemDeServico ordem = new OrdemDeServico(quantidade, preco, produto);
			pedido.adicionarItem(ordem);

		}

		System.out.println();
		System.out.println("Historico de pedidos: ");
		System.out.println("Hora do pedido: " + data.format(pedido.getMomento()));
		System.out.println("Estatus: " + pedido.getEstatus().toString());
		System.out.println("Cliente: " + cliente.getNome() + " " + data.format(cliente.getDataAniversario()) + " " + cliente.getEmail());
		System.out.println("Produtos pedidos: ");
		System.out.println(pedido);
		System.out.println("Preço total: " + pedido.total());
				
		sc.close();

	}

}
