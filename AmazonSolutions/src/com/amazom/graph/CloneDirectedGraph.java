package com.amazom.graph;

import java.util.Collection;
import java.util.List;

public class CloneDirectedGraph {

	public static void main(String args[]) {

		Graph<String> graph = new Graph<String>(false);
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.addEdge(2, 4);
		graph.addEdge(1, 5);

		System.out.println(" Edges for the graph are ");

		List<Edge<String>> edges = graph.getEdges();

		for (Edge<String> e : edges) {
			System.out.println(e.getWeight() + "  " + e.getVertex1().getId()
					+ "  " + e.getVertex2().getId());
		}

		System.out.println();

		System.out.println(" Vertexs in the HGraph are ");

		Collection<Vertex<String>> vertexs = graph.getAllVertex();

		for (Vertex<String> v : vertexs) {
			System.out.println("  " + v.id + " ");
		}
		System.out.println();

	}

}
