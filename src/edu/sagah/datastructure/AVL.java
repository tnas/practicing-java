package edu.sagah.datastructure;

public class AVL {

	Nodo raiz;

	int altura(Nodo no) {
		if (no == null)
			return 0;
		return no.altura;
	}

	int obterFatorBalanceamento(Nodo no) {
		if (no == null)
			return 0;
		return altura(no.esq) - altura(no.dir);
	}

	void atualizarAltura(Nodo no) {
		no.altura = 1 + Math.max(altura(no.esq), altura(no.dir));
	}

	Nodo rotacionarADir(Nodo y) {
		Nodo x = y.esq;
		Nodo z = x.dir;
		x.dir = y;
		y.esq = z;
		atualizarAltura(x);
		atualizarAltura(y);
		return x;
	}

	Nodo rotacionarAEsq(Nodo x) {
		Nodo y = x.dir;
		Nodo z = y.esq;
		y.esq = x;
		x.dir = z;
		atualizarAltura(x);
		atualizarAltura(y);
		return y;
	}

	Nodo rebalancear(Nodo z) {
		atualizarAltura(z);
		int fator = obterFatorBalanceamento(z);
		if (fator > 1) {
			if (altura(z.dir.dir) > altura(z.dir.esq)) {
				z = rotacionarAEsq(z);
			} else {
				z.dir = rotacionarADir(z.dir);
				z = rotacionarAEsq(z);
			}
		} else if (fator < -1) {
			if (altura(z.esq.esq) > altura(z.esq.dir))
				z = rotacionarADir(z);
			else {
				z.esq = rotacionarAEsq(z.esq);
				z = rotacionarADir(z);
			}
		}
		return z;
	}

	Nodo insert(Nodo Nodo, int valor) {
		if (Nodo == null) {
			return new Nodo(valor);
		} else if (Nodo.valor > valor) {
			Nodo.esq = insert(Nodo.esq, valor);
		} else if (Nodo.valor < valor) {
			Nodo.dir = insert(Nodo.dir, valor);
		} else {
			throw new RuntimeException("duplicate valor!");
		}
		return rebalancear(Nodo);
	}

	Nodo nodoMaisAEsq(Nodo Nodo) {
		Nodo atual = Nodo;
		while (atual.esq != null) {
			atual = atual.esq;
		}
		return atual;
	}

	Nodo delete(Nodo Nodo, int valor) {
		if (Nodo == null) {
			return Nodo;
		} else if (Nodo.valor > valor) {
			Nodo.esq = delete(Nodo.esq, valor);
		} else if (Nodo.valor < valor) {
			Nodo.dir = delete(Nodo.dir, valor);
		} else {
			if (Nodo.esq == null || Nodo.dir == null) {
				Nodo = (Nodo.esq == null) ? Nodo.dir : Nodo.esq;
			} else {
				Nodo mostesqChild = nodoMaisAEsq(Nodo.dir);
				Nodo.valor = mostesqChild.valor;
				Nodo.dir = delete(Nodo.dir, Nodo.valor);
			}
		}
		if (Nodo != null) {
			Nodo = rebalancear(Nodo);
		}
		return Nodo;
	}

	Nodo buscar(int chave) {
		Nodo atual = raiz;
		while (atual != null) {
			if (atual.valor == chave) {
				break;
			}
			atual = atual.valor < chave ? atual.dir : atual.esq;
		}
		return atual;
	}
}
