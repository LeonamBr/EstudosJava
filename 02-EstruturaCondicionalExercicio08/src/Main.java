import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		double salario, conta = 0;

		Scanner sc = new Scanner(System.in);

		System.out.println("Entre com valor do salario do cidadão Lisarbiano: ");

		salario = sc.nextDouble();

		if (salario >= 0 && salario <= 2000)
			System.out.println("Isento do imposto de renda!");
		else if (salario > 2000 && salario <= 3000)
			conta += (salario - 2000) * 0.08;
		else if (salario > 3000 && salario <= 4500) {

			conta += 1000 * 0.08;
			conta += (salario - 3000) * 0.18;

		} else if (salario > 4500) {

			conta += 1000 * 0.08;
			conta += 1500 * 0.18;
			conta += (salario - 4500) * 0.28;

		}

		System.out.printf("O imposto total a ser pago é: %.2f%n", conta);

		sc.close();

	}

}
