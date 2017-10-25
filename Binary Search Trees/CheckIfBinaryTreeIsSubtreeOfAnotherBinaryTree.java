import java.io.*;
import java.util.*;

 public class CheckIfBinaryTreeIsSubtreeOfAnotherBinaryTree { 
	private static Node root1;	
	private static Node root2;	
	private static Node previous = null;	 
	
  public static boolean isSubtree(Node tree, Node subtree) {
		  
     if (subtree == null) {
	   return true;
	 }
     
     if (tree == null) {
  	    return false;
  	 }
		 
	 if (areIdentical(tree, subtree)) {
		return true;
	 }
		
   // If the tree with root as current node doesn't match then try left and right subtrees one by one */
	 
	 return isSubtree(tree.left, subtree) || isSubtree(tree.right, subtree) ;
   }	
	
  public static boolean areIdentical(Node node1, Node node2) {
	  
	 if (node1 == null && node2 == null) {
		return true;
	 }
	 
	 if (node1 == null || node2 == null) {
		return false;
	 }
	
	 // Check if the data of both roots is same and data of left and right subtrees are also same 
	 
     return (node1.data == node2.data && areIdentical(node1.left, node2.left) && areIdentical(node1.right, node2.right));
  }	

   public static void main(String[] args) {  
	  CheckIfBinaryTreeIsSubtreeOfAnotherBinaryTree tree = new CheckIfBinaryTreeIsSubtreeOfAnotherBinaryTree();
	  tree.root1 = new Node(1);
	  tree.root1.left = new Node(2);
	  tree.root1.right = new Node(4);
	  tree.root1.left.left = new Node(3);
	  tree.root1.right.left = new Node(5);
	  tree.root1.right.right = new Node(6);
	  
	  tree.root2 = new Node(4);
	  tree.root2.left = new Node(5);
	  tree.root2.right = new Node(6);

	  boolean isSubtree = isSubtree(tree.root1, tree.root2);
	  
	  if(isSubtree) {
		 System.out.println("Tree 2 is subtree of Tree 1");  
	  }
	  else {
		 System.out.println("Tree 2 is not a subtree of Tree 1");    
	  }
	  
	}
  }
