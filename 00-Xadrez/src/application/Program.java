package application;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import xadrez.ExcessaoXadrez;
import xadrez.PartidaXadrez;
import xadrez.PecaXadrez;
import xadrez.PosicaoXadrez;

public class Program {

	public static void main(String[] args) {

		PartidaXadrez partidaXadrez = new PartidaXadrez();
		List<PecaXadrez> capiturada = new ArrayList<>();
		
		Scanner sc = new Scanner(System.in);

		while (!partidaXadrez.getCheckMate()) {
			try {
			UI.clearScreen();
			UI.mostrarPartida(partidaXadrez, capiturada);
			System.out.println();
			System.out.print("Saida: ");
			PosicaoXadrez saida = UI.lerPosicaoPeca(sc);
			
			boolean[][] movimentosPossiveis = partidaXadrez.movimentoPossivel(saida);
			UI.clearScreen();
			UI.mostrarTabuleiro(partidaXadrez.getPecas(), movimentosPossiveis);
			
			System.out.println();
			System.out.print("Destino: ");
			PosicaoXadrez destino = UI.lerPosicaoPeca(sc);
			
			PecaXadrez move = partidaXadrez.moverPeca(saida, destino);
			
			if (move != null) {
				capiturada.add(move);
			}
			
			if(partidaXadrez.getPromocao() != null) {
				System.out.println("'Digite o nome da peça que deseja (q/t/c/b): ");
				String type = sc.nextLine();
				while (!type.equals("b") && !type.equals("q") && !type.equals("c") && !type.equals("t")) {
					System.out.println("Valor Invalido! Digite o nome da peça que deseja (q/t/c/b): ");
					type = sc.nextLine();
				}

				partidaXadrez.recolocarPecaPromovida(type);
			}
			
			}catch(ExcessaoXadrez e) {
				System.out.println(e.getMessage());	
				sc.nextLine();
			}catch(InputMismatchException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
		}
		UI.clearScreen();
		UI.mostrarPartida(partidaXadrez, capiturada);
	}

}
