package com.amazom.graph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph<T> {

	private List<Edge<T>> allEdges;
	private Map<Long, Vertex<T>> allVertex;
	boolean isDirected = false;

	public Graph(boolean isDirected) {
		allEdges = new ArrayList<Edge<T>>();
		allVertex = new HashMap<Long, Vertex<T>>();
		this.isDirected = isDirected;
	}

	public void addEdge(long id1, long id2) {
		addEdge(id1, id2, 0);
	}

	public void addEdge(long id1, long id2, int weight) {
		Vertex<T> vertex1 = null;
		if (allVertex.containsKey(id1)) {
			vertex1 = allVertex.get(id1);
		} else {
			vertex1 = new Vertex<T>(id1);
			allVertex.put(id1, vertex1);
		}
		Vertex<T> vertex2 = null;
		if (allVertex.containsKey(id2)) {
			vertex1 = allVertex.get(id2);
		} else {
			vertex2 = new Vertex<T>(id2);
			allVertex.put(id2, vertex2);
		}
		Edge<T> edge = new Edge<T>(vertex1, vertex2, isDirected, weight);
		allEdges.add(edge);
		vertex1.addAdjacentVertex(edge, vertex1);
		if (!isDirected) {
			vertex2.addAdjacentVertex(edge, vertex1);
		}
	}

	public List<Edge<T>> getEdges() {
		return allEdges;
	}

	public Collection<Vertex<T>> getAllVertex() {
		return allVertex.values();

	}

	
	
}

class Edge<T> {
	private boolean isDirected = false;
	private Vertex<T> vertex1;
	private Vertex<T> vertex2;

	private int weight;

	Edge(Vertex<T> vertex1, Vertex<T> vertex2) {
		this.vertex1 = vertex1;
		this.vertex2 = vertex2;
	}

	Edge(Vertex<T> vertex1, Vertex<T> vertex2, boolean isDirected, int weight) {
		this.vertex1 = vertex1;
		this.vertex2 = vertex2;
		this.isDirected = isDirected;
		this.weight = weight;
	}

	Edge(Vertex<T> vertex1, Vertex<T> vertex2, boolean isDirected) {
		this.isDirected = isDirected;
		this.vertex1 = vertex1;
		this.vertex2 = vertex2;
	}

	public Vertex<T> getVertex1() {
		return vertex1;
	}

	public Vertex<T> getVertex2() {
		return vertex2;
	}

	int getWeight() {
		return weight;
	}

	public boolean isDirected() {
		return isDirected;
	}

}

class Vertex<T> {
	long id;
	private T data;
	private List<Edge<T>> edges = new ArrayList<Edge<T>>();
	private List<Vertex<T>> adjacentVertex = new ArrayList<Vertex<T>>();

	Vertex(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public void addAdjacentVertex(Edge<T> e, Vertex<T> v) {
		edges.add(e);
		adjacentVertex.add(v);
	}
	
	public List<Vertex<T>> getAdjacentVertexes(){
        return adjacentVertex;
    }
}
