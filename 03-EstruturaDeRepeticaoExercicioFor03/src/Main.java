import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		int cont;
		double x1, x2, x3, media;
		
		Scanner sc = new Scanner(System.in);

		System.out.println("Entre com a quantidade a ser testada: ");
		
		cont = sc.nextInt();
		
		for(int i=0; i<cont;i++) {
			System.out.println("Entre com tr�s valores separados por espa�o: ");
			
			x1 = sc.nextDouble();
			x2 = sc.nextDouble();
			x3 = sc.nextDouble();
			
			media = (x1*2 + x2*3 + x3*5)/10;
			
			System.out.printf("Media(%d) = %.1f%n", i+1, media);
			
		}
		
		sc.close();
		
	}

}
