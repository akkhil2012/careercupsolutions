package com.graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import com.graph.Graph.Vertex;

public class GraphTraversal {
	
	
		public void BFS(Graph<Integer> graph){
			Set<Long> visited = new HashSet<Long>();
			Queue<Vertex<Integer>> q = new LinkedList<Vertex<Integer>>();
			
			
			
			
		
		
		
	   }
	
	
	
	
	public static void main(String args[]) {
		Graph<Integer> graph = new Graph<Integer>(false);
		graph.addSingleVertex(1);
		graph.addSingleVertex(2);
		graph.addSingleVertex(3);
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.addEdge(2, 3);
		
		new GraphTraversal().BFS(graph);
		
		
	}
}
