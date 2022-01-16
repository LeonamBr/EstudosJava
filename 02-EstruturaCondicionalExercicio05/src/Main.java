import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int quantidade, produto;
		double preco = 0, total;
		
		System.out.println("----------------------------------------");
		System.out.println(" Codigo\t\tEspecificação\tPreço");
		System.out.println("----------------------------------------");
		System.out.println("1\t\tCachorro-Quente\tR$ 4.00 ");
		System.out.println("2\t\tX-Salada\tR$ 4.50 ");
		System.out.println("3\t\tX-Bacon\t\tR$ 5.00 ");
		System.out.println("4\t\tTorrada Simples\tR$ 2.00 ");
		System.out.println("5\t\tRefrigerante\tR$ 1.50 ");
		System.out.println("----------------------------------------\n");
		
		System.out.println("Entre com o produto desejado e a quantidade separados por espaço: ");
		
		produto = sc.nextInt();
		quantidade = sc.nextInt();
		
		if (produto == 1)
			preco = 4.00;
		else if (produto == 2)
			preco = 4.50;
		else if (produto == 3)
			preco = 5.00;
		else if (produto == 4)
			preco = 2.00;
		else if (produto == 5)
			preco = 1.50;
		else
			System.out.println("Produto Invalido!!!");
		
		total = preco*quantidade;
		
		System.out.println("O preço total foi de: " + total);
		
		sc.close();

	}

}
