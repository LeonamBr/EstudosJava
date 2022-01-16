import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int hora1, hora2, total;
		
		System.out.println("Entre com dois valores de horas entre 0 e 24h: ");
		
		hora1 = sc.nextInt();
		hora2 = sc.nextInt();

		
		if (hora1 > hora2)
			total = (24-hora1) + hora2;
		else if (hora2 > hora1)
			total = hora2 - hora1;
		else
			total = 24;
		
		
		System.out.println("A quantidade total de horas foram: " + total + " Horas");
		
		sc.close();

	}

}
