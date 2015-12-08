package com.amazom.graph;

class GraphLinkedIn{
	
	FriendNode fNode;
	FriendNode[] fArray;
	int fCount;
	Boolean[][] fMatrix;
	int i = 0;
	
	
	public GraphLinkedIn() {
		fCount = 10;
		for(int i=0;i<fCount;i++){
			for(int j=0;j<fCount;j++){
				fMatrix[i][j] = false;
			}
		}
	}
	
	public FriendNode createFreind(String name){
		FriendNode node = new FriendNode(name);
		fArray[i++] = node;
		return node;
	}
	
	public FreindEdge createEdge(String src,String dest){
		FreindEdge freindEdge = new FreindEdge(src, dest);
		return freindEdge;
	}
	
	
	public void displayFMatrix(){
		
		for(int i=0;i<fCount;i++){
			for(int j=0;j<fCount;j++){
				System.out.print(" "+fMatrix[i][j]+" ");
			}
		}
	}
	
	
	
	
}

class FriendNode{
	String name;
	boolean isVisited;
	
	public FriendNode(String name) {
	  this.name = name;
	}
}

class FreindEdge{
	String src;
	String dest;
	
	public FreindEdge(String src,String dest) {
		this.src = src;
		this.dest = dest;
	}
}



public class GraphLinkedInHops {

	public static void main(String args[]) {
		
		GraphLinkedIn graphLinkedIn = new GraphLinkedIn();
		graphLinkedIn.createFreind("akkhil");
		//graphLinkedIn.createEdge(0, 1);
		graphLinkedIn.displayFMatrix();
		
		
	}
	
	
}
