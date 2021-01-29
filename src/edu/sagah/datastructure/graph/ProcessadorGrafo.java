package edu.sagah.datastructure.graph;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ProcessadorGrafo {

	public static void main(String[] args) {
		
		Map<String, Vertice<String>> vertices = new HashMap<>();
		Arrays.asList(new String[] { "A", "B", "C", "D", "E", "F"})
			.forEach(v -> vertices.put(v, new Vertice<String>(v)));
		
		String[][] arestas = new String[][] { {"A", "B", "10"}, {"A", "C", "15"}, {"B", "D", "12"}, 
			{"B", "F", "15"}, {"C", "E", "15"}, {"D", "E", "2"}, {"D", "F", "1"}};
		
		GrafoListaAdj<String> grafo = new GrafoListaAdj<>();
		Arrays.asList(arestas).forEach(a ->	grafo.adicionarAresta(
				vertices.get(a[0]), vertices.get(a[1]), Integer.valueOf(a[2])));
		grafo.executarDijkstra(vertices.get("A"));
		Map<Vertice<String>, Vertice<String>> rota = grafo.getPredecessor();	
		grafo.imprimirCaminhoMinimo(vertices.get("E"));
		///buscarProfunidadeLargura();
	}
	
	public static void bellmanFord() {
		Map<String, Vertice<String>> vertices = new HashMap<>();
		Arrays.asList(new String[] { "s", "t", "x", "y", "z" })
			.forEach(v -> vertices.put(v, new Vertice<String>(v)));
		
		String[][] arestas = new String[][] { {"s", "t", "6"}, {"s", "y", "7"}, {"t", "y", "8"}, 
			{"t", "x", "5"}, {"t", "z", "-4"}, {"x", "t", "-2"}, {"y", "x", "-3"}, {"y", "z", "9"},
			{"z", "x", "7"},  {"z", "s", "2"}};
		
		GrafoListaAdj<String> grafo = new GrafoListaAdj<>();
		Arrays.asList(arestas).forEach(a ->	grafo.adicionarAresta(
				vertices.get(a[0]), vertices.get(a[1]), Integer.valueOf(a[2])));
		grafo.executarBellmanFord(vertices.get("s"));
		Map<Vertice<String>, Vertice<String>> rota = grafo.getPredecessor();
		
		System.out.println("Menor Caminho");
		rota.forEach((k, v) -> {
			System.out.println(k + " -> " + v);
		});
	}
	
	public static  void dijkstra2() {
		
		Map<String, Vertice<String>> vertices = new HashMap<>();
		Arrays.asList(new String[] { "s", "t", "x", "y", "z" })
			.forEach(v -> vertices.put(v, new Vertice<String>(v)));
		
		String[][] arestas = new String[][] { {"s", "t", "10"}, {"s", "y", "5"}, {"t", "y", "2"}, 
			{"t", "x", "1"}, {"y", "t", "3"}, {"y", "x", "9"}, {"y", "z", "2"},
			{"x", "z", "4"},  {"z", "x", "6"}, {"z", "s", "7"}};
		
		GrafoListaAdj<String> grafo = new GrafoListaAdj<>();
		Arrays.asList(arestas).forEach(a ->	grafo.adicionarAresta(
				vertices.get(a[0]), vertices.get(a[1]), Integer.valueOf(a[2])));
		Map<Vertice<String>, Vertice<String>> rota = grafo.executarDijkstra(vertices.get("s"));
		
		System.out.println("Menor Caminho");
		rota.forEach((k, v) -> {
			System.out.println(k + " -> " + v);
		});
		System.out.println("-----------");
		
		grafo.imprimir();
	}
	
	public static  void dijkstra1() {
		Map<String, Vertice<String>> vertices = new HashMap<>();
		Arrays.asList(new String[] { "s", "v", "w", "t" })
			.forEach(v -> vertices.put(v, new Vertice<String>(v)));
		
		String[][] arestas = new String[][] { {"s", "v", "1"}, {"s", "w", "4"}, {"v", "w", "2"}, 
			{"w", "t", "3"}, {"v", "t", "6"} };
		
		GrafoListaAdj<String> grafo = new GrafoListaAdj<>();
		Arrays.asList(arestas).forEach(a ->	grafo.adicionarAresta(
				vertices.get(a[0]), vertices.get(a[1]), Integer.valueOf(a[2])));
		grafo.executarDijkstra(vertices.get("s"));
		grafo.imprimir();
	}
	
	public static void buscarProfunidadeLargura() {
		Map<String, Vertice<String>> vertices = new HashMap<>();
		Arrays.asList(new String[] { "s", "a", "b", "c", "d", "e" })
			.forEach(v -> vertices.put(v, new Vertice<String>(v)));
		
		String[][] arestas = new String[][] { {"s", "a"}, {"s", "b"}, {"a", "c"}, {"b", "c"},
			{"b", "d"}, {"c", "e"}, {"c", "d"}, {"d", "e"} };
		
		GrafoListaAdj<String> grafo = new GrafoListaAdj<>();
		Arrays.asList(arestas).forEach(a ->
				grafo.adicionarArestaNaoOrientada(vertices.get(a[0]), vertices.get(a[1])));
		grafo.buscarEmProfunidade(vertices.get("s"));
		System.out.println("Eh alcancavel: " + grafo.ehAlcancavelPor(vertices.get("e")));
		grafo.imprimir();
		/*
		grafo.buscarEmLargura(vertices.get("s"));
		System.out.println("Eh alcancavel: " + grafo.ehAlcancavelPor(vertices.get("e")));
		*/	
	}
	
	public static void gerarGrafoCustoCaminho() {
		GrafoMatrizAdj grafo = new GrafoMatrizAdj(4);
		grafo.adicionarArestaPonderada(0, 1, 5);
		grafo.adicionarArestaPonderada(0, 2, 1);
		grafo.adicionarArestaPonderada(1, 2, 7);
		grafo.adicionarArestaPonderada(1, 3, 4);
		grafo.adicionarArestaPonderada(2, 3, 2);
		grafo.imprimir();
		grafo.encontrarCaminhoPonderado(0, 3, 14);
		System.out.println("Custo caminho 0-1-2-3: " + grafo.obterCustoCaminho(new int[] {0, 1, 2, 3}));		
	}
	
	public static void gerarRepresentacoesGrafos() {
		
		GrafoListaAdj<Integer> grafo = new GrafoListaAdj<>();
		grafo.adicionarAresta(new Vertice<Integer>(9), new Vertice<Integer>(10));
		grafo.adicionarAresta(new Vertice<Integer>(9), new Vertice<Integer>(11));
		grafo.adicionarAresta(new Vertice<Integer>(9), new Vertice<Integer>(12));
		grafo.adicionarAresta(new Vertice<Integer>(10), new Vertice<Integer>(9));
		grafo.adicionarAresta(new Vertice<Integer>(11), new Vertice<Integer>(9));
		grafo.adicionarAresta(new Vertice<Integer>(11), new Vertice<Integer>(12));
		grafo.adicionarAresta(new Vertice<Integer>(12), new Vertice<Integer>(9));
		grafo.adicionarAresta(new Vertice<Integer>(12), new Vertice<Integer>(11));
		grafo.adicionarAresta(new Vertice<Integer>(12), new Vertice<Integer>(10));
		grafo.imprimir();
		grafo.imprimirListaMaiorGrau();
		
		GrafoMatrizAdj grafoMatrizAdj = new GrafoMatrizAdj(4);
		grafoMatrizAdj.adicionarAresta(0, 1);
		grafoMatrizAdj.adicionarAresta(0, 2);
		grafoMatrizAdj.adicionarAresta(0, 3);
		grafoMatrizAdj.adicionarAresta(1, 0);
		grafoMatrizAdj.adicionarAresta(1, 2);
		grafoMatrizAdj.adicionarAresta(1, 3);
		grafoMatrizAdj.adicionarAresta(2, 0);
		grafoMatrizAdj.adicionarAresta(2, 1);
		grafoMatrizAdj.adicionarAresta(2, 3);
		grafoMatrizAdj.adicionarAresta(3, 0);
		grafoMatrizAdj.adicionarAresta(3, 1);
		grafoMatrizAdj.adicionarAresta(3, 2);
		grafoMatrizAdj.imprimir();
		grafoMatrizAdj.imprimirArestas();
		System.out.println("Eh completo? " + grafoMatrizAdj.ehCompleto());
	}
	
	public static void gerarGrafoGrauPonderado() {
		GrafoListaAdj<String> grafo = new GrafoListaAdj<>();
		grafo.adicionarAresta(new Vertice<String>("A"), new Vertice<String>("B", 3));
		grafo.adicionarAresta(new Vertice<String>("A"), new Vertice<String>("C", 5));
		grafo.adicionarAresta(new Vertice<String>("A"), new Vertice<String>("D", 2));
		grafo.adicionarAresta(new Vertice<String>("A"), new Vertice<String>("H", 10));
		
		grafo.adicionarAresta(new Vertice<String>("B"), new Vertice<String>("A", 3));
		grafo.adicionarAresta(new Vertice<String>("B"), new Vertice<String>("C", 5));
		grafo.adicionarAresta(new Vertice<String>("B"), new Vertice<String>("D", 8));
		grafo.adicionarAresta(new Vertice<String>("B"), new Vertice<String>("E", 4));
		grafo.adicionarAresta(new Vertice<String>("B"), new Vertice<String>("G", 6));
		grafo.adicionarAresta(new Vertice<String>("B"), new Vertice<String>("H", 6));
		
		grafo.adicionarAresta(new Vertice<String>("C"), new Vertice<String>("A", 5));
		grafo.adicionarAresta(new Vertice<String>("C"), new Vertice<String>("B", 5));
		grafo.adicionarAresta(new Vertice<String>("C"), new Vertice<String>("E", 1));
		grafo.adicionarAresta(new Vertice<String>("C"), new Vertice<String>("F", 7));
		grafo.adicionarAresta(new Vertice<String>("C"), new Vertice<String>("G", 9));
		
		grafo.adicionarAresta(new Vertice<String>("D"), new Vertice<String>("A", 2));
		grafo.adicionarAresta(new Vertice<String>("D"), new Vertice<String>("E", 12));
		grafo.adicionarAresta(new Vertice<String>("D"), new Vertice<String>("B", 8));
		grafo.adicionarAresta(new Vertice<String>("D"), new Vertice<String>("H", 14));
		
		grafo.adicionarAresta(new Vertice<String>("E"), new Vertice<String>("C", 1));
		grafo.adicionarAresta(new Vertice<String>("E"), new Vertice<String>("B", 4));
		grafo.adicionarAresta(new Vertice<String>("E"), new Vertice<String>("D", 12));
		grafo.adicionarAresta(new Vertice<String>("E"), new Vertice<String>("G", 15));
		
		grafo.adicionarAresta(new Vertice<String>("F"), new Vertice<String>("C", 7));
		grafo.adicionarAresta(new Vertice<String>("F"), new Vertice<String>("H", 9));
		
		grafo.adicionarAresta(new Vertice<String>("G"), new Vertice<String>("H", 3));
		grafo.adicionarAresta(new Vertice<String>("G"), new Vertice<String>("B", 6));
		grafo.adicionarAresta(new Vertice<String>("G"), new Vertice<String>("C", 9));
		grafo.adicionarAresta(new Vertice<String>("G"), new Vertice<String>("E", 15));
		
		grafo.adicionarAresta(new Vertice<String>("H"), new Vertice<String>("A", 10));
		grafo.adicionarAresta(new Vertice<String>("H"), new Vertice<String>("F", 9));
		grafo.adicionarAresta(new Vertice<String>("H"), new Vertice<String>("B", 6));
		grafo.adicionarAresta(new Vertice<String>("H"), new Vertice<String>("G", 3));
		grafo.adicionarAresta(new Vertice<String>("H"), new Vertice<String>("D", 14));
		
		grafo.ordenarPorGrauPonderado();
	}
}
