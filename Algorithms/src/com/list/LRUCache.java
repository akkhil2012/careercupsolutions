package com.list;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

	private Node front;
	private Node rear;
	private Map<Integer,Node> map = new HashMap<Integer,Node>();
	private int MAX_SIZE = 10;
	private int size = 0;
	private LRUCache(int size){
		MAX_SIZE = size;
	}
	
	
	
	
	public void used(){
		
		
		
		
	}
	
	
	
	public addInCache(int data){
		size++;
		if(front==null){
			front = new Node(data);
		    rear = front;
		    return;
		}
		if(size > MAX_SIZE){
			
			
			
		}
		
		
		
	}
	
	
	
	
	
	
	
	
	
}
