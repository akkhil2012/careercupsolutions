package com.amazom.graph;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Graph {
	Map<Integer, List<Integer>> adjList;
	public Graph(int v) {
		adjList = new HashMap<Integer, List<Integer>>();
		for (int i = 0; i < v; i++) {
			adjList.put(i, new LinkedList<Integer>());
		}
	}

	public void createEdge(Integer to, Integer from) {
		List<Integer> sList = adjList.get(to);
		sList.add(from);
		List<Integer> dList = adjList.get(from);// Since a BiDirectional Graph
		dList.add(to);
	}

	public void showGraph(Graph graph) {
		Map<Integer, List<Integer>> lst = graph.adjList;
		for (Map.Entry<Integer, List<Integer>> s : lst.entrySet()) {
			System.out.print("source " + s.getKey() + " --->");
			Iterator<Integer> itr = s.getValue().iterator();
			while (itr.hasNext()) {
				System.out.print("--- " + itr.next() + " ---- > ");
			}
			System.out.println(" ");
		}
	}
}

class Vertex {
	boolean isVisited;
	char label;
	Vertex(char l) {
		label = l;
	}
}

class Edge {
	Vertex source;
	Vertex destination;
	Edge(Vertex src, Vertex dest) {
		source = src;
		destination = dest;
	}
}

public class GraphBFS {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		int vertices = scanner.nextInt();
		scanner.close();
		Graph graph = new Graph(vertices);
		graph.createEdge(0, 1);
		graph.createEdge(0, 2);
		graph.createEdge(0, 3);
		graph.createEdge(0, 4);
		graph.createEdge(1, 5);
		graph.createEdge(5, 7);
		graph.createEdge(3, 6);
		graph.createEdge(6, 8);
		graph.showGraph(graph);
	}
}
