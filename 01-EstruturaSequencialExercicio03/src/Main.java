import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int A,B,C,D, diferenca;
		
		System.out.println("Entre com quatro inteiros separados por espaço: ");
		
		A = sc.nextInt();
		B = sc.nextInt();
		C = sc.nextInt();
		D = sc.nextInt();
		
		diferenca = ((A*B) - (C*D));
		
		System.out.printf("A diferença entre as multiplicações é: %d%n", diferenca);		
		
		sc.close();

	}

}
