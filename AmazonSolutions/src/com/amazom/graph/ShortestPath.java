package com.amazom.graph;

class GraphMatrix {
	MVertex[] vertexArray;
	boolean[][] matrix;
	int capacity;
	int i = 0;

	public GraphMatrix(int capacity) {
		this.capacity = capacity;
		this.matrix = new boolean[capacity][capacity];
		vertexArray = new MVertex[capacity];
		for (int i = 0; i < capacity; i++) {
			for (int j = 0; j < capacity; j++) {
				matrix[i][j] = false;
			}
		}
	}

	public void addVertex(char label) {
		MVertex vert = new MVertex();
		vert.label = label;
		vertexArray[i++] = vert;
	}

	public void addEdge(int src, int dest) {
		matrix[src][dest] = true;
		matrix[dest][src] = true;
	}

	public void displayGraph() {
		for (int i = 0; i < matrix.length - 2; i++) {
			for (int j = 0; j < matrix[i].length - 2; j++) {
				if (matrix[i][j] == true)
					System.out.println(" " + vertexArray[i].label);
			}
		}
	}
}

class MVertex {
	char label;
	boolean isVisited;

	public MVertex() {
		this.isVisited = false;
	}
}

public class ShortestPath {
	public static void main(String args[]) {
		GraphMatrix graphMatrix = new GraphMatrix(9);
		graphMatrix.addVertex('A');
		graphMatrix.addVertex('B');
		graphMatrix.addVertex('C');
		graphMatrix.addVertex('D');
		graphMatrix.addVertex('E');
		graphMatrix.addEdge(0, 1);
		graphMatrix.addEdge(0, 2);
		graphMatrix.addEdge(0, 3);
		graphMatrix.addEdge(0, 4);
		graphMatrix.addEdge(1, 5);
		graphMatrix.addEdge(5, 7);
		graphMatrix.addEdge(3, 6);
		graphMatrix.addEdge(6, 8);
		graphMatrix.displayGraph();

	}

}
