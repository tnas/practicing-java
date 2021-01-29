package edu.sagah.datastructure.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.IntStream;

public class GrafoMatrizAdj {
	
	private static final int COM_ARESTA = 1;
	private static final int SEM_ARESTA = 0;
	private final int numVertices;
	private int numArestas;
	private int[][] matrizAdj;
	
	public GrafoMatrizAdj(int numVertices) {
		this.numVertices = numVertices;
		this.matrizAdj = new int[numVertices][numVertices];
	}
	
	public void adicionarAresta(int orig, int dest) {
		if (this.matrizAdj[orig][dest] == SEM_ARESTA) {
			this.matrizAdj[orig][dest] = COM_ARESTA;
			++this.numArestas;
		}
	}
	
	public void adicionarArestaBidirecional(int orig, int dest) {
		adicionarAresta(orig, dest);
		adicionarAresta(dest, orig);
	}
	
	public void adicionarArestaPonderada(int orig, int dest, int valor) {
		this.matrizAdj[orig][dest] = valor;
		this.matrizAdj[dest][orig] = valor;
	}
	
	public int obterCustoCaminho(int[] caminho) {
		
		int custoCaminho = 0;
		boolean existeCaminho = true;
		
		for (int v = 0; v < caminho.length - 1; ++v) {
			
			int custoAresta = matrizAdj[caminho[v]][caminho[v + 1]];
			
			if (custoAresta > 0) {
				custoCaminho += custoAresta;
			}
			else {
				existeCaminho = false;
				custoCaminho = -1;
				break;
			}
		}
		
		if (!existeCaminho) {
			System.out.println("Caminho inexistente!");
		}
		
		return custoCaminho;
	}
	
	// TODO: Corrigir
	public void encontrarCaminhoPonderado(int orig, int dest, int custo) {
		
		boolean encontrado = false;
		int custoAtual = 0;
		List<Integer> caminho = new ArrayList<>();
		Stack<Integer> vizinhos = new Stack<Integer>();
		vizinhos.push(orig);
		
		while (!vizinhos.isEmpty() && !encontrado) {
			
			int atual = vizinhos.pop();
			caminho.add(atual);
			caminho.forEach(v -> System.out.print(v + "-"));
			System.out.println();
			
			custoAtual = 0;
			if (caminho.size() > 1) {
				for (int v = 0; v < caminho.size() - 1; ++v) 
					custoAtual += matrizAdj[caminho.get(v)][caminho.get(v+1)];
				
			}
			
			if (atual == dest && custoAtual == custo) {
				encontrado = true;
			}
			else {
				boolean empilhado = false;
				for (int v = 0; v < numVertices; ++v) {
					if (this.matrizAdj[atual][v] > 0 && !caminho.contains(v))
						vizinhos.push(v);
					empilhado = true;
				}
				if (!empilhado) caminho.remove(caminho.size() - 1);
			}
			
		}
		
		if (encontrado) {
			caminho.forEach(v -> System.out.print(v + "-"));
		}
		else {
			System.out.println("Caminho não encontrado!");
		}
	}
	
	
	
	public int getNumVertices() {
		return this.numVertices;
	}
	
	public int getNumArestas() {
		return this.numArestas;
	}

	public void imprimir() {
		
		IntStream.range(0, this.numVertices).forEach(lin -> {
			IntStream.range(0, this.numVertices).forEach(col -> {
				System.out.print(String.format("%d ", 
						this.matrizAdj[lin][col]));
			});
			System.out.println();
		});
	}
	
//	public void imprimirArestas() {
//		
//		IntStream.range(0, this.numVertices).forEach(lin -> {
//			IntStream.range(0, this.numVertices).forEach(col -> {
//				if (this.matrizAdj[lin][col] == COM_ARESTA) {
//					System.out.print(String.format("(%d - %d)", 
//							lin, col));	
//				}
//			});
//			System.out.println();
//		});
//	}
	
	public void imprimirArestas() {
		
		for (int lin = 0; lin < this.numVertices; lin++) {
			for (int col = 0; col < this.numVertices; col++) {
				if (this.matrizAdj[lin][col] == COM_ARESTA) {
					System.out.print(String.format("(%d - %d)", 
							lin, col));	
				}
			}
			System.out.println();
		}
	}
	
	public boolean ehCompleto() {
		for (int lin = 0; lin < this.numVertices; ++lin) {
			for (int col = 0; col < this.numVertices; ++col) {
				if (this.matrizAdj[lin][col] == SEM_ARESTA && lin != col) 
					return false;
			}
		}
		return true;
	}
	
}
