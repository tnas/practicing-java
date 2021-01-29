package edu.sagah.datastructure.graph;

import java.awt.Dimension;

import javax.swing.JApplet;
import javax.swing.JFrame;

import org.jgrapht.ListenableGraph;
import org.jgrapht.ext.JGraphXAdapter;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultListenableGraph;

import com.mxgraph.layout.mxCircleLayout;
import com.mxgraph.swing.mxGraphComponent;

public class VisualizadorGrafoJGraphT extends JApplet {
	
	private static final Dimension DEFAULT_SIZE = new Dimension(530, 320);
	private JGraphXAdapter<String, DefaultEdge> adaptadorJgrapht;

	public static void main(String[] args) {
		
		VisualizadorGrafoJGraphT applet = new VisualizadorGrafoJGraphT();
		applet.init();

		JFrame frame = new JFrame();
		frame.getContentPane().add(applet);
		frame.setTitle("Adaptador para JGraphT");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	
	private ListenableGraph<String, DefaultEdge> criarGrafo() {
		
		ListenableGraph<String, DefaultEdge> grafo = new DefaultListenableGraph<>(
				new DefaultDirectedGraph<>(DefaultEdge.class));

		grafo.addVertex("v1");
		grafo.addVertex("v2");
		grafo.addVertex("v3");
		grafo.addVertex("v4");

		grafo.addEdge("v1", "v2");
		grafo.addEdge("v2", "v3");
		grafo.addEdge("v3", "v1");
		grafo.addEdge("v4", "v3");
		
		return grafo;
	}
	
	@Override
	public void init() {
		
		adaptadorJgrapht = new JGraphXAdapter<>(this.criarGrafo());

		setPreferredSize(DEFAULT_SIZE);
		mxGraphComponent component = new mxGraphComponent(adaptadorJgrapht);
		component.setConnectable(false);
		component.getGraph().setAllowDanglingEdges(false);
		getContentPane().add(component);
		resize(DEFAULT_SIZE);
		
		mxCircleLayout layout = new mxCircleLayout(adaptadorJgrapht);

		// center the circle
		int radius = 100;
		layout.setX0((DEFAULT_SIZE.width / 2.0) - radius);
		layout.setY0((DEFAULT_SIZE.height / 2.0) - radius);
		layout.setRadius(radius);
		layout.setMoveCircle(true);

		layout.execute(adaptadorJgrapht.getDefaultParent());
	}
}
