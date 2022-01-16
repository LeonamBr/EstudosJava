import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		int valor;

		Scanner sc = new Scanner(System.in);

		System.out.println("Entre com um valor inteiro: ");

		valor = sc.nextInt();

		for (int i = 1; i <= valor; i++) {

			if (valor % i == 0)
				System.out.println(i);

		}

		sc.close();

	}

}
