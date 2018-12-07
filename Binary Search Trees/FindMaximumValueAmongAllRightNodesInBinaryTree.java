import java.util.*;
import java.io.*;

  public class FindMaximumValueAmongAllRightNodesInBinaryTree { 	
    Node root;	    
    Node previous;	  
  
    public static int maxRightElement(Node root) {
      int result = Integer.MIN_VALUE; 	
  	  if (root == null) {
  		return 0;
  	  }
  	  if (root.right != null) {
  		result = root.right.data; 
  	  }
  	        
  	  int left = maxRightElement(root.left);
  	  int right = maxRightElement(root.right);
  	        
  	  return Math.max(result, Math.max(left, right));
    }

	public static void main(String[] args) {   
	  FindMaximumValueAmongAllRightNodesInBinaryTree tree = new FindMaximumValueAmongAllRightNodesInBinaryTree();
	  tree.root = new Node(1);
	  tree.root.left = new Node(2);
	  tree.root.right = new Node(3);
	  tree.root.left.left = new Node(4);
	  tree.root.right.right = new Node(6);
	  tree.root.right.left = new Node(5);
	  tree.root.right.left.left = new Node(8);
	  tree.root.right.left.right = new Node(9);
	  tree.root.left.left.right = new Node(7);
	   
	  int maxRightElement = maxRightElement(tree.root);		
		     
	  System.out.print("The maximum value among all of the right child nodes of the Binary Tree is: " + maxRightElement);
	}
  }
