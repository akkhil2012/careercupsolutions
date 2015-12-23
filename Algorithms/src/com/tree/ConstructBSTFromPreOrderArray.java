package com.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


class Index{
    int index;
}



	public class ConstructBSTFromPreOrderArray {
		
	    public void preOrder(Node root){
	        if(root == null){
	            return;
	        }
	        System.out.print(root.data + " ");
	        preOrder(root.left);
	        preOrder(root.right);
	    }

	    
	    public void inOrder(Node root){
	        if(root == null){
	            return;
	        }
	        inOrder(root.left);
	        System.out.print(root.data + " ");
	        inOrder(root.right);
	    }
	    
	    
	    public void spiralTraversal(Node root){
	    	Queue<Node> q = new LinkedList<Node>();
	    	boolean level = false;	
	    	q.add(root);
	    	q.add(null);
	    	while(!q.isEmpty()){
	    		if(q.peek()==null){
	    			q.poll();
	    		   level = !level;
	    		}else{
	    			Node temp = q.poll();
	    			System.out.println("--"+ temp.data);
	    			if(level){
	    			if(temp.left!=null)
	    				q.add(temp.left);
	    			if(temp.right!=null)
	    				q.add(temp.right);
	    			}else{
	    				if(temp.right!=null)
		    				q.add(temp.right);
		    			if(temp.left!=null)
		    				q.add(temp.left);
	    			}
	    			q.add(null);
	    		}
	    	}
	    }

	    public Node toBST(int preorder[],BinarySearchTree tree){
	        Index index = new Index();
	        return toBST(preorder,Integer.MIN_VALUE,Integer.MAX_VALUE,index,tree);
	    }
	    
	    //stack based version
	    public Node toBSTIterative(int preorder[]){
	        return null;
	    }
	    
	    public void displayTree(Node root) {
			Stack<Node> globalStack = new Stack<Node>();
			globalStack.push(root);
			int emptyLeaf = 32;
			boolean isRowEmpty = false;
			System.out
					.println("****......................................................****");
			while (isRowEmpty == false) {

				Stack<Node> localStack = new Stack<Node>();
				isRowEmpty = true;
				for (int j = 0; j < emptyLeaf; j++)
					System.out.print(' ');
				while (globalStack.isEmpty() == false) {
					Node temp = (Node) globalStack.pop();
					if (temp != null) {
						System.out.print(" ** " + temp.data);
						localStack.push(temp.left);
						localStack.push(temp.right);
						if (temp.left != null || temp.right != null)
							isRowEmpty = false;
					} else {
						System.out.print("--");
						localStack.push(null);
						localStack.push(null);
					}
					for (int j = 0; j < emptyLeaf * 2 - 2; j++)
						System.out.print(' ');
				}
				System.out.println();
				emptyLeaf /= 2;
				while (localStack.isEmpty() == false)
					globalStack.push(localStack.pop());
			}
			System.out
					.println("****......................................................****");
		}

	    
	    private Node toBST(int preorder[],int min, int max,Index index,BinarySearchTree tree){
	        if(index.index >= preorder.length){
	            return null;
	        }
	        if(preorder[index.index] < min || preorder[index.index] >= max){
	            return null;
	        }
	        
	        Node node = new Node();
	        node.data = preorder[index.index];
	        System.out.println("-->"+ node.data);
	        index.index++;
	        node.left = toBST(preorder,min,node.data, index,tree);
	        node.right = toBST(preorder,node.data,max,index,tree);
           tree.addNode(node.data);
	        return node;
	    }
	    
	    
	    

	    
	    private int index=0;
	    public Node treeFromInPreTraversal(int[] pre,int[] in){
	    	Node result = createTree(in,pre,0,in.length-1);
	    	index = 0;
	    	return result;
	    }
	    
	    private Node createTree(int[] in,int[] pre,int start,int end){
	    	if(start > end) return null;
	    	int i;
	    	for(i=start;i<end;i++)
	    	  if(pre[index] == in[i])
	    		  break;
	    	Node newNode = new Node(pre[index]);
	    	index++;
	    	newNode.left = createTree(in, pre, start, i-1);
	    	newNode.right = createTree(in, pre, i+1, end);
			return newNode;
	    }
	    
	    public static void main(String args[]){
	        int preorder[] = {10,5,1,7,40,50};
	        ConstructBSTFromPreOrderArray poa = new ConstructBSTFromPreOrderArray();
	        BinarySearchTree tree = new BinarySearchTree();
	        Node root = poa.toBST(preorder,tree);
	        poa.preOrder(root);
	        System.out.println(" Aftre preOrder Traversal");
	        poa.inOrder(root);
	        poa.displayTree(tree.root);
	    }
	}

