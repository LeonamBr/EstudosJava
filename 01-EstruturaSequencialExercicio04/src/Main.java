import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int numero;
		double horasTrabalhadas, ganhoHora;
		
		System.out.println("Entre com numero do funcionario: ");
		
		numero = sc.nextInt();
		
		System.out.println("Entre com numero de horas trabalhadas pelo funcionario: ");
		
		horasTrabalhadas = sc.nextDouble();
		
		System.out.println("Entre com ganho por hora do funcioanrio: ");
		
		ganhoHora =  sc.nextDouble();
		
		System.out.printf("O funcionario numero: %d%nTrabalhou por: %.2f Horas%nGanhou: $ %.2f",numero, horasTrabalhadas, horasTrabalhadas*ganhoHora);
		
		sc.close();

	}

}
