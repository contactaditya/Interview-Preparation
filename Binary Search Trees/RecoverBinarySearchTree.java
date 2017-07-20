import java.util.*;
import java.io.*;

 public class RecoverBinarySearchTree { 	
    Node root;	    
    Node previous;
    Node first;
    Node second;
	
    public void findSegments(Node node) {
		 
      if (node == null) {
	return;
      }
	  
      findSegments(node.left);
	  
      if (previous != null && previous.data > node.data) {
	 if(first == null){
            first = previous;
	    second = node;
	 }
	 else {
	    second = node;
	 }
      }
       previous = node;
       findSegments(node.right);
    }
	
  public void recoverTree(Node node) {
      if (node == null) {
	return;
      }	
      findSegments(node);	
      if (first !=null && second!=null) {
	 int x = first.data;
	 first.data = second.data;
	 second.data = x;
      }
  }
		
  public void printInorderTraversal(Node node) {
			 
     if (node == null) {
	return;
     }
		 
     printInorderTraversal(node.left); 
     System.out.print(node.data + " ");	
     printInorderTraversal(node.right);
  }

  public static void main(String[] args) {   
      RecoverBinarySearchTree tree = new RecoverBinarySearchTree();
      tree.root = new Node(6);
      tree.root.left = new Node(10);
      tree.root.right = new Node(2);
      tree.root.left.left = new Node(1);
      tree.root.left.right = new Node(3);
      tree.root.right.left = new Node(7);
      tree.root.right.right = new Node(12);
    	     
      System.out.print("Inorder Traversal of the original tree is: ");
      tree.printInorderTraversal(tree.root);	
	  
      tree.recoverTree(tree.root);
	  
      System.out.println();
      System.out.println();
      System.out.print("Inorder Traversal of the fixed tree is: ");
      tree.printInorderTraversal(tree.root);	

  }
 }
