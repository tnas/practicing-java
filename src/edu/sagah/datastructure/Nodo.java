package edu.sagah.datastructure;

public class Nodo {
	
	int valor, altura;
	Nodo esq, dir;

	public Nodo(int val) {
		valor = val;
		altura = 0;
		esq = dir = null;
	}
}
