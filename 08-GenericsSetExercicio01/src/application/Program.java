package application;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import entities.Curso;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Set<Curso> set = new HashSet<>();
		
		System.out.print("Entre quantos alunos tem o curso A: ");
		int n = sc.nextInt();
		
		for (int i = 0; i<n ; i++) {
			set.add(new Curso(sc.nextInt()));
		}
		
		System.out.print("Entre quantos alunos tem o curso B: ");
		n = sc.nextInt();
		
		for (int i = 0; i<n ; i++) {
			set.add(new Curso(sc.nextInt()));
		}
		
		System.out.print("Entre quantos alunos tem o curso C: ");
		n = sc.nextInt();
		
		for (int i = 0; i<n ; i++) {
			set.add(new Curso(sc.nextInt()));
		}
		
		System.out.println("Total de alunos: " + set.size());
		
		sc.close();		
	}

}
