package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Contrato;
import model.services.Pagamento;
import model.services.PagamentoOnline;
import model.services.PagamentoPayPal;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date data = new Date();
		
		System.out.println("Entre com dados do contrato: ");
		System.out.print("Numero: ");
		int numero = sc.nextInt();
		sc.nextLine();
		System.out.print("Data: (DD/MM/YYYY)");
		data = sdf.parse(sc.nextLine());
		System.out.print("Valor do contrato: ");
		double valor = sc.nextDouble();
		System.out.print("Numero de parcelamentos: ");
		int parcelas = sc.nextInt();
		
		Contrato contrato = new Contrato(numero, data, valor, parcelas);
		
		PagamentoOnline pagamentoOnline = new PagamentoPayPal();
		
		Pagamento pagamento = new Pagamento(pagamentoOnline);
		
		pagamento.gerarContrato(contrato);
		
		System.out.println("Parcelamentos: ");
		
		System.out.println(contrato);	
		
		sc.close();
	}

}
