package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import entities.Urna;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("Entre o nome comleto do caminho: ");

		String path = sc.nextLine();

		int n1 = 0, n2 = 0, n3 = 0;

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			Map<Integer, Urna> map = new HashMap<>();
			int i = 1;
			while (br.ready()) {
				String str = br.readLine();
				String[] tmp = str.split(", ");
				map.put(i, new Urna(tmp[0], Integer.parseInt(tmp[1])));

				i++;
			}

			for (int j = 1; j <= map.size(); j++) {

				if (map.get(j).getNome().equals("Alex Blue"))
					n1 += map.get(j).getVotos();
				if (map.get(j).getNome().equals("Maria Green"))
					n2 += map.get(j).getVotos();
				if (map.get(j).getNome().equals("Bob Brown"))
					n3 += map.get(j).getVotos();
			}

			System.out.println("Alex Blue " + n1);
			System.out.println("Maria Green " + n2);
			System.out.println("Bob Brown " + n3);

		} catch (IOException e) {
			e.getStackTrace();
		}

		sc.close();
	}

}
