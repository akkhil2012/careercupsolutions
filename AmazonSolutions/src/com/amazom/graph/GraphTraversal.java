package com.amazom.graph;

import java.util.HashSet;
import java.util.Set;

public class GraphTraversal {
	public void DFS(Graph<Integer> graph) {
		Set<Long> visited = new HashSet<Long>();
		for (Vertex<Integer> vertex : graph.getAllVertex()) {
			if (!visited.contains(vertex.getId())) {
				DFSUtil(vertex, visited);
			}
		}
	}

	private void DFSUtil(Vertex<Integer> vertex, Set<Long> visited) {
		visited.add(vertex.getId());
		System.out.println(" vertex " + vertex.id);
		for (Vertex<Integer> ver : vertex.getAdjacentVertexes()) {
			if (!visited.contains(ver.getId())) {
				DFSUtil(vertex, visited);
			}
		}
	}

	public static void main(String args[]) {
		Graph<Integer> graph = new Graph<Integer>(true);
		graph.addEdge(1, 2);
		graph.addEdge(1, 5);
		graph.addEdge(1, 6);
		graph.addEdge(1, 9);
		graph.addEdge(2, 3);
		graph.addEdge(3, 4);
		graph.addEdge(6, 7);
		graph.addEdge(7, 8);
		GraphTraversal graphTraversal = new GraphTraversal();
		graphTraversal.DFS(graph);
	}
}
