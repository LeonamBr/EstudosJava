import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		int N, fatorial = 1;

		Scanner sc = new Scanner(System.in);

		System.out.println("Entre com valor inteiro para encontrar seu fatorial: ");

		N = sc.nextInt();

		if (N == 0)
			fatorial = 1;

		for (int i = 1; i <= N; i++) {

			fatorial *= i;

		}

		System.out.println("Fatorial = " + fatorial);

		sc.close();

	}

}
