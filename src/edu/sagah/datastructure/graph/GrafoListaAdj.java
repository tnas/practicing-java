package edu.sagah.datastructure.graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class GrafoListaAdj<T> {
	
	private int numArestas;
	private List<Vertice<T>> listaAdj;
	private Map<Aresta<T>, Integer> pesoArestas;
	private int infinito;
	private Map<Vertice<T>, Vertice<T>> predecessor;
	
	public GrafoListaAdj() {
		this.listaAdj = new ArrayList<Vertice<T>>();
		this.pesoArestas = new HashMap<>();
	}
	
	public int getNumVertices() {
		return this.listaAdj.size();
	}
	
	public int getNumArestas() {
		return this.numArestas;
	}
	
	public Vertice<T> obterVertice(Vertice<T> vertice) {
		return this.listaAdj.stream()
				.filter(v -> v.equals(vertice))
				.findFirst().get();
	}
	
	public List<Vertice<T>> obterAdjacentes(Vertice<T> vertice) {
		return this.listaAdj.stream()
				.filter(v -> v.equals(vertice))
				.findFirst().get().getVizinhos();
	}
	
	private void marcarVertices(EstadoVertice estado) {
		this.listaAdj.forEach(v -> {
			v.marcar(estado);
			v.getVizinhos().forEach(n -> n.marcar(estado));
		});
	}
	
	public boolean ehAlcancavelPor(Vertice<T> vertice) {
		return this.listaAdj.stream()
				.filter(v -> v.equals(vertice))
				.findFirst().get()
				.ehVisitado();
	}
		
	public void buscarEmProfunidade(Vertice<T> inicio) {
		
		this.marcarVertices(EstadoVertice.NAO_VISITADO);
		
		Stack<Vertice<T>> pilhaTrajeto = new Stack<>();
		pilhaTrajeto.push(inicio);
		int maiorPilha = 0;
		
		while (!pilhaTrajeto.isEmpty()) {
			
			if (pilhaTrajeto.size() > maiorPilha) 
				maiorPilha = pilhaTrajeto.size();
			
			Vertice<T> vertice = pilhaTrajeto.pop();
			
			if (!vertice.ehVisitado()) {
				vertice.marcar(EstadoVertice.VISITADO);
				if (vertice.getVizinhos() != null)
					vertice.getVizinhos().forEach(pilhaTrajeto::push);
			}
		}
		
		System.out.println("Maior tamanho de pilha: " + maiorPilha);
	}
	
	public void buscarEmLargura(Vertice<T> inicio) {
		
		this.marcarVertices(EstadoVertice.NAO_VISITADO);
		inicio.marcar(EstadoVertice.VISITADO);
		System.out.println("Vertice: " + inicio.getValor());
		
		Queue<Vertice<T>> filaTrajeto = new LinkedList<>();
		filaTrajeto.add(inicio);
		
		while (!filaTrajeto.isEmpty()) {
			
			Vertice<T> vertice = filaTrajeto.remove();
			
			if (vertice.getVizinhos() != null) {
				vertice.getVizinhos().forEach(w -> {
					if (!w.ehVisitado()) {
						w.marcar(EstadoVertice.VISITADO);
						filaTrajeto.add(w);
						System.out.println("Vertice: " + w.getValor());				
					}
				});
			}
		}
	}
	
	
	
	public Map<Vertice<T>, Vertice<T>> executarDijkstra(Vertice<T> inicio) {
		
		Aresta<T> aresta = new Aresta<>();
		predecessor = new HashMap<>();
		
		List<Vertice<T>> fila = new ArrayList<>();
		this.listaAdj.forEach(v -> {
			v.setPeso(Integer.MAX_VALUE);
			fila.add(v);
			predecessor.put(v, null);
		});
		
		inicio.setPeso(0);
		List<Vertice<T>> processados = new ArrayList<>();
		
		while (!fila.isEmpty()) {
			
			fila.sort(Comparator.comparing(Vertice<T>::getPeso));
			Vertice<T> vertice = fila.remove(0);
			processados.add(vertice);
			
			if (vertice.getVizinhos() != null) {
				vertice.getVizinhos().forEach(w -> {
					if (!processados.contains(w)) {
						aresta.setVertices(vertice, w);
						int novoPeso = vertice.getPeso() + pesoArestas.get(aresta); 
						if (novoPeso < w.getPeso()) {
							w.setPeso(novoPeso);
							predecessor.put(w, vertice);
						}
					}
				});
			}
		}
		
		return predecessor;
	}
	
	public boolean executarBellmanFord(Vertice<T> inicio) {
		
		Aresta<T> aresta = new Aresta<>();
		this.predecessor = new HashMap<>();
		
		this.listaAdj.forEach(v -> {
			v.setPeso(this.infinito);
			predecessor.put(v, null);
		});
		
		inicio.setPeso(0);
		
		for (int passo = 1; passo < this.getNumVertices(); ++passo) {
			
			this.pesoArestas.forEach((a, p) -> {
				aresta.setVertices(a.getOrigem(), a.getDestino());
				int novoPeso = a.getOrigem().getPeso() + this.pesoArestas.get(aresta); 
				if (a.getDestino().getPeso() > novoPeso) {
					a.getDestino().setPeso(novoPeso);
					predecessor.put(a.getDestino(), a.getOrigem());
				}
			});
		}
		
		for (Aresta<T> a : this.pesoArestas.keySet())  {
			aresta.setVertices(a.getOrigem(), a.getDestino());
			if (a.getDestino().getPeso() > a.getOrigem().getPeso() + this.pesoArestas.get(aresta))
				return false;
		}
		
		return true;
	}
	

	
	public void imprimirCaminhoMinimo(Vertice<T> vertice) {

		// Obtendo vertice inicial
		Vertice<T> inicio = null;
		for (Vertice<T> v : this.predecessor.keySet()) {
			if (this.predecessor.get(v) == null) {
				inicio = v;
				break;
			}
		}
		
		Stack<T> caminho = new Stack<>();
		caminho.push(vertice.getValor());
		
		Vertice<T> aux = this.predecessor.get(vertice);
		
		while (aux != null) {
			caminho.push(aux.getValor());
			aux = this.predecessor.get(aux);
		}
		
		while (!caminho.isEmpty()) {
			System.out.print(caminho.pop() + " ");
		}
	}

	public Map<Vertice<T>, Vertice<T>> getPredecessor() {
		return predecessor;
	}

	public void adicionarAresta(Vertice<T> orig, Vertice<T> dest) {
		
		Vertice<T> vert = this.listaAdj.stream()
				.filter(v -> v.equals(orig)).findFirst().orElse(null);
		
		if (vert == null) {
			orig.adicionarAresta(dest);
			this.listaAdj.add(orig);
			++this.numArestas;
		}
		else {
			if (vert.adicionarAresta(dest)) ++this.numArestas;
		}
		
		if (this.listaAdj.stream().filter(v -> v.equals(dest)).findFirst().orElse(null) == null)
			this.listaAdj.add(dest);
		
	}
	
	public void adicionarAresta(Vertice<T> orig, Vertice<T> dest, Integer peso) {
		this.adicionarAresta(orig, dest);
		this.pesoArestas.put(new Aresta<T>(orig, dest, peso), peso);
		this.infinito += peso;
	}
	
	public void adicionarArestaNaoOrientada(Vertice<T> orig, Vertice<T> dest) {
		this.adicionarAresta(orig, dest);
		this.adicionarAresta(dest, orig);
	}
	
	public void ordenarPorGrauPonderado() {
		
		List<Vertice<T>> vertices = new ArrayList<Vertice<T>>();
		
		this.listaAdj.forEach(v -> {
			vertices.add(new Vertice<T>(v.getValor(), v.obterGrauPonderado()));
		});
		
	    Comparator<Vertice<T>> comparator = Comparator.comparing(Vertice<T>::getPeso);
		vertices.sort(comparator.reversed());
		
		vertices.forEach(System.out::println);
	}
	
	
	public void imprimirMaiorGrau() {
		Vertice<T> vertice = null;
		int maiorGrau = 0;
		
		for (Vertice<T> vert : this.listaAdj) {
			if (vert.getVizinhos().size() > maiorGrau) {
				vertice = vert;
				maiorGrau = vert.getVizinhos().size();
			}
		}
		
		System.out.println(String.format("Vertice de maior grau: %d - Grau: %d", 
				vertice.getValor(), maiorGrau));
	}
	
	
	public void imprimirListaMaiorGrau() {
		List<Vertice<T>> vertices = new ArrayList<>();
		int maiorGrau = 0;
		
		for (Vertice<T> vert : this.listaAdj) {
			if (vert.getVizinhos().size() == maiorGrau) {
				vertices.add(vert);
			}
			else if (vert.getVizinhos().size() > maiorGrau) {
				vertices.clear();
				vertices.add(vert);
				maiorGrau = vert.getVizinhos().size();
			}
		}
		
		vertices.forEach(v -> {
			System.out.println(String.format("Vertice de maior grau: %d - Grau: %d", 
					v.getValor(), v.getVizinhos().size()));	
		});
		
	}

	public void imprimir() {
		this.listaAdj.forEach(v -> {
			System.out.print(v + " -> ");
			if (v.getVizinhos() != null)
				v.getVizinhos().forEach(n -> {System.out.print(n + ", ");});
			System.out.println();
		});
	}
}
