

package com.graphAlgo;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

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

	void addVertex(String ch,Double fare) {
		addVertex(vertArray, ch,fare);
	}
	
	
	

	void addVertex(Vertex[] vertArray, String ch,Double fare) {
		Vertex vertex = new Vertex(ch,fare);
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
	Double fare;
	boolean isVisited;

	public Vertex(String label,Double fare) {
		this.label = label;
		this.isVisited = false;
		this.fare = fare;
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

public class DjKastraAlgorithm {
	Graph graph = new Graph(true);
	Double min = Double.MAX_VALUE;
	
	private Double getMinDistantVertex(Vertex[] verArray,int index,boolean flag){
		
		if(flag) {
			min = Double.MAX_VALUE;
			Set<Double> stNew = new TreeSet<Double>();
			stNew.add(verArray[index].fare);
			min =  stNew.iterator().next();
		//	return min;
		}
		else{
			Set<Double> st = new TreeSet<Double>();
			min = Double.MAX_VALUE;
    	    st.add(verArray[index].fare);
	    	   min =  st.iterator().next();
			//return min;
		}
		return min;
	}
	
	
	
	void displayGraph(Graph graph) {
		int len = graph.martix.length;
		for (int i = 0; i < len; i++)
			for (int j = 0; j < len; j++) {
				if(graph.isDirected){
				if (graph.martix[i][j] != 0 && i !=j ) {
					System.out.print(" " + graph.vertArray[i].label + " ----->"
							+ graph.vertArray[j].label + "= "+ graph.martix[i][j]);
					System.out.println(" ");
					graph.martix[j][i] = 0;
				}
				}else{
					if (graph.martix[i][j] != 0 && i !=j ) {
						System.out.print(" " + graph.vertArray[i].label + " ----->"
								+ graph.vertArray[j].label + "= "+ graph.martix[i][j] );
						System.out.println(" ");
					}	
				}
			}

	}
	
	public boolean ifCycleExists(Graph graph){
		Stack<Integer> stack = new Stack<Integer>();
		
		Stack<Integer> globalStack = new Stack<Integer>();
		stack.push(0);
		graph.vertArray[0].isVisited = true;
		while(!stack.isEmpty()){
			int source = stack.peek();
			int v = getAdjoiningVertex(graph,source);
			if(v!=-1){
				graph.vertArray[v].isVisited = true;
				System.out.println(" Visited is "+ graph.vertArray[v].label);
				/*if(globalStack.contains(v)){
					return true;
				}*/
				stack.push(v);
			}else{
				globalStack.add(stack.peek());
				/*if(graph.vertArray[stack.peek()].isVisited == true){
					System.out.println(" Loop at AirPort " +  graph.vertArray[stack.peek()].label);
					return true;
				}*/
				stack.pop();
			}
		}
		
		while(!globalStack.isEmpty()){
			System.out.println(" --- "+ graph.vertArray[globalStack.pop()].label+" --- ");
		}
		
		return false;
	}
	
	
	private int getAdjoiningVertex(Graph graph,int j){
		for(int i=0;i<graph.vertArray.length;i++)
			if(graph.martix[j][i]!=0 && graph.vertArray[i].isVisited==false){
			//	if()
				return i;
			}
			return -1;
		}
	
	
	
	
	
	/*public Deque<Vertex>topSort(Graph graph){
		
	}*/
	
	
	
	
	
	
	
	private void topologicalUtil(int vertex,Stack<Integer> stack,Boolean[] visited){
		visited[vertex] = false;
		Integer i;
		
		Integer v = getAdjoiningVertex(graph, vertex);
	/*	if(v.h){
			
		}
	*/	
		
		
		
	}
	
	
	
	public void topologicalSort(Graph graph){
		Stack<Integer> stack = new Stack<Integer>(); 
		Boolean[] visited = new Boolean[graph.vertArray.length];
		for(int i=0;i<graph.vertArray.length;i++){
			topologicalUtil(i, stack, visited);
		}
	}
	
	/*int getUnvisitedVertex(int j) {
		for (int k = 0; k < i; k++)
			if (martix[j][k] != 0 && vertArray[k].isVisited == false) {
				System.out.print(" " + martix[j][k] + " ");
				return k;
			}
		return -1;
	}
	*/
	
	
	public void shortestPath(Graph graph) {
		Double minDistantVertexFare = Double.MAX_VALUE;
		Vertex[] tempArray = new Vertex[graph.martix[0].length];
		tempArray[0] = graph.vertArray[0];
		
		LinkedList<String> lst = new LinkedList<String>();
		
		int k = 0;
		int i = 0;
		boolean flag = false;
		Double maxFare;
		Double minFare;
		for (int j=0;j < graph.vertArray.length;j=k) {
		 maxFare = Double.MAX_VALUE;
			graph.vertArray[j].isVisited = true;
			System.out.println(" Source  "+ graph.vertArray[j].label);
			for (i = j; i < graph.vertArray.length; i++) {
				if (graph.martix[j][i] != 0
						&& graph.vertArray[i].isVisited == false && i != j) {
					tempArray[i] = graph.vertArray[i];
					 minFare = getMinDistantVertex(tempArray, i,flag);
					if(minDistantVertexFare > minFare){
						minDistantVertexFare = minFare;
					}

				}
			//	System.out.println(" Min distance fare -------------------------------------->>>>>>>>>>> " + minDistantVertexFare);
			}
			flag = !flag;
			System.out.println(" Min distance fare -------------------------------------->>>>>>>>>>> " + minDistantVertexFare);
			for (; k < graph.vertArray.length;k++) {
				if (graph.vertArray[k].fare == minDistantVertexFare) {
					System.out.println("  Destibnation is " + graph.vertArray[k].label);
					j = k;
					minDistantVertexFare = Double.MAX_VALUE;
			//		minFare = Double.MAX_VALUE;
					break;
				}
				/*for (i =0; i < graph.vertArray.length-1; i++) {
					graph.vertArray[++i].isVisited = false;
				}*/
				//break;
				//break;
			}
		//	k=0;
			
		}
 // return lst;
	}
	
	
	public static void main(String args[]) {
		Graph graph = new Graph(true);
		graph.addVertex("Berlin",1d);
		graph.addVertex("Dubai",12d);
		graph.addVertex("Chicago",2155d);
		graph.addVertex("Moscow",3d);
		graph.addVertex("Singapore",400d);
		graph.addVertex("New Delhi",290d);
		
/*		
		graph.addVertex("NewYork",310d);
		graph.addVertex("Shanghai",340d);
*/
		graph.addEdge(0, 3,12);
		graph.addEdge(0, 2,6);
		graph.addEdge(1, 3,3990);
		
		graph.addEdge(1, 4,13);
		graph.addEdge(2, 5,13);
		graph.addEdge(5, 4,16);
		/*graph.addEdge(0, 4,20);
		graph.addEdge(3, 6,21);
		graph.addEdge(1, 5,28);
		graph.addEdge(5, 7,130);
		graph.addEdge(2, 5,230);
		graph.addEdge(4, 6,430);
		graph.addEdge(7, 8,530);
		graph.addEdge(2, 6,930);
*/


	//graph.vertArray[i]	new DjKastraAlgorithm().shortestPath(graph);
		//System.out.println(" List is "+ lst.size());
		
//		new DjKastraAlgorithm().displayGraph(graph);
		
		

		
		System.out.println(" Chrck if Cyle exisyts " + new DjKastraAlgorithm().ifCycleExists(graph));
		
		
	}
	
	
	
	
	
	
	
	
	

}
