package xadrez;

import java.util.ArrayList;

import java.util.List;
import java.util.stream.Collectors;

import tabuleiro.Peca;
import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;
import xadrez.pecas.Bispo;
import xadrez.pecas.Cavalo;
import xadrez.pecas.Peao;
import xadrez.pecas.Rainha;
import xadrez.pecas.Rei;
import xadrez.pecas.Torre;

public class PartidaXadrez {

	private Tabuleiro tabuleiro;

	private Integer turno;

	private boolean check;
	private boolean checkMate;

	private PecaXadrez enPassantVuneravel;

	private PecaXadrez promocao;

	private Cor jogador;

	private List<Peca> pecasTabuleiro = new ArrayList<>();

	private List<Peca> pecasCapituradas = new ArrayList<>();

	public PartidaXadrez() {
		turno = 1;
		jogador = Cor.BRANCO;
		tabuleiro = new Tabuleiro(8, 8);
		configuracaoPecas();
	}

	public PecaXadrez[][] getPecas() {
		PecaXadrez[][] matriz = new PecaXadrez[tabuleiro.getLinha()][tabuleiro.getColuna()];
		for (int i = 0; i < tabuleiro.getLinha(); i++) {
			for (int j = 0; j < tabuleiro.getColuna(); j++) {
				matriz[i][j] = (PecaXadrez) tabuleiro.peca(i, j);
			}
		}
		return matriz;
	}

	public int getTurno() {
		return turno;
	}

	public Cor getJogador() {
		return jogador;
	}

	public boolean getCheck() {
		return check;
	}

	public boolean getCheckMate() {
		return checkMate;
	}

	public PecaXadrez getEnPassanVuneravel() {
		return enPassantVuneravel;
	}

	public PecaXadrez getPromocao() {
		return promocao;
	}

	public boolean[][] movimentoPossivel(PosicaoXadrez posicaoPrincipal) {
		Posicao posicao = posicaoPrincipal.toPosicao();
		validarPosicaoInicial(posicao);
		return tabuleiro.peca(posicao).movimentosPossiveis();
	}

	public PecaXadrez moverPeca(PosicaoXadrez saida, PosicaoXadrez alvo) {

		Posicao sai = saida.toPosicao();
		Posicao target = alvo.toPosicao();

		validarPosicaoInicial(sai);
		validarPosicaoDestino(sai, target);

		Peca pecaMarcada = fazerMovimento(sai, target);

		if (testeCheck(jogador)) {
			desfazerMovimento(sai, target, pecaMarcada);
			throw new ExcessaoXadrez("Você não pode se colocar em Check");
		}

		PecaXadrez pecaMovida = (PecaXadrez) tabuleiro.peca(target);

		promocao = null;

		if (pecaMovida instanceof Peao) {

			if ((pecaMovida.getCor() == Cor.BRANCO && target.getLinha() == 0)
					|| (pecaMovida.getCor() == Cor.PRETO && target.getLinha() == 7)) {
				promocao = (PecaXadrez) tabuleiro.peca(target);
				promocao = recolocarPecaPromovida("q");
			}

		}

		check = (testeCheck(oponente(jogador))) ? true : false;

		if (testeCheckMate(oponente(jogador))) {
			checkMate = true;
		} else {
			proximoTurno();
		}

		// enPassant

		if (pecaMovida instanceof Peao
				&& (target.getLinha() == sai.getLinha() - 2 || target.getLinha() == sai.getLinha() + 2)) {
			enPassantVuneravel = pecaMovida;
		} else {
			enPassantVuneravel = null;
		}

		return (PecaXadrez) pecaMarcada;

	}

	public PecaXadrez recolocarPecaPromovida(String type) {

		if (promocao == null) {
			throw new IllegalStateException("Não existe peca promovida");
		}
		if (!type.equals("b") && !type.equals("q") && !type.equals("c") && !type.equals("t")) {
			return promocao;
		}

		Posicao pos = promocao.getPosicaoXadrez().toPosicao();
		Peca p = tabuleiro.removerPeca(pos);
		pecasTabuleiro.remove(p);

		PecaXadrez novaPeca = novaPeca(type, promocao.getCor());
		tabuleiro.colocarPecas(novaPeca, pos);
		pecasTabuleiro.add(novaPeca);

		return novaPeca;

	}

	private PecaXadrez novaPeca(String type, Cor cor) {
		if (type.equals("b"))
			return new Bispo(tabuleiro, cor);
		if (type.equals("q"))
			return new Rainha(tabuleiro, cor);
		if (type.equals("c"))
			return new Cavalo(tabuleiro, cor);
		return new Torre(tabuleiro, cor);
	}

	private Peca fazerMovimento(Posicao saida, Posicao alvo) {
		PecaXadrez p = (PecaXadrez) tabuleiro.removerPeca(saida);
		p.aumentarContagemMovimentos();
		Peca pecaMarcada = tabuleiro.removerPeca(alvo);
		tabuleiro.colocarPecas(p, alvo);

		if (pecaMarcada != null) {
			pecasTabuleiro.remove(pecaMarcada);
			pecasCapituradas.add(pecaMarcada);
		}

		// roque

		if (p instanceof Rei && alvo.getColuna() == saida.getColuna() + 2) {
			Posicao saidaTorre = new Posicao(saida.getLinha(), saida.getColuna() + 3);
			Posicao alvoTorre = new Posicao(saida.getLinha(), saida.getColuna() + 1);
			PecaXadrez torre = (PecaXadrez) tabuleiro.removerPeca(saidaTorre);
			tabuleiro.colocarPecas(torre, alvoTorre);
			torre.aumentarContagemMovimentos();
		}

		if (p instanceof Rei && alvo.getColuna() == saida.getColuna() - 2) {
			Posicao saidaTorre = new Posicao(saida.getLinha(), saida.getColuna() - 4);
			Posicao alvoTorre = new Posicao(saida.getLinha(), saida.getColuna() - 1);
			PecaXadrez torre = (PecaXadrez) tabuleiro.removerPeca(saidaTorre);
			tabuleiro.colocarPecas(torre, alvoTorre);
			torre.aumentarContagemMovimentos();
		}

		// en passant

		if (p instanceof Peao) {
			if (saida.getColuna() != alvo.getColuna() && pecaMarcada == null) {
				Posicao posicaoPeao;
				if (p.getCor() == Cor.BRANCO) {
					posicaoPeao = new Posicao(alvo.getLinha() + 1, alvo.getColuna());
				} else {
					posicaoPeao = new Posicao(alvo.getLinha() - 1, alvo.getColuna());
				}
				pecaMarcada = tabuleiro.removerPeca(posicaoPeao);
				pecasCapituradas.add(pecaMarcada);
				pecasTabuleiro.remove(pecaMarcada);

			}
		}

		return pecaMarcada;

	}

	private void desfazerMovimento(Posicao saida, Posicao alvo, Peca pecaMarcada) {

		PecaXadrez p = (PecaXadrez) tabuleiro.removerPeca(alvo);
		p.diminuirContagemMovimentos();
		tabuleiro.colocarPecas(p, saida);

		if (pecaMarcada != null) {
			tabuleiro.colocarPecas(pecaMarcada, alvo);
			pecasCapituradas.remove(pecaMarcada);
			pecasTabuleiro.add(pecaMarcada);
		}

		// roque

		if (p instanceof Rei && alvo.getColuna() == saida.getColuna() + 2) {
			Posicao saidaTorre = new Posicao(saida.getLinha(), saida.getColuna() + 3);
			Posicao alvoTorre = new Posicao(saida.getLinha(), saida.getColuna() + 1);
			PecaXadrez torre = (PecaXadrez) tabuleiro.removerPeca(alvoTorre);
			tabuleiro.colocarPecas(torre, saidaTorre);
			torre.diminuirContagemMovimentos();
		}

		if (p instanceof Rei && alvo.getColuna() == saida.getColuna() - 2) {
			Posicao saidaTorre = new Posicao(saida.getLinha(), saida.getColuna() - 4);
			Posicao alvoTorre = new Posicao(saida.getLinha(), saida.getColuna() - 1);
			PecaXadrez torre = (PecaXadrez) tabuleiro.removerPeca(alvoTorre);
			tabuleiro.colocarPecas(torre, saidaTorre);
			torre.diminuirContagemMovimentos();
		}

		// en passant

		if (p instanceof Peao) {
			if (saida.getColuna() != alvo.getColuna() && pecaMarcada == enPassantVuneravel) {
				PecaXadrez peao = (PecaXadrez) tabuleiro.removerPeca(alvo);
				Posicao posicaoPeao;
				if (p.getCor() == Cor.BRANCO) {
					posicaoPeao = new Posicao(3, alvo.getColuna());
				} else {
					posicaoPeao = new Posicao(4, alvo.getColuna());
				}
				tabuleiro.colocarPecas(peao, posicaoPeao);
			}
		}

	}

	private void validarPosicaoInicial(Posicao posicao) {
		if (!tabuleiro.temPeca(posicao)) {
			throw new ExcessaoXadrez("Não tem peça nessa posição.");
		}
		if (jogador != ((PecaXadrez) tabuleiro.peca(posicao)).getCor()) {
			throw new ExcessaoXadrez("A peça escolhida não é sua!");
		}
		if (!tabuleiro.peca(posicao).existeAlgumMovimentoPossivel()) {
			throw new ExcessaoXadrez("Não existe movimentos possiveis");
		}
	}

	private void validarPosicaoDestino(Posicao saida, Posicao alvo) {
		if (!tabuleiro.peca(saida).movimentoPossivel(alvo))
			throw new ExcessaoXadrez("A peça escolhida nao pode ser movimentada para local de destino.");
	}

	private void proximoTurno() {
		turno++;
		jogador = (jogador == Cor.BRANCO) ? Cor.PRETO : Cor.BRANCO;
	}

	private Cor oponente(Cor cor) {

		return (cor == Cor.BRANCO) ? Cor.PRETO : Cor.BRANCO;
	}

	private PecaXadrez rei(Cor cor) {
		List<Peca> lista = pecasTabuleiro.stream().filter(x -> ((PecaXadrez) x).getCor() == cor)
				.collect(Collectors.toList());
		for (Peca p : lista) {
			if (p instanceof Rei) {
				return (PecaXadrez) p;
			}
		}
		throw new IllegalStateException("Não existe rei " + cor + " no tabuleiro");
	}

	private boolean testeCheck(Cor cor) {

		Posicao posicaoRei = rei(cor).getPosicaoXadrez().toPosicao();
		List<Peca> pecaOponente = pecasTabuleiro.stream().filter(x -> ((PecaXadrez) x).getCor() == oponente(cor))
				.collect(Collectors.toList());

		for (Peca p : pecaOponente) {
			boolean[][] mat = p.movimentosPossiveis();
			if (mat[posicaoRei.getLinha()][posicaoRei.getColuna()]) {
				return true;
			}
		}
		return false;
	}

	private boolean testeCheckMate(Cor cor) {
		if (!testeCheck(cor)) {
			return false;
		}
		List<Peca> lista = pecasTabuleiro.stream().filter(x -> ((PecaXadrez) x).getCor() == cor)
				.collect(Collectors.toList());
		for (Peca p : lista) {
			boolean[][] mat = p.movimentosPossiveis();
			for (int i = 0; i < tabuleiro.getLinha(); i++) {
				for (int j = 0; j < tabuleiro.getColuna(); j++) {
					if (mat[i][j]) {
						Posicao saida = ((PecaXadrez) p).getPosicaoXadrez().toPosicao();
						Posicao target = new Posicao(i, j);
						Peca pecaMarcada = fazerMovimento(saida, target);
						boolean testeCheck = testeCheck(cor);
						desfazerMovimento(saida, target, pecaMarcada);
						if (!testeCheck) {
							return false;
						}
					}
				}
			}
		}
		return true;
	}

	public void colocarNovaPeca(char coluna, int linha, PecaXadrez peca) {

		tabuleiro.colocarPecas(peca, new PosicaoXadrez(coluna, linha).toPosicao());
		pecasTabuleiro.add(peca);

	}

	public void configuracaoPecas() {

		colocarNovaPeca('a', 2, new Peao(tabuleiro, Cor.BRANCO, this));
		colocarNovaPeca('b', 2, new Peao(tabuleiro, Cor.BRANCO, this));
		colocarNovaPeca('c', 2, new Peao(tabuleiro, Cor.BRANCO, this));
		colocarNovaPeca('d', 2, new Peao(tabuleiro, Cor.BRANCO, this));
		colocarNovaPeca('e', 2, new Peao(tabuleiro, Cor.BRANCO, this));
		colocarNovaPeca('f', 2, new Peao(tabuleiro, Cor.BRANCO, this));
		colocarNovaPeca('g', 2, new Peao(tabuleiro, Cor.BRANCO, this));
		colocarNovaPeca('h', 2, new Peao(tabuleiro, Cor.BRANCO, this));
		colocarNovaPeca('b', 1, new Cavalo(tabuleiro, Cor.BRANCO));
		colocarNovaPeca('g', 1, new Cavalo(tabuleiro, Cor.BRANCO));
		colocarNovaPeca('a', 1, new Torre(tabuleiro, Cor.BRANCO));
		colocarNovaPeca('h', 1, new Torre(tabuleiro, Cor.BRANCO));
		colocarNovaPeca('f', 1, new Bispo(tabuleiro, Cor.BRANCO));
		colocarNovaPeca('c', 1, new Bispo(tabuleiro, Cor.BRANCO));
		colocarNovaPeca('d', 1, new Rainha(tabuleiro, Cor.BRANCO));
		colocarNovaPeca('e', 1, new Rei(tabuleiro, Cor.BRANCO, this));

		colocarNovaPeca('a', 7, new Peao(tabuleiro, Cor.PRETO, this));
		colocarNovaPeca('b', 7, new Peao(tabuleiro, Cor.PRETO, this));
		colocarNovaPeca('c', 7, new Peao(tabuleiro, Cor.PRETO, this));
		colocarNovaPeca('d', 7, new Peao(tabuleiro, Cor.PRETO, this));
		colocarNovaPeca('e', 7, new Peao(tabuleiro, Cor.PRETO, this));
		colocarNovaPeca('f', 7, new Peao(tabuleiro, Cor.PRETO, this));
		colocarNovaPeca('g', 7, new Peao(tabuleiro, Cor.PRETO, this));
		colocarNovaPeca('h', 7, new Peao(tabuleiro, Cor.PRETO, this));
		colocarNovaPeca('b', 8, new Cavalo(tabuleiro, Cor.PRETO));
		colocarNovaPeca('g', 8, new Cavalo(tabuleiro, Cor.PRETO));
		colocarNovaPeca('a', 8, new Torre(tabuleiro, Cor.PRETO));
		colocarNovaPeca('h', 8, new Torre(tabuleiro, Cor.PRETO));
		colocarNovaPeca('f', 8, new Bispo(tabuleiro, Cor.PRETO));
		colocarNovaPeca('c', 8, new Bispo(tabuleiro, Cor.PRETO));
		colocarNovaPeca('d', 8, new Rainha(tabuleiro, Cor.PRETO));
		colocarNovaPeca('e', 8, new Rei(tabuleiro, Cor.PRETO, this));
	}
}
