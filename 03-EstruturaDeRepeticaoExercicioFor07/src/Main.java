import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		int numero;
		double sqr, cube;

		Scanner sc = new Scanner(System.in);

		System.out.println("Digite um valor inteiro: ");

		numero = sc.nextInt();

		for (int i = 1; i <= numero; i++) {

			sqr = Math.pow(i, 2);
			cube = Math.pow(i, 3);

			System.out.printf("%d %.0f %.0f%n", i, sqr, cube);
		}

		sc.close();

	}

}
