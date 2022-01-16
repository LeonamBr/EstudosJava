import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		int valor;

		Scanner sc = new Scanner(System.in);

		System.out.println("Entre com um valor: ");

		valor = sc.nextInt();

		while (!(valor >= 1 && valor <= 1000)) {
			System.out.println("Valor invalido, digite novamente: ");
			valor = sc.nextInt();
		}

		for (int i = 0; i <= valor; i++) {
			if (i % 2 != 0)
				System.out.println("Valor: " + i);

		}

		sc.close();

	}

}
