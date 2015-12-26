package com.graph;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import javax.xml.bind.ValidationEvent;

class Graph {
	int nVerts;
	int size;
	Vertex[] vertArray;
	int[][] martix;
	int i = 0;
	
	boolean isDirected;
	
	Stack<Integer> stack = new Stack<Integer>();
	Queue<Integer> queue = new LinkedList<Integer>();

	public Graph(boolean isDirected) {
		nVerts = 0;
		size = 9;

		martix = new int[size][size];
        this.isDirected = isDirected;
		for (int i = 0; i < size; i++)
			for (int j = 0; j < size; j++) {
				martix[i][j] = 0;
			}
		vertArray = new Vertex[size];

	}

	/*
	 * public Graph(){
	 * 
	 * }
	 */

	void addEdge(int src, int dest, int distance) {
		if(isDirected)
		martix[src][dest] = distance;
		else{
			martix[src][dest] = distance;
		    martix[dest][src] = distance;
			
		}
	}

	void addVertex(String ch) {
		addVertex(vertArray, ch);
	}

	void addVertex(Vertex[] vertArray, String ch) {
		Vertex vertex = new Vertex(ch);
		vertArray[i++] = vertex;
	}

	void displayGraph() {
		for (int i = 0; i <= 7; i++)
			for (int j = 0; j <= 7; j++) {
				if(isDirected){
				if (martix[i][j] != 0 && i !=j ) {
					System.out.print(" " + vertArray[i].label + " ----->"
							+ vertArray[j].label + "= "+ martix[i][j]);
					System.out.println(" ");
					martix[j][i] = 0;
				}
				}else{
					if (martix[i][j] != 0 && i !=j ) {
						System.out.print(" " + vertArray[i].label + " ----->"
								+ vertArray[j].label + "= "+ martix[i][j] );
						System.out.println(" ");
					}	
				}
			}

	}

	void detectCycle() {
		/*
		 * Boolean[] visited = new Boolean[vertArray.length]; Boolean[] recStack
		 * = new Boolean[vertArray.length]; for(int i=0;i<vertArray.length;i++){
		 * visited[i] = false; recStack[i] = false; }
		 * 
		 * for(int i=0;i<vertArray.length;i++){ if(isCyclicUtil()){ return true;
		 * } return false;
		 * 
		 * }
		 */
	}

	void displayVert(int v) {
		System.out.println(" ** " + vertArray[v].label + " ** ");
	}

	
	
	private int getAdjoiningVertex(int s){
		
		for(int k=0;k<i;k++){
			if(martix[s][k]!=0 && vertArray[k].isVisited == false){
				return k;
			}
		}
		return -1;
	}
	
	
	void dfs() {
		Stack<Integer> stack = new Stack<Integer>();
		vertArray[0].isVisited = true;
		stack.push(0);
		//int i = 0;
		while (!stack.isEmpty()) {
			int v = getUnvisitedVertex(stack.peek());
			if(v == -1){
				stack.pop();
			}else{
				vertArray[v].isVisited = true;
				System.out.println(" Vertex visited is "+ vertArray[v].label);
				stack.push(v);
			}
		}
		for (int j = 0; j < nVerts; j++)
			vertArray[j].isVisited = false;
	}
	private void adjacentVetrex(int j){
		for(int i=1;i<vertArray.length;i++){
			if(martix[j][i]!=0 && vertArray[i].isVisited==false && i !=j){
				System.out.println(" --> " + vertArray[i].label+" with distance "+ martix[j][i]);
			}
		}
	}
	

	void bfs() {
		Queue<Vertex> queue = new LinkedList<Vertex>();
		int i = 0;
		System.out.println(" "+ vertArray[0].label+" ");
		for(;i<vertArray.length-1;i++){
		queue.add(vertArray[i]);
		
		//int j = 0;
		vertArray[i].isVisited = true;
		
		adjacentVetrex(i);
		
		queue.remove();
		
		}
		
		//queue.add(vertArray[i++]);
		
		
		
		
		
		/*vertArray[0].isVisited = true;
		queue.add(0);
		displayVert(0);
		int v2;
		while (!queue.isEmpty()) {
			int v1 = queue.remove();
			while ((v2 = getUnvisitedVertex(v1)) != -1) {
				vertArray[v2].isVisited = true;
				displayVert(v2);
				queue.add(v2);
			}
		}
		for (int j = 0; j < i; j++)
			vertArray[j].isVisited = false;*/
	}

	int getUnvisitedVertex(int j) {
		for (int k = 0; k < i; k++)
			if (martix[j][k] != 0 && vertArray[k].isVisited == false) {
				System.out.print(" " + martix[j][k] + " ");
				return k;
			}
		return -1;
	}

}

class Vertex {
	String label;
	boolean isVisited;

	public Vertex(String label) {
		this.label = label;
		this.isVisited = false;
	}
}

class Edge {
	char src;
	char dest;

	public Edge(char src, char dest) {
		this.src = src;
		this.dest = dest;
	}
}

public class GraphSample {
	public static void main(String args[]) {

		Graph graph = new Graph(true);

		graph.addVertex("Berlin");
		graph.addVertex("Dubai");
		graph.addVertex("Moscow");
		graph.addVertex("Paris");
		
		
		graph.addVertex("New Delhi");
		graph.addVertex("Singapore");
		graph.addVertex("Chicago");
		graph.addVertex("NewYork");
		graph.addVertex("Shanghai");
		//graph.addVertex("colombo");
		
		graph.addEdge(0, 1,12);
		graph.addEdge(0, 2,6);
		graph.addEdge(0, 3,13);
		graph.addEdge(6, 8,16);
		graph.addEdge(0, 4,20);
		
		graph.addEdge(3, 6,21);
		graph.addEdge(1, 5,28);
		graph.addEdge(5, 7,130);
		/*graph.addEdge(0, 5,9);
		graph.addEdge(0, 6,8);
		graph.addEdge(0, 7,14);
		graph.addEdge(0, 8,10);*/

	//	graph.displayGraph();

		// 

//		 graph.bfs();
		 
		 graph.dfs();

		//graph.detectCycle();

	}
}
