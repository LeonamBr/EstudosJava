package xadrez;

import tabuleiro.Posicao;

public class PosicaoXadrez {

	private char coluna;

	private Integer linha;

	public PosicaoXadrez(char coluna, Integer linha) {

		if (coluna < 'a' || coluna > 'h' || linha < 1 || linha > 8) {

			throw new ExcessaoXadrez("Erro ao buscar posicao: Posições validas são de a1 a h8! ");

		}

		this.coluna = coluna;
		this.linha = linha;
	}

	public char getColuna() {
		return coluna;
	}

	public Integer getLinha() {
		return linha;
	}

	protected Posicao toPosicao() {
		return new Posicao(8 - linha, coluna - 'a');
	}

	protected static PosicaoXadrez paraPosicao(Posicao posicao) {
		
		return new PosicaoXadrez((char)('a' + posicao.getColuna()), 8 - posicao.getLinha());
	}

	@Override
	public String toString() {
		return "" + coluna + linha;
	}
}
