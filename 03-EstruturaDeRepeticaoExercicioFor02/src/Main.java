import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N, entra=0, sai=0;
		double x;
		
		System.out.println("Entre com a quantidade de numeros a serem testados: ");
		
		N = sc.nextInt();
		
		for (int i=0; i<N; i++) {
			
			System.out.println("Entre com valor a ser testado: ");
			x = sc.nextInt();
			
			if (x>=10 && x<=20)
				entra++;
			else
				sai++;
						
		}
		
		System.out.printf("in: %d%nout: %d%n", entra, sai);
		
		sc.close();

	}

}
