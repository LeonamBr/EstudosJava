import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		double x, y;
		
		System.out.println("Entre com valores de x e y separados por espa�o: ");
		
		x = sc.nextDouble();
		y = sc.nextDouble();
		
		if (x >0 && y >0)
			System.out.println("Est� no primeiro quadrante!");
		else if(x <0 && y >0)
			System.out.println("Est� no segundo quadrante!");
		else if(x <0 && y <0)
			System.out.println("Est� no terceiro quadrante!");
		else if(x > 0 && y<0)
			System.out.println("Est� no quarto quadrante!");
		else
			System.out.println("Est� na origem!");
		
		sc.close();

	}

}
