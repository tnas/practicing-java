package edu.sagah.datastructure;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ABP {

	Nodo raiz;

	public ABP() {
		raiz = null;
	}

	void adicionar(Nodo no) {

		if (raiz == null) {
			raiz = no;
		} else {
			Nodo tmp = raiz;

			while (tmp != null) {
				if (no.valor > tmp.valor) {
					if (tmp.dir == null) {
						tmp.dir = new Nodo(no.valor);
						break;
					} else {
						tmp = tmp.dir;
					}
				} else if (no.valor < tmp.valor) {
					if (tmp.esq == null) {
						tmp.esq = new Nodo(no.valor);
						break;
					} else {
						tmp = tmp.esq;
					}
				} else {
					break;
				}
			}
		}
	}

	Nodo obterPiso(Nodo x, int chave) {
		if (x == null)
			return null;
		if (chave == x.valor)
			return x;
		if (chave < x.valor)
			return obterPiso(x.esq, chave);
		Nodo t = obterPiso(x.dir, chave);
		if (t != null)
			return t;
		else
			return x;
	}

	void imprimirEmOrdem() {

		Nodo tmp = this.raiz;
		Stack<Nodo> pilha = new Stack<Nodo>();

		while (tmp != null || !pilha.isEmpty()) {
			if (tmp != null) {
				pilha.push(tmp);
				tmp = tmp.esq;
			} else {
				tmp = pilha.pop();
				System.out.println(tmp.valor);
				tmp = tmp.dir;
			}
		}
	}

	void imprimirPorNivel() {

		if (null == raiz)
			return;

		Queue<Nodo> q = new LinkedList<Nodo>();
		q.add(raiz);
		Nodo n;

		while (!q.isEmpty()) {
			int size = q.size();
			while (size-- > 0) {
				n = q.remove();
				System.out.print(n.valor + ", ");
				if (null != n.esq) {
					q.add(n.esq);
				}
				if (null != n.dir) {
					q.add(n.dir);
				}
			}
			System.out.println();
		}
	}
}
