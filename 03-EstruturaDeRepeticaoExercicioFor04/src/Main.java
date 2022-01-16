import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		int cont;
		double x, y;

		Scanner sc = new Scanner(System.in);

		System.out.println("Entre com a quantidade de testes a ser feito: ");

		cont = sc.nextInt();

		for (int i = 0; i < cont; i++) {
			System.out.println("Entre com valores de x e y separados por espaço: ");

			x = sc.nextDouble();
			y = sc.nextDouble();

			if (y != 0)
				System.out.println("Resultado da Divisao é: " + (x / y));
			else
				System.out.println("Divisao Impossivel");
		}

		sc.close();

	}

}
