package com.amazon.search;

import java.util.LinkedList;
import java.util.List;



class Trie{

	private TrieNode root;
	
	public Trie() {
		root = new TrieNode(' ');
	}
	
	
	
	public void insert(String word){
		if(search(word)==true)return;
		TrieNode current = root;
			for(char ch : word.toCharArray()){
				TrieNode child = current.subNode(ch);
				if(child!=null)
					current = child;
				else{
					current.childList.add(new TrieNode(ch));
					current = current.subNode(ch);
				}
			}
			current.isEndOfString = true;
		}
		
		
		
	
	
	
	
	public boolean search(String word){
		
		TrieNode current = root;
		for(char c : word.toCharArray()){
			if(current.subNode(c)==null)
				return false;
			current = current.subNode(c);
		}
		
		if(current.isEndOfString==true)
		 return true;
		
		return false;
		
	}
	
	
	
	
	

	
	
	
	
	
	
	
}






class TrieNode{
	
	char content;
	List<TrieNode> childList; 
	boolean isEndOfString;
	
	public TrieNode(char c){
		content = c;
		isEndOfString = false;
		childList = new LinkedList<TrieNode>();
	}
	
	
	public TrieNode subNode(char c){
		if(childList!=null){
			for(TrieNode child : childList)
			{
				if(child.content == c)
					return child;
			}
			
		}
		return null;
	}
	
	
}


public class SearchusingTrie {

}
