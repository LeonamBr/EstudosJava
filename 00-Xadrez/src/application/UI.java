package application;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import xadrez.Cor;
import xadrez.PartidaXadrez;
import xadrez.PecaXadrez;
import xadrez.PosicaoXadrez;

public class UI {

	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";

	public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
	public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
	public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
	public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
	public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
	public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
	public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
	public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

	public static void clearScreen() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}

	public static PosicaoXadrez lerPosicaoPeca(Scanner sc) {

		try {
			String s = sc.nextLine();
			char coluna = s.charAt(0);
			Integer linha = Integer.parseInt(s.substring(1));
			return new PosicaoXadrez(coluna, linha);
		} catch (RuntimeException e) {
			throw new InputMismatchException("A posicao deve estar entre a1 a h8!");
		}
	}

	public static void mostrarPartida(PartidaXadrez partida, List<PecaXadrez> capituradas) {

		mostrarTabuleiro(partida.getPecas());
		System.out.println();
		pecaCapiturada(capituradas);
		System.out.println();
		System.out.println("Turno: " + partida.getTurno());
		if (!partida.getCheckMate()) {
			System.out.println("Esperando jogador: " + partida.getJogador());
			if (partida.getCheck()) {
				System.out.println(ANSI_RED);
				System.out.println("CHECK!!");
				System.out.print(ANSI_RESET);
			}
		} else {
			System.out.println("CHECKMATE!!");
			System.out.println("Vencedor: " + partida.getJogador());
		}

	}

	public static void mostrarTabuleiro(PecaXadrez[][] pecas) {

		for (int i = 0; i < pecas.length; i++) {
			System.out.print(8 - i + " ");
			for (int j = 0; j < pecas.length; j++) {
				mostrarPeca(pecas[i][j], false);
			}
			System.out.println();
		}
		System.out.println("  a b c d e f g h");

	}

	public static void mostrarTabuleiro(PecaXadrez[][] pecas, boolean[][] movimentosPossiveis) {

		for (int i = 0; i < pecas.length; i++) {
			System.out.print(8 - i + " ");
			for (int j = 0; j < pecas.length; j++) {
				mostrarPeca(pecas[i][j], movimentosPossiveis[i][j]);
			}
			System.out.println();
		}
		System.out.println("  a b c d e f g h");

	}

	public static void mostrarPeca(PecaXadrez peca, boolean fundo) {

		if (fundo)
			System.out.print(ANSI_BLUE_BACKGROUND);
		if (peca == null)
			System.out.print("-" + ANSI_RESET);
		else {
			if (peca.getCor() == Cor.BRANCO) {
				System.out.print(ANSI_WHITE + peca + ANSI_RESET);
			} else {
				System.out.print(ANSI_CYAN + peca + ANSI_RESET);
			}
		}

		System.out.print(" ");

	}

	public static void pecaCapiturada(List<PecaXadrez> capiturada) {

		List<PecaXadrez> branca = capiturada.stream().filter(x -> x.getCor() == Cor.BRANCO)
				.collect(Collectors.toList());
		List<PecaXadrez> preta = capiturada.stream().filter(x -> x.getCor() == Cor.PRETO).collect(Collectors.toList());

		System.out.println("Peças capituradas: ");
		System.out.print("Brancas: ");
		System.out.print(ANSI_WHITE);
		System.out.println(Arrays.toString(branca.toArray()));
		System.out.print(ANSI_RESET);
		System.out.print("Pretas: ");
		System.out.print(ANSI_CYAN);
		System.out.println(Arrays.toString(preta.toArray()));
		System.out.print(ANSI_RESET);

	}

}
