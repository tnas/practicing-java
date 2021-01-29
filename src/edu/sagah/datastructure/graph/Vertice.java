package edu.sagah.datastructure.graph;

import java.util.ArrayList;
import java.util.List;

public class Vertice<T> {
	
	private final T valor;
	private int peso;
	private EstadoVertice estado;
	private List<Vertice<T>> vizinhos;
	
	public Vertice(T val) {
		this.valor = val;
		this.peso = 0;
	}
	
	public Vertice(T val, int peso) {
		this.valor = val;
		this.peso = peso;
	}

	public T getValor() {
		return valor;
	}
	
	public int getPeso() {
		return peso;
	}
	
	public void setPeso(int peso) {
		this.peso = peso;
	}

	public void marcar(EstadoVertice estado) {
		this.estado = estado;
	}
	
	public boolean ehVisitado() {
		return this.estado == EstadoVertice.VISITADO;
	}

	public boolean adicionarAresta(Vertice<T> vert) {
		if (this.vizinhos == null)
			this.vizinhos = new ArrayList<Vertice<T>>();
		if (this.vizinhos.contains(vert)) {
			return false;
		}
		else {
			this.vizinhos.add(vert);
			return true;
		}
	}
	
	public int obterGrauPonderado() {
		return this.vizinhos.stream()
				.reduce(0, (subtotal, vertice) -> 
				subtotal + vertice.getPeso(), Integer::sum);
	}
	
	public int getGrau() {
		return this.vizinhos == null ? 0 :
			this.vizinhos.size();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public boolean equals(Object obj) {
		return ((Vertice<T>) obj).getValor().equals(this.valor);
	}

	@Override
	public String toString() {
		return this.valor.toString() + "(" + this.peso + ")";
	}

	public List<Vertice<T>> getVizinhos() {
		return vizinhos;
	}
	
}
