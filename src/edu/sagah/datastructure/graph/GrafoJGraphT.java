package edu.sagah.datastructure.graph;

import java.util.HashMap;
import java.util.Map;

import org.jgrapht.Graph;
import org.jgrapht.generate.CompleteGraphGenerator;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

public class GrafoJGraphT {

	public static void main(String[] args) {

		Graph<String, DefaultEdge> grafo = 
				new DefaultDirectedGraph<String, DefaultEdge>(DefaultEdge.class);
		grafo.addVertex("v1");
		grafo.addVertex("v2");
		grafo.addVertex("v3");
		grafo.addVertex("v4");
		grafo.addVertex("v5");
		grafo.addVertex("v6");
		grafo.addVertex("v7");
		grafo.addVertex("v8");
		grafo.addVertex("v9");
		grafo.addEdge("v1", "v2");
		grafo.addEdge("v2", "v4");
		grafo.addEdge("v4", "v3");
		grafo.addEdge("v3", "v1");
		grafo.addEdge("v5", "v4");
		grafo.addEdge("v5", "v6");
		grafo.addEdge("v6", "v7");
		grafo.addEdge("v7", "v5");
		grafo.addEdge("v8", "v5");
		grafo.addEdge("v9", "v8");
		System.out.println(grafo.toString());
	}
}
