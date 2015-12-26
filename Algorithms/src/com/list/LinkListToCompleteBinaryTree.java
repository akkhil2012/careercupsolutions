package com.list;

import java.util.LinkedList;
import java.util.Queue;

public class LinkListToCompleteBinaryTree {

    public void convert(Node head){
        if(head == null){
            return;
        }
        
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(head);
        head = head.next;
        while(head != null){
            Node top = queue.poll();
            top.before = head;
            head = head.next;
            if(head != null){
                top.next = head;
                head = head.next;
                //null the next of child before putting them into queue
                top.before.next = null;
                top.next.next = null;
                queue.add(top.before);
                queue.add(top.next);
            }else{
                break;
            }
        }
     }
    
    public void inorder(Node head){
        if(head == null){
            return;
        }
        inorder(head.before);
        System.out.print(head.data + " ");
        inorder(head.next);
    }
    
    public static void main(String args[]){
        LinkedList ll = new LinkedList();
        Node head = null;
        head = ll.add(10);
        head = ll.addNode(12, head);
        head = ll.addNode(15, head);
        head = ll.addNode(25, head);
        head = ll.addNode(30, head);
        head = ll.addNode(36, head);
        head = ll.addNode(40, head);
        head = ll.addNode(45, head);
        
        LinkListToCompleteBinaryTree llct = new LinkListToCompleteBinaryTree();
        llct.convert(head);
        llct.inorder(head);
    }
}
Status 