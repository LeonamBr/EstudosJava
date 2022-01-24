package xadrez;

import tabuleiro.Peca;
import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;

public abstract class PecaXadrez extends Peca {

	private Cor cor;

	private int contaMovimentos;

	public PecaXadrez(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro);
		this.cor = cor;
	}

	public Cor getCor() {
		return cor;
	}

	public int getContaMovimento() {
		return contaMovimentos;
	}

	public void aumentarContagemMovimentos() {
		contaMovimentos++;
	}

	public void diminuirContagemMovimentos() {
		contaMovimentos--;
	}

	public PosicaoXadrez getPosicaoXadrez() {
		return PosicaoXadrez.paraPosicao(posicao);
	}

	protected boolean temUmaPecaInimiga(Posicao posicao) {
		PecaXadrez p = (PecaXadrez) getTabuleiro().peca(posicao);
		return p != null && p.getCor() != cor;
	}

}
