import java.io.*;
import java.util.*;

 public class BoundaryTraversalOfABinaryTree {  
   Node root;	    
   Node previous;
   
   public void printBoundaryTraversalLeft(Node node) {
		  
      if (node != null) {
	 if (node.left != null) {
            System.out.print(node.data + " ");		
	    printBoundaryTraversalLeft(node.left);	 
	 }
	 else if (node.right != null) {
	    System.out.print(node.data + " ");		
            printBoundaryTraversalLeft(node.right);	   		   
	 }
      }
   } 
   
   public void printBoundaryTraversalRight(Node node) {
		 
     if (node != null) {
       if (node.right != null) {
          printBoundaryTraversalRight(node.right);	  
          System.out.print(node.data + " ");		
       }
       else if (node.left != null) {
          printBoundaryTraversalRight(node.left);	   
          System.out.print(node.data + " ");		  		   
       }
     }
   }
   
   public void printLeaves(Node node) {
		 	
     if (node != null) {
       printLeaves(node.left);
	     
     if (node.left == null && node.right == null) {
        System.out.print(node.data + " ");
     }
	 
     printLeaves(node.right);
		  
     }
   }
   
   public void printBoundaryTraversal(Node node) {
		 
     if (node == null) {
       return;
     }
   
     System.out.print(node.data + " ");		
   
     // Print the left boundary in top-down manner.
     printBoundaryTraversalLeft(node.left);

     // Print all leaf nodes
     printLeaves(node.left);
     printLeaves(node.right);

     // Print the right boundary in bottom-up manner
     printBoundaryTraversalRight(node.right);
  }
			
  public static void main(String[] args) {  
     BoundaryTraversalOfABinaryTree tree = new BoundaryTraversalOfABinaryTree();
     tree.root = new Node(20);
     tree.root.left = new Node(8);
     tree.root.left.left = new Node(4);
     tree.root.left.right = new Node(12);
     tree.root.left.right.left = new Node(10);
     tree.root.left.right.right = new Node(14);
     tree.root.right = new Node(22);
     tree.root.right.right = new Node(25);
	     
     System.out.print("Boundary traversal of binary tree is: ");
     tree.printBoundaryTraversal(tree.root);		
  }
}
