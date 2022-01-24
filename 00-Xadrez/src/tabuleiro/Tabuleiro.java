package tabuleiro;

public class Tabuleiro {

	private Integer linha;
	private Integer coluna;
	private Peca[][] pecas;

	public Tabuleiro(Integer linha, Integer coluna) {
		if (linha < 1 || coluna < 1) {
			throw new ExcessaoTabuleiro("Erro ao construir tabuleiro: numero de linhas e colunas invalidas.");
		}
		this.linha = linha;
		this.coluna = coluna;
		pecas = new Peca[linha][coluna];
	}

	public Integer getLinha() {
		return linha;
	}

	public Integer getColuna() {
		return coluna;
	}

	public Peca peca(Integer linha, Integer coluna) {
		if (!posicaoExiste(linha, coluna)) {
			throw new ExcessaoTabuleiro("Posicao não existe!");
		}
		return pecas[linha][coluna];
	}

	public Peca peca(Posicao posicao) {
		if (!posicaoExiste(posicao)) {
			throw new ExcessaoTabuleiro("Posicao não existe!");
		}
		return pecas[posicao.getLinha()][posicao.getColuna()];
	}

	public void colocarPecas(Peca peca, Posicao posicao) {
		if (temPeca(posicao)) {
			throw new ExcessaoTabuleiro("Já existe uma peca na posiçao: " + posicao);
		}
		pecas[posicao.getLinha()][posicao.getColuna()] = peca;
		peca.posicao = posicao;
	}
	
	public Peca removerPeca (Posicao posicao) {
		if (!posicaoExiste(posicao))
			throw new ExcessaoTabuleiro("Posicao não existe!");
		if (peca(posicao) == null)
			return null;
		Peca aux = peca(posicao);
		aux.posicao = null;
		pecas[posicao.getLinha()][posicao.getColuna()] = null;
		return aux;
	}

	public boolean posicaoExiste(int linha, int coluna) {
		return linha >= 0 && linha < this.linha && coluna >= 0 && coluna < this.coluna;
	}

	public boolean posicaoExiste(Posicao posicao) {
		return posicaoExiste(posicao.getLinha(), posicao.getColuna());
	}

	public boolean temPeca(Posicao posicao) {
		if (!posicaoExiste(posicao)) {
			throw new ExcessaoTabuleiro("Posicao não existe!");
		}
		return peca(posicao) != null;
	}
}
