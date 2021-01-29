package edu.sagah.datastructure.graph;

public class Aresta<T> {
	
	private Vertice<T> origem;
	
	private Vertice<T> destino;
	
	private Integer peso;
	
	public Aresta() {
	}

	public Aresta(Vertice<T> origem, Vertice<T> destino) {
		this.origem = origem;
		this.destino = destino;
	}

	public Aresta(Vertice<T> origem, Vertice<T> destino, Integer peso) {
		this.origem = origem;
		this.destino = destino;
		this.peso = peso;
	}

	public Integer getPeso() {
		return peso;
	}
	
	public Vertice<T> getOrigem() {
		return origem;
	}

	public Vertice<T> getDestino() {
		return destino;
	}
	
	public void setVertices(Vertice<T> orig, Vertice<T> dest) {
		this.origem = orig;
		this.destino = dest;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object obj) {
		Aresta<T> aresta = (Aresta<T>) obj;
		return this.origem.equals(aresta.getOrigem()) &&
				this.destino.equals(aresta.getDestino());
	}
	
	@Override
	public int hashCode() {
		return origem.hashCode() * destino.hashCode();
	}

	@Override
	public String toString() {
		return origem.getValor() + "-" + destino.getValor();
	}
	
	

}
