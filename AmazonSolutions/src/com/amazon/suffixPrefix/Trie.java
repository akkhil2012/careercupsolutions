package com.amazon.suffixPrefix;

public class Trie {
	private Node root = new Node();
	private static int NUM_CHAR = 256;
	static class Node{
		Node[] child = new Node[NUM_CHAR];
		boolean isWord;
	}
	
	
	/*public void delete(char[] str){
	if(search(str)==false)return;
	
	
	for(char ch : str){
		
		
	}
	}*/
	
	
	
	public void insert(char[] str){
		Node start = root;
		for(char ch : str){
			if(start.child[ch]!=null){
			  start = start.child[ch];
			}else{
				start.child[ch] = new Node();
				start = start.child[ch];
			}
		}
		start.isWord = true;
	}
	
	public boolean search(char[] key) {
		Node current = root;
		for (char ch : key) {
			if (current.child[ch] != null)
				current = current.child[ch];
			else
				return false;
		}
		return true;
	}
	
	public void displayTrie(Node root){
		int count = 0;
		Node current = root;
		for(int i=0;i<NUM_CHAR;i++){
		if(current.child[i]!=null){
			count++;
			System.out.print((char)i);
			displayTrie(current.child[i]);
		}
		}
	}
	
	public static void main(String args[]) {
		Trie t = new Trie();
		t.insert("A".toCharArray());
        t.insert("Ak".toCharArray());
        t.insert("Akh".toCharArray());
        t.insert("Akhi".toCharArray());
        t.insert("Akhil".toCharArray());
        t.displayTrie(t.root);
        System.out.println(" Is this word present "+ t.search("AAkh".toCharArray()));
	}
}
