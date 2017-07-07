import java.util.*;
import java.io.*;

 public class SumOfAllLeftLeavesInAGivenBinaryTree {
	Node root;	    
	Node previous;
	
	public static boolean isLeaf(Node node) {
		 
	  if (node == null) {
		return false;
	  }
	  
	  if (node.left == null && node.right == null) {
		return true;
	  }

	  return false;	
    }
	
	public static int leftLeavesSum(Node node) {
	  int result = 0;
	  
	  if (node != null) {
		// If left of root is NULL, then add key of left child  
 		if (isLeaf(node.left)) {
 		  result += node.left.data; 
		}
		else {
	      result += leftLeavesSum(node.left);
		}
 		result += leftLeavesSum(node.right);		  
	  }
	
	  return result;	 
    }
	
	public static void main(String[] args) {
	  SumOfAllLeftLeavesInAGivenBinaryTree tree = new SumOfAllLeftLeavesInAGivenBinaryTree();
	  tree.root = new Node(20);
      tree.root.left = new Node(9);
      tree.root.right = new Node(49);
      tree.root.left.right = new Node(12);
      tree.root.left.left = new Node(5);
      tree.root.right.left = new Node(23);
      tree.root.right.right = new Node(52);
      tree.root.left.right.right = new Node(12);
      tree.root.right.right.left = new Node(50);
      
      int sum = leftLeavesSum(tree.root);
  
	  System.out.print("The Sum of left leaves of the Binary Tree is: " + sum);

	}
 }
